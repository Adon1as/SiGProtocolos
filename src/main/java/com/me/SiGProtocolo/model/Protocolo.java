package com.me.SiGProtocolo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Table(name = "Protocolo")
@Entity
public class Protocolo {
    public Protocolo(Natureza natureza) {
        this.natureza = natureza;
    }
    public Protocolo() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "protocolo_numero_seq")
    @SequenceGenerator(name = "protocolo_numero_seq", sequenceName = "protocolo_numero_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long numero;

    @Column(nullable = false)
    private LocalDateTime criacao;

    @Column(nullable = false)
    private Natureza natureza;




    public Long getNumero() {
        return numero;
    }

    public LocalDateTime getCriacao() {
        return criacao;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public LocalDateTime getVencimento(){
        return criacao.plusDays(natureza.getVencimento());
    }

    public void setCriacao(LocalDateTime criacao) {
        this.criacao = criacao;
    }
}
