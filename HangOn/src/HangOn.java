import java.util.*;
public class HangOn
{
	String WordToFind = Reader.A;

	int wrongLetterNum = 0, 
			arrayNum = WordToFind.length();
	char theEqual, 
			arrayFullWord[] = WordToFind.toCharArray();
	char[] Letters = new char[arrayNum];
	static LinkedList<Character>WasEqualStorager = new LinkedList<Character>();
	
	 LinkedList<Character>SummonedLetters = new LinkedList<Character>();
	public HangOn()
	{
		
		System.out.println("All Letters: " + arrayNum);
		for(int i = 0; i < arrayNum; i++)
		{
			Letters[i] = '_';
		}
		Letters[0] = arrayFullWord[0];
		Letters[arrayNum - 1] = arrayFullWord[arrayNum - 1];
		SummonedLetters.addFirst(Letters[0]);
		SummonedLetters.offer(Letters[arrayNum - 1]);
		CheckLetters();
	}
	boolean EqualLetters(char isEqual)
	{
		LinkedList<Integer>TheIndexer = new LinkedList<Integer>();
		int letterNum = 0;
		for(int i = 0; i < arrayNum; i++)
		{
			if(isEqual == arrayFullWord[i])
			{
				TheIndexer.addLast(i);
				letterNum++;
			}
		}
		WasEqualStorager.add(isEqual);
		if(letterNum > 1){
			ShowLetters(TheIndexer, isEqual);
			return true;
		}
		else return false;
	}
	void ShowLetters(LinkedList<Integer>IndexesToAdd, char letterToAdd)
	{
		IndexesToAdd.sort(null);
		for(int i = 0; i < IndexesToAdd.size(); i++)
			Letters[IndexesToAdd.get(i)] = letterToAdd;
	}
	void ShowLetters()//Update or stay -_- Maybe not...
	{
		//System.out.println("In ShowLetters()");
	}
	void CheckLetters()
	{
		for(int i = 0; i <= arrayNum - 1; i++)
		{
			if(SummonedLetters.contains(Letters[i]))
			{
				if(!WasEqualStorager.contains(Letters[i]))
					if(EqualLetters(Letters[i]) == true);
			}
		}
	}
	void OutputTheWord()
	{
		SummonedLetters.sort(null);
		System.out.println("\nThe word is:");
		System.out.println(String.valueOf(Letters).replaceAll(".", "$0  "));
		System.out.println("Used letters: " + SummonedLetters);
		
		System.out.println("Number of wrong letters: " + wrongLetterNum + "\n(Max: 8)\n");
	}
	boolean isEnded()
	{
		for(int i = 0; i < arrayNum; i++)
			if(Letters[i] == '_' && wrongLetterNum < 8){
				return false;
			}
		return true;
	}
	void TryLetter(char isContains[])
	{
		if(!SummonedLetters.contains(isContains[0]))
		{
			SummonedLetters.add(isContains[0]);
		}
		else return;
			
		for(int i = 0; i < arrayNum; i ++)
		{
			if(arrayFullWord[i] == isContains[0])
			{
				Letters[i] = isContains[0];
				return;
			}
			if(!WasEqualStorager.contains(isContains[0]))
				if(EqualLetters(isContains[0]) == true);
		}
			wrongLetterNum++;
	}
	public static void main(String[] args)throws Exception
	{
		Reader.Readers();
		
		Scanner tryContains = new Scanner(System.in);
		HangOn word = new HangOn();
		do
		{
			word.OutputTheWord();
			System.out.print("Try letter:" );
			word.TryLetter(tryContains.next().toCharArray());
			
			if(word.wrongLetterNum >= 8)
			{
				for (int i = 0; i < 50; ++i) 
					System.out.println();
				System.out.println("\n\n\nYou used more than 8 different letters\n"
						+ "You Lost :(\nBetter KYS\nThe word was:\n" + 
						String.valueOf(word.WordToFind).replaceAll(".", "$0  "));
				//return;
			}
			if(word.isEnded() && word.wrongLetterNum < 8)
			{
				for (int i = 0; i < 50; ++i) 
					System.out.println();
				word.OutputTheWord();
				System.out.println("You Win! || GG\nYo still need to KYS");
			}
			if(word.isEnded());
			else 
				for (int i = 0; i < 50; ++i) 
					System.out.println();
		}
		while(!word.isEnded());
		
		System.out.println("Press Enter to exit");
		tryContains.nextLine();
		tryContains.nextLine();
		
		System.out.println("END");
		tryContains.close();
		
		System.exit(0);
	}
}
