package core;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	ArrayList<Card> cards;
	Random rand;
	
	Deck() {
		this.cards = new ArrayList<Card>();
		this.rand = new Random();
		for (int s = 0; s < 4; s++) { // x = suits
			for (int r = 0; r < 13; r++) { // y = ranks
                cards.add( new Card(s, r) );
            }
        }
	}
	
	public Card drawCard(){
		Card c = this.cards.get( this.rand.nextInt(this.cards.size()) );
		this.cards.remove(c);
		return c;
	}
	
	public void removeHand(Hand hand){
		for (int x = 0; x < this.cards.size(); x++) {
            for (int y = 0; y < hand.cards.size(); y++) {
                if (this.cards.get(x).equals(hand.cards.get(y))) {
                    this.cards.remove(x);
                }
            }
        }
	}
}
