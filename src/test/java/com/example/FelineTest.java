package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FelineTest {

    @Test
    public void testFelineEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }
    @Test
    public void testFelineGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void testFelineGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
}
