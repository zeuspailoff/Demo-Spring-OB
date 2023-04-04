package com.example.DemoSpringOB.service;

import com.example.DemoSpringOB.entities.Laptop;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LaptopPriceCalculatorTest {

    @Test
    void calculatePrice() {
        Laptop laptop = new Laptop(1L,"HP", "Razer 7", 32, 525.25, LocalDate.now(),true);
        LaptopPriceCalculator calculator = new LaptopPriceCalculator();
        double price =calculator.calculatePrice(laptop);


        assertEquals(2175.25,price);

        Laptop laptop2 = new Laptop(1L,"HP", "Razer 3", 8, 525.25, LocalDate.now(),true);
        LaptopPriceCalculator calculator2 = new LaptopPriceCalculator();
        double price2 =calculator2.calculatePrice(laptop2);

        assertEquals(1175.25,price2);
    }
}