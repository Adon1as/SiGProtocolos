package com.me.SiGProtocolo.model;

public enum Natureza {
    FINANCEITO(10),
    JURIDICO(20),
    ADMINISTRATIVO(30);

    private final int vencimento;

    public int getVencimento() {
        return vencimento;
    }

    Natureza(int vencimento) {
        this.vencimento = vencimento;
    }
}
