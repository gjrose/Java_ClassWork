package r2;

public class UnderstandDivision {
	public static void main(String[] args) {
		int number;
		int lastDigit;
		double secondNumber;
		
		number = 675;
		secondNumber = 67;
		lastDigit = number%10;
		
		System.out.println(number/10);
		System.out.println(secondNumber/10);
		System.out.println(67%10);
		System.out.println(lastDigit);
	}
}
