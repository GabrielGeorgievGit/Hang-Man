import java.util.*;
public class HangOn {
	String WordToFind = "gabetoyes";
	char theEqual;
	int arrayNum = WordToFind.length();
	char[] Letters = new char[arrayNum];
	static LinkedList<Character>WasEqualStorager = new LinkedList<Character>();
	//Make a container for all equals letters (Not LinkedList), have to sort 'em
	char arrayFullWord[] = WordToFind.toCharArray();
	static LinkedList<Character>SummonedLetters = new LinkedList<Character>();
	public HangOn()
	{
		System.out.println("All Letters: " + arrayNum);
		for(int i = 0; i < arrayNum; i++)
		{
			Letters[i] = '_';
		}
		MakeArray();
	}
	boolean EqualLetters(char isEqual)
	{
		LinkedList<Integer>TheIndexer = new LinkedList<Integer>();
		//int theIndexer[] = new int[10];
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
		
	}
	void CheckLetters(char isContains)
	{
		//char[] WordArray = WordToFind.toCharArray();
		int br = 0; 
		System.out.print("Check number: ");
		for(int i = 0; i <= arrayNum - 1; i++)
		{
			
			System.out.print(i + " ");
			if(SummonedLetters.contains(Letters[i]))
			{
				System.out.println("\nFK | contains: " + Letters[i]);
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
	public void MakeArray()
	{
		Letters[0] = arrayFullWord[0];
		Letters[arrayNum - 1] = arrayFullWord[arrayNum - 1];
		SummonedLetters.addFirst(Letters[0]);
		//for(int i = 0; i < arrayNum - 2; i++)SummonedLetters.addLast('0');
		
		SummonedLetters.offer(Letters[arrayNum - 1]);
		/*SummonedLetters.remove(2);
		SummonedLetters.add(2,'k');*/
	//	SummonedLetters.add(1,'5');
	}
	void OutputTheWord()
	{
		System.out.println(String.valueOf(Letters).replaceAll(".", "$0  "));
		System.out.println("Used letters: " + SummonedLetters);
		System.out.println("WasEqualStorager: " + WasEqualStorager);
	}
	/*boolean isEnded()
	{
		//for(int i = 0; i<arrayNum;)
			//if(Letters[i] == '_')return false;
			//else return true;
		return false;
	}*/
	boolean TryLetter()
	{
		
		return true;
	}
	public static void main(String[] args)
	{
		char tryContains = 'g';
		HangOn word = new HangOn();
		
		word.OutputTheWord();
		word.CheckLetters(tryContains);
		/*do
		{
			word.OutputTheWord();
			
		}
		while(word.isEnded() == false);
		*/
		System.exit(0);
	}
}