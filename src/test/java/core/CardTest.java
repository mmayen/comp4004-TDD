package core;

import junit.framework.TestCase;

public class CardTest extends TestCase {
 
	public void testGetSuit(){
		Card card = new Card();
		
		assertEquals("C", card.getSuit());
	}
	
	public void testGetRank(){
		Card card = new Card(); 
		 
		 assertEquals("7", card.getRank());
	}
	
	public void testEquals() {
		Card card = new Card(); 
		
		assertEquals(true, card.equals(new Card("C","7")));	 
    }
}
