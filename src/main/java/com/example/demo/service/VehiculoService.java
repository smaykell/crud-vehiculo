package com.example.demo.service;

import java.util.List;

import com.example.demo.payload.VehiculoRequest;
import com.example.demo.payload.VehiculoResponse;

public interface VehiculoService {

	VehiculoResponse crear(final VehiculoRequest vehiculoRequest);

	VehiculoResponse buscarPorId(final Long id);

	List<VehiculoResponse> listarTodo();

	VehiculoResponse actualizar(final Long id, final VehiculoRequest vehiculoRequest);

	void eliminar(final Long id);
}
