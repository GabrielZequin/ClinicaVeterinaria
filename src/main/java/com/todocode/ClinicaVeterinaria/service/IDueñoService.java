package com.todocode.ClinicaVeterinaria.service;

import com.todocode.ClinicaVeterinaria.model.Dueño;

import java.util.List;

public interface IDueñoService {

    public void altaDueño(Dueño dueño);

    public String borrarDueño(Long id);

    public List<Dueño> todosLosDueños();

    public Dueño editarDueño(Dueño dueño);

    public Dueño obtenerDueño(Long id);
}
