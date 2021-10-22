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
			
			String k = System.getProperty("user.dir");
			String dir = k.replace( "\\" , "/");
			
			FileReader f = new FileReader(dir + "/Words.txt");
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
				
				Word = Words.get(rand.nextInt(Words.size()));
				
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
