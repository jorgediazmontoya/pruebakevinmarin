package com.veris.pruebakevinmarin.controller.contract;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.veris.pruebakevinmarin.entity.Medico;

public interface MedicoController {
	
	@GetMapping(value = {"/", ""}, produces = "application/json")
	ResponseEntity<List<Medico>> findAll (@RequestParam(required = false) Long codigoEmpresa, @RequestParam(required = false) Long codigoSucursal, @RequestParam String nombreCompleto);
	
	@PostMapping(value = {"/", ""}, produces = "application/json")
	ResponseEntity<?> save (@Valid @RequestBody Medico medico);
}
