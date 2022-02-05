package com.veris.pruebakevinmarin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veris.pruebakevinmarin.entity.Medico;
import com.veris.pruebakevinmarin.exception.custom.ConflictException;
import com.veris.pruebakevinmarin.repository.MedicoRepository;
import com.veris.pruebakevinmarin.service.contract.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository; 
	
	@Override
	public Medico save(Medico medico) {
		Medico _med = this.medicoRepository.findByNumeroIdentificacion(medico.getNumeroIdentificacion());
		
		if (_med != null)
			throw new ConflictException("La identificación " + medico.getNumeroIdentificacion() + " ya existe.");
		
		return this.medicoRepository.save(medico);
	}

	@Override
	public List<Medico> findByCodigoEmpresaAndSucursal_CodigoSucursalAndNombreCompleto (Long codigoEmpresa, Long codigoSucursal, String nombreCompleto) {
		return this.medicoRepository.findByCodigoEmpresaAndSucursal_CodigoSucursalAndNombreCompleto(codigoEmpresa, codigoSucursal, nombreCompleto);
	}

}
