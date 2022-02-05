package com.veris.pruebakevinmarin.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.veris.pruebakevinmarin.util.enums.GeneroEnum;
import com.veris.pruebakevinmarin.util.enums.TipoIdentificacionEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

private static final long serialVersionUID = -4732891610270496689L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MED_SEQ")
	@SequenceGenerator(sequenceName = "increment_medicos", allocationSize = 1, name = "MED_SEQ")
    @Column(name = "codigo_medico")
	private Long codigoMedico;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "El tipo de identificación no puede ser nulo.")
	@Column(name = "tipo_identificacion")
    private TipoIdentificacionEnum tipoIdentificacion;
	
	@Column(name = "numero_identificacion")
	@NotEmpty(message = "El número de identificación es obligatorio.")
	private String numeroIdentificacion;

	@Column(name = "primer_nombre")
	@NotEmpty(message = "El primer nombre del empleado es obligatorio.")
	private String primerNombre;
	
	@Column(name = "segundo_nombre")
	@NotEmpty(message = "El segundo nombre del empleado es obligatorio.")
	private String segundoNombre;
	
	@Column(name = "primer_apellido")
	@NotEmpty(message = "El primer apellido del empleado es obligatorio.")
	private String primerApellido;
	
	@Column(name = "segundo_apellido")
	@NotEmpty(message = "El segundo apellido del empleado es obligatorio.")
	private String segundoApellido;
	
	@Column(name = "nombre_completo")
	private String nombreCompleto;
	
	@Column(name = "mail")
	@NotEmpty(message = "El correo es obligatorio.")
	@Email(message = "El correo debe tener un formato válido.")
	private String mail;
	
	@Column(name = "fecha_nacimiento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	@NotNull(message = "El sueldo no puede ser nulo.")
	private Double sueldo;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "El género es requerido")
	@Column(name = "sexo")
    private GeneroEnum sexo;

	@ManyToOne
	@JsonIgnoreProperties({"medicos"})
	@JoinColumn(name = "codigo_sucursal", referencedColumnName = "codigo_sucursal")
	private Sucursal sucursal;
	
	private Long codigoEmpresa;
}
