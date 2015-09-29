package r5;
import java.util.Scanner;
public class DivisibleByNine 
{
	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("Enter two numbers to be shown the divisibility by 9 of the range");
		int num1 = stdin.nextInt();
		int num2 = stdin.nextInt();
		
		for (num1 <= num2; num1 %9 == 0; num1++) 
		{
			System.out.println(num1);
		}
		
		System.out.println("done");
		}
}
