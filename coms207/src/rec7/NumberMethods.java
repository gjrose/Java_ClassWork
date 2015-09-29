package rec7;
import java.util.Random;
public class NumberMethods 
{
public static void main(String[] args)
 {
	int rightMost = firstDigit(2578);
	System.out.println("right most digit: " +rightMost);
	
	mystery(1234);
	
	int sum = sumOfDigits(3333);
	System.out.println("sum of digits: " +sum);
	
	int randRange = 23;  // number for random prime generation and prime status consideration
	int pRand = randomPrime(randRange);
	System.out.println("Random prime number in the not exceeding range of "+randRange+":"+" " +pRand);
	
	int pTest = pRand ;
	boolean prime = isPrime(pTest);
	System.out.println("Prime status of "+pTest+":"+" " +prime);
 }

	public static int firstDigit(int num)
	{
	int first = num%10;
	return first;
	}
	
	public static boolean isPrime(int num)
	{
		boolean result = true;
		for(int i = 2; i<=num-1; i++)
		{
			if(num % i ==0)
			{
			result = false;
			}
		}
		
		return result;
	}
	
	public static int randomPrime(int num)
	{
		Random r = new Random();
		int x = r.nextInt(num);
		while(isPrime(x) == false)
		{
		x = r.nextInt(num);
		}
	
		return x;
	}
	
	public static int sumOfDigits(int num)
	{
		int sum = 0;
		while(num != 0)
		{
		int digit = num%10;
		num = num/10;
		sum = sum + digit;
		}
		return sum;
	}
	
	public static void mystery(int num)
	{
	while(num != 0) 
	{
	int digit = num%10;
	System.out.println("mystery digit: " +digit);
	num = num/10;
	}
	}
 
}
