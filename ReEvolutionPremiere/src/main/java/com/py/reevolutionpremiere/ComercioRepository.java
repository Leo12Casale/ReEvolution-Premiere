package com.py.reevolutionpremiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<ComercioEntidad,Integer> {
}
