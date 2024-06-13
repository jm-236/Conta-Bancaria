package com.ContasBancarias;

import com.Cliente.Cliente;
import com.Operacao.Operacao;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente, String senha) {
        super(cliente, senha);
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da conta poupança " + this.getNumero() + " - Agência " + this.getAgencia() + ":");
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Histórico de operações: ");

        // ordenar as operações por data e na ordem decrescente
        // printar os saldos antes tbm
        for (Operacao operacao : this.historicoOperacoes) {
            System.out.println(operacao);
        }
    }
}
