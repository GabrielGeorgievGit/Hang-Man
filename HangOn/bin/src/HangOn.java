import java.util.*;
//import java.lang.Runtime;//KYS code
public class HangOn {
	String WordToFind = "programming";
	int wrongLetterNum = 0, 
			arrayNum = WordToFind.length();
	char theEqual, 
			arrayFullWord[] = WordToFind.toCharArray();
	char[] Letters = new char[arrayNum];
	static LinkedList<Character>WasEqualStorager = new LinkedList<Character>();
	//Make a container for all equals letters (Not LinkedList), have to sort 'em
	//Maybe sort is not an option :(
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
		//System.out.println(letterNum + " equals letters");
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
		//System.out.println("In ShowLetters(LinkedList, char)");
		//System.out.println("Indexes To Add: " + IndexesToAdd);
		for(int i = 0; i < IndexesToAdd.size(); i++)
			Letters[IndexesToAdd.get(i)] = letterToAdd;
	}
	void ShowLetters()//Update or stay -_- Maybe not...
	{
		//System.out.println("In ShowLetters()");
		
	}
	void CheckLetters()
	{
		//int br = 0; 
		//System.out.println("Check number: ");
		for(int i = 0; i <= arrayNum - 1; i++)
		{
			//System.out.println(i + " ");
			if(SummonedLetters.contains(Letters[i]))
			{
				/*System.out.println("FK | contains: " + Letters[i]);
				System.out.println("Index: " 
					+ " br = " + br);
				br++;
				*/
				if(!WasEqualStorager.contains(Letters[i]))
					if(EqualLetters(Letters[i]) == true);
						//System.out.println("EQUALS!!! " + Letters[i] + "'s");
			}
		}
	}
	void OutputTheWord()
	{
		SummonedLetters.sort(null);//maybe remove soon?
		System.out.println("\nThe word is:");
		System.out.println(String.valueOf(Letters).replaceAll(".", "$0  "));
		System.out.println("Used letters: " + SummonedLetters);
		//System.out.println("WasEqualStorager: " + WasEqualStorager);
		System.out.println("Number of wrong letters: " + wrongLetterNum + "\n(Max: 8)\n");
		if(isEnded())System.out.println("You Win! || GG\nYo still need to KYS");
	}
	boolean isEnded()
	{
		for(int i = 0; i < arrayNum; i++)
			if(Letters[i] == '_'){
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
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner tryContains = new Scanner(System.in);//Better tryContains than uselessShit2000
		HangOn word = new HangOn();
		do
		{
			word.OutputTheWord();
			System.out.print("Try letter:" );
			word.TryLetter(tryContains.next().toCharArray());
			//System.out.print("KYS");//Best code ever
			if(word.wrongLetterNum == 8)
			{
				word.OutputTheWord();
				System.out.println("\n\n\nYou used more than 8 different letters\n"
						+ "You Lost :(\nBetter KYS\nThe word was:\n" + 
						String.valueOf(word.WordToFind).replaceAll(".", "$0  "));//Cool, huh?
				return;
			}
			System.out.println("Yo mad to scroll?\nIt's better than nothing :(\njust delete BEST CLEAR CONSOLE EVER M8" +
					  "Hint(For most lazy people: Just press the letter you want to add(auto scroll) :*");
			for (int i = 0; i < 50; ++i) 
				System.out.println();//BEST CLEAR CONSOLE EVERRRR
		}
		while(!word.isEnded());
		tryContains.close();
		word.OutputTheWord();
		System.exit(0);
	}
}
