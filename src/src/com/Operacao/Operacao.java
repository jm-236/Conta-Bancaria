package com.Operacao;

import com.ContasBancarias.Conta;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;


public class Operacao {
    // Salvar: data da operação, tipo da operação, valores e conta(s) envolvidas
    private LocalDate dataOperacao;
    private TipoOperacao tipoDaOperacao;
    private double valor;
    private Conta contaAlvo;

    // Opcional, pq existem operações que envolvem só uma conta
    private Conta contaInicial;

    public Operacao(TipoOperacao tipoDaOperacao, double valor, Conta contaAlvo) {
        this.dataOperacao = LocalDate.now();
        this.tipoDaOperacao = tipoDaOperacao;
        this.valor = valor;
        this.contaAlvo = contaAlvo;
    }

    public Operacao(TipoOperacao tipoDaOperacao, double valor) {
        this.valor = valor;
        this.tipoDaOperacao = tipoDaOperacao;
        this.dataOperacao = LocalDate.now();
        this.contaAlvo = null;
        this.contaInicial = null;
    }

    public Operacao(TipoOperacao tipoDaOperacao, double valor, Conta contaAlvo, Conta contaInicial) {
        this.dataOperacao = LocalDate.now();
        this.tipoDaOperacao = tipoDaOperacao;
        this.valor = valor;
        this.contaAlvo = contaAlvo;
        this.contaInicial = contaInicial;
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
    }

    public TipoOperacao getTipoDaOperacao() {
        return tipoDaOperacao;
    }

    public double getValor() {
        return valor;
    }

    public Conta getContaAlvo() {
        return contaAlvo;
    }

    public Conta getContaInicial() {
        return contaInicial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operacao operacao = (Operacao) o;
        return Double.compare(valor, operacao.valor) == 0 && Objects.equals(dataOperacao, operacao.dataOperacao)
                && Objects.equals(tipoDaOperacao, operacao.tipoDaOperacao)
                && Objects.equals(contaAlvo, operacao.contaAlvo)
                && Objects.equals(contaInicial, operacao.contaInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataOperacao, tipoDaOperacao, valor, contaAlvo, contaInicial);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        String valorFormatado = df.format(getValor());
        switch (this.tipoDaOperacao){
            case SAQUE -> {
                return "Saque: -R$" + valorFormatado;
            }
            case DEPOSITO -> {
                return "Depósito: +R$" + valorFormatado;
            }
            case TRANSFERENCIA_ENVIADA -> {
                return "Transferência: -R$" + valorFormatado + "de " + contaInicial.getCliente().getNome()
                        + " para " + contaAlvo.getCliente().getNome();
            }
            case TRANSFERENCIA_RECEBIDA -> {
                return "Transferência: +R$" + valorFormatado + "de " + contaInicial.getCliente().getNome()
                        + " para " + contaAlvo.getCliente().getNome();
            }
        }
        return "Tipo de operação não identificado";
    }
}
