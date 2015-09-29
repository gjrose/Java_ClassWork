/**
   A class to test an array of BankAccounts.
*/
public class BankArrayTester {

	/**
	 * Test building an array of BankAccounts
	 * and then total their balances.
	 * @param args not used
	 */
	public static void main(String[] args) {
		// Make three accounts.
		BankAccount[] accounts = new BankAccount[3];
		accounts[0] = new BankAccount();
		accounts[1] = new BankAccount();
		accounts[2] = new BankAccount();

		// Deposit some money in each of the accounts.
		// You choose the amounts to store in each of the three accounts.
		accounts[0].deposit(1000.00);
		accounts[1].deposit(2000.00);
		accounts[2].deposit(3000.00);
		
		
		
		double totalBalance = 0.0;
		for(int i = 0; i<accounts.length; i++)
		{
			totalBalance = accounts[i].getBalance() + totalBalance;
		}
		System.out.println("Total balance of accounts is $" + totalBalance);
		// Fill in the number below that should be printed for the total
		// balance so we can compare the two numbers when we test the program.
		System.out.println("Expected Total: $6000.0");
	}
}
