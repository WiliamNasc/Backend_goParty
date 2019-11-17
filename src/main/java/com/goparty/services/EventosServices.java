package com.goparty.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventosServices {

	@Autowired
	private EventosRepository eventosRepository;
	
	private List<Eventos> eventos = new ArrayList<>(Arrays.asList(
			new Eventos("Festa", "Livre", "JavaSwing", "Casa do seu Zé", "2019-11-20", "22:30", "22:35")));

	public List<Eventos> getTodosEventos() {
		return eventosRepository.findAll();
	}

	public Optional<Eventos> getEvento(String nome) {
		return eventosRepository.findById(nome);
	}

	public void addEvento(Eventos evento) {
		eventosRepository.save(evento);
	}

}
