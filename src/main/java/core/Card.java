package core;

public class Card {
	public String suit="";
	public String rank="";
	
	public static final String[] suits = {"C", "D", "H", "S"};
    public static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

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
	
	public int CheckSuit(String suit) {
        for (int x = 0; x < suits.length; x++) {
            if(suits[x].equals(suit)) {
                return x;
            }
        }
        return -1;
    }

    public int CheckRank(String rank) {
        for (int x = 0; x < ranks.length; x++) {
            if(ranks[x].equals(rank)) {
                return x;
            }
        }
        return -1;
    }
    
    public boolean Higherthan(Card c) {
        if ( (CheckRank(this.rank)>CheckRank(c.rank)) || (this.rank.equals(c.rank) && (CheckSuit(this.suit) > CheckSuit(c.suit)) ) ) {
            return true;
        }
        return false;
    }

	
	public void printCard(){
		System.out.print(this.suit+""+this.rank+ " ");
	}
}
