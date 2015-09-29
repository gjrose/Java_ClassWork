package TEST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;
public class pa6TEST {
		public static void main(String[] args) throws FileNotFoundException
		{
			File x = new File("PA6Edit.txt");
		}
		
		
		public static ArrayList<String> fileToList(String fileName) throws FileNotFoundException{
			ArrayList<String> words = new ArrayList<String>();
			File f = new File(fileName);
			Scanner fileIn = new Scanner(f);
			
			while(fileIn.hasNext())
			{
			words.add(fileIn.next());
			
			
			}
			
			return words;
		}
}
