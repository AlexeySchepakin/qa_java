package com.example;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.List;

public class LionTest {

    @Mock
    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion("Самец", feline);
    }

    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        new Lion("Неверный пол", feline);
    }

    @Test
    public void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }
}
