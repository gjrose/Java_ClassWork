import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BankTransactions {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter accounts file name: ");
		String accountsFilename = console.nextLine();
		System.out.print("Enter transactions file name: ");
		String transactionsFilename = console.nextLine();
		Bank myBank = new Bank();

		Scanner accountsScanner = new Scanner(new File(accountsFilename));
		myBank.readBankAccounts(accountsScanner);
		accountsScanner.close();

		Scanner transactionsScanner = new Scanner(new File(transactionsFilename));
		myBank.applyTransactions(transactionsScanner);
		transactionsScanner.close();

		System.out.println(myBank.toString());
	}
}
