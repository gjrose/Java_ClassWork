package pa1;

public class Mileage {
	public static void main(String[] args) {
		int initialReading;
		int finalReading;
		double gasUsed;
		double mpg;
		
		gasUsed = 6.7;
		finalReading = 1346;
		initialReading = 1286;
		mpg = (finalReading - initialReading)/gasUsed;
		
		System.out.println("The fuel efficiency is " +mpg);
	}	
}
