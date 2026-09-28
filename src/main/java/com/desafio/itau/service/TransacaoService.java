package com.desafio.itau.service;

import com.desafio.itau.model.EstatisticaResponse;
import com.desafio.itau.model.Transacao;
import com.desafio.itau.model.TransacaoRequest;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class TransacaoService {

    private List<Transacao> transacoes;

    Logger logger = LoggerFactory.getLogger(TransacaoService.class);

    public TransacaoService() {
        transacoes = new ArrayList<>();
    }

    public void criarTransacao(TransacaoRequest transacaoRequest) {
        logger.warn("Criando Transação com o valor de " + transacaoRequest.getValor());

        transacoes.add(new Transacao(transacaoRequest.getValor(), transacaoRequest.getDataHora()));
    }

    public EstatisticaResponse estatisticaTransacao(Integer tempo) {
        logger.warn("Gerando estatísticas de transações: " + transacoes);

        OffsetDateTime agora = OffsetDateTime.now();
        DoubleSummaryStatistics estatisticas = transacoes.stream()
                .filter((t) -> t.getDataHora().isAfter(agora.minusSeconds(tempo)))
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
        logger.warn("Deletando transações " + transacoes);

        transacoes.clear();
    }
}
