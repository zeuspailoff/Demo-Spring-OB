package com.example.DemoSpringOB.repository;
import com.example.DemoSpringOB.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
