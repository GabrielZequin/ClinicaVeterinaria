package com.todocode.ClinicaVeterinaria.repository;

import com.todocode.ClinicaVeterinaria.model.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DueñoRepository extends JpaRepository<Dueño, Long> {
}
