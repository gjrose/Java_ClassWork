package pa4;
import java.util.Scanner;
public class ForLoop 
{
	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		double product = 1;
	//1	Print all even integers between 87 and 45 in decreasing order.
		
		for (int i = 87; i >= 45; i--) 
		{
			if (i %2 == 0)
			{
				System.out.print(i+" ");
			}
			
		}
		
	System.out.println();
	//2	Output product of all integers between 4 and 15
	
		for (int i = 4; i <= 15; i++) 
		{
			product = i * product;
		}
		System.out.print(product);
		
	System.out.println();
	/*3 Prompts the user to enter a word and output the word formed by concatenating every other
	character of the word.*/
	
	System.out.println("Enter a word to be concatenated");
	String word = stdin.next();
	int len = word.length();
	String concatenatedWord = "";
		for(int i = 0;i < len ;i++)
		{
			char ch = word.charAt(i);
			
			if(i %2 ==0)
			{
				concatenatedWord = concatenatedWord+ch;
			}
		}
			System.out.println(concatenatedWord);
		
	}
}
