package pa7;

import java.util.Scanner;

public class RightAngleTriangle 
{
	
	//instance variables
	int height;
	int width;
	double hypotenuse;

	//default constructor
	public RightAngleTriangle(){ //Creates a RightAngleTriangle whose height and width is 1
		height = 1;
		width = 1;
		hypotenuse = Math.sqrt((height*height) + (width*width));
	}	
	
	//specific constructor
	public RightAngleTriangle(int hei, int wid){ //Creates a RightAngleTrianglewith height hei and width wid. If any of hei or wid are negative, then creates a RightAngleTriangle with height and width 1
	height = hei;
	width = wid;
	hypotenuse = Math.sqrt((hei*hei) + (wid*wid));
		if(hei <=0 || wid <=0){
		height = 1;
		width = 1;
		hypotenuse = Math.sqrt((hei*hei) + (wid*wid));
		}
	}

	//Methods
	public double area(){ //Returns the area of the RightAngleTriangle
		double area = (height*width)/2;
		return area;
	}
	
	public double perimeter(){ //Returns the perimeter of the RightAngleTriangle
		double perimeter = height + width + hypotenuse;
		return perimeter;
	}
	
	public boolean isIsosceles(){ //returns true if height is same as width
		boolean result = false;
		if(height == width){
		result = true;
		}
		return result;
	}
	
	public static boolean largerThan(RightAngleTriangle RightAngleTriangle, RightAngleTriangle anotherRightAngleTriangle){ //Returns true if area of RightAngleTriangle is larger than the area of anotherRightAngleTriangle
		boolean result = false;
		if(RightAngleTriangle.area() > anotherRightAngleTriangle.area()){
		result = true;
		}
		return result;
	}
	
}
