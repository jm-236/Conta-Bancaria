package com.Banco;

import com.ContasBancarias.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta c){
        contas.add(c);
    }

    public void excluirConta(Conta contaExcluida){
        contas.stream().filter(n -> n == contaExcluida).forEach(n -> contas.remove(n));
    }
}
