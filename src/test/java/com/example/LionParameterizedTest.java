package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private Feline feline;
    private Lion lion;
    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        }
        );
    }
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, feline);
    }
    @Test
    public void testDoesHaveMane() {
        assertEquals("Ошибка в методе doesHaveMane с полом: " + sex,
                hasMane, lion.doesHaveMane());
    }
}
