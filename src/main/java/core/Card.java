package core;

public class Card {
	public String suit="";
	public String rank="";
	
	private static final String[] suits = {"C", "D", "H", "S"};
    private static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

	Card(String suit, String rank) {
		this.suit= suit;
		this.rank= rank;
	}
	
	Card(Integer suit, Integer rank) {
		this.suit = whatSuit(suit);
	    this.rank = whatRank(rank);
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public String getRank() {
		return this.rank;
	}
	
	public boolean equals(Object o) {
		
		if (!(o instanceof Card)) {
            return false;
        }
		
		if(o == this){
			return true;
		}
		else{
			Card card = (Card) o;
	        if (this.suit == card.suit && this.rank == card.rank) {
	            return true;
	        }
	    }
		return false;
	}
	
	public String whatSuit(Integer suit){
		return suits[suit];
	}
	
	public String whatRank(Integer rank){
		return ranks[rank];
	}
	
	public void printCard(){
		System.out.println(this.suit+""+this.rank);
	}
}
