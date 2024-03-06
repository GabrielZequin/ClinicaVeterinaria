package com.todocode.ClinicaVeterinaria.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter @Setter
public class Dueño {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int dni;

    private String nombre;

    private String apellido;

    private int celular;

    @OneToOne
    private Mascota mascota;


    public Dueño() {
    }

    public Dueño(Long id, int dni, String nombre, String apellido, int celular, Mascota mascota) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.mascota = mascota;
    }
}
