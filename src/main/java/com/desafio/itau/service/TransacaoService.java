package com.desafio.itau.service;

import com.desafio.itau.model.EstatisticaResponse;
import com.desafio.itau.model.Transacao;
import com.desafio.itau.model.TransacaoRequest;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
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

    public EstatisticaResponse estatisticaTransacao() {
        OffsetDateTime agora = OffsetDateTime.now();
        DoubleSummaryStatistics estatisticas = transacoes.stream()
                .filter((t) -> t.getDataHora().isAfter(agora.minusSeconds(60)))
                .mapToDouble((t) -> t.getValor())
                .summaryStatistics();

        if (estatisticas.getCount() == 0) {
            return new EstatisticaResponse(0,
                    0.0,
                    0.0,
                    0.0,
                    0.0);
        }

        return new EstatisticaResponse(estatisticas.getCount(),estatisticas.getSum(),estatisticas.getAverage(),estatisticas.getMin(),estatisticas.getMax());
    }

    public void deleteTransacao() {
        transacoes.clear();
    }
}
