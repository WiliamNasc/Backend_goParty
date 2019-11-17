package com.goparty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EventosController {
	
	@Autowired
	private EventosServices eventosServices;
	
	@RequestMapping(method=RequestMethod.GET, value="/evento")
	public List<Eventos> getTodosEventos() {
		return eventosServices.getTodosEventos();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/evento/{nome}")
	public Optional<Eventos> getEvento(@PathVariable String nome) {
		return eventosServices.getEvento(nome);
	}

	@RequestMapping(method=RequestMethod.POST, value="/evento")
	public void addEvento(@RequestBody Eventos evento) {
		eventosServices.addEvento(evento);
	}
	

}
