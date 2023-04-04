package com.example.DemoSpringOB.service;

import com.example.DemoSpringOB.entities.Laptop;

public class LaptopPriceCalculator {

    public double calculatePrice(Laptop laptop){
        double price = laptop.getPrice();
        if (laptop.getRam() > 16){
            price += 1000;
        }
        price += 650;
        return price;
    }
}
