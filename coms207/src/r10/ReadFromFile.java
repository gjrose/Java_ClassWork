package r10;
import java.util.*;
import java.io.*;
public class ReadFromFile //COM_S 207 section 3, Gentry Rose
{
	public static void main(String[] args) throws FileNotFoundException
 {
	File f = new File("numbers.txt");
	Scanner fileIn = new Scanner(f);
	
	while(fileIn.hasNextDouble())
	{
	double number = fileIn.nextDouble();
	System.out.println(number);
	}
	System.out.println();
 }
}
