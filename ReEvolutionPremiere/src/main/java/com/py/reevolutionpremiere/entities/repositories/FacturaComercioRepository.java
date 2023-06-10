package com.py.reevolutionpremiere.entities.repositories;

import com.py.reevolutionpremiere.entities.FacturaComercioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FacturaComercioRepository extends JpaRepository<FacturaComercioEntidad,Integer> {

    Collection<FacturaComercioEntidad> findAllByIdComercio(Integer idComercio);
}
