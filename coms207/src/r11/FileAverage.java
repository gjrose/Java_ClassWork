package r11;
import java.util.*;
import java.io.*;
public class FileAverage //COM_S 207 section 3, Gentry Rose
{
	public static void main (String[] args) throws FileNotFoundException
	{
		double avg = listAverage(readFile("population.txt"));
		System.out.println("Average : " + avg);
	}
	
	
	public static ArrayList<Integer> readFile(String fileName) throws FileNotFoundException
	{
		File f = new File(fileName);
		Scanner fileIn = new Scanner(f);
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		
		while(fileIn.hasNextInt())
		{
		int number = fileIn.nextInt();
		data.add(number);
		}
		return data;
	}
	public static double listAverage (ArrayList<Integer> list)
	{
		double avg = 0;
		int sum = 0;
		for(int i = 0; i<list.size(); i++) 
		{
		sum = list.get(i) + sum;
		}
		avg = sum/list.size();
		return avg;
	}

}
