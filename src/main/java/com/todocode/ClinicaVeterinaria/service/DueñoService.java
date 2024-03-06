package com.todocode.ClinicaVeterinaria.service;

import com.todocode.ClinicaVeterinaria.model.Dueño;
import com.todocode.ClinicaVeterinaria.model.Mascota;
import com.todocode.ClinicaVeterinaria.repository.DueñoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DueñoService implements IDueñoService {

    @Autowired
    private DueñoRepository dueñoRepository;

    //Alta de Dueño
    public void altaDueño(Dueño dueño){
        dueñoRepository.save(dueño);
    }
    //Borrar Dueño
    public String borrarDueño(Long id){
        dueñoRepository.deleteById(id);
        return "Borraste al dueño con id: " + id;
    }
    //Obtener todos los dueños
    public List<Dueño> todosLosDueños(){
        List<Dueño> dueñoList = dueñoRepository.findAll();
        return dueñoList;
    }
    //Editar dueño
    public Dueño editarDueño(Dueño dueño){
        Dueño dueñoModificado = dueñoRepository.findById(dueño.getId()).get();
        dueñoModificado.setApellido(dueño.getApellido());
        dueñoModificado.setNombre(dueño.getNombre());
        dueñoModificado.setCelular(dueño.getCelular());
        dueñoModificado.setDni(dueño.getDni());
        dueñoModificado.setId(dueño.getId());

        return dueñoModificado;
    }
    //Obtener dueño
    public Dueño obtenerDueño(Long id){
        Dueño dueño = dueñoRepository.findById(id).get();
        return dueño;
    }
}
