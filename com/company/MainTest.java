package com.company;

import static org.junit.Assert.*;

public class MainTest {
    private Hand h;
    private String fourOfAKind = "12|s,12|h,12|c,12|d,4|h";
    private String fullHouse = "12|s,12|h,10|s,10|h,10|c";
    private String flush = "1|d,4|d,6|d,9|d,12|d";

    private String onePair = "12|s,12|h,11|s,10|c,4|h";
    private String twoPair = "12|s,12|h,10|c,10|s,4|h";
    private String threeOfAKind = "12|s,12|h,12|c,10|c,4|h";

    @org.junit.Before
    public void setUp() throws Exception {

        h = new Hand();

    }


    @org.junit.Test
    public void isFlush() {
        h.addCards(flush);
        assertEquals(true,Main.isFlush(h));

    }

    @org.junit.Test
    public void findDupeRanks() {
        h.addCards(fullHouse);
        assertEquals("FullHouse",Main.findDupeRanks(h));
        h.clearCards();

        h.addCards(threeOfAKind);
        assertEquals("ThreeOfAKind",Main.findDupeRanks(h));
        h.clearCards();

        h.addCards(fourOfAKind);
        assertEquals("FourOfAKind",Main.findDupeRanks(h));
        h.clearCards();

        h.addCards(onePair);
        assertEquals("OnePair",Main.findDupeRanks(h));
        h.clearCards();

        h.addCards(twoPair);
        assertEquals("TwoPair",Main.findDupeRanks(h));
        h.clearCards();
    }
}