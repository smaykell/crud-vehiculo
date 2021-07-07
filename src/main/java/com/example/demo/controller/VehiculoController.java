package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.payload.VehiculoRequest;
import com.example.demo.service.VehiculoService;

@Controller
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("vehiculos", vehiculoService.listarTodo());
		return "index";
	}

	@GetMapping(value = "/crear")
	public String crear(VehiculoRequest vehiculoRequest) {
		return "crear";
	}

	@PostMapping(value = "/guardar")
	public String guardar(@Valid VehiculoRequest vehiculoRequest, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors())
			return "crear";

		vehiculoService.crear(vehiculoRequest);
		return "redirect:/";
	}

	@GetMapping(value = "/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("vehiculo", vehiculoService.buscarPorId(id));
		return "editar";
	}

	@PostMapping(value = "/actualizar/{id}")
	public String actualizar(@PathVariable("id") Long id, @Valid VehiculoRequest vehiculoRequest) {
		vehiculoService.actualizar(id, vehiculoRequest);
		return "redirect:/";
	}

	@GetMapping(value = "/eliminar/{id}")
	public String destroy(@PathVariable("id") Long id) {
		vehiculoService.eliminar(id);
		return "redirect:/";
	}

}
