import com.Banco.Banco;
import com.Cliente.Cliente;
import com.ContasBancarias.Conta;
import com.ContasBancarias.ContaCorrente;
import com.ContasBancarias.ContaPoupanca;
import com.ContasBancarias.ContaSalario;

public class Main {
    public static void main(String[] args) {
        Banco BB = new Banco("Banco do Brasil");
        // System.out.println(BB);

        Conta contaTeste = new ContaCorrente(new Cliente("João Marcelo"), "1234");
        Conta contaTeste2 = new ContaPoupanca(new Cliente("Pedro Ivo"), "1234");

        BB.adicionarConta(contaTeste);
        BB.adicionarConta(contaTeste2);


//
//        for (Conta c: BB.getContas()){
//            System.out.println("-----------------");
//            c.imprimirInfosComuns();
//            System.out.println("-----------------");
//        }

        Conta contaTeste3 = new ContaSalario(new Cliente("Euclides"),
                "1234", BB.getContas().get(0), BB.getContas().get(1));
        BB.adicionarConta(contaTeste3);

        BB.getContas().get(0).depositar(50);
        BB.getContas().get(0).sacar(60);
        BB.getContas().get(0).sacar(40);

        BB.getContas().get(1).depositar(10);
        BB.getContas().get(1).transferir(BB.getContas().get(0), 5);
        for (Conta c: BB.getContas()){
            System.out.println("-----------------");
            c.imprimirInfosComuns();
            c.imprimirExtrato();
            System.out.println("-----------------");
        }
        System.out.println(BB);

        BB.getContas().get(0).transferir(BB.getContas().get(2), 2);
        BB.getContas().get(1).transferir(BB.getContas().get(2), 2);

        BB.getContas().get(2).imprimirExtrato();
        BB.getContas().get(0).imprimirExtrato();

        BB.getContas().get(2).transferir(BB.getContas().get(0), 2);
        BB.getContas().get(2).transferir(BB.getContas().get(1), 2);


        BB.getContas().get(2).sacar(0);

        for (Conta c : BB.getContas()){
            c.imprimirInfosComuns();
            c.imprimirExtrato();
        }
    }
}