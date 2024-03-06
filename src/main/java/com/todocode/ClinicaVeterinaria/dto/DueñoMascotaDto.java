package com.todocode.ClinicaVeterinaria.dto;

import com.todocode.ClinicaVeterinaria.model.Dueño;
import com.todocode.ClinicaVeterinaria.model.Mascota;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DueñoMascotaDto {

    private String nombreMascota;

    private String especie;

    private String raza;

    private String nombreDueño;

    private String apellidoDueño;

    public DueñoMascotaDto() {
    }

    public DueñoMascotaDto(String nombreMascota, String especie, String raza, String nombreDueño, String apellidoDueño) {
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
        this.nombreDueño = nombreDueño;
        this.apellidoDueño = apellidoDueño;
    }
}
