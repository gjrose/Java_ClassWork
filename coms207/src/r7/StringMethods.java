package r7;
import java.util.Scanner;
public class StringMethods 
{
 public static void main(String[] args)
 {

	char endChar = lastChar ("Chugger");
	System.out.println(endChar);
	String reverseString = reverseString("Chugger");
	System.out.println(reverseString);
	int firstVowel = firstVowel("Chugger");
	String pigLatin = pigLatin("Chugger");
	System.out.println(pigLatin);
 }

	public static char lastChar(String word) //gets a String as parameter, returns the last character of the string
	{
		
		int len = word.length();
		char last = word.charAt(len-1);
		return last;
		
	}
	public static String reverseString(String word) //gets a String as parameter, reverses order of letters
	{
		int len = word.length();
		String reverseString = "";
		
		for(int i=(len-1); i>=0; i--) 
		{
		char c = word.charAt(i);
		reverseString = reverseString +c;
		}
		return reverseString;
	}
	
	 public static int firstVowel(String word)
	{
	     int vowelPosition = -1;
	        
	     for(int i=1; i <=word.length(); i++)  
	     {      
	            if((word.charAt(i-1) == 'a') ||(word.charAt(i-1) == 'A')
	             ||(word.charAt(i-1) == 'e') ||(word.charAt(i-1) == 'E')
	             ||(word.charAt(i-1) == 'i') ||(word.charAt(i-1) == 'I')
	             ||(word.charAt(i-1) == 'o') ||(word.charAt(i-1) == 'O')
	             ||(word.charAt(i-1) == 'u') ||(word.charAt(i-1) == 'U')
	             ||(word.charAt(i-1) == 'y') ||(word.charAt(i-1) == 'Y'))
	            {
	               vowelPosition = i;
	               return vowelPosition;
	            }
	      } 
	     return vowelPosition;
		
	}
	public static String pigLatin(String word) //gets a String as parameter, translates into pig Latin
	{
		String pigLatin = "";
		int vowelPos = firstVowel(word);
		int len = word.length();

		pigLatin = word.substring(vowelPos-1,len) +
				word.substring(0,vowelPos-1) + "ay";
		
		return pigLatin;
	}

 
}
