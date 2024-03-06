package com.todocode.ClinicaVeterinaria.controller;

import com.todocode.ClinicaVeterinaria.model.Dueño;
import com.todocode.ClinicaVeterinaria.service.IDueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DueñoController {

    @Autowired
    private IDueñoService dueñoService;

    @PostMapping("/altaDueño")
    public String altaDueño(Dueño dueño){
        dueñoService.altaDueño(dueño);
        return "Ingresaste correctamente al dueño con dni: " + dueño.getDni();
    }
    @GetMapping("/obtenerDueño/{id}")
    public Dueño dueño(@PathVariable(name = "id")Long id){
        return dueñoService.obtenerDueño(id);
    }
    @DeleteMapping("/borrarDueño/{id}")
    public String borrarDueño(@PathVariable(name = "id")Long id){
        dueñoService.borrarDueño(id);
        return "Borraste al dueño con id: " + id;
    }
    @GetMapping("/listaDueños")
    @ResponseBody
    public List<Dueño> dueñoList(){
        return dueñoService.todosLosDueños();
    }
    @PutMapping("/editarDueño")
    public Dueño dueño(Dueño dueño){
        return dueñoService.editarDueño(dueño);
    }
}
