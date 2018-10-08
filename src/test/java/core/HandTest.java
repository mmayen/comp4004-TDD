package core;

import java.util.ArrayList;

import junit.framework.TestCase;

public class HandTest extends TestCase {

	public void testlessHandSize() {
		 boolean result = false;
		 try {
			 ArrayList<Card> lesscards = new ArrayList<Card>();
			 
			 for (int x = 0; x < 4; x++){
				 lesscards.add(new Card("C", "7"));
				 }
			 Hand hand = new Hand(lesscards);
	      }
		 catch (IllegalArgumentException e) {
			 result = true;
		 }
		 assertTrue(result);
	}
	
	public void testMoreHandSize() {
		boolean result = false;
		try {
			 ArrayList<Card> morecards = new ArrayList<Card>();
			 
			 for (int x = 0; x < 6; x++){
				 morecards.add(new Card("C", "7"));
				 }
			Hand hand = new Hand(morecards);
	        }
		 catch (IllegalArgumentException e) {
			 result = true;
			 }
		assertTrue(result);
	}
	
	public void testcalculateHand(){
		
	}
	
	public void testcountSameRank(){
		Hand hand= new Hand("src/main/resources/SameRank");
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		
		assertEquals(5, hand.countSameRank("6"));
		assertEquals(1, hand1.countSameRank("10"));
	}
	
	public void testcountSameSuit(){
		Hand hand= new Hand("src/main/resources/SameSuit");
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		
		assertEquals(5, hand.countSameSuit("C"));
		assertEquals(0, hand1.countSameSuit("C"));
	}
	
	public void testmakeHandfromFile(){
		boolean result = true;
		try {
			Hand hand= new Hand("src/main/resources/SameSuit");
			}
		catch (IllegalArgumentException e) {
			result = false;	
		}
		assertTrue(result);
	}
	
	public void testIsRoyalFlush(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		assertTrue(hand1.isRoyalFlush());
		assertFalse(hand2.isRoyalFlush());
	}
	
	public void testIsStraightFlush(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		assertTrue(hand2.isStraightFlush());
		assertFalse(hand1.isStraightFlush());
	}
	
	public void testIsFullhouse(){

	}
	
	public void testIsFlush(){

	}
	
	public void testIsStraight(){

	}
	
	public void testIsFourOfAkind(){

	}
	
	public void testIsThreeOfAkind(){

	}
	
	public void testIsTwoOfAkind(){

	}

}
