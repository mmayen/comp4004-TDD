package core;

public class Card {
	public String suit="";
	public String rank="";
;

	Card(String suit, String rank){
		this.suit= suit;
		this.rank= rank;
	}
	
	public String getSuit(){
		return this.suit;
	}
	
	public String getRank(){
		return this.rank;
	}
	
	public boolean equals(Object o){
		
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
}
