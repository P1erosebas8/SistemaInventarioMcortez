package com.inventario.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Ubicacion {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String lugar;
private LocalDate fechaRegistro;

@OneToOne
private Equipo equipo;

public Ubicacion() {
    
}

public Ubicacion(String lugar, LocalDate fechaRegistro, Equipo equipo) {
this.lugar = lugar;
this.fechaRegistro = fechaRegistro;
this.equipo = equipo;
}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public String getLugar() { return lugar; }
public void setLugar(String lugar) { this.lugar = lugar; }


public LocalDate getFechaRegistro() { return fechaRegistro; }
public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }


public Equipo getEquipo() { return equipo; }
public void setEquipo(Equipo equipo) { this.equipo = equipo; }
}