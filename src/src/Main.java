import com.Banco.Banco;
import com.Cliente.Cliente;
import com.ContasBancarias.Conta;
import com.ContasBancarias.ContaCorrente;
import com.ContasBancarias.ContaPoupanca;
import com.ContasBancarias.ContaSalario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco BB = new Banco("Banco");
        Cliente Joao = new Cliente("João");
        Cliente Boss = new Cliente("Boss");

        // contas default
        BB.adicionarConta(new ContaCorrente(Joao, "1234"));
        Conta ccJoao = BB.getContas().getFirst();
        BB.adicionarConta(new ContaPoupanca(Boss, "1234"));
        Conta cpBoss = BB.getContas().get(1);
        cpBoss.depositar(Double.MAX_VALUE);
        BB.adicionarConta(new ContaSalario(Joao, "1234", cpBoss, ccJoao));
        Conta csJoao = BB.getContas().getLast();

        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (i != 3) {
            System.out.println("Bem vindo ao nosso Banco! O que deseja fazer ?");
            System.out.println("1- Login");
            System.out.println("2- Criar uma nova conta");
            System.out.println("3- Encerrar sessão");
            System.out.print("Sua opção: ");
            i = sc.nextInt();

            switch (i){
                case 1:
                    System.out.print("Digite o número da conta: ");
                    int numeroConta = sc.nextInt();
                case 2:
                    System.out.println("Você escolheu a opção 2");
                    continue;
                case 3:
                    System.out.println("Tchau!");
                    break;
                default:
                    System.out.println("Opção inválida, tente de novo!");
            }
        }
    }
}