package r3;

public class R3PrintName {
	
	public static void main(String[] args){
		
		// declare a String variable named firstName
		// Assign "John" to firstName
		String firstName;
		firstName = "John";
		String str1 = firstName.substring(0,3);
		int firstLen = firstName.length();
		
		// declare a String variable named lastName
		// Assign "Atanasoff" to lastName
		String lastName; 
		lastName = "Atanasoff";
		String str2 = lastName.substring(1,7);
		int secondLen = lastName.length();
		
		// Concatenate firstName and lastName
		// and assign to fullName
		String fullName;
		fullName = firstName + lastName;
		int fullLen = fullName.length();
		
		// print
		System.out.println(fullName);
		System.out.println(firstLen);
		System.out.println(secondLen);
		System.out.println(fullLen);
		System.out.println(str1);
		System.out.println(str2);
		
	} // end of main method
} // end of R3PrintName class declaration
