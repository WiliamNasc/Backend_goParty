package com.goparty.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Eventos> getAllEmployees() {
        return eventosrep.findAll();
    }

	@RequestMapping(method=RequestMethod.POST, value="/incluir")
	public Eventos addEvento(@Valid @RequestBody Eventos evento) {
		return eventosrep.save(evento);
	}
	

}
