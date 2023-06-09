package com.py.reevolutionpremiere.entities.repositories;

import com.py.reevolutionpremiere.entities.ComercioEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ComercioRepository extends JpaRepository<ComercioEntidad,Integer> {
    @Query("DELETE FROM ComercioEntidad c WHERE c.codigoComercio = :id AND NOT EXISTS (SELECT fc FROM FacturaComercioEntidad fc WHERE fc.comercioByIdComercio = c AND fc.pagada = false)")
    @Modifying
    @Transactional
    int  deleteIfNoUnpaidFacturas(@Param("id") Integer id);
}
