package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Vehiculo;
import com.example.demo.payload.VehiculoRequest;
import com.example.demo.payload.VehiculoResponse;
import com.example.demo.repository.VehiculoRepository;
import com.example.demo.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Override
	public VehiculoResponse crear(VehiculoRequest vehiculoRequest) {

		var vehiculo = Vehiculo.builder().placa(vehiculoRequest.getPlaca()).color(vehiculoRequest.getColor())
				.ruedas(vehiculoRequest.getRuedas()).cilindrada(vehiculoRequest.getCilindrada())
				.fabricacion(vehiculoRequest.getFabricacion()).automatico(vehiculoRequest.getAutomatico()).build();

		vehiculo = vehiculoRepository.save(vehiculo);

		return VehiculoResponse.builder().id(vehiculo.getId()).placa(vehiculo.getPlaca()).color(vehiculo.getColor())
				.ruedas(vehiculo.getRuedas()).cilindrada(vehiculo.getCilindrada())
				.fabricacion(vehiculo.getFabricacion()).automatico(vehiculo.getAutomatico()).build();
	}

	@Override
	public VehiculoResponse buscarPorId(Long id) {
		var vehiculo = vehiculoRepository.findById(id).orElseThrow(NotFoundException::new);

		return VehiculoResponse.builder().id(vehiculo.getId()).placa(vehiculo.getPlaca()).color(vehiculo.getColor())
				.ruedas(vehiculo.getRuedas()).cilindrada(vehiculo.getCilindrada())
				.fabricacion(vehiculo.getFabricacion()).automatico(vehiculo.getAutomatico()).build();
	}

	@Override
	public List<VehiculoResponse> listarTodo() {

		var vehiculosResponse = new ArrayList<VehiculoResponse>();

		vehiculoRepository.findAll().forEach(vehiculo -> {
			vehiculosResponse.add(VehiculoResponse.builder().id(vehiculo.getId()).placa(vehiculo.getPlaca())
					.color(vehiculo.getColor()).ruedas(vehiculo.getRuedas()).cilindrada(vehiculo.getCilindrada())
					.fabricacion(vehiculo.getFabricacion()).automatico(vehiculo.getAutomatico()).build());
		});

		return vehiculosResponse;
	}

	@Override
	public VehiculoResponse actualizar(Long id, VehiculoRequest vehiculoRequest) {
		var vehiculo = vehiculoRepository.findById(id).orElseThrow(NotFoundException::new);

		vehiculo.setPlaca(vehiculoRequest.getPlaca());
		vehiculo.setColor(vehiculoRequest.getColor());
		vehiculo.setRuedas(vehiculoRequest.getRuedas());
		vehiculo.setCilindrada(vehiculoRequest.getCilindrada());
		vehiculo.setFabricacion(vehiculoRequest.getFabricacion());
		vehiculo.setAutomatico(vehiculoRequest.getAutomatico());

		vehiculo = vehiculoRepository.save(vehiculo);

		return VehiculoResponse.builder().id(vehiculo.getId()).placa(vehiculo.getPlaca()).color(vehiculo.getColor())
				.ruedas(vehiculo.getRuedas()).cilindrada(vehiculo.getCilindrada())
				.fabricacion(vehiculo.getFabricacion()).automatico(vehiculo.getAutomatico()).build();
	}

	@Override
	public void eliminar(Long id) {
		vehiculoRepository.deleteById(id);
	}

}
