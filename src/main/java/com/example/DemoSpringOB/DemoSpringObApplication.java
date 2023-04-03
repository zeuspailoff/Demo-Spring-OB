package com.example.DemoSpringOB;

import com.example.DemoSpringOB.entities.Laptop;
import com.example.DemoSpringOB.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class DemoSpringObApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoSpringObApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 =  new Laptop(
				null, "HP", "Ryzen 7 ", 32, 850.50, LocalDate.of(2018,12,1),true);
		Laptop laptop2 =  new Laptop(
				null, "ASUS ", "INTEL 5 ", 16, 650.50, LocalDate.of(2019,10,5),true);

		System.out.println("El numero de libros es: " + repository.findAll().size());

		repository.save(laptop1);
		repository.save(laptop2);

		System.out.println("El numero de libros es: " + repository.findAll().size());

		System.out.println("fin");

	}

}
