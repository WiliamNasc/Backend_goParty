package com.goparty.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventosRepository eventosrep;

//	@RequestMapping(method=RequestMethod.GET, value="/evento")
//	public List<Eventos> getTodosEventos() {
//		return eventosServices.getTodosEventos();
//	}

//	@RequestMapping(method=RequestMethod.GET, value="/evento/{nome}")
//	public Eventos getEvento(@PathVariable String nome) {
//		return eventosServices.getEvento(nome);
//	}

	@GetMapping("/consultarTodos")
	public List<Eventos> getEventos() {
		return eventosrep.findAll();
	}
	
	@GetMapping("consultarTodos/{id}")
	public Optional<Eventos> getEventoById(@PathVariable(value = "id") int eventoId) {
		return eventosrep.findById(eventoId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/incluir")
	public Eventos addEvento(@Valid @RequestBody Eventos evento) {
		return eventosrep.save(evento);
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public Eventos updateEvento(@Valid @RequestBody Eventos evento) {
		return eventosrep.save(evento);
		
	}

//	@RequestMapping(value = "/deletar/{id}", method = { RequestMethod.DELETE})
	@DeleteMapping("/deletar/{id}")
	public String deleteEvento(@PathVariable int id) {
		Optional<Eventos> eventos = eventosrep.findById(id);
		if (eventos.isPresent()) {
			eventosrep.delete(eventos.get());
			return "Evento excluido com sucesso!";
		} else {
			return "Evento inexistente!";
		}
	}
	
	@GetMapping("/mostrar")
	public int mostrar() {
		Eventos e = new Eventos();
		int TotalPart = 0;
		while(e.getId() > 0) {
			TotalPart += e.getId();
		}
		
		System.out.println(e.getQtdConvidados());
		return TotalPart;
	}
}
