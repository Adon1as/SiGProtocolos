package com.me.SiGProtocolo.controller;

import com.me.SiGProtocolo.model.Protocolo;
import com.me.SiGProtocolo.service.ProtocoloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/protocolos")
public class ProtocoloConrtroller {
    private final ProtocoloService service;

    public ProtocoloConrtroller(ProtocoloService service) {
        this.service = service;
    }

    @PostMapping
    public void cadatrarProtocolo(@RequestBody Protocolo protocolo){
        service.cadatrar(protocolo);
    }

    @GetMapping
    public List<Protocolo> listarProtocolos(){
        return service.listarTodos();
    }
}
