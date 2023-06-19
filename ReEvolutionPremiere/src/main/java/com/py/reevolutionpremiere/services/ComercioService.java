package com.py.reevolutionpremiere.services;

import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTO;
import com.py.reevolutionpremiere.controllers.transferobjects.ComercioDTOMapper;
import com.py.reevolutionpremiere.entities.*;
import com.py.reevolutionpremiere.entities.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;;

/**
 * Clase que se encarga de la lógica de ABMC de comercios.
 */
@Service
public class ComercioService {
    private final ComercioRepository comercioRepository;
    private final ComercioCategoriaRepository comercioCategoriaRepository;
    private final ComercioRepresentanteRepository comercioRepresentanteRepository;
    private final FacturaComercioRepository facturaComercioRepository;
    private final DomicilioRepository domicilioRepository;
    private final ComercioDTOMapper comercioDTOMapper;


    @Autowired
    public ComercioService(ComercioRepository comercioRepository,
                           ComercioCategoriaRepository comercioCategoriaRepository,
                           ComercioRepresentanteRepository comercioRepresentanteRepository,
                           FacturaComercioRepository facturaComercioRepository,
                           DomicilioRepository domicilioRepository,
                           ComercioDTOMapper comercioDTOMapper)
    {
        this.comercioRepository = comercioRepository;
        this.comercioCategoriaRepository = comercioCategoriaRepository;
        this.comercioRepresentanteRepository = comercioRepresentanteRepository;
        this.facturaComercioRepository = facturaComercioRepository;
        this.domicilioRepository = domicilioRepository;
        this.comercioDTOMapper = comercioDTOMapper;
    }

    /**
     * Consulta un comercio particular desde la BDD.
     * @param codigoComercio
     * @return
     */
    public Optional<ComercioDTO> getComercioById(Integer codigoComercio) {
        return Optional.of(comercioRepository.findById(codigoComercio)
                .map(comercioDTOMapper)
                .orElseThrow());
    }

    /**
     * Consulta todos los comercios desde la BDD.
     * @return
     */
    public List<ComercioDTO> getComercios() {
        List<ComercioEntidad> comercioEntidad = comercioRepository.findAll();
        return comercioEntidad.stream()
                .map(comercioDTOMapper)
                .toList();
    }
    /**
     * Creación y llamado a repository para persistir un nuevo comercio.
     * @param comercioDTO datos del comercio en formato JSON.
     */
    public void newComercio(ComercioDTO comercioDTO) {
        //TODO: agg validaciones
        //Traer la entidad Categoria
        Optional<ComercioCategoriaEntidad> categoriaEntidad = Optional.ofNullable(comercioCategoriaRepository.findByNombreCategoria(comercioDTO.categoria()));
        //Crear la entidad representante
        ComercioRepresentanteEntidad representanteEntidad = null;
        if(comercioDTO.representante() != null){
            representanteEntidad = new ComercioRepresentanteEntidad(
                    null,
                    comercioDTO.representante().nombre(),
                    comercioDTO.representante().apellido(),
                    comercioDTO.representante().email(),
                    comercioDTO.representante().telefono(),
                    null
            );
        }
        //Crear la entidad domicilio
        DomicilioEntidad domicilioEntidad = null;
        if(comercioDTO.domicilio() != null) {
            domicilioEntidad = new DomicilioEntidad(
                    null,
                    comercioDTO.domicilio().provincia(),
                    comercioDTO.domicilio().localidad(),
                    comercioDTO.domicilio().calle(),
                    comercioDTO.domicilio().numeroCalle(),
                    comercioDTO.domicilio().codigoPostal(),
                    comercioDTO.domicilio().pisoDepto(),
                    comercioDTO.domicilio().numeroDepto(),
                    comercioDTO.domicilio().observaciones(),
                    null
            );
        }
        //Crear la entidad comercio finalmente
        ComercioEntidad comercioEntidad = new ComercioEntidad(
                null,
                comercioDTO.razonSocial(),
                comercioDTO.nombreFantasia(),
                comercioDTO.cuit(),
                comercioDTO.ingresosBrutos(),
                comercioDTO.condicionIva(),
                0.0,
                0.0,
                comercioDTO.diaCobro(),
                comercioDTO.comisiones(),
                null,
                null,
                null,
                categoriaEntidad.get(),
                representanteEntidad,
                null,
                null,
                domicilioEntidad
        );
        comercioRepresentanteRepository.save(representanteEntidad);
        domicilioRepository.save(domicilioEntidad);
        comercioRepository.save(comercioEntidad);
    }

