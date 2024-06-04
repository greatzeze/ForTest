package org.example;

import org.junit.Test;

public class StringHandlerTest {

    @Test
    public void testStrHandler1() {
        StringHandler.strHandler("aabcccbbad");
    }

    @Test
    public void testStrHandler2() {
        StringHandler.strAdvancedHandler("abcccbad");
    }

    @Test
    public void testStrHandler3() {
        System.out.println(Elimination.elimination("aabcccbbad"));

    }

    @Test
    public void testStrHandler4() {
        System.out.println(Elimination.backwardElimination("aabcccbbad"));

    }
}
