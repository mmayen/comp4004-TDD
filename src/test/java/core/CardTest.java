package core;

import junit.framework.TestCase;

public class CardTest extends TestCase {
 
	public void testGetSuit(){
		Card card = new Card("C","7");
		
		assertEquals("C", card.getSuit());
	}
	
	public void testGetRank(){
		Card card = new Card("C","7"); 
		 
		 assertEquals("7", card.getRank());
	}
	
	public void testEquals() {
		Card card = new Card("C","7"); 
		
		assertEquals(true, card.equals(new Card("C","7")));	 
    }
	
	public void testWhatSuit(){
		Card card = new Card(0, 2);
		
		assertEquals("C", card.whatSuit(0));
	}
	
	public void testWhatRank(){
		Card card = new Card(0, 2);
		
		assertEquals("4", card.whatRank(2));
	}
}
