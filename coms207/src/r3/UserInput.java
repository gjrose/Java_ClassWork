package r3;

	import java.util.Scanner;
		public class UserInput {
			public static void main(String[] args){
				
				Scanner stdin = new Scanner(System.in);
				
				System.out.print("Enter an integer");
				int intNumber = stdin.nextInt();
				
				System.out.println("Enter any number");
				double number = stdin.nextDouble();
				
				System.out.println("Type two words");
				String firstWord = stdin.next();
				String secondWord = stdin.next();
				
				System.out.print("The words you typed are: ");
				System.out.println(firstWord+ " " + secondWord);
				System.out.println(number);
				System.out.print(intNumber);
	}
}
