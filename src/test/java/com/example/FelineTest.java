package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int inputKittensCount;
    private final int expectedKittensCount;

    public FelineTest(int inputKittensCount, int expectedKittensCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 1 },
                { 10, 10 },
                { 0, 0 }
        }
        );
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat()
        );
    }

    @Test
    public void testFelineGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily()
        );
    }

    @Test
    public void testFelineGetKittensCount() {
        Feline feline = new Feline();
        assertEquals(expectedKittensCount, feline.getKittens(inputKittensCount));
    }

    @Test
    public void testFelineGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens()
        );
    }
}
