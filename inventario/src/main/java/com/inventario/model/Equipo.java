package com.inventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Equipo {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String tipo; 
private String marca;
private String estado;
private String responsable;
private String ubicacion;

public Equipo() {}

public Equipo(String tipo, String marca, String estado, String responsable, String ubicacion) {
this.tipo = tipo;
this.marca = marca;
this.estado = estado;
this.responsable = responsable;
this.ubicacion = ubicacion;
}

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getTipo() { return tipo; }
public void setTipo(String tipo) { this.tipo = tipo; }

public String getMarca() { return marca; }
public void setMarca(String marca) { this.marca = marca; }

public String getEstado() { return estado; }
public void setEstado(String estado) { this.estado = estado; }

public String getResponsable() { return responsable; }
public void setResponsable(String responsable) { this.responsable = responsable; }

public String getUbicacion() { return ubicacion; }
public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}