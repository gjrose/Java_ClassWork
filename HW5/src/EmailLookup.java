import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

/* The input file has the format

Abbott, Amy
aabott@gmail.com
Abeyta, Ric
rica@hotmail.com
Abrams, Arthur
abrams@yahoo.com
Abriam-Yago, Kathy
kathy@hushmail.com
Accardo, Dan
dana@outlook.com
Acevedo, Elvira
eacevedo@gmail.com
Acevedo, Gloria
gacevedo@gmail.com
Achtenhagen, Stephen
sachten@outlook.com
. . .

*/

public class EmailLookup
{
   public static void main(String[] args) throws IOException
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of the email list file: ");
      String fileName = in.nextLine();
 
      LookupTable table = new LookupTable();
      FileReader reader = new FileReader(fileName);
      table.read(new Scanner(reader));
      
      boolean more = true;
      while (more)
      {  
         System.out.println("Lookup by N)ame, E)mail, Q)uit?");
         String cmd = in.nextLine();
           
         if (cmd.equalsIgnoreCase("Q")) 
            more = false;
         else if (cmd.equalsIgnoreCase("N"))
         { 
            System.out.println("Enter name:");
            String n = in.nextLine();
            System.out.println("Email address: " + table.lookup(n));
         }
         else if (cmd.equalsIgnoreCase("E"))
         { 
            System.out.println("Enter email address:");
            String n = in.nextLine();
            System.out.println("Name: " + table.reverseLookup(n));
         }
      }
   }
}
