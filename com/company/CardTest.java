package com.company;

import static org.junit.Assert.*;

public class CardTest {
    private Card c;
    @org.junit.Before
    public void setUp() throws Exception {
         c= new Card(2,"c");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getCard() {
        String expected = "2,c";
        assertEquals(expected,c.getCard());
    }

    @org.junit.Test
    public void getSuit() {
        String expected = "c";
        assertEquals(expected,c.getSuit());
    }

    @org.junit.Test
    public void getRank() {
        int expected = 2;
        assertEquals(expected,c.getRank());
    }
}