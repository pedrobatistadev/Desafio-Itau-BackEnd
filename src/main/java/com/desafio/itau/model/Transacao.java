package com.desafio.itau.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double valor;

    private OffsetDateTime dataHora;

    public Transacao() {
    }

    public Transacao(Double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "valor=" + valor +
                ", dataHora=" + dataHora +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Transacao transacaoRequest)) return false;
        return Objects.equals(valor, transacaoRequest.valor) && Objects.equals(dataHora, transacaoRequest.dataHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, dataHora);
    }
}
