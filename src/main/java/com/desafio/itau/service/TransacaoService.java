package com.desafio.itau.service;

import com.desafio.itau.model.Transacao;
import com.desafio.itau.model.TransacaoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private List<Transacao> transacoes;

    public TransacaoService() {
        transacoes = new ArrayList<>();
    }

    public void criarTransacao(TransacaoRequest transacaoRequest) {
        transacoes.add(new Transacao(transacaoRequest.getValor(), transacaoRequest.getDataHora()));
    }

    public void deleteTransacao() {
        transacoes.clear();
    }
}
