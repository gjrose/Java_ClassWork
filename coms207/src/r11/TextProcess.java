package r11;
import java.util.*;
import java.io.*;
public class TextProcess //COM_S 207 section 3, Gentry Rose
{
	public static void main (String[] args) throws FileNotFoundException
	{
		ArrayList<String> avg = fileToList("cs.txt");
		ArrayList<String> chkwords = beginsWith(avg, 'a');
		
		System.out.println(print(chkwords));
		
	}
	
		public static ArrayList<String> fileToList(String fileName) throws FileNotFoundException
		{
			File f = new File(fileName);
			Scanner fileIn = new Scanner(f);
			ArrayList<String> data = new ArrayList<String>();
			while(fileIn.hasNext())
			{
			String word = fileIn.next();
			data.add(word);
			}
			return data;
		}
		
		public static ArrayList<String> beginsWith (ArrayList<String> inputList, char ch)
		{
			ArrayList<String> words = new ArrayList<String>();
			for(int i = 0; i<inputList.size(); i++){
				String wrdck = inputList.get(i);
				char chk = wrdck.charAt(0);
				if(chk == ch){
				words.add(wrdck);
				}
			}
			return words;
		}
		
		public static String print(ArrayList<String> inputList)
		{
			String print = "";
			for(int i = 0; i<inputList.size(); i++) 
			{
			System.out.print(inputList.get(i) + " " );
			}
			return print;
		}
		
}
