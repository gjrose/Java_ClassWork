package pa5;
import java.util.Scanner;
import java.util.Random;
public class CowsAndBulls 
{
	public static void main(String[] args)
 {
		
		Scanner stdin = new Scanner(System.in);
		int secretNumber = generateSecretNumber(9999); 														 //Game start
		System.out.println("Welcome to Cows and Bulls Game. I picked a random 4-digit number with distinct integers, try finding it. Type your guess, must be a 4-digit number consisting of distinct digits.");
		
		int guessedNumber = stdin.nextInt();
		int guesses = 1;
		
		while (getBulls(secretNumber,guessedNumber) != 4)
		{
			if(inValidInteger(guessedNumber) == -1)
			{System.out.println("Invalid guess. Must be a positive integer");
			System.out.println("Type your guess, must be a 4-digit number consisting of distinct digits.");		//invalid guesses
			guessedNumber = stdin.nextInt();
			guesses++;
			}
			else if(inValidInteger(guessedNumber) == -2)
			{System.out.println("Invalid guess. Must have only four digits");
			System.out.println("Type your guess, must be a 4-digit number consisting of distinct digits.");
			guessedNumber = stdin.nextInt();
			guesses++;
			}
			else if(inValidInteger(guessedNumber) == -3)
			{System.out.println("Invalid guess. Must have distinct digits");
			System.out.println("Type your guess, must be a 4-digit number consisting of distinct digits.");
			guessedNumber = stdin.nextInt();
			guesses++;
			}
			else if(inValidInteger(guessedNumber) == 0)															//valid guess
			{
			System.out.println("Cows: "+getCows(secretNumber,guessedNumber)+" Bulls: "+getBulls(secretNumber,guessedNumber));
			System.out.println("Type your guess, must be a 4-digit number consisting of distinct digits.");
			guessedNumber = stdin.nextInt();
			guesses++;
			}
		}
		
		
		if (getBulls(secretNumber,guessedNumber) == 4)														//Win
		{
		System.out.println("Congratulations, You found the number, you took " + guesses + " guesses");
		}
		

		
 }
	
	public static int numDigits(int number) //number of digits in a number
	{
		int length = 0;
        while (number > 0) 
        {
            length += 1;
            number = (number / 10);
        }
		return length;
	}
	
	public static int getDigit(int number, int i) //specified digit finding, based on location i
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
	public static boolean hasDistinctDigits(int number) // distinct digit checking
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
	public static int indexOf(int number, int digit) //position of requested number check
	{
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
	
	
	public static int inValidInteger(int number) // validity check
	{
			int validityResult = 0;
			if(number < 0)
			{
				validityResult = -1;
			}
			else if(numDigits(number) != 4)
			{
				validityResult = -2;
			}
			else if(hasDistinctDigits(number) == false && numDigits(number) == 4)
			{
				validityResult = -3;
			}
			
			return validityResult;
	}
	public static int generateSecretNumber(int secretNumber) //Secret number generator
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
