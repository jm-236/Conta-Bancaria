package com.Banco;

import com.ContasBancarias.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta contaAdicionada){
        if (contas.stream().filter(c -> c == contaAdicionada).count() == 0) {
            contas.add(contaAdicionada);
        }
    }

    public void excluirConta(Conta contaExcluida){
        contas.stream().filter(n -> n == contaExcluida).forEach(n -> contas.remove(n));
    }

    @Override
    public String toString() {
        return "Banco: " + this.getNome() + ", número de contas abertas: " + this.getContas().size();
    }
}
