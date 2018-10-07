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

	}
	
	public void testIsStraightFlush(){

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
