package r4;
import java.util.Scanner;
public class Temperature {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("Enter temperature");
		if(stdin.hasNextDouble()){
			double temp = stdin.nextDouble();
			
			if(temp >= 80) {
				System.out.println("hot");}
			
			else if(temp >= 65){
				System.out.println("pleasant");}	
			
			else if(temp >= 50){
				System.out.println("chilly");}
			
			else if(temp < 50){
				System.out.println("cold");}}
		else {
		System.out.println("Invalid input");
}
}}