package r3;
	import java.util.Scanner;
		public class Rectangle {
			public static void main(String[] args){
				
				Scanner stdin = new Scanner(System.in);
				
				System.out.println("Enter width and length");
				double width = stdin.nextDouble();
				double length = stdin.nextDouble();
				
				double area = width * length;
				double perimeter = 2 * width * length;
				
				System.out.print("area: " +area);
				System.out.print(", perimeter: " +perimeter);
			}
}
