package com.veris.pruebakevinmarin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.veris.pruebakevinmarin.util.enums.RegionEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sucursales")
@JsonInclude(Include.NON_NULL)
public class Sucursal implements Serializable {

	private static final long serialVersionUID = 301221593452760975L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUC_SEQ")
	@SequenceGenerator(sequenceName = "increment_sucursales", allocationSize = 1, name = "SUC_SEQ")
    @Column(name = "codigo_sucursal")
	private Long codigoSucursal;
    
	@Id
	@Column(name = "codigo_empresa")
	private Long codigoEmpresa;
	
	@NotEmpty(message = "El nombre de la sucursal es obligatoria.")
	@Column(name = "nombre_sucursal")
	private String nombreSucursal; 
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "La region no puede ser nula.")
	@Column(name = "region")
	private RegionEnum regionEnum;

	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"sucursal"})
	@JsonProperty(access = Access.READ_ONLY)
	private List<Medico> medicos;
		
	@NotEmpty(message = "El nombre de usuario es obligatoria.")
	@Column(name = "usuario_registro")
	private String usuarioRegistro;
	
	@NotEmpty(message = "La fecha de registro es obligatoria.")
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
}
