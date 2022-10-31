package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionTest {
    private String sexOption = "Самец";

    @Test
    public void lionGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, sexOption);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
    }

    @Test
    public void lionSexException() {
        Feline feline = Mockito.mock(Feline.class);
        String sexInvalidOption = "неизвестно";
        Exception actualException = null;
        try {
            new Lion(feline, sexInvalidOption);
        } catch (Exception e) {
            actualException = e;
        }
        Assert.assertNotNull(actualException);
    }
}