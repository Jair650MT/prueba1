package com.example.validacion.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Persona {
	@Size(min = 3, max = 50)
	private String nombre;
	@NotBlank
	@Email(message = "Ingrese el correo en formato email")
	private String email;
	@NotBlank
	@Size(min = 5, max = 15)
	private String password;
	@NotBlank
	private String genero;
	@Size(min = 5, max = 150)
	private String domicilio;
	@AssertTrue
	private boolean matrimonio;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date fechaNacimiento;
	@NotBlank
	private String profesion;
	@Min(value = 6000)
	@Max(value = 50000)
	private long ingreso;
}
