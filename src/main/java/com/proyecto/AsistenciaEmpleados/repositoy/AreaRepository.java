package com.proyecto.AsistenciaEmpleados.repositoy;


import com.proyecto.AsistenciaEmpleados.models.SisArea;
import com.proyecto.AsistenciaEmpleados.models.SisUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<SisArea,Integer> {


}
