import java.util.*;
public class HangOn {
	String WordToFind = "keabab";
	int wrongLetterNum = 0, 
			arrayNum = WordToFind.length();
	char theEqual, 
			arrayFullWord[] = WordToFind.toCharArray();
	char[] Letters = new char[arrayNum];
	static LinkedList<Character>WasEqualStorager = new LinkedList<Character>();
	//Make a container for all equals letters (Not LinkedList), have to sort 'em
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
		System.out.println(letterNum + " equals");
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
		System.out.println("In ShowLetters(LinkedList, char)");
		System.out.println("Indexes To Add: " + IndexesToAdd);
		for(int i = 0; i < IndexesToAdd.size(); i++)
			Letters[IndexesToAdd.get(i)] = letterToAdd;
		OutputTheWord();
	}
	void ShowLetters()
	{
		System.out.println("In ShowLetters()");
		
	}
	void CheckLetters()
	{
		int br = 0; 
		System.out.println("Check number: ");
		for(int i = 0; i <= arrayNum - 1; i++)
		{
			System.out.println(i + " ");
			if(SummonedLetters.contains(Letters[i]))
			{
				System.out.println("FK | contains: " + Letters[i]);
				System.out.println("Index: " 
					+ " br = " + br);
				br++;
				
				if(!WasEqualStorager.contains(Letters[i]))
					if(EqualLetters(Letters[i]) == true)
						System.out.println("EQUALS!!! " + Letters[i] + "'s");
						//System.out.print("Check number: ");
			}
		}
		OutputTheWord();
	}
	void OutputTheWord()
	{
		System.out.println(String.valueOf(Letters).replaceAll(".", "$0  "));
		System.out.println("Used letters: " + SummonedLetters);
		System.out.println("WasEqualStorager: " + WasEqualStorager);
		if(isEnded())System.out.println("prikluchila e || GG");
	}
	boolean isEnded()
	{
		for(int i = 0; i < arrayNum; i++)
			if(Letters[i] == '_'){
				//System.out.println("ne e prikluchila");
				return false;
			}
		//System.out.println("prikluchila e || GG");
		return true;
	}
	void TryLetter(char isContains)
	{
		SummonedLetters.add(isContains);
		System.out.println("In TryLetter");
		for(int i = 0; i < arrayNum; i ++)
		{
			if(arrayFullWord[i] == isContains)
				Letters[i] = isContains;
		}
		OutputTheWord();
	}
	public static void main(String[] args)
	{
		char tryContains = 'a', tryContains2 = 'e';
		HangOn word = new HangOn();
		//word.SummonedLetters.add(tryContains);
		word.OutputTheWord();
		word.CheckLetters();
		word.TryLetter(tryContains);
		word.TryLetter(tryContains2);
		/*do
		{
			word.OutputTheWord();
			
		}
		while(word.isEnded() == false);
		*/
		System.exit(0);
	}
}