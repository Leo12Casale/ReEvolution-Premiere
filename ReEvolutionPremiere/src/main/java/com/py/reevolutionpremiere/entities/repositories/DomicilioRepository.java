package com.py.reevolutionpremiere.entities.repositories;

import com.py.reevolutionpremiere.entities.DomicilioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<DomicilioEntidad,Integer> {
}
