package com.py.reevolutionpremiere.entities.repositories;

import com.py.reevolutionpremiere.entities.ComercioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<ComercioEntidad,Integer> {
    /*@Modifying
    @Query("UPDATE ComercioEntidad comercio SET comercio.borrado = true WHERE comercio.codigoComercio = :codigoComercio")
    void marcarComoBorrado(@Param("codigoComercio") Integer codigoComercio);
    */
}
