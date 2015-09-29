package r10;
import java.util.*;
public class ArrayListPractice //COM_S 207 section 3, Gentry Rose
{
	public static void main (String[] args)
 {
	Scanner stdin = new Scanner(System.in);	
	ArrayList<Integer> data = new ArrayList<Integer>();
	System.out.println("Enter a list of integers, end the list by typing a non-integer");
		while (stdin.hasNextInt()) 
		{
		int num = stdin.nextInt();
		data.add(num);
		}
	System.out.println(printList(data));
	System.out.println(sumList(data)/data.size());
 }
	
	public static String printList(ArrayList<Integer> list)
	{
		String print = "";
		for(int i = 0; i<list.size(); i++) 
		{
		System.out.print(list.get(i) + " " );
		}
		return print;
	}
	public static int sumList(ArrayList<Integer> list)
	{
		int sum = 0;
		for(int i = 0; i<list.size(); i++) 
		{
		sum = list.get(i) + sum;
		}
		return sum;
	}
}
