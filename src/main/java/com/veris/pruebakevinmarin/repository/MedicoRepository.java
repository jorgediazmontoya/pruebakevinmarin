package com.veris.pruebakevinmarin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veris.pruebakevinmarin.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
	
	Medico findByNumeroIdentificacion (String  numeroIdentificacion);
	
	List<Medico> findByCodigoEmpresaAndSucursal_CodigoSucursalAndNombreCompleto (Long codigoEmpresa, Long codigoSucursal, String nombreCompleto);
}
