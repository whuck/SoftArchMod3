package com.company;

import java.util.ArrayList;

/**
 * Main class creates a few hands to be tested.
 * Hand string is "Rank|Suit,Rank|Suit,Rank|Suit,Rank|Suit,Rank|Suit"
 *
 */
public class Main {
    public static void main(String[] args) {
        String flush = "1|d,4|d,6|d,9|d,12|d";
        String onePair = "12|s,12|h,11|s,10|c,4|h";
        String twoPair = "12|s,12|h,10|c,10|s,4|h";
        String threeOfAKind = "12|s,12|h,12|c,10|c,4|h";
        String fourOfAKind = "12|s,12|h,12|c,12|d,4|h";
        String fullHouse = "12|s,12|h,10|s,10|h,10|c";

        Hand h = new Hand();
        h.addCards(threeOfAKind);
        String dupes = findDupeRanks(h);
        System.out.println(dupes);
        h.clearCards();
        h.addCards(fourOfAKind);
        System.out.println("4k "+findDupeRanks(h));

        h.clearCards();
        h.addCards(fullHouse);
        System.out.println("FH "+findDupeRanks(h));

        h.clearCards();
        h.addCards(threeOfAKind);
        System.out.println("3k "+findDupeRanks(h));

        h.clearCards();
        h.addCards(onePair);
        System.out.println("1p "+findDupeRanks(h));

        h.clearCards();
        h.addCards(twoPair);
        System.out.println("2p "+findDupeRanks(h));

    }

    /**
     * Finds out if a hand is a flush.
     * It loops through the hands' cards, comparing each card's suit to the first card.
     *
     * @param h the Hand to parse
     * @return returns true if the hand is a flush
     */
    public static boolean isFlush(Hand h) {
        boolean isFlush = false;
        String firstCardSuit = h.getCardSuit(0);
        for (int i = 1; i < 5; i++) {
            String nextCardSuit = h.getCardSuit(i);
            if (firstCardSuit.equals(nextCardSuit)) {
                isFlush = true;
            } else {
                isFlush = false;
            }
        }
        return isFlush;
    }

    /**
     * Finds duplicate cards. This method determines if a hand
     * has a pair, 2 pairs, 3 of a kind, 4 of a kind, or a full house.
     * First it creates an arraylist representing all the card ranks.
     * Then it iterates through the hand and increments the respective element in the array of ranks.
     * This counts the cards in the hand, ie there are 2 kings, 1 seven, and 2 aces.
     * It then loops through the list of counted cards to catch specific hands like a Full House and Two Pair.
     * Lastly it determines the string output of the hand name.
     *
     * @param h the Hand to parse
     * @return returns a string of the hand name ie FourOfAKind, ThreeOfAKind, TwoPair, OnePair, FullHouse
     */
    public static String findDupeRanks(Hand h) {
        //ranks = {0,0,0,0,0,0,0,0,0,0,0,0,0};
        ArrayList<Integer> ranks = new ArrayList<Integer>();
        for (int i = 0; i < 13; i++) {
            ranks.add(0);
        }
        for (int i = 0; i < 5; i++) {
            int cardRank = h.getCardRank(i);
            int dupeCount = ranks.get(cardRank);
            ranks.set(cardRank, dupeCount + 1);
        }
        int twoOfAKind = 0;
        int threeOfAKind = 0;
        for (int a : ranks) {
            if(a==4) { return "FourOfAKind"; }
            else if (a==3) { threeOfAKind = 1; }
            else if (a==2) { twoOfAKind += 1; }
        }
        if (twoOfAKind == 2) { return "TwoPair"; }
        else if (twoOfAKind == 1 && threeOfAKind != 1) { return "OnePair"; }
        else if (twoOfAKind == 1 && threeOfAKind == 1) { return "FullHouse"; }
        else if (twoOfAKind == 0 && threeOfAKind == 1) { return "ThreeOfAKind"; }
        else return "None";
    }
}