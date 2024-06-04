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
}
