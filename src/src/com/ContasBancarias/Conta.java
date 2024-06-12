package com.ContasBancarias;

import com.Cliente.Cliente;
import com.Operacao.Operacao;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected String senha;
    protected List<Operacao> historicoOperacoes;

    public Conta( Cliente cliente, String senha) {
        this.cliente = cliente;
        this.senha = senha;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0.0;
        this.historicoOperacoes = new ArrayList<>();
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.setSaldo(this.getSaldo() - valor);
            this.historicoOperacoes.add(new Operacao(/* Adicionar argumentos posteriormente*/));
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            this.historicoOperacoes.add(new Operacao(/* Adicionar argumentos posteriormente*/));
        } else {
            // configurar tratamento de exceções posteriormente
            System.out.println("Valor inválido");
        }
    }

    public void transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= this.saldo && destino != null) {
            this.setSaldo(this.getSaldo() - valor);
            destino.setSaldo(destino.getSaldo() + valor);
            this.historicoOperacoes.add(new Operacao(/* Adicionar argumentos posteriormente*/));
            destino.historicoOperacoes.add(new Operacao(/* Adicionar argumentos posteriormente*/));
        } else {
            // configurar tratamento de exceções posteriormente
            System.out.println("Saldo insuficiente");
        }
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da conta " + this.getNumero() + " - Agência " + this.getAgencia() + ":");
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Histórico de operações: ");

        // ordenar as operações por data e na ordem decrescente
        // printar os saldos antes tbm
        for (Operacao operacao : this.historicoOperacoes) {
            System.out.println(operacao);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    void imprimirInfosComuns() {
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Cliente: " + this.cliente.getNome());
    }
}
