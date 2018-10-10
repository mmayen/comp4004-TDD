package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		this.cards= tocards;
    }
	
	Hand() {
    }
	
	private String readFile(String url){
		File file = new File(url); 
		String hand = "";
		try {
			sc = new Scanner(file);
			hand = sc.nextLine(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return hand;
	}
	public Hand[] handsFromInputFile(int line) {
        return handsFromInputFile(line, "src/main/resources/inputfile");
    }

    public Hand[] handsFromInputFile(int line, String path) {
        String fileContent = readFile(path);
        System.out.println(fileContent);
        //String theLine = fileContent.split("\\r?\\n")[line - 1];
        ArrayList<Card> AICards = new ArrayList<Card>();
        ArrayList<Card> userCards = new ArrayList<Card>();

        String[] splitCards = fileContent.split(" ");

        for (int x = 0; x < 5; x++) {
           AICards.add(new Card(splitCards[x].substring(0,1), splitCards[x].substring(1)));
        }

        for (int x = 5; x < 10; x++) {
            userCards.add(new Card(splitCards[x].substring(0,1), splitCards[x].substring(1)));
        }

        Hand[] hands = {new Hand(AICards), new Hand(userCards)};
        return hands;
    }


    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public Hand[] handsFromFile(String path) {
        try {
            System.out.println("Reading file: " + path);
            String fileContent = readFileAsString(path);
            String[] cards = fileContent.split(" ");
            ArrayList<Card> AICards = new ArrayList<Card>();
            ArrayList<Card> userCards = new ArrayList<Card>();
            System.out.println("Contents of file: " + fileContent);

            for (int x = 0; x < 5; x++) {
                AICards.add(new Card(cards[x].substring(0,1), cards[x].substring(1)));
            }

            for (int x = 5; x < 10; x++) {
                userCards.add(new Card(cards[x].substring(0,1), cards[x].substring(1)));
            }

            Hand[] hands = {new Hand(AICards), new Hand(userCards)};
            return hands;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            Hand[] hands = {};
            return hands;
        }

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
    
    public int hasThreeOfSameSuit() {
        for (int x = 0; x < cards.size(); x++) {
            if (countSameSuit(cards.get(x).suit) == 3) {
                return x;
            }
        }
        return -1;
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

    public boolean ThreeInSequence() {
		if(this.isStraightFlush() || this.isStraight()){
			return false;
		}
		
		else{
			int[] order = new int[5];
			
			for (int x = 0; x < cards.size(); x++) {
				for(int y = 0; y < Card.ranks.length; y++){
					if(cards.get(x).rank.equals(Card.ranks[y])){
						order[x] = y; //for each card in Hand save the position of its rank according to rank-order array in Card class
					}
				}
			}
			
			for (int x = 0; x < 3; x++) {
	            if ( ((order[x]) == (order[x+1] + 1)) &&  ((order[x+1]) == (order[x+2] + 1)) ) {
	                return true;
	            }
	        }	
		}
		return false;
	}
    
    public int OneAwayFrom(){
    	Deck deck = new Deck();
        deck.removeHand(this);
        
        if(this.isRoyalFlush() || this.isFullHouse() || this.isStraightFlush() || this.Flush() || this.isStraight() ){
		return -1;
        }
        
        else{
        	for (int x = 0; x < this.cards.size(); x++) {
        		Hand hand = this;
        		Card c = hand.cards.get(x);
                for (int y = 0; y < deck.cards.size(); y++) {
                	hand.cards.remove(c);//remove the first card in hand
                    hand.cards.add(x, deck.cards.get(y));// add a card from the deck to that position
                    if (hand.isStraight() || hand.Flush() || hand.isStraightFlush() || hand.isRoyalFlush()) {
                    	//for each position of my hand if i add any new card from the deck 
                    	//does my hand become straight, flush, straightFlush, royalflush ?
                    	return x;
                    }
                    else{
                    	hand.cards.remove(x);
                    	hand.cards.add(x, c);
                    }
                }
        	}
        }
        return -1;
    }
    
    public void sortByRank() {
        ArrayList<Card> c = new ArrayList<Card>();
        Card highestCard;
        int highestIndex;
        for (int x = 0; x < this.cards.size(); x++) {
            highestCard = this.cards.get(x);
            highestIndex = x;
            for (int y = x; y < this.cards.size(); y++) {
                if (highestCard.CheckRank(highestCard.rank) <= this.cards.get(y).CheckRank(this.cards.get(y).rank)) {
                    Card copy = this.cards.get(y);
                	highestCard = copy;
                    highestIndex = y;
                }
            }
            this.cards.remove(highestIndex);
            this.cards.add(0, highestCard);
        }

    }
   
    public Hand changeHand(){
    	Deck deck = new Deck();
        deck.removeHand(this);
        int pos;
        // Don't improve if straight or better
        if (this.isStraight() || this.Flush() || this.isFullHouse() || this.FourRank() || this.isRoyalFlush()) {
        	System.out.print("Doing Nothing");
        }
        // if one card away from straight, full house, flush, royalflush, straightflush then exchange the card
        else if(-1 != (pos= this.OneAwayFrom())){
        	System.out.print("Removing: ");
            this.cards.get(pos).printCard();
        	this.cards.remove(pos);
            
            Card replacement = deck.drawCard();
        	this.cards.add(pos, replacement);
        	System.out.print("...Replacing with: ");
            replacement.printCard();
        }
        else if(this.hasThreeOfSameSuit() != -1){
        	int count = 0;
        	for (int x = 0; x < this.cards.size(); x++) {
                if (x != this.hasThreeOfSameSuit()) {
                	System.out.print("Removing: ");
                    this.cards.get(x).printCard();
                	this.cards.remove(x);
                	count++;
                } 
            }
        	while(count!=0){
        		Card replacement = deck.drawCard();
                this.cards.add(0, replacement);
                System.out.print("...Replacing with: ");
                replacement.printCard();
                count--;
        	}
        }
        else if(this.ThreeRank()){
        	
        }
        else if (ThreeInSequence()) {
        	System.out.print("Removing: ");
            this.cards.get(this.cards.size() - 1).printCard();
            this.cards.get(this.cards.size() - 2).printCard();

            this.cards.remove(this.cards.size() - 1);
            this.cards.remove(this.cards.size() - 1);
            this.cards.add(deck.drawCard());
            this.cards.add(deck.drawCard());
        	System.out.print("...Hand is now: ");
        	this.print();
        } 
        else if(this.TwopairRank()){
        	
        }
        else if(this.TwoRank()){
        	
        }
        else{
        	//keeps two highest cards
        }
        
		return this;
    }

    public void print() {
        for (int x = 0; x < this.cards.size(); x++) {
            this.cards.get(x).printCard();
        }
    }
}

