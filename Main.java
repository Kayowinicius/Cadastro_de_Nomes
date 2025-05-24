import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroNomes cadastro = new CadastroNomes();

        cadastro.preencherNomes(scanner);

        while(true) {

            System.out.println("\nEscolha uma opção de 01 a 06: \n");
            System.out.println("01 - Exibir nomes");
            System.out.println("02 - Buscar nome por índice");
            System.out.println("03 - Mostrar nomes em maiúsculas");
            System.out.println("04 - Mostrar maior nome");
            System.out.println("05 - Contar nomes que começam com uma letra");
            System.out.println("06 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n---Nomes cadastrados---");
                    cadastro.exibirNomes();
                    break;

                case 2:
                    System.out.println("\nDigite um índice para buscar (0 a 04): ");
                    int indiceBuscado = scanner.nextInt();
                    System.out.println("Nome encontrado: " + cadastro.buscarNome(indiceBuscado));
                    break;

                case 3:
                    System.out.println("\nNomes em maiúsculas: ");
                    for (String nome : cadastro.converterParaMaiuscula()) {
                        System.out.println(nome);
                    }
                    break;

                case 4:
                    System.out.println("\nMaior nome é: " + cadastro.maiorNome());
                    break;

                case 5:
                    System.out.println("\nDigite uma letra para buscar os nomes que começam com ela: \n ");
                    String letra = scanner.nextLine();
                    if (letra.length() == 1) {
                        char letraChar = letra.charAt(0);
                        int quantidade = cadastro.ContarNomes(letraChar);
                        System.out.println("Tem " + quantidade + " nomes que começam com a letra " + letraChar + ".\n");
                    } else {
                        System.out.println("Digite apenas uma letra! ");
                    }
                    break;

                case 6:
                    System.out.println("Saindo do programa");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        }
    }

    static class CadastroNomes {
        private String[] nomes;

        public CadastroNomes() {
            this.nomes = new String[5];

        }

        public void preencherNomes(Scanner scanner) {
            System.out.println("\n--- Cadastro de nomes---");
            for (int i = 0; i < nomes.length; i++) {
                System.out.print("Digite o nome #" + (i + 1) + ": ");
                nomes[i] = scanner.nextLine().trim();
            }
        }

        public void exibirNomes() {
            for (String nome : nomes) {
                System.out.println(nome);
            }
        }

        public String buscarNome(int indiceBuscado) {
             if (indiceBuscado >= 0 && indiceBuscado < nomes.length) {
                 return nomes[indiceBuscado];
             } else {
                 return "Indice inválido";
             }

        }

        public String[] converterParaMaiuscula() {
            String[] nomesMaiusculos = new String[nomes.length];
            for (int i = 0; i < nomes.length; i++) {
                nomesMaiusculos[i] = nomes[i].toUpperCase();
            }
            return nomesMaiusculos;
        }

        public String maiorNome () {
            String maiorNome = "";
            for (String nome : nomes) {
                if (nome.length() > maiorNome.length()) {
                    maiorNome = nome;

                }
            }
            return maiorNome;

        }

        public int ContarNomes (char letra) {
            int contador = 0;
            String letraStr = String.valueOf(letra).toLowerCase();

            for (String nome: nomes) {
                if (nome.toLowerCase().startsWith(String.valueOf(letra).toLowerCase())) {
                    contador++;
                }

            }
            return contador;
        }
    }
}



