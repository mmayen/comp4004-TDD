package core;

import junit.framework.TestCase;

public class PlayGameTest extends TestCase {
	
	Hand h = new Hand();    
    public void testisBetterHandTypes() {
        PlayGame testPlayGame;

        // initialized in order of winners vs. losers
        Hand royalFlush = new Hand("src/main/resources/RoyalFlush");
        Hand straightFlush = new Hand("src/main/resources/StraightFlush");
        Hand fourOfAKind = new Hand("src/main/resources/FourRank");
        Hand fullHouse = new Hand("src/main/resources/Fullhouse");
        Hand flush = new Hand("src/main/resources/Flush");
        Hand straight = new Hand("src/main/resources/unorderedStraight");
        Hand threeOfAKind = new Hand("src/main/resources/ThreeRank");
        Hand twoOfAKind = new Hand("src/main/resources/handWithPairTogether");
        Hand highCard = new Hand("src/main/resources/highestCard");

        Hand[] orderedHands = {highCard, twoOfAKind, threeOfAKind, straight, flush, fullHouse, fourOfAKind, straightFlush, royalFlush};

        for (int x = 1; x < orderedHands.length; x++) { // defines root hand
            for (int y = x - 1; y >= 0; y--) { // compare all lower ranked hands to root hand
                testPlayGame = new PlayGame(orderedHands[x], orderedHands[y]);
                assertTrue(testPlayGame.isBetter());
            }
        }

		Hand[][] hands = {
                h.handsFromInputFile(18), // highest card
                h.handsFromInputFile(17), // one pair
                h.handsFromInputFile(19), // two pairs
                h.handsFromInputFile(12), // three of a kind
                h.handsFromInputFile(8), // straight
                h.handsFromInputFile(7), // flush
                h.handsFromInputFile(6), // full house
                h.handsFromInputFile(5), // four of a kind
                h.handsFromInputFile(4), // straight flush
                h.handsFromInputFile(3) // royal flush
        };

        // make sure that all lower hands of root hand are beat
        for (int x = 1; x < hands.length; x++) { // defines root hand
            for (int y = x - 1; y >= 0; y--) { // compare all lower ranked hands to root hand
                testPlayGame = new PlayGame(hands[x][0], hands[y][0]);
                assertTrue(testPlayGame.isBetter());
                testPlayGame = new PlayGame(hands[x][1], hands[y][1]);
                assertTrue(testPlayGame.isBetter());
                testPlayGame = new PlayGame(hands[x][0], hands[y][1]);
                assertTrue(testPlayGame.isBetter());
                testPlayGame = new PlayGame(hands[x][1], hands[y][0]);
                assertTrue(testPlayGame.isBetter());
            }
        }
        // make sure that all higher cases of root hand beat it.
        for (int x = 0; x < hands.length - 1; x++) { // defines root hand
            for (int y = x + 1; y < hands.length; y++) { // compare all higher ranked hands to root hand
                testPlayGame = new PlayGame(hands[x][0], hands[y][0]);
                assertFalse(testPlayGame.isBetter());
                testPlayGame = new PlayGame(hands[x][1], hands[y][1]);
                assertFalse(testPlayGame.isBetter());
                testPlayGame = new PlayGame(hands[x][0], hands[y][1]);
                assertFalse(testPlayGame.isBetter());
                testPlayGame = new PlayGame(hands[x][1], hands[y][0]);
                assertFalse(testPlayGame.isBetter());
            }
        }
    }

    // Test to make sure that royal flush is ordered by suit.
    
