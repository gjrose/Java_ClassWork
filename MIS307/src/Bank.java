
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
   This bank contains a collection of bank accounts.
*/
public class Bank
{   
	private ArrayList<BankAccount> accounts;

	/**
	 * Constructs a bank with no bank accounts.
	 */
	public Bank()
	{
		accounts = new ArrayList<BankAccount>();
	}

	/**
	 * Adds an account to this bank.
	 * @param a the account to add
	 */
	public void addAccount(BankAccount a)
	{
		accounts.add(a);
	}
   
	/**
	 * Read the accounts as account number and balance from the given file,
	 * create a new BankAccount object with the given number and balance,
	 * and use addAccount() method to store the new account in the bank.
	 * @param in - Scanner from which to read account information
	 */
	public void readBankAccounts(Scanner in) 
	{
		int numAccount;
		double balance;
		
		while(in.hasNext()){
			
		numAccount = in.nextInt();
		balance = in.nextDouble();
		
		BankAccount newAccount = new BankAccount(numAccount, balance);
		addAccount(newAccount);
		}
	}

	

	/**
	 * Read and apply the transactions from the given file.
	 * Transactions may be:
	 * "deposit <account> <amount>"
	 * "withdraw <account> <amount>"
	 * "transfer <fromAccount> <toAccount> <amount>"
	 *
	 * Read the word determining the kind of transaction. Based on
	 * the type of transaction, read one or two account number(s)
	 * and amount. Find the matching account(s) in the bank, and use the
	 * appropriate method(s) to apply the transaction to the account(s).
	 * Note that to do a "transfer", you can use the withdraw method on
	 * the "from" account and then a deposit method on the "to" account.
	 *
	 * @param in - Scanner from which to read transactions
	 */
	public void applyTransactions(Scanner in)
	{
		String method = "";
		int account1;
		int account2;
		double balance;
		
		
		while(in.hasNext()){
		method = in.next();
		
			if(method.equals("deposit")){
				account1 = in.nextInt();
				balance = in.nextDouble();
				BankAccount bAcctOne = find(account1);
				
					if(balance > 0){
					bAcctOne.deposit(balance);
					}
			}
			
			else if(method.equals("withdraw")){
				account1 = in.nextInt();
				balance = in.nextDouble();
				BankAccount bAcctOne = find(account1);
				
					if(balance < bAcctOne.getBalance() && balance > 0){
					bAcctOne.withdraw(balance);
					}
			}
			
			else if(method.equals("transfer")){
				account1 = in.nextInt();
				account2 = in.nextInt();
				balance = in.nextDouble();
				BankAccount bAcctOne  = find(account1);
				BankAccount bAcctTwo = find(account2);
				
					if(balance < bAcctOne.getBalance() && balance > 0){
					bAcctOne.transfer(bAcctTwo, balance);
					}
			}
		
		}
		
	}

	/**
	 * Gets the sum of the balances of all accounts in this bank.
	 * @return the sum of the balances
	 */
	public double getTotalBalance()
	{
		double total = 0;
		for (BankAccount a : accounts)
		{
			total = total + a.getBalance();
		}
		return total;
	}

	/**
	 * Counts the number of bank accounts whose balance is at
	 * least a given value.
	 * @param atLeast the balance required to count an account
	 * @return the number of accounts having least the given balance
	 */
	public int countBalancesAtLeast(double atLeast)
	{
		int matches = 0;
		for (BankAccount a : accounts)
		{
			if (a.getBalance() >= atLeast) matches++; // Found a match
		}
		return matches;
	}

	/**
	 * Finds a bank account with a given number.
	 * @param accountNumber the number to find
	 * @return the account with the given number, or null if there
	 * is no such account
	 */
	public BankAccount find(int accountNumber)
	{
		for (BankAccount a : accounts)
		{
			if (a.getAccountNumber() == accountNumber) // Found a match
				return a;
		} 
		// No match in the entire array list
		throw new IllegalArgumentException("Account number " + accountNumber + " was not found in the bank");
	}

	/**
	 * Gets the bank account with the largest balance.
	 * @return the account with the largest balance, or null if the
	 * bank has no accounts
	 */
	public BankAccount getMaximum()
	{
		if (accounts.size() == 0) return null;
		BankAccount largestYet = accounts.get(0);
		for (int i = 1; i < accounts.size(); i++) 
		{
			BankAccount a = accounts.get(i);
			if (a.getBalance() > largestYet.getBalance())
				largestYet = a;
		}
		return largestYet;
	}
   
	/**
	 * Return a string that describes all the accounts in the bank.
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		for (BankAccount a : accounts)
		{
			sb.append(a.toString());
			sb.append('\n');
		}
		return sb.toString();
	}
}
