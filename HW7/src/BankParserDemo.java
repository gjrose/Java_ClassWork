/**
   This program parses an XML file containing an account list.
   It prints out the total balance of the bank accounts that 
   are described in the XML file.
*/
public class BankParserDemo
{
   public static void main(String[] args) throws Exception
   {
      BankParser parser = new BankParser();
      Bank b = parser.parse(args[0]);
      System.out.println("Accounts:\n" + b.toString());
      System.out.println("Total balance: " + b.getTotalBalance());
   }
}
