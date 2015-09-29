package r6;
import java.util.Scanner;
public class SumOfDivisibleBySeven 
{
	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("Enter two integers to be shown the divisibility by 7 of the range");	
		int num1 = stdin.nextInt();
		int num2 = stdin.nextInt();
		int sum = 0;
		
		for (int i = num1; i <= num2; i++) 
		{
			if (i %7 == 0)
			{
			sum = i + sum;
			}
		}
		
		System.out.println(sum);
	}
}
