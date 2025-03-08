package com.me.SiGProtocolo.service;

import com.me.SiGProtocolo.model.Protocolo;
import com.me.SiGProtocolo.repository.ProtocoloRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProtocoloService {
    private final ProtocoloRepository repository;

    public ProtocoloService(ProtocoloRepository repository) {
        this.repository = repository;
    }

    public List<Protocolo> listarTodos(){
        return repository.findAll();
    }

    public Protocolo cadatrar(Protocolo protocolo){
        protocolo.setCriacao(LocalDateTime.now());
        return repository.save(protocolo);
    }
}
