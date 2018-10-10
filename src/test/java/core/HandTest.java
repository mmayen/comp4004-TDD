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
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");
		Hand hand9 = new Hand("src/main/resources/TwoPairRank");
		Hand hand10 = new Hand("src/main/resources/TwoRank");
		Hand hand11 = new Hand("src/main/resources/OneAwayFromRoyalFlush");
		Hand hand12 = new Hand("src/main/resources/Flush");

		
		assertTrue(hand3.isFullHouse());
		assertFalse(hand1.isFullHouse());
		assertFalse(hand2.isFullHouse());
		assertFalse(hand4.isFullHouse());
		assertFalse(hand5.isFullHouse());
		assertFalse(hand6.isFullHouse());
		assertFalse(hand7.isFullHouse());
		assertFalse(hand8.isFullHouse());
		assertFalse(hand9.isFullHouse());
		assertFalse(hand10.isFullHouse());
		assertFalse(hand11.isFullHouse());
		assertFalse(hand12.isFullHouse());
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
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");
		Hand hand9 = new Hand("src/main/resources/TwoPairRank");
		Hand hand10 = new Hand("src/main/resources/TwoRank");
		Hand hand11 = new Hand("src/main/resources/OneAwayFromRoyalFlush");
		Hand hand12 = new Hand("src/main/resources/Flush");


		assertTrue(hand3.isStraight());
		assertFalse(hand1.isStraight());
		assertTrue(hand2.isStraight());
		assertFalse(hand4.isStraight());
		assertFalse(hand5.isStraight());
		assertFalse(hand6.isStraight());
		assertFalse(hand7.isStraight());
		assertFalse(hand8.isStraight());
		assertFalse(hand9.isStraight());
		assertFalse(hand10.isStraight());
		assertFalse(hand11.isStraight());
		assertFalse(hand12.isStraight());
	}
	
	public void testIsThreeSequence(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");
		Hand hand9 = new Hand("src/main/resources/TwoPairRank");
		Hand hand10 = new Hand("src/main/resources/TwoRank");
		Hand hand11 = new Hand("src/main/resources/OneAwayFromRoyalFlush");
		Hand hand12 = new Hand("src/main/resources/Flush");
		
		assertTrue(hand4.ThreeInSequence());
		assertFalse(hand1.ThreeInSequence());
		assertFalse(hand2.ThreeInSequence());
		assertFalse(hand3.ThreeInSequence());
		assertFalse(hand5.ThreeInSequence());
		assertFalse(hand6.ThreeInSequence());
		assertFalse(hand7.ThreeInSequence());
		assertFalse(hand8.ThreeInSequence());
		assertFalse(hand9.ThreeInSequence());
		assertFalse(hand10.ThreeInSequence());
		assertFalse(hand11.ThreeInSequence());
		assertFalse(hand12.ThreeInSequence());
	}
	
	public void testIsFourOfARank(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");
		Hand hand9 = new Hand("src/main/resources/TwoPairRank");
		Hand hand10 = new Hand("src/main/resources/TwoRank");
		Hand hand11 = new Hand("src/main/resources/OneAwayFromRoyalFlush");
		Hand hand12 = new Hand("src/main/resources/Flush");

		assertTrue(hand5.FourRank());
		assertFalse(hand1.FourRank());
		assertFalse(hand2.FourRank());
		assertFalse(hand3.FourRank());
		assertFalse(hand4.FourRank());
		assertFalse(hand6.FourRank());
		assertFalse(hand7.FourRank());
		assertFalse(hand8.FourRank());
		assertFalse(hand9.FourRank());
		assertFalse(hand10.FourRank());
		assertFalse(hand11.FourRank());
		assertFalse(hand12.FourRank());
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
		Hand hand9 = new Hand("src/main/resources/Fullhouse");


		assertTrue(hand7.ThreeRank());
		assertFalse(hand1.ThreeRank());
		assertFalse(hand2.ThreeRank());
		assertFalse(hand3.ThreeRank());
		assertFalse(hand4.ThreeRank());
		assertFalse(hand5.ThreeRank());
		assertFalse(hand4.ThreeRank());
		assertFalse(hand6.ThreeRank());
		assertFalse(hand8.ThreeRank());
		assertTrue(hand9.ThreeRank());
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
		Hand hand9 = new Hand("src/main/resources/TwoPairRank");
		Hand hand10 = new Hand("src/main/resources/TwoRank");
		Hand hand11 = new Hand("src/main/resources/OneAwayFromRoyalFlush");
		
		assertNotSame(-1, hand8.hasThreeOfSameSuit());
		assertEquals(-1, hand1.hasThreeOfSameSuit());
		assertEquals(-1, hand2.hasThreeOfSameSuit());
		assertEquals(-1, hand3.hasThreeOfSameSuit());
		assertEquals(-1, hand4.hasThreeOfSameSuit());
		assertEquals(-1, hand5.hasThreeOfSameSuit());
		assertEquals(-1, hand4.hasThreeOfSameSuit());
		assertEquals(-1, hand6.hasThreeOfSameSuit());
		assertEquals(-1, hand7.hasThreeOfSameSuit());
		assertEquals(-1, hand9.hasThreeOfSameSuit());
		assertEquals(-1, hand10.hasThreeOfSameSuit());
		assertEquals(-1, hand11.hasThreeOfSameSuit());
	}
	
	public void testIsTwoPairOfARank(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");
		Hand hand9 = new Hand("src/main/resources/TwoPairRank");
		Hand hand10 = new Hand("src/main/resources/TwoRank");
		Hand hand11 = new Hand("src/main/resources/OneAwayFromRoyalFlush");
		
		assertTrue(hand9.TwopairRank());
		assertFalse(hand1.TwopairRank());
		assertFalse(hand2.TwopairRank());
		assertFalse(hand3.TwopairRank());
		assertFalse(hand4.TwopairRank());
		assertFalse(hand5.TwopairRank());
		assertFalse(hand6.TwopairRank());
		assertFalse(hand7.TwopairRank());
		assertFalse(hand8.TwopairRank());
		assertFalse(hand10.TwopairRank());
		assertFalse(hand11.TwopairRank());
	}
	
	public void testIsTwoOfARank(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");
		Hand hand9 = new Hand("src/main/resources/TwoPairRank");
		Hand hand10 = new Hand("src/main/resources/TwoRank");
		Hand hand11 = new Hand("src/main/resources/OneAwayFromRoyalFlush");
		
		assertTrue(hand10.TwoRank());
		assertFalse(hand1.TwoRank());
		assertFalse(hand2.TwoRank());
		assertFalse(hand3.TwoRank());
		assertTrue(hand4.TwoRank());//my textfile also has two Sameranks
		assertFalse(hand5.TwoRank());
		assertFalse(hand6.TwoRank());
		assertFalse(hand7.TwoRank());
		assertFalse(hand8.TwoRank());
		assertFalse(hand9.TwoRank());
		assertFalse(hand11.TwoRank());
	}
	
	public void testOneAwayFrom(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");
		Hand hand9 = new Hand("src/main/resources/OneAwayFromRoyalFlush");
		Hand hand10 = new Hand("src/main/resources/Fullhouse");
		Hand hand11 = new Hand("src/main/resources/Flush");
		Hand hand12 = new Hand("src/main/resources/TwoPairRank");
		
		assertNotSame(-1, hand9.OneAwayFrom());
		assertEquals(-1, hand12.OneAwayFrom());
		assertEquals(-1, hand1.OneAwayFrom());
		assertEquals(-1, hand2.OneAwayFrom());
		assertEquals(-1, hand10.OneAwayFrom());
		assertEquals(-1, hand11.OneAwayFrom());
		assertEquals(-1, hand3.OneAwayFrom());
		assertEquals(-1, hand4.OneAwayFrom());
		assertEquals(-1, hand5.OneAwayFrom());
		assertEquals(-1, hand6.OneAwayFrom());
		assertEquals(-1, hand7.OneAwayFrom());
		assertEquals(-1, hand8.OneAwayFrom());
	}
	
	public void testChangeHand(){
		Hand hand1 = new Hand("src/main/resources/RoyalFlush");
		Hand hand2 = new Hand("src/main/resources/StraightFlush");
		Hand hand3 = new Hand("src/main/resources/Straight");
		Hand hand4 = new Hand("src/main/resources/ThreeSequence");
		Hand hand5 = new Hand("src/main/resources/FourRank");
		Hand hand6 = new Hand("src/main/resources/FiveRank");
		Hand hand7 = new Hand("src/main/resources/ThreeRank");
		Hand hand8 = new Hand("src/main/resources/ThreeSuit");
		Hand hand9 = new Hand("src/main/resources/OneAwayFromRoyalFlush");
		Hand hand10 = new Hand("src/main/resources/Fullhouse");
		Hand hand11 = new Hand("src/main/resources/Flush");
		Hand hand12 = new Hand("src/main/resources/TwoPairRank");
		
		hand8.changeHand();
		
	}

}
