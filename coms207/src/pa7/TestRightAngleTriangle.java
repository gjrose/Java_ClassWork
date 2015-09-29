package pa7;
import java.io.File;
import java.util.Scanner;
public class TestRightAngleTriangle {
	

	public static void main(String[] args){
		Scanner id = new Scanner(System.in);
	
		RightAngleTriangle unitRightAngleTriangle = new RightAngleTriangle();
		
		RightAngleTriangle r1 = new RightAngleTriangle(5,4);
		
		
		System.out.println("Enter non-zero values for height and width and create a RightAngleTriangle");
		int hei = id.nextInt();  
		int wid = id.nextInt();  
		RightAngleTriangle r2 = new RightAngleTriangle(hei,wid);
	
		double r1area = r1.area();
		System.out.println(r1area);
		
		
		
		//print area and perimeter of all triangles
		System.out.println("unitRightAngleTriangle area = "+unitRightAngleTriangle.area()+" perimeter = "+unitRightAngleTriangle.perimeter());
		System.out.println("r1 area = "+r1.area()+" perimeter = "+r1.perimeter());
		System.out.println("r2 area = "+r2.area()+" perimeter = "+r2.perimeter());
		
		//Determine isosceles status
		boolean uRATIso = unitRightAngleTriangle.isIsosceles();
		boolean r1Iso = r1.isIsosceles();
		boolean r2Iso = r2.isIsosceles();
		
		
		
		//outputs largest Triangle
		if(largerThan(r2,unitRightAngleTriangle) == true && largerThan(r2,r1) == true){
			System.out.println("r2");
			}
		else{
			System.out.println("r1");
			}
			
		}
	
	
	public static boolean largerThan(RightAngleTriangle RightAngleTriangle, RightAngleTriangle anotherRightAngleTriangle){ //Returns true if area of RightAngleTriangle is larger than the area of anotherRightAngleTriangle
		boolean result = false;
		if(RightAngleTriangle.area() > anotherRightAngleTriangle.area()){
		result = true;
		}
		return result;
		}
	


}
	
