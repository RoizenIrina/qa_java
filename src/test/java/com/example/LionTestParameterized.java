package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParameterized {

    private final String sexOption;
    private final boolean expected;

    public LionTestParameterized(String sexOption, boolean expected) {
        this.sexOption = sexOption;
        this.expected = expected;
    }

    @Before
    public void initMocks() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Parameterized.Parameters
    public static Object[] getListOfMealDataForHerbivoreAndPredator() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void lionSex() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, sexOption);
        boolean actual = lion.hasMane;

        assertEquals(expected, actual);
    }

    @Test
    public void lionHasMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, sexOption);
        boolean actual = lion.doesHaveMane();

        assertEquals(expected, actual);
    }

    @Test
    public void lionGetKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, sexOption);
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();

        assertEquals(expected, actual);
    }


}
