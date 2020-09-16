package com.company;

import static org.junit.Assert.*;

public class HandTest {
    private Card c;
    private Hand h;

    @org.junit.Before
    public void setUp() throws Exception {
        c= new Card(2,"c");
        h= new Hand();
        h.addCards("2|c,3|c,4|c,5|c,6|c");
    }

    @org.junit.Test
    public void getCardRank() {
        int expected = 2;
        assertEquals(expected,h.getCardRank(0));
    }

    @org.junit.Test
    public void getCardSuit() {
        String expected = "c";
        assertEquals(expected,h.getCardSuit(0));
    }


    @org.junit.Test
    public void testToString() {
        String expected = "2|c,3|c,4|c,5|c,6|c";
        assertEquals(expected,h.toString());
    }
}