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
			//For same directory - maybe bad decision :(
			String k = System.getProperty("user.dir");
			String dir = k.replace( "\\" , "/");
			//System.out.println(dir + "/Words.txt");
			/*
			URL path = ClassLoader.getSystemResource(dir + "/Words.txt");
			if(path==null)
				System.out.println("The file for words was not found");
			File f = new File(path.toURI());
			BufferedReader reader = new BufferedReader(new FileReader(f));
			*/
			//For different directory - have to know the path to it :(
			/*
			System.out.println("Working Directory = " +
		            System.getProperty("user.dir").replace("\\", "/"));
		            */
			/*
			String k = System.getProperty("user.dir");
			String dir =k.replace( "\\" , "/");
			System.out.println(dir);
			*/
			/*
			FileReader f = new FileReader("C:/Users/gabet/Desktop/prygrammer/JAVA PROGRAMMING/HangOn/src/Words.txt");
			BufferedReader reader = new BufferedReader(f);
			*/
											//C:/Users/gabet/Desktop/prygrammer/JAVA PROGRAMMING/HangOn/Words.txt
			FileReader f = new FileReader(dir + "/Words.txt");///src/Words.txt	//for compiler
			BufferedReader reader = new BufferedReader(f);
			
			if(reader.ready())
			{
				String line = null;
				line = reader.readLine();
				while(line != null)
				{
					Words.add(line.toLowerCase());
					line = reader.readLine();
				}
				//System.out.println("Words: " + Words + "\nsize: " + Words.size());
				Word = Words.get(rand.nextInt(Words.size()));
				//System.out.println("Word = " + Word);
				reader.close();
			}
			else
			{
				Scanner end = new Scanner(System.in);
				System.out.println("Word searching failed");
				System.out.println("Press Enter to exit");
				end.nextLine();
				end.nextLine();
				end.close();
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