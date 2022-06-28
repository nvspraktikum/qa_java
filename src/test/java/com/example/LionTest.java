package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void checkTwoGenders() throws Exception {
        try {
            Lion lion = new Lion("Оно", feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }


    @Test
    public void checkGetFoodFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expected = List.of("Животные","Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные","Птицы", "Рыба"));
        List<String> food = lion.getFood();
        assertEquals(expected, food);
    }

    @Test
    public void checkGetFoodMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные","Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные","Птицы", "Рыба"));
        List<String> food = lion.getFood();
        assertEquals(expected, food);
    }

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expected = 0;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }


}