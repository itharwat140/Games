package com.company;
//Islam Mohamed
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class GuessingGameTest {
    @Test
    public void testGetRandomNum() {
        GuessingGame tester = new GuessingGame();
        tester.setup();
        for (int x = 0; x < 100000; x++) {
            int randNum = tester.getRandomNum(10, 20);
            assertTrue("num in range, normal values", randNum <= 20 && randNum >= 10);
        }
        for (int x = 0; x < 100000; x++) {
            int randNum = tester.getRandomNum(-10, 20);
            assertTrue ("num in range, negative values", randNum <= 20 && randNum >= -10);
        }
    }
}