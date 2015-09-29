package pa4;

public class WhileLoop 
{
	public static void main(String[] args) 
	{
		int num1 = 34;
		int num2 = 33;
		int num3 = 2;
		int sum = 0;
	//1 Print all integers from 34 to 66
		
		while (num1 <= 66)
		{
			System.out.print(num1 + " ");
			num1++;
		}
		
	System.out.println();		
	//2 Print all integers in the range [33; 49] that are either divisible by 2 or by 5.
	
		while(num2 <= 49)
		{
			if(num2 %2 == 0 || num2 %5 == 0)
			System.out.print(num2 + " ");
			num2++;
		}
		
	System.out.println();
	//3 Output sum of all odd integers between 2 and 100.
	
		while(num3 <=100)
		{
			if(num3 %2 != 0)
			sum = num3 + sum;
			num3++;
		}
		System.out.print(sum);
	}
}
