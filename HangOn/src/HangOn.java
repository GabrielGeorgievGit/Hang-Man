import java.util.*;
public class HangOn {
	String WordToFind = "programming";
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
		System.out.println("In ShowLetters(LinkedList, char)");
		System.out.println("Indexes To Add: " + IndexesToAdd);
		for(int i = 0; i < IndexesToAdd.size(); i++)
			Letters[IndexesToAdd.get(i)] = letterToAdd;
		//OutputTheWord();
	}
	void ShowLetters()
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
					if(EqualLetters(Letters[i]) == true)
						System.out.println("EQUALS!!! " + Letters[i] + "'s");
						//System.out.print("Check number: ");
			}
		}
		//OutputTheWord();
	}
	void OutputTheWord()
	{
		SummonedLetters.sort(null);//maybe remove soon?
		System.out.println(String.valueOf(Letters).replaceAll(".", "$0  "));
		System.out.println("Used letters: " + SummonedLetters);
		//System.out.println("WasEqualStorager: " + WasEqualStorager);
		System.out.println("Number of wrong letters: " + wrongLetterNum + "\n(Max: 8)");
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
	void TryLetter(char isContains[])
	{
		if(!SummonedLetters.contains(isContains[0]))
		{
			SummonedLetters.add(isContains[0]);
		}
		else return;
			
		//System.out.println("In TryLetter");
		for(int i = 0; i < arrayNum; i ++)
		{
			if(arrayFullWord[i] == isContains[0])
			{
			
				Letters[i] = isContains[0];
				return;
			}
		}
		//if(!SummonedLetters.contains(isContains))
			wrongLetterNum++;
		//OutputTheWord();
	}
	/*private static void clearConsole() {
	    try {
	      final String os = System.getProperty("os.name");
	      if (os.contains("Windows")) {
	          Runtime.getRuntime().exec("cls");
	      } else {
	          Runtime.getRuntime().exec("clear");
	      }
	    } catch (final Exception e) {
	       // mConsole.printf("something went wrong :(");
	    }
	  }*/
	public static void main(String[] args)
	{
		Scanner tryContains = new Scanner(System.in);
		//char tryContains = 'a', tryContains2 = 'e';
		HangOn word = new HangOn();
		//word.SummonedLetters.add(tryContains);
		do
		{
			word.OutputTheWord();
			//word.CheckLetters();
			word.TryLetter(tryContains.next().toCharArray());
			//System.out.print("KYS");
			if(word.wrongLetterNum == 8)
			{
				System.out.println("You used more than 8 different letters\nYou Lost :(");
				break;
			}
		}
		while(!word.isEnded());
		tryContains.close();
		word.OutputTheWord();
		System.exit(0);
	}
}
