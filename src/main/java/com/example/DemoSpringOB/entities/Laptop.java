package com.example.DemoSpringOB.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Laptop")
public class Laptop {

    // Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String cpu;
    private Integer ram;
    private Double price;
    private LocalDate releaseDate;
    private Boolean online;
    //constructores

    public Laptop() {
    }

    public Laptop(Long id, String marca, String cpu, Integer ram, Double price, LocalDate releaseDate, Boolean online) {
        this.id = id;
        this.marca = marca;
        this.cpu = cpu;
        this.ram = ram;
        this.price = price;
        this.releaseDate = releaseDate;
        this.online = online;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String cpu) {
        this.marca = marca;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    // toString


    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", Marca='" + marca + '\'' +
                ", cpu ='" + cpu + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", online=" + online +
                '}';
    }
}
