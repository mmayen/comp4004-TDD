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
}