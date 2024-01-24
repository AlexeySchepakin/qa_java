package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.List;

public class LionTest {

    @Mock
    private Feline feline;
    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lionMale = new Lion("Самец", feline);
        lionFemale = new Lion("Самка", feline);
    }

    @Test
    public void testLionDoesHaveManeMale() {
        assertTrue(lionMale.doesHaveMane());
    }

    @Test
    public void testLionDoesHaveManeFemale() {
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        new Lion("Неверный пол", feline);
    }

    @Test
    public void testLionGetKittens() {
        when(feline.getKittens()).thenReturn(3);
        assertEquals(3, lionMale.getKittens());
    }

    @Test
    public void testLionGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lionMale.getFood());
    }
}
