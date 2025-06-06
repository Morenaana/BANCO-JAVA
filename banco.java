import java.util.Scanner;

public class banco {
    
    private String nome;
    private String numeroConta;
    private double saldo;

    public void ContaBancaria(String nome, String numeroConta, double saldoInicial) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo disponível: R$ " + String.format("%.2f", saldo));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome da pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria();
        System.out.println("Conta bancária criada com sucesso.");

        int opcao;
        do {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1 - Depositar valor");
            System.out.println("2 - Sacar valor");
            System.out.println("3 - Obter saldo disponível");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor para depósito: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 2:
                    System.out.print("Informe o valor para saque: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 3:
                    conta.consultarSaldo();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}