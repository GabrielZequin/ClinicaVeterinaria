package com.todocode.ClinicaVeterinaria.service;

import com.todocode.ClinicaVeterinaria.dto.DueñoMascotaDto;
import com.todocode.ClinicaVeterinaria.model.Mascota;
import com.todocode.ClinicaVeterinaria.repository.DueñoRepository;
import com.todocode.ClinicaVeterinaria.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private DueñoRepository dueñoRepository;

    //Alta de mascota
    public void altaMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    //Borrar mascota
    public String borrarMascota(Long id) {
        mascotaRepository.deleteById(id);
        return "Borraste la mascota con id: " + id;
    }

    //Obtener todas las mascotas
    public List<Mascota> todasLasMascotas() {
        List<Mascota> mascotaList = mascotaRepository.findAll();
        return mascotaList;
    }

    //Editar Mascota
    public Mascota editarMascota(Mascota mascota) {
        Mascota mascotaModificada = mascotaRepository.findById(mascota.getId()).get();
        mascotaModificada.setColor(mascota.getColor());
        mascotaModificada.setEspecie(mascota.getEspecie());
        mascotaModificada.setId(mascota.getId());
        mascotaModificada.setNombre(mascota.getNombre());
        mascotaModificada.setRaza(mascota.getRaza());

        return mascotaModificada;
    }

    //Obtener Mascota
    public Mascota obtenerMascota(Long id) {
        Mascota mascota = mascotaRepository.findById(id).get();
        return mascota;
    }

    //Obtener todas las mascotas de especie "perro" y raza "caniche"
    public List<Mascota> listaPerrosCaniches() {
        List<Mascota> todasLasMascotas = mascotaRepository.findAll();
        List<Mascota> listaPerroCaniche = new ArrayList<>();
        for (Mascota mascotasList : todasLasMascotas) {
            if (mascotasList.getEspecie().contains("perro") && mascotasList.getRaza().contains("caniche")) {
                listaPerroCaniche.add(mascotasList);
            }
        }
        return listaPerroCaniche;
    }

    //Obtener una lista de mascotas y dueños
    public List<DueñoMascotaDto> dueñoMascotaDto() {

        List<Mascota> mascotaList = mascotaRepository.findAll();

        List<DueñoMascotaDto> dueñoMascotaDtoList = new ArrayList<>();

        for (Mascota mascota : mascotaList) {


                DueñoMascotaDto dueñoMascotaDto = new DueñoMascotaDto();
                dueñoMascotaDto.setNombreMascota(mascota.getNombre());
                dueñoMascotaDto.setEspecie(mascota.getEspecie());
                dueñoMascotaDto.setRaza(mascota.getRaza());
                dueñoMascotaDto.setNombreDueño(mascota.getDueño().getNombre());
                dueñoMascotaDto.setApellidoDueño(mascota.getDueño().getApellido());

                dueñoMascotaDtoList.add(dueñoMascotaDto);
            }

        return dueñoMascotaDtoList;
        }

}

