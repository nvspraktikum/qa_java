package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void checkGetFoodPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные","Птицы", "Рыба");
        System.out.println(expected);
        List<String> food = animal.getFood("Хищник");
        assertEquals(expected, food);
    }

    @Test
    public void checkGetFoodHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        System.out.println(expected);
        List<String> food = animal.getFood("Травоядное");
        assertEquals(expected, food);
    }

    @Test
    public void checkGetFoodUnknown() {
        try {
            Animal animal = new Animal();
            animal.getFood("Человек");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    e.getMessage());
        }
    }

    @Test
    public void checkGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(actual, expected);
    }
}