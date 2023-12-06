package com.autoventas.autos.infrastructure.entities;

import com.autoventas.autos.domain.models.Auto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class AutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String  modelo;
    private int anio;
    private double precio;
    private String color;
    private LocalDateTime fechaIngreso;
    private boolean disponible;


    public AutoEntity() {
    }

    public AutoEntity(Long id, String marca, String modelo, int anio, double precio, String color, LocalDateTime fechaIngreso, boolean disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.color = color;
        this.fechaIngreso = fechaIngreso;
        this.disponible = disponible;
    }
    public static AutoEntity fromDomainModel(Auto auto){
        return new AutoEntity(auto.getId(),auto.getMarca(),auto.getModelo(), auto.getAnio(), auto.getPrecio(),auto.getColor(),auto.getFechaIngreso(),auto.isDisponible());
    }
    public Auto toDomainModel(){
        return new Auto(id,marca,modelo, anio, precio,color,fechaIngreso,disponible);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
