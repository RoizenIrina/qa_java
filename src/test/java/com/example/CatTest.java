package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void catGetSound() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "���";

        assertEquals(expected, actual);
    }

    @Test
    public void catGetFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected = List.of("��������", "�����", "����");
        Mockito.when(feline.eatMeat()).thenReturn(expected);

        assertEquals(expected, cat.getFood());
    }
}