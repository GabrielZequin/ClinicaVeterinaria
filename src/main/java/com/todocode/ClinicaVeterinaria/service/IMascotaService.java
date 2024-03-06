package com.todocode.ClinicaVeterinaria.service;

import com.todocode.ClinicaVeterinaria.dto.DueñoMascotaDto;
import com.todocode.ClinicaVeterinaria.model.Mascota;

import java.util.List;

public interface IMascotaService {

    public void altaMascota(Mascota mascota);

    public String borrarMascota(Long id);

    public List<Mascota> todasLasMascotas();

    public Mascota editarMascota(Mascota mascota);

    public Mascota obtenerMascota(Long id);

    public List<Mascota> listaPerrosCaniches();

    public List<DueñoMascotaDto> dueñoMascotaDto();
}
