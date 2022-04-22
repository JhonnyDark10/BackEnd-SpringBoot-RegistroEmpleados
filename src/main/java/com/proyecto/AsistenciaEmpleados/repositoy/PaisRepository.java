package com.proyecto.AsistenciaEmpleados.repositoy;

import com.proyecto.AsistenciaEmpleados.models.SisPai;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<SisPai, Integer> {
}
