package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String gender;
    private final boolean hasMane;

    public LionParameterizedTest(String gender, boolean hasMane) {
        this.gender = gender;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void checkManeBasedOnGender() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(gender, feline);
        Boolean expected = hasMane;
        Boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}
