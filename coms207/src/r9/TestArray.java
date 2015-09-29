package r9;
import java.util.Scanner;
public class TestArray    
{  //COM_S 207 section 3, Gentry Rose
	public static void main(String[] args) 
	{
	Scanner stdin = new Scanner(System.in);
	double[] scores = new double[5];
	double[] data = new double[25];
	System.out.println(scores.length);
	System.out.println(data.length);
	
	
	double[] values = {2, -3, 4, 6, 8, -99};
	System.out.println(values.length);
	
	for(int i = 0; i<scores.length; i++) 
	{
	System.out.println("Please enter " + i +"th array value");
	scores[i]= stdin.nextDouble();
	}
		
	for(int i = 0; i<scores.length; i++) 
	{
	System.out.print(scores[i] + " " );
	}
	System.out.println(sumArray(scores));
	System.out.println(sumArray(data));
	System.out.println(sumArray(values));
	System.out.println("");
		
	double[] sTest = {1, 4, 6, 7};
	double[] sTestSq = squareArray(sTest);
	for(int i = 0; i<sTest.length; i++) 
	{
	System.out.print(sTestSq[i] + " " );
	}
	
	System.out.println();
	
	double[] scoresSquared = squareArray(scores);
	for(int i = 0; i<scoresSquared.length; i++) 
	{
	System.out.print(scoresSquared[i] + " " );
	}
	
	}
	
		public static double sumArray(double[] dArray)
		{
		double sum = 0;
		
		for(int i = 0; i<dArray.length; i++) 
		{
		sum = dArray[i] + sum;
		}
		return sum;
		}
	
		
		public static double[] squareArray(double[] dArray)
		{
		double[] squareArray = new double[dArray.length];	
		
		for(int i = 0; i<=dArray.length-1; i++) 
		{
		squareArray[i] = dArray[i]*dArray[i];
		}
		return squareArray;
		}
	
}
