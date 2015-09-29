package r4;
import java.util.Scanner;
public class Reciprocal {

	public static void main(String[] args) {
	Scanner stdin = new Scanner(System.in);
		
		System.out.println("Enter a non-zero number");
	
		if(stdin.hasNextDouble()){
			double number = stdin.nextDouble();
			if(number != 0) {
				System.out.println("Reciprocal is " + 1/number);}
			else		{
				System.out.println("Invalid input (0)");
			}	
		}
		else {
		System.out.println("Invalid input (non-double)");
}
}
}
