package r12;
import java.io.*;
import java.util.*;

public class TestCard {
	public static void main (String[] args)
	{
		Card c1 = new Card("HEART", 2);
		Card c2 = new Card("SPADE", 4);
		Card c3 = new Card("CLUB", 12);
		Card c4 = new Card("DIAMOND", 1);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		
	}
}
