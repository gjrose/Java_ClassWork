package r6;
import java.util.Scanner;
public class Disemvowel
{
	public static void main(String[] args) 
	{
		
		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter a word to be DISEMVOWELED!");
		String word = stdin.next();
		String disemvoweledWord = "";
		int len = word.length();
	
		
		for(int i = 0;i < len ;i++)
		{
		char ch = word.charAt(i);
		
		if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
		{
		disemvoweledWord = disemvoweledWord+ch;
		}
		}
		System.out.println(disemvoweledWord);
		
	}
}