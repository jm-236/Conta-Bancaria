package com.ContasBancarias;

import com.Cliente.Cliente;
import com.Operacao.Operacao;

public class ContaSalario extends Conta {

    private Conta contaPagadora;
    private Conta contaTransferencias;

    public Conta getContaTransferencias() {
        return contaTransferencias;
    }

    @Override
    public Conta getContaPagadora() {
        return contaPagadora;
    }

    public ContaSalario(Cliente cliente, String senha, Conta cp, Conta ct) {
        super(cliente, senha);
        this.contaPagadora = cp;
        this.contaTransferencias = ct;
    }

    @Override
    public void sacar(double valor) {
        System.out.println("Não é permitido sacar dinheiro diretamente desta conta.");
    }

    @Override
    public void depositar(double valor) {
        System.out.println("Não é possível depositar diretamente nessa conta bancária.");
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (destino.equals(getContaTransferencias())) {
            super.transferir(destino, valor);
            return;
        }
        System.out.println("Você não pode tranferir dinheiro para essa conta!");
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da conta salário " + this.getNumero() + " - Agência " + this.getAgencia() + ":");
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Histórico de operações: ");

        // ordenar as operações por data e na ordem decrescente
        // printar os saldos antes tbm
        for (Operacao operacao : this.historicoOperacoes) {
            System.out.println(operacao);
        }
    }
}
