import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.File;
import java.util.*;
class Reader {
	public static String A;
	public static String Readers() throws URISyntaxException
	{
		String Word = "MAYBEEE";
		Random rand = new Random();
		LinkedList<String>Words = new LinkedList<String>();
		try 
		{
			URL path = ClassLoader.getSystemResource("Words.txt");
			if(path==null)
				System.out.println("The file for words was not found");
			File f = new File(path.toURI());
			BufferedReader reader = new BufferedReader(new FileReader(f));
			if(reader.ready())
			{
				String line = null;
				line = reader.readLine();
				while(line != null)
				{
					Words.add(line.toLowerCase());
					line = reader.readLine();
				}
				System.out.println("Words: " + Words + "\nsize: " + Words.size());
				Word = Words.get(rand.nextInt(Words.size()));
				System.out.println("Word = " + Word);
				reader.close();
			}
			else
			{
				System.out.println("Word searching failed");
				reader.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		A = Word;
		return Word;
	}
}