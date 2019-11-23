package com.goparty.services;

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
	public List<Eventos> getAllEmployees() {
		return eventosrep.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/incluir")
	public Eventos addEvento(@Valid @RequestBody Eventos evento) {
		return eventosrep.save(evento);
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Eventos> Put(@PathVariable(value = "id") int id, @Valid @RequestBody Eventos newEvento) {
		Optional<Eventos> oldEvento = eventosrep.findById(id);
		if (oldEvento.isPresent()) {
			Eventos evento = oldEvento.get();
			evento.setNome(newEvento.getNome());
			evento.setFaixaEtaria(newEvento.getFaixaEtaria());
			evento.setClassificacao(newEvento.getClassificacao());
			evento.setLocal(newEvento.getLocal());
			evento.setDataEvento(newEvento.getDataEvento());
			evento.setHoraInicio(newEvento.getHoraInicio());
			evento.setHoraFim(newEvento.getHoraFim());
			eventosrep.save(evento);
			return new ResponseEntity<Eventos>(evento, HttpStatus.OK);

		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

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
}
