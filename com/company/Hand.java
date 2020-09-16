package com.company;
import java.util.ArrayList;

/**
 * Hand class that represents a hand of poker.
 * Has properties for the cards in the hand, and a string representation of the hand.
 *
 * @author willhuck
 */
public class Hand {
    private ArrayList<Card> cards;
    private String handString;

    /**
     * Hand constructor class. Instantiates the list of cards and the representation string.
     */
    public Hand() {
        cards = new ArrayList<Card>();
        handString = "";
    }

    /**
     * addCard class.  This class takes a string of cards like "Rank|Suit,Rank|Suit,Rank|Suit,Rank|Suit,Rank|Suit"
     * The string is parsed, each Card object is made and added to the Class's arraylist of cards.
     * @param cards the string representing the cards to add to the hand. "Rank|Suit,Rank|Suit,Rank|Suit,Rank|Suit,Rank|Suit"
     */
    public void addCards(String cards) {
        //cards string should be "0|h,1|h,2|h,3|h,4|h"
        this.handString = cards;
        String cardsArray[] = cards.split(",");

        for (int i = 0; i < 5; i++)
        {
            String cardParts[] = cardsArray[i].split("\\|");
            Card c = new Card(Integer.parseInt(cardParts[0]),cardParts[1]);
            this.cards.add(c);
            //System.out.println("r:"+cardParts[0]+" s:"+cardParts[1]);
        }
    }

    /**
     * getCardRank class returns the rank of a certain card in the hand.
     * @param c index of the card whose rank you want.
     * @return int rank of the card passed.
     */
    public int getCardRank(int c) {
        return cards.get(c).getRank();
    }
    /**
     * getCardSuit class returns the suit of a certain card in the hand.
     * @param c index of the card whose suit you want.
     * @return string suit of the card passed.S
     */
    public String getCardSuit(int c) {
        return cards.get(c).getSuit();
    }

    /**
     * Clear cards method clears the hand so a different one can be added without needing to create a new hand object.
     */
    public void clearCards() {
        cards.clear();
    }

    /**
     * Hands toString override.  Here I cheat and use the aforementiond class property handString that was made in the
     * constructor.
     * @return string representing the hand
     */
    @Override
    public String toString() {
        return this.handString;
    }
}
