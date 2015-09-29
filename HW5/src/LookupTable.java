import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
   A table for lookups and reverse lookups
*/
public class LookupTable
{ 
   private ArrayList<Item> byName;
   private ArrayList<Item> byEmail;

   /**
      Constructs a LookupTable object.
   */
   public LookupTable()
   { 
      byName = new ArrayList<Item>();
      byEmail = new ArrayList<Item>();
   }
   
   /**
      Reads name and email pairs from the Scanner
      and adds them to the byName and byEmail array lists.
      @param in -- Scanner for reading the input
   */
   public void read(Scanner in) 
   { 
      while (in.hasNextLine())
      {
    	 String name = in.nextLine();
    	 String email = in.nextLine();
    	 byName.add(new Item (name, email));
    	 byEmail.add(new Item (email, name));
      }
      // Sort the byName Items so we can binary search
      Collections.sort(byName);
      // Sort the byEmail Items so we can binary search
      Collections.sort(byEmail);
   }
   
   /**
      Looks up an item in the table.
      @param k the key to find
      @return the value with the given key, or null if no
      such item was found.
   */
   public String lookup(String k)
   {
	
	  int pos = Collections.binarySearch(byName, new Item (k,null));
	  if(pos < 0){
		  return null;
	  }
	  else{
		  Item Name = byName.get(pos);
		  String email = Name.getValue();
		  return email;
	  }
      // Use the Collections.binarySearch() method to find the
      // position of the matching name in the byName array list.
      // Return null if a match is not found.
      // Otherwise, return the email address for the found name.
   
   }

   /**
      Looks up an item in the table.
      @param v the value to find
      @return the key with the given value, or null if no
      such item was found.
   */
   public String reverseLookup(String v)
   { 
	   int pos = Collections.binarySearch(byEmail, new Item (v,null));
		 if(pos < 0){
			 return null;
		 }
		 else{
			 Item Email = byEmail.get(pos);
			 String name = Email.getValue();
			 return name;
		 }
      // Use the Collections.binarySearch() method to find the
      // position of the matching email address in the byEmail array list.
      // Return null if a match is not found.
      // Otherwise, return the name for the found email address.
     
   }
}

