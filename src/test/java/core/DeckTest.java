package core;

import java.util.ArrayList;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

	public void testDrawCard(){
		Deck deck = new Deck();
        Card card = deck.drawCard();
       
        boolean result = true;
        
        // ensure that the card we draw from deck is removed from deck
        for (int index = 0; index < deck.cards.size(); index++) {
            if(card.equals(deck.cards.get(index))) {
                result = false;
            }
        }
        assertTrue(result);
    }
	
	public void testRemoveHand(){
		Deck deck = new Deck();//create deck
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C","7"));
		cards.add(new Card("S","K"));
		cards.add(new Card("D","Q"));
		cards.add(new Card("H","7"));
		cards.add(new Card("C","A")); //create arraylist of cards
		
		Hand hand = new Hand(cards);//create hand of cards arraylist
		
		deck.removeHand(hand);
		assertEquals(47, deck.cards.size());
    }
}
