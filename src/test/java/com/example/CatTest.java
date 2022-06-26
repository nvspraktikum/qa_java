package com.example;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void getSound() {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual);
    }

    @Test
    public void getFood() throws Exception{
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные","Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные","Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        System.out.println(actual);
    }
}