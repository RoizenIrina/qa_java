package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTestParameterized {

    private final int kittenNumber;
    private final int expected;

    public FelineTestParameterized(int kittenNumber, int expected) {
        this.kittenNumber = kittenNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittenNumber() {
        return new Object[][] {
                {1, 1},
                {0, 0},
                {100, 100},
        };
    }

    @Test
    public void felineGetKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittenNumber);

        assertEquals(expected, actual);
    }
}