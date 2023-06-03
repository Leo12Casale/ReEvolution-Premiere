package com.py.reevolutionpremiere.entities.repositories;

import com.py.reevolutionpremiere.entities.ComercioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<ComercioEntidad,Integer> {
}
