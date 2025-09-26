import java.util.List;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        locadora locadora = new locadora();
        Scanner sc = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            mostrarMenu();
            int opcao = lerInt(sc, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    int ano = lerInt(sc, "Ano: ");
                    System.out.print("Cor: ");
                    String cor = sc.nextLine();
                    locadora.cadastrarCarro(new carro(modelo, ano, cor));
                    System.out.println("Carro cadastrado!\n");
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    int idade = lerInt(sc, "Idade: ");
                    locadora.cadastrarCliente(new cliente(nome, cpf, idade));
                    System.out.println("Cliente cadastrado!\n");
                    break;

                case 3:
                    System.out.print("Modelo do carro a alugar: ");
                    String modeloAlugar = sc.nextLine();
                    if (locadora.alugarCarro(modeloAlugar))
                        System.out.println("Carro alugado!\n");
                    else
                        System.out.println("Carro não encontrado ou indisponível.\n");
                    break;

                case 4:
                    System.out.print("Modelo do carro a devolver: ");
                    String modeloDevolver = sc.nextLine();
                    if (locadora.devolverCarro(modeloDevolver))
                        System.out.println("Carro devolvido!\n");
                    else
                        System.out.println("Carro não encontrado ou já disponível.\n");
                    break;

                case 5:
                    List<carro> disponiveis = locadora.listarCarrosDisponiveis();
                    if (disponiveis.isEmpty())
                        System.out.println("Nenhum carro disponível.\n");
                    else {
                        System.out.println("Carros disponíveis:");
                        for (carro c : disponiveis) {
                            System.out.println(c.toString());
                        }
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("Saindo... Até mais!");
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida.\n");
            }
        }
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("--- Sistema Locadora ---");
        System.out.println("1 - Cadastrar carro");
        System.out.println("2 - Cadastrar cliente");
        System.out.println("3 - Alugar carro");
        System.out.println("4 - Devolver carro");
        System.out.println("5 - Listar carros disponíveis");
        System.out.println("6 - Sair");
    }

    private static int lerInt(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
