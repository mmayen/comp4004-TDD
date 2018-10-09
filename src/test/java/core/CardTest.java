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
	
	public void testCheckSuit(){
		Card card1 = new Card("S", "K");
		Card card2 = new Card("D", "7");

		assertEquals(3, card1.CheckSuit(card1.getSuit()));
		assertEquals(1, card2.CheckSuit(card2.getSuit()));
	}
	
	public void testCheckRank(){
		Card card1 = new Card("S", "K");
		Card card2 = new Card("D", "7");

		assertEquals(11, card1.CheckRank(card1.getRank()));
		assertEquals(5, card2.CheckRank(card2.getRank()));
	}
	
	public void testRanking() {
        String[] suits = {"C", "D", "H", "S"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        Card card = new Card("S", "7");

        for (int x = 0; x < suits.length; x++) {
            suits[x].equals(card.suits[x]);
        }
        for (int x = 0; x < ranks.length; x++) {
            ranks[x].equals(card.ranks[x]);
        }
    }

	public void testHigher(){
		
		assertFalse(new Card("S", "K").Higherthan(new Card("S", "K")));
		assertFalse(new Card("D", "2").Higherthan(new Card("D", "8")));
		assertFalse(new Card("D", "A").Higherthan(new Card("S", "A")));
		assertFalse(new Card("S", "5").Higherthan(new Card("H", "6")));
		assertTrue(new Card("D", "Q").Higherthan(new Card("H", "J")));
		assertTrue(new Card("S", "5").Higherthan(new Card("H", "5")));
		assertTrue(new Card("D", "5").Higherthan(new Card("C", "5")));
		assertTrue(new Card("S", "5").Higherthan(new Card("S", "4")));
	}
}