    public void testisBetterRoyalFlush() {
        PlayGame testPlayGame;
        Hand heartsRoyalFlush = new Hand("src/main/resources/heartsRoyalFlush");
        Hand spadesRoyalFlush = new Hand("src/main/resources/spadesRoyalFlush");

        // ensure both hands are actually royal flushes
        assertTrue(heartsRoyalFlush.isRoyalFlush());
        assertTrue(spadesRoyalFlush.isRoyalFlush());

        testPlayGame = new PlayGame(heartsRoyalFlush, spadesRoyalFlush);
        assertFalse(testPlayGame.isBetter());

        testPlayGame = new PlayGame(spadesRoyalFlush, heartsRoyalFlush);
        assertTrue(testPlayGame.isBetter());

        // royal flush with highest suit wins
        Hand[] hands;
        hands = h.handsFromInputFile(20);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
    }

    
    public void testisBetterStraightFlush() {
        Hand[] hands;

        hands = h.handsFromInputFile(21);
        //assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());

        hands = h.handsFromInputFile(22);
       // assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
    }

    
    public void testisBetterHigherCardTest() {
        PlayGame testPlayGame;


        Hand heartsStraightFlush = new Hand("src/main/resources/heartsStraightFlush");
        Hand spadesStraightFlush = new Hand("src/main/resources/spadesStraightFlush");
        Hand lowerRankedStraight = new Hand("src/main/resources/lowerRankedStraightFlush");
        Hand higherRankedStraight = new Hand("src/main/resources/higherRankedStraightFlush");
        Hand aceStraightFlush = new Hand("src/main/resources/aceStraightFlush");

        // ensure both are straight flushes
        assertTrue(heartsStraightFlush.isStraightFlush());
        assertTrue(spadesStraightFlush.isStraightFlush());

        assertFalse(new PlayGame(heartsStraightFlush, spadesStraightFlush).isBetter());
        assertTrue(new PlayGame(spadesStraightFlush, heartsStraightFlush).isBetter());

        assertTrue(new PlayGame(higherRankedStraight, lowerRankedStraight).isBetter());
        assertFalse(new PlayGame(lowerRankedStraight, higherRankedStraight).isBetter());

        assertTrue(new PlayGame(heartsStraightFlush, aceStraightFlush).isBetter());
    }

    
    public void testcomparingFlushesTest() {
        Hand flushWithTenHighCard = new Hand("src/main/resources/flushWithTenHighCard");
        Hand worseFlushWithTenHighCard = new Hand("src/main/resources/worseFlushWithTenHighCard");
        Hand flushWithJokerHighCard = new Hand("src/main/resources/flushWithJokerHighCard");
        Hand flushWithTenHighCardBetterSuit = new Hand("src/main/resources/flushWithTenHighCardBetterSuit");

        assertTrue(new PlayGame(flushWithTenHighCard, worseFlushWithTenHighCard).isBetter());
        assertFalse(new PlayGame(worseFlushWithTenHighCard, flushWithTenHighCard).isBetter());
        assertTrue(new PlayGame(flushWithJokerHighCard, flushWithTenHighCard).isBetter());
        assertFalse(new PlayGame(flushWithTenHighCard,flushWithJokerHighCard).isBetter());
        assertTrue(new PlayGame(flushWithTenHighCardBetterSuit, flushWithTenHighCard).isBetter());
        assertFalse(new PlayGame(flushWithTenHighCard, flushWithTenHighCardBetterSuit).isBetter());

        Hand[] hands;

        hands = h.handsFromInputFile(34);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());

