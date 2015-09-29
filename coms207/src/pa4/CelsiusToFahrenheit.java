package pa4;

public class CelsiusToFahrenheit 
{
	public static void main(String[] args) 
	{
		int degC = 0;
		double degF = 0;
		
		System.out.println("Celsius		     Fahrenheit");
		
		for (int i = 0; i <= 100; i++) 
		{
		degC = i;
		degF = i * 9/5 + 32;     //Fahrenheit conversion
		
		if (degC %10 == 0)		//Print determinate
			
		System.out.println(degC+"			"+degF);
			
		}
		
	}
}
