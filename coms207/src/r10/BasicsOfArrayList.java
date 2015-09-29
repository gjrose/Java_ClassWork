package r10;
import java.util.*;
public class BasicsOfArrayList //COM_S 207 section 3, Gentry Rose
{
	
	public static void main (String[] args)
 {
	Scanner stdin = new Scanner(System.in);
	ArrayList<Integer> scores = new ArrayList<Integer>();
	ArrayList<Double> data = new ArrayList<Double>();
	
	System.out.println(scores.size());
	
	scores.add(56);
	System.out.println(scores.size());
	
	scores.add(-67);
	System.out.println(scores.size());
	
	System.out.println(scores.get(0));
	System.out.println(scores.get(1));
	
	scores.add(-78);
	
	for(int i = 1; i<= 5; i++) 
	{
		System.out.println("Please enter " + i +"th number");
		double num = stdin.nextDouble();
		data.add(num);
	}
	
	for(int i = 0; i<data.size(); i++) 
	{
	System.out.print(data.get(i) + " " );
	}
	System.out.println("");
	
	data.set(2, 99.0);
	
	System.out.println(data.get(2));
	
 }
}