        hands = h.handsFromInputFile(36);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());

        hands = h.handsFromInputFile(37);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());

        hands = h.handsFromInputFile(38);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());

        hands = h.handsFromInputFile(39);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
    }

    
    public void testcomparingStraightHands() {
        Hand highRankStraight = new Hand("src/main/resources/highRankStraight");
        Hand lowRankStraight = new Hand("src/main/resources/lowRankStraight");
        Hand betterSuitStraight = new Hand("src/main/resources/betterSuitStraight");
        Hand worseSuitStraight = new Hand("src/main/resources/worseSuitStraight");

        //assertTrue(new PlayGame(highRankStraight, lowRankStraight).isBetter());
        assertFalse(new PlayGame(lowRankStraight, highRankStraight).isBetter());
        assertTrue(new PlayGame(betterSuitStraight, worseSuitStraight).isBetter());
        assertFalse(new PlayGame(worseSuitStraight, betterSuitStraight).isBetter());

        Hand[] hands;

        // AI rank only has the highest card with a better suit... it still wins :)
        hands = h.handsFromInputFile(26);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
        // AI has a better rank highest card, but the rest of user hands is better suits.
        // AI still wins
        hands = h.handsFromInputFile(27);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
    }

    
    public void testfourOfAKindTest() {
        Hand fourOfAKind = new Hand("src/main/resources/FourRank");
        Hand worseFourOfAKindWithHigherCard = new Hand("src/main/resources/fourOfAKindHigherCard");

        assertFalse(new PlayGame(worseFourOfAKindWithHigherCard, fourOfAKind).isBetter());
        assertTrue(new PlayGame(fourOfAKind, worseFourOfAKindWithHigherCard).isBetter());

        Hand[] hands;

        hands = h.handsFromInputFile(23);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
    }

    
    public void testthreeOfAKindTest() {
        Hand fullHouse = new Hand("src/main/resources/Fullhouse");
        Hand betterFullHouse = new Hand("src/main/resources/betterFullHouse");
        Hand threeOfAKind = new Hand("src/main/resources/ThreeRank");
        Hand worseThreeOfAKindWithHigherCard = new Hand("src/main/resources/threeOfAKindWithKing");

        assertTrue(new PlayGame(betterFullHouse, fullHouse).isBetter());
        assertFalse(new PlayGame(fullHouse, betterFullHouse).isBetter());
        assertTrue(new PlayGame(threeOfAKind, worseThreeOfAKindWithHigherCard).isBetter());
        assertFalse(new PlayGame(worseThreeOfAKindWithHigherCard, threeOfAKind).isBetter());

        Hand[] hands;

        // full houses
        hands = h.handsFromInputFile(24);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());

        // three of a kind
        hands = h.handsFromInputFile(25);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
    }

    
    public void testtwoPairsTest() {
        Hand handWithTwoPairs = new Hand("src/main/resources/hasTwoPairs");
        Hand handWithWorsePairs = new Hand("src/main/resources/hasTwoWorsePairs");
        Hand handWithSamePairsBetterSuit = new Hand("src/main/resources/handWithTwoPairsBetterSuits");
        Hand handWithBetterRankedSecondPair = new Hand("src/main/resources/hasOneBetterPair");

        assertTrue(new PlayGame(handWithTwoPairs, handWithWorsePairs).isBetter());
        assertFalse(new PlayGame(handWithWorsePairs, handWithTwoPairs).isBetter());

        assertTrue(new PlayGame(handWithSamePairsBetterSuit, handWithWorsePairs).isBetter());
        assertFalse(new PlayGame(handWithWorsePairs, handWithSamePairsBetterSuit).isBetter());

        // rank of second pair doesn't matter, we only care about highest card between both pairs.
        assertFalse(new PlayGame(handWithBetterRankedSecondPair, handWithTwoPairs).isBetter());
        assertTrue(new PlayGame(handWithTwoPairs, handWithBetterRankedSecondPair).isBetter());

        Hand[] hands;
        // user has better suit on high card and lower pair, but it don't
        // matter cause AI has better high pair.
        hands = h.handsFromInputFile(28);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
        // AI has better pair but worse suits on lesser pair and worse high card... still wins.
        hands = h.handsFromInputFile(29);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
    }

    // testing hands with only one pair each.
    
    public void testpairsTest() {
        Hand pairOfFives = new Hand("src/main/resources/pairOfFives");
        Hand betterPairOfFives = new Hand("src/main/resources/betterPairOfFives");
        Hand pairOfFours = new Hand("src/main/resources/pairOfFours");
        Hand pairOfFoursWithOtherHighCards = new Hand("src/main/resources/pairOfFoursWithOtherHighCards");

        assertTrue(new PlayGame(betterPairOfFives, pairOfFives).isBetter());
        assertFalse(new PlayGame(pairOfFives, betterPairOfFives).isBetter());

        assertTrue(new PlayGame(pairOfFives, pairOfFours).isBetter());
        assertFalse(new PlayGame(pairOfFours, pairOfFives).isBetter());

        assertTrue(new PlayGame(pairOfFives, pairOfFoursWithOtherHighCards).isBetter());
        assertFalse(new PlayGame(pairOfFoursWithOtherHighCards, pairOfFives).isBetter());

        Hand[] hands;

        // same rank of pair, but AI has better suit (spades)
        hands = h.handsFromInputFile(30);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());

        // AI has better pair, but user has better everything else... AI still wins.
        hands = h.handsFromInputFile(31);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
    }

    
    public void testhighestCardTest() {
        Hand highestCardTen = new Hand("src/main/resources/highestCardTen");
        Hand highestCardTenWorseSuit = new Hand("src/main/resources/highestCardTenWorseSuit");
        Hand highestCardNine = new Hand("src/main/resources/highestCardNine");

        assertTrue(new PlayGame(highestCardTen, highestCardTenWorseSuit).isBetter());
        assertFalse(new PlayGame(highestCardTenWorseSuit, highestCardTen).isBetter());

        assertTrue(new PlayGame(highestCardTen, highestCardNine).isBetter());
        assertFalse(new PlayGame(highestCardNine, highestCardTen).isBetter());

        Hand[] hands;

        // same rank of high card, but AI has better suit (spades)
        hands = h.handsFromInputFile(32);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());

        // AI has better rank of high card, but user has better suits... AI still wins.
        hands = h.handsFromInputFile(33);
        assertTrue(new PlayGame(hands[0], hands[1]).isBetter());
        assertFalse(new PlayGame(hands[1], hands[0]).isBetter());
    }
}
