package com.company;

/**
 * Card class
 * Has two properties, rank and suit, and their respective getters.
 *
 * @author willhuck
 */
public class Card {
    private String suit;
    private int rank;

    /**
     * Card Constructer class.  This takes rank and suit as arguments and sets them.
     * @param rank integer rank of the card 0-12 , being two-ace
     * @param suit string of the card's suit, clubs "c" spades "s" hearts "h" diamonds "d"
     */
    public Card(int rank, String suit) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * getCard class deprecated.
     * @return string output of card's values.
     * @deprecated not needed in the slightest.
     */
    public String getCard() {
        String output = this.rank + "," + String.valueOf(this.suit);
        return output;
    }

    /**
     * Get Suit returns card's suit.
     * @return String representing card's suit.
     */
    public String getSuit() { return this.suit; }

    /**
     * Get Rank returns card's rank.
     * @return Int representing card's rank.
     */
    public int getRank() { return this.rank; }

}
