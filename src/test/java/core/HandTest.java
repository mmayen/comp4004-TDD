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
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/Flush");
		
		assertTrue(hand1.isRoyalFlush());
		assertFalse(hand2.isRoyalFlush());
		assertFalse(hand3.isRoyalFlush());
		assertFalse(hand4.isRoyalFlush());
	}
	
	public void testIsStraightFlush(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/Flush");

		
		assertTrue(hand2.isStraightFlush());
		assertFalse(hand1.isStraightFlush());
		assertFalse(hand3.isStraightFlush());
		assertFalse(hand4.isStraightFlush());
	}
	
	public void testIsFullhouse(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Fullhouse");
		
		assertTrue(hand3.isFullHouse());
		assertFalse(hand1.isFullHouse());
		assertFalse(hand2.isFullHouse());


	}
	
	public void testIsFlush(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Fullhouse");
		Hand hand4 = new Hand("src/main/resources/Flush");
		
		assertTrue(hand4.Flush());
		assertFalse(hand1.Flush());
		assertFalse(hand2.Flush());
		assertFalse(hand3.Flush());
	}
	
	public void testIsStraight(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");

		assertTrue(hand3.isStraight());
		assertFalse(hand1.isStraight());
		assertTrue(hand2.isStraight());
	}
	
	public void testIsThreeSequence(){

	}
	
	public void testIsFourOfARank(){

	}
	
	public void testIsThreeOfARank(){

	}
	
	public void testIsThreeOfASuit(){

	}
	
	public void testIsTwoPairOfARank(){

	}
	
	public void testIsTwoOfARank(){

	}
	
	public void testKeepTwo(){
		
	}

}
