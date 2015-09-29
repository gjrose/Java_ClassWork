package ExtraCredit;

public class ECWhile {
	public static void main(String[] args){

		int i = 0;
		int sum = 0;
		{
		while (sum < 10)
		{
		   i++; 
		   sum = sum + i;
		}
	 System.out.println(i + " and " + sum + "  //top left example");
	 
		int i1 = 0;
		int sum1 = 0;
		{
		while (sum1 < 0)
		{
		   i1++; 
		   sum1 = sum1 + i1;
		}
	 System.out.println(i1 + " and " + sum1 + "  //bottom left example");
	 
		int i2 = 0;
		int sum2 = 0;
		{
		while (sum2 < 10)
		{
		   i2++; 
		   sum2 = sum2 - i2;
		}
	 System.out.println(i2 + " and " + sum2 + "  //top right example");
	 
		int i3 = 0;
		int sum3 = 0;
		{
		while (sum3 >= 10)
		{
		   i3++; 
		   sum = sum3 + i3;
		}
	 System.out.println(i3 + " and " + sum3 + "  //bottom right example");
	}
	}
	}
	}
	}
	}