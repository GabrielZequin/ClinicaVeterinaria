package com.todocode.ClinicaVeterinaria.controller;

import com.todocode.ClinicaVeterinaria.dto.DueñoMascotaDto;
import com.todocode.ClinicaVeterinaria.model.Mascota;
import com.todocode.ClinicaVeterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;

    @PostMapping("/altaMascota")
    public String altaMascota(@RequestBody Mascota mascota){
        mascotaService.altaMascota(mascota);
        return "Se ingresó correctamente a la mascota con id: " + mascota.getId();
    }
    @GetMapping("/obtenerMascota/{id}")
    public Mascota obtenerMascota(@PathVariable(name = "id")Long id){
        return mascotaService.obtenerMascota(id);
    }
    @PutMapping("/editarMascota")
    public Mascota editarMascota(@RequestBody Mascota mascota){
        return mascotaService.editarMascota(mascota);
    }
    @GetMapping("/mascota/obtenerTodas")
    @ResponseBody
    public List<Mascota> mascotaList(){
        return mascotaService.todasLasMascotas();
    }
    @DeleteMapping("/borrarMascota/{id}")
    public String borrarMascota(@PathVariable(value = "id")Long id){
        mascotaService.borrarMascota(id);
        return "Borraste las mascota con id: " + id;
    }
    @GetMapping("mascotas/dueños")
    @ResponseBody
    public List<DueñoMascotaDto> dueñoMascotaDto(){
        return mascotaService.dueñoMascotaDto();
    }
    @GetMapping("perros/caniche")
    @ResponseBody
    public List<Mascota> perroCaniche(){
        return mascotaService.listaPerrosCaniches();
    }
}
