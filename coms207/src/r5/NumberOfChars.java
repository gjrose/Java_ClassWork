package r5;
import java.util.Scanner;
public class NumberOfChars 
{
	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		
		double totalChar = 0;
		double totalWord = 0;
		double avgTotalChar = 0;
		
		System.out.println("Enter a list of words, with the last word being \"quit\"");
		String currentWord = stdin.next();
		
		while (!currentWord.equals("quit"))
		{
			int num = currentWord.length();
			totalChar = totalChar + num;
			totalWord++;
			avgTotalChar = totalChar / totalWord;
			currentWord = stdin.next();	
		}
		
		System.out.println();
		System.out.printf("%.2f",avgTotalChar);
		
	}
}
