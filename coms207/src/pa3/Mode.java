package pa3;
import java.util.Scanner;
public class Mode 
{
	public static void main(String[] args) 
	{
		
		Scanner id = new Scanner(System.in);
			
			System.out.println("Enter three integers: "); 	// obtain inputs
			int num1 = id.nextInt();  		
			int num2 = id.nextInt();			
			int num3 = id.nextInt();
			
			
			if(num1 == num2 || num1 == num3)		//determine num1 mode potential
			{
				System.out.println("Mode is "+num1);
			}
			else if(num2 == num1 || num2 == num3)   //determine num2 mode potential
			{
				System.out.println("Mode is "+num2);
			}
			else if(num3 == num1 || num3 == num2)   //determine num3 mode potential
			{
				System.out.println("Mode is "+num3);
			}
			else									//total lack of mode
			{	
			System.out.println("Mode does not exist");  
			}
	}
}