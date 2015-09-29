/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount
{  
   private double balance;
   private int accountNumber;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount(int _accountNumber)
   {   
      balance = 0;
      accountNumber = _accountNumber;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(int _accountNumber, double initialBalance)
   {   
      balance = initialBalance;
      accountNumber = _accountNumber;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {  
         double newBalance = balance + amount;
         balance = newBalance;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {   
         double newBalance = balance - amount;
         balance = newBalance;
   }

   /**
   Withdraws money from the bank account.
   @param amount the amount to withdraw
    */
   public void transfer(BankAccount other, double amount)
   {
	   this.balance = this.balance - amount;
	   other.balance = other.balance + amount;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {   
      return balance;
   }
   
   /**
    * Gets the number assigned to this back account.
    * @return account number
    */
   public int getAccountNumber()
   {
	   return accountNumber;
   }
   
   /**
    * Return a string describing this bank account.
    */
   public String toString()
   {
	   return "Account: " + accountNumber + " Balance: " + String.format("%.2f", balance);
   }
}

