package com.veris.pruebakevinmarin.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veris.pruebakevinmarin.controller.contract.MedicoController;
import com.veris.pruebakevinmarin.entity.Medico;
import com.veris.pruebakevinmarin.service.contract.MedicoService;

@RestController
@RequestMapping(value = "/api/medicos")
public class MedicoControllerImpl implements MedicoController {

	@Autowired
	private MedicoService serviceMedico;
	
	@Override
	public ResponseEntity<List<Medico>> findAll (Long codigoEmpresa, Long codigoSucursal, String nombreCompleto) {
		return ResponseEntity
			.ok(this.serviceMedico
			.findByCodigoEmpresaAndSucursal_CodigoSucursalAndNombreCompleto(codigoEmpresa, codigoSucursal, nombreCompleto));
	}
	
	@Override
	public ResponseEntity<?> save(@Valid Medico medico) {
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(this.serviceMedico.save(medico));
	}
}
