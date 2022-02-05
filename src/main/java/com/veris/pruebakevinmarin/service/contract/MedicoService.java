package com.veris.pruebakevinmarin.service.contract;

import java.util.List;

import com.veris.pruebakevinmarin.entity.Medico;

/**
 * 
 * @author kevin
 *
 */
public interface MedicoService {
	
	/**
	 * 
	 * @param medico
	 * @return new medico
	 */
	Medico save (Medico medico);
	
	/**
	 * 
	 * @return lista de médicos
	 */
	List<Medico> findByCodigoEmpresaAndSucursal_CodigoSucursalAndNombreCompleto (Long codigoEmpresa, Long codigoSucursal, String nombreCompleto);
}