    public boolean modificarComercio(Integer codigoComercio, ComercioDTO comercioDTO){
        Optional<ComercioEntidad> optionalComercioEntidad = comercioRepository.findById(codigoComercio);
        if(!optionalComercioEntidad.isPresent())
            return false;
        //Traigo objetos a memoria
        ComercioEntidad comercioEntidad = optionalComercioEntidad.get();
        DomicilioEntidad domicilioEntidad = comercioEntidad.getDomicilioEntidad();
        ComercioRepresentanteEntidad comercioRepresentanteEntidad = comercioEntidad.getComercioRepresentanteByIdRepresentante();
        ComercioCategoriaEntidad categoriaEntidad = comercioCategoriaRepository.findByNombreCategoria(comercioDTO.categoria());

        //Setteo de nuevos valores de domicilio
        domicilioEntidad.setProvincia(comercioDTO.domicilio().provincia());
        domicilioEntidad.setLocalidad(comercioDTO.domicilio().localidad());
        domicilioEntidad.setCalle(comercioDTO.domicilio().calle());
        domicilioEntidad.setNumeroCalle(comercioDTO.domicilio().numeroCalle());
        domicilioEntidad.setCodigoPostal(comercioDTO.domicilio().codigoPostal());
        domicilioEntidad.setPisoDepto(comercioDTO.domicilio().pisoDepto());
        domicilioEntidad.setNumeroDepto(comercioDTO.domicilio().pisoDepto());
        domicilioEntidad.setObservaciones(comercioDTO.domicilio().observaciones());

        //Setteo de nuevos valores de representante
        comercioRepresentanteEntidad.setNombre(comercioDTO.representante().nombre());
        comercioRepresentanteEntidad.setApellido(comercioDTO.representante().apellido());
        comercioRepresentanteEntidad.setEmail(comercioDTO.representante().email());
        comercioRepresentanteEntidad.setTelefono(comercioDTO.representante().telefono());

        //Setteo de nuevos valores de comercios
        comercioEntidad.setCodigoComercio(comercioDTO.codigoComercio());
        comercioEntidad.setRazonSocial(comercioDTO.razonSocial());
        comercioEntidad.setNombreFantasia(comercioDTO.nombreFantasia());
        comercioEntidad.setCuit(comercioDTO.cuit());
        comercioEntidad.setIngresosBrutos(comercioDTO.ingresosBrutos());
        comercioEntidad.setCondicionIva(comercioDTO.condicionIva());
        comercioEntidad.setDiaCobro(comercioDTO.diaCobro());
        comercioEntidad.setDomicilioEntidad(domicilioEntidad);
        comercioEntidad.setComisionesPorCuota(comercioDTO.comisiones());
        comercioEntidad.setCategoriaComercioByIdCategoria(categoriaEntidad);
        comercioEntidad.setComercioRepresentanteByIdRepresentante(comercioRepresentanteEntidad);
        comercioRepresentanteRepository.save(comercioRepresentanteEntidad);
        domicilioRepository.save(domicilioEntidad);
        comercioRepository.save(comercioEntidad);
        return true;
    }


    public void eliminarComercio(Integer codigoComercio){
        ComercioEntidad comercioEntidad = comercioRepository.findById(codigoComercio).orElse(null);
        //Si no tiene consumos
        if (comercioEntidad != null && comercioEntidad.getImporteConsumos() == 0) {
            //Si no tiene facturas
            List<FacturaComercioEntidad> facturaComercioEntidad = (List<FacturaComercioEntidad>) facturaComercioRepository.findAllByIdComercio(codigoComercio);
            if (comercioEntidad.getFacturaComerciosByCodigoComercio() != null)
                comercioRepository.delete(comercioEntidad);
        }
    }
}