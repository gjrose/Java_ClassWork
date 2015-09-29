package r12;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Deck{
	Card[] deck;
public Deck() {
	deck = new Card[52];
	
	for(int i = 0; i<52; i++){
		if (i /13 == 0){
			deck[i] = new Card("SPADE", i %13);
		}
		else if (i / 26 == 0) {
			deck[i] = new Card("HEART", i % 13 +1);
		}
		else if (i / 39 == 0) {
			deck[i] = new Card("CLUB", i % 13 +1);
		}
		else if (i / 52 == 0) {
			deck[i] = new Card("DIAMOND", i % 13);
		}
	}
}
	
	public Card getCard(int i){
		return deck[i];
	}
	
	public Card[] getHand(){
		Card[] hand = new Card[5];
		for(int i =0; i<5; i++){
		hand[i] = getCard(i);
		}
		return hand;
	}
	
	public Card[] shuffleDeck(){
		for(int i =0; i<52; i++){
			Random r = new Random();
			int pos = r.nextInt(52);
			deck[pos] = deck[i];
		}
		return deck;
	}	
}