package TEST;
import java.util.Random;
import java.util.Scanner;
public class TEST1
{
	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		
		int superNum = 0;
		int secretNumber = generateSecretNumber(9999);
		superNum = secretNumber;
		
		System.out.println(secretNumber);
	
		
		
		int numberOfDigits = numDigits(superNum);
		System.out.println(numberOfDigits);
		int digitith = getDigit(superNum, 2);
		System.out.println("getDigit: "+digitith);
		boolean dResult = hasDistinctDigits(superNum);
		System.out.println("distinct digits? "+dResult);
		int indexNum = indexOf(superNum, 1);
		System.out.println("indexOf: "+indexNum);
		int vR = inValidInteger(superNum);
		System.out.println("validity: "+vR);
		
		
		System.out.println("Enter your guess.");
		int guessNumber = stdin.nextInt();
		
		int cowCatcher = getCows(secretNumber, guessNumber);
		System.out.println(cowCatcher + " Cows");
		int bullCatcher = getBulls(secretNumber, guessNumber);
		System.out.println(bullCatcher + " Bulls");
	}
	
	
	
	
	public static int numDigits(int number) //num digits
	{
		int length = 0;
        while (number > 0) 
        {
            length += 1;
            number = (number / 10);
        }
		return length;
	}
	
	public static int getDigit(int number, int i) //get digit
	{
		int digit = 0;
		if(i<=numDigits(number))
		{
		for (int ind = 0; ind < i; ind++)
		{
			digit = number%10;
			number = number/10;
		}
		
		}
		else
		{
			digit = -1;
		}
		return digit;
	
	}	
	public static boolean hasDistinctDigits(int number) // distinct digit
	{
		boolean result = true;
		for(int x = 1; x <= numDigits(number); x++) //digit1 for comparison
		{
		for(int y = x+1; y <= numDigits(number); y++) //digits to compare to digit1
		{
			if (getDigit(number, x) == getDigit(number, y))	
			{
			result = false;
			}
		}
		}
		return result;
	}
	public static int indexOf(int number, int digit) //index must return position of requsted number
	{//123, 1 must return 3
		int indexDigit = 0;
		for(int y = 1; y <= numDigits (number); y++)
		{
		if(digit != getDigit(number,y))
		{
			indexDigit = -1;
		}
		for (int x = 1; x <= numDigits(number); x++)
		{
			if(digit == getDigit(number,x))
			{
				indexDigit = x;
			}
		}
		}
		
		return indexDigit;
		
	}
	
	
	public static int inValidInteger(int number) //validity
	{
			int validityResult = 0;
			if(number < 0)
			{
				validityResult = -1;
			}
			else if(numDigits(number)!=4)
			{
				validityResult = -2;
			}
			else if(hasDistinctDigits(number) == false && numDigits(number) == 4)
			{
				validityResult = -3;
			}
			
			return validityResult;
	}
	public static int generateSecretNumber(int secretNumber) //Snum gen
	{
		
			Random r = new Random();
			int secretNumberR = r.nextInt(secretNumber);
				
			while(inValidInteger(secretNumberR) != 0)
			{
			secretNumberR = r.nextInt(secretNumber);
			}
			
			return secretNumberR;
	}
	public static int getCows(int first, int second) // if the number is equal but position is not
	{
		int cowsAvail = 0;	
		for(int x = 1; x <= numDigits(second); x++) //compare 1
		{
			for(int y = 1; y<= numDigits(second); y++) // compare 2
		{
			if(getDigit(first,x) == getDigit(second,y) && 
				indexOf(first, getDigit(first,x)) != indexOf(second, getDigit(second,y)))
			{
				cowsAvail = cowsAvail+1;
			}
		}
		}
		return cowsAvail;	
	}	
	public static int getBulls(int first, int second) //both number and position are equal
	{
		int bullsAvail = 0;	
		for(int x = 1; x <= numDigits(second); x++)
		{
		if((getDigit(first,x) == (getDigit(second,x))))
		{
			{
			bullsAvail = bullsAvail+1;
			}
		}
		}
		return bullsAvail;	
	}
	
}
