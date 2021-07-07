package com.example.demo.payload;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class VehiculoRequest {

	@Size(min = 4, max = 8, message = "Ingrese una placa valida")
	private String placa;

	private String color;

	@Min(value = 2, message = "Cantidad de ruedas incoherente")
	private Integer ruedas;

	@Min(value = 1, message = "Cilindrada incoherente")
	private Double cilindrada;

	@NotNull(message = "Fecha requerida")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fabricacion;

	private Boolean automatico;
	
}
