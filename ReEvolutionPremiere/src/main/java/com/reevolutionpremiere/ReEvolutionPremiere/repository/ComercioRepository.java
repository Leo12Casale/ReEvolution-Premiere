package com.reevolutionpremiere.ReEvolutionPremiere.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends CrudRepository<Comercio,Integer> {
}
