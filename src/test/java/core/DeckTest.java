package core;

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
}
