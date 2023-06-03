package com.py.reevolutionpremiere.entities.repositories;

import com.py.reevolutionpremiere.entities.ComercioCategoriaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioCategoriaRepository extends JpaRepository<ComercioCategoriaEntidad,Integer> {
    ComercioCategoriaEntidad findByNombreCategoria(String categoria);
}
