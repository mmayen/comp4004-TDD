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
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		
		assertTrue(hand4.ThreeInSequence());
		assertFalse(hand1.ThreeInSequence());
		assertFalse(hand2.ThreeInSequence());
		assertFalse(hand3.ThreeInSequence());
	}
	
	public void testIsFourOfARank(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");

		assertTrue(hand5.FourRank());
		assertFalse(hand1.FourRank());
		assertFalse(hand2.FourRank());
		assertFalse(hand3.FourRank());
		assertFalse(hand4.FourRank());
		assertFalse(hand6.FourRank());
		assertFalse(hand7.FourRank());
	}
	
	public void testIsThreeOfARank(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");

		assertTrue(hand7.ThreeRank());
		assertFalse(hand1.ThreeRank());
		assertFalse(hand2.ThreeRank());
		assertFalse(hand3.ThreeRank());
		assertFalse(hand4.ThreeRank());
		assertFalse(hand5.ThreeRank());
		assertFalse(hand4.ThreeRank());
		assertFalse(hand6.ThreeRank());
		assertFalse(hand8.ThreeRank());

	}
	
	public void testIsThreeOfASuit(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");
		
		assertTrue(hand8.hasThreeOfSameSuit());
		assertFalse(hand1.hasThreeOfSameSuit());
		assertFalse(hand2.hasThreeOfSameSuit());
		assertFalse(hand3.hasThreeOfSameSuit());
		assertFalse(hand4.hasThreeOfSameSuit());
		assertFalse(hand5.hasThreeOfSameSuit());
		assertFalse(hand4.hasThreeOfSameSuit());
		assertFalse(hand6.hasThreeOfSameSuit());
		assertFalse(hand7.hasThreeOfSameSuit());
	}
	
	public void testIsTwoPairOfARank(){

	}
	
	public void testIsTwoOfARank(){

	}
	
	public void testKeepTwo(){
		
	}

}
