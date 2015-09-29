package pa2;
import java.util.Scanner;
public class LoanPayment {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		
			System.out.println("Please enter the loan amount ");
			int loanAmount = in.nextInt();
			System.out.println("Please enter APR and the number of years to pay off the loan ");
			double apr = in.nextDouble();
			byte year = in.nextByte();
			
			
			int month = year * 12;
			double interestRate = (apr/12)/100;
			double monthlyPayment = ((loanAmount*interestRate) *
					(Math.pow(1+interestRate, month)) /
					(Math.pow(1+interestRate, month) - 1));
			double mPRoundOff = Math.round(monthlyPayment * 100.0) / 100.0;
			double totalPayment = mPRoundOff * month;
			double totalInterest = totalPayment - loanAmount;
			

			System.out.print("Your Monthly payment is $");
			System.out.printf("%.2f",monthlyPayment);
			System.out.println();
			System.out.print("You will be paying a total amount of $");
			System.out.printf("%.2f",totalPayment);
			System.out.println (" over " +year+ " years");
			System.out.print("Your total interest is $");
			System.out.printf("%.2f",totalInterest);
	}
	
	
	
	
}
