package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hand {
	ArrayList<Card> cards;
	private Scanner sc = null;
	
	Hand(ArrayList<Card> cards){
		if (cards.size() != 5){
			throw new IllegalArgumentException("A hand requires 5 cards.");
		}
		this.cards = cards;
	}
	
	Hand(String path) {
		ArrayList<Card> tocards = new ArrayList<Card>();
		String fileread = readFile(path);
		String[] cards = fileread.split("\\s+");
		
		for(int x = 0; x < cards.length; x++) {
			String suit= cards[x].substring(0,1);
			String rank= cards[x].substring(1);
            Card card = new Card(suit, rank);
            tocards.add(card);
        }
		if (tocards.size() != 5) {
            throw new IllegalArgumentException("A hand requires 5 cards. Cards from " + path + "are not 5 in total");
        }
		else{
			this.cards= tocards;
		}
    }
	
	private String readFile(String url){
		File file = new File(url); 
		String hand = "";
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()){
				hand = sc.nextLine(); 
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return hand;
	}
	
	public int countSameRank(String rank) {
        int count = 0;
        for (int x = 0; x < this.cards.size(); x++) {
            if (this.cards.get(x).getRank().equals(rank)) {
                count++;
            }
        }
        return count;
    }
	
	public int countSameSuit(String suit) {
    	int count = 0;
        for (int x = 0; x < this.cards.size(); x++) {
            if (this.cards.get(x).getSuit().equals(suit)) {
                count++;
            }
        }
        return count;
    }
	
	public boolean isRoyalFlush(){
        boolean result= false;
        
        String[] royal = {"A", "K", "Q", "J", "10"};
        
        for (int x = 0; x < royal.length; x++) {
            for (int y = 0; y < royal.length; y++) {
                 if ( royal[x].equals(this.cards.get(y).getRank()) && (countSameSuit(this.cards.get(0).getSuit()) == 5) ) {
                     result = true;
                 }
            }
            if (!result) { 
            	return false; 
            }
        }
        return result;
	}
	
	public boolean isStraight() {
		int[] order = new int[5];
		boolean bool = true;
		for (int x = 0; x < cards.size(); x++) {
			for(int y = 0; y < Card.ranks.length; y++){
				if(cards.get(x).getRank().equals(Card.ranks[y])){
					order[x] = y;
				}
			}
		}
		for (int x = 0; x < (order.length-1); x++){
			if(order[x+1] != (order[x] - 1)){
				bool = false;
			}
		}		
		return bool;
	}
	
	public boolean isStraightFlush() {
		
		return ( this.isStraight() && (countSameSuit(this.cards.get(0).getSuit()) == 5));
	}
	
	public boolean isNumberOfRank(int n) {
        for (int x = 0; x < cards.size(); x++) {
            if (countSameRank(cards.get(x).rank) == n) {
                return true;
            }
        }
        return false;
    }
	
	public boolean FourRank() {
        return isNumberOfRank(4);
    }

    public boolean ThreeRank() {
        return isNumberOfRank(3);
    }
    
    public boolean hasThreeOfSameSuit() {
        for (int x = 0; x < cards.size(); x++) {
            if (countSameSuit(cards.get(x).suit) == 3) {
                return true;
            }
        }
        return false;
    }
    
    public boolean TwopairRank() {
    	int count = 0;
    	for (int x = 0; x < cards.size(); x++) {
            if (countSameRank(cards.get(x).getRank()) == 2) {
            	count++;
            }
        }
    	if(count == 4){return true; }

    	return false;
    }

    public boolean TwoRank() {
    	if(this.TwopairRank()) { return false; }
    	
        return isNumberOfRank(2);
    }
    
    public boolean isFullHouse() {
        if(!this.ThreeRank()){
        	return false;
        }
        else{
        	if(this.TwoRank()){
        		return true;
        	}
        }
        return false;
    }
	
    public boolean Flush() {
		if(this.isStraightFlush() || this.isRoyalFlush()){
			return false;
		}
		
		for (int x = 0; x < this.cards.size()-1; x++) {
			if ( countSameSuit(this.cards.get(x).getSuit()) == 5 ) {
                return true;
            }
        }
        return false;
	}
}
