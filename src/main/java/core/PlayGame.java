package core;

import java.util.ArrayList;

public class PlayGame {
	
    Hand aIP, handToBeat;


	public PlayGame(Hand aIP, Hand beat) {
		this.aIP= aIP;
		this.handToBeat= beat;
	}
	
	public boolean isBetter() {
        int aIPrank = handScore(this.aIP);
        int handToBeatRank = handScore(this.handToBeat);

        if (aIPrank > handToBeatRank) { // aip is better
            return true;
        }
        else if (aIPrank < handToBeatRank) { // handtobeat is better
            return false;
        }
        else { // tie
            switch (aIPrank) {
                case 10: // royal flush
                    return betterSuit();
                case 9: // straight flush
                    return AceStraightFlush();
                case 8: // four of a kind
                    return bestOfFourOfAKind(); //isBetterHighestCard();
                case 4: case 7: // full house & three of a kind
                    return bestOfThreeOfAKind();
                case 6:
                    return bestFlush();
                case 5:
                    return BestHighCard();
                case 3: case 2:
                    return isBetterPairs();
                case 1:
                    return BestHighCard();
            }
        }

        try {
            throw new Exception("Could not identify a winner from given hands");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
	
	public boolean isBetterPairs() {
		ArrayList<Card> h1filteredCards = filterCardsByRankCount(2, this.aIP);
        ArrayList<Card> h2filteredCards = filterCardsByRankCount(2, this.handToBeat);
        aIP.cards = h1filteredCards;
        handToBeat.cards = h2filteredCards;
        System.out.println();
        handToBeat.print();
        aIP.print();
        return BestHighCard();

	}

    public boolean bestFlush() {
    	this.aIP.sortByRank();
        this.handToBeat.sortByRank();
        ArrayList<Card> aipCards = this.aIP.cards;
        ArrayList<Card> handCards = this.handToBeat.cards;

        for (int x = 0; x < this.aIP.cards.size(); x++) {
            if (aipCards.get(x).rank != handCards.get(x).rank) {
                return (aipCards.get(x).CheckRank(aipCards.get(x).rank)  > handCards.get(x).CheckRank(handCards.get(x).rank) );
            }
        }

        return (aipCards.get(0).CheckSuit(aipCards.get(0).suit) > handCards.get(0).CheckSuit(handCards.get(0).suit));
	}

    public boolean bestOfFourOfAKind() {
    	ArrayList<Card> h1filteredCards = filterCardsByRankCount(4, this.aIP);
        ArrayList<Card> h2filteredCards = filterCardsByRankCount(4, this.handToBeat);
        aIP.cards = h1filteredCards;
        handToBeat.cards = h2filteredCards;
        return BestHighCard();
	}

    public boolean AceStraightFlush() {
    	 boolean AIHasAce = false, userHasAce = false;

         for (int x = 0; x < this.aIP.cards.size(); x++) {
             if (aIP.cards.get(x).getRank().equals("A")) {
                 AIHasAce = true;
             }
             if (handToBeat.cards.get(x).getRank().equals("A")) {
                 userHasAce = true;
             }
         }
         if (userHasAce && !AIHasAce) { return true; }
         if (!userHasAce && AIHasAce) { return false; }
         return BestHighCard();
	}

    public boolean betterSuit() {
	 Card betterAipCard = aIP.cards.get(0);
	 Card handtobeatCard = handToBeat.cards.get(0);

	 
     return (betterAipCard.CheckSuit(betterAipCard.suit) > handtobeatCard.CheckSuit(handtobeatCard.suit));
	}

    private boolean bestOfThreeOfAKind() {
    	ArrayList<Card> h1filteredCards = filterCardsByRankCount(3, this.aIP);
        ArrayList<Card> h2filteredCards = filterCardsByRankCount(3, this.handToBeat);
        this.aIP.cards = h1filteredCards;
        this.handToBeat.cards = h2filteredCards;
        return BestHighCard();
	}
    private ArrayList<Card> filterCardsByRankCount(int i, Hand hand) {
    	ArrayList<Card> cards = new ArrayList<Card>();
        for (int x = 0; x < hand.cards.size(); x++) {
            if (i == hand.countSameRank(hand.cards.get(x).rank)) {
                cards.add(hand.cards.get(x));
            }
        }
        return cards;
	}

// returns a number which represents the ranking of the hand.
   private int handScore(Hand hand) {
	   if (hand.isRoyalFlush()) { return 10; }
	   else if (hand.isStraightFlush()) { return 9; }
	   else if (hand.FourRank()) { return 8; }
	   else if (hand.isFullHouse()) { return 7; }
	   else if (hand.Flush()) { return 6; }
	   else if (hand.isStraight()) { return 5; }
	   else if (hand.ThreeRank()) { return 4; }
	   else if (hand.TwopairRank()) { return 3; }
	   else if (hand.TwoRank()) { return 2; }
	   else {return 1;}
    }
 
   public boolean BestHighCard() {
	   Card highestAipCard = new Card(0,0);
	   Card highesthandtobeatCard = new Card(0,0);

	   for (int x = 0; x < this.aIP.cards.size(); x++) {
		   if (this.aIP.cards.get(x).Higherthan(highestAipCard)) {
			   highestAipCard = this.aIP.cards.get(x);
		   }
		   if (this.handToBeat.cards.get(x).Higherthan(highesthandtobeatCard)) {
			   highesthandtobeatCard = this.handToBeat.cards.get(x);
		   }
	   }
	   return (highestAipCard.Higherthan(highesthandtobeatCard));
   }
}