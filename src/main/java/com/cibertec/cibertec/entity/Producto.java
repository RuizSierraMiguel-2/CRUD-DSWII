package com.cibertec.cibertec.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "producto")
public class Producto {
    
    @Id
    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;
    private Date fechaVencimiento;

}
