package com.example.demo.payload;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class VehiculoResponse {

	private Long id;

	private String placa;

	private String color;

	private Integer ruedas;

	private Double cilindrada;


    @DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fabricacion;

	private Boolean automatico;
}
