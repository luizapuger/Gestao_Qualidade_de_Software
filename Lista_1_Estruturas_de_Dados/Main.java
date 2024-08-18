import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Ler = new Scanner(System.in);
        int escolha;

        do {
            // Exibir menu
            System.out.println("Menu de Questões");
            System.out.println("1. Questão 1: Sequência Crescente e Decrescente");
            System.out.println("2. Questão 2: Sequência Fibonacci");
            System.out.println("3. Questão 3: Função");
            System.out.println("4. Questão 4: Matriz transposta");
            System.out.println("5. Questão 5: Classe UML - Produto");
            System.out.println("6. Questão 6: Diagrama de classe UML");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = Ler.nextInt();

            switch (escolha) {
                case 1:
                    Questao1();
                    break;
                case 2:
                    Questao2();
                    break;
                case 3:
                    Questao3();
                    break;
                case 4:
                    Questao4();
                    break;
                case 5:
                    System.out.println("Presente no arquivo 'Produto.java'");
                    break;
                case 6:
                    System.out.println("Presente nos arquivos: 'Mamifero.java', 'Cachorro.java', 'Ovelha.java', 'Gato.java'");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção não existe! Tente novamente.");
            }
        } while (escolha != 0);

        Ler.close();
    }

    public static void Questao1() {
        Scanner Ler = new Scanner(System.in);

        // Solicitar valores de n e m
        System.out.print("Inteiro positivo para n: ");
        int n = Ler.nextInt();
        // Verifica se n é maior que 0
        if (n < 1) {
            System.out.println("Erro, o valor deve ser Inteiro e maior que 0.");
            return;
        } 
        System.out.print("Repetições (m): ");
        int m = Ler.nextInt();

        // Sequencia para alternar entre crescente e decrescente
        Sequencia sequencia = new Sequencia(n, m);
        sequencia.exibirSequencia();

    }

    public static void Questao2() {
        Scanner Ler = new Scanner(System.in);

        System.out.print("Digite a quantidade de números da sequência de Fibonacci que você quer: ");
        int n = Ler.nextInt();

        if (n <= 0) {
            System.out.println("Por favor, insira um número positivo.");
            } 
        else {
            System.out.println("Sequência de Fibonacci:");
            int a = 1, b = 1;
            System.out.print(a + " ");

            for (int i = 2; i <= n; i++) {
                System.out.print(b + " ");
                int temp = b;
                b = a + b;
                a = temp;
            }
        }
        System.out.print("\n");
    }


    public static void Questao3() {
        Scanner Ler = new Scanner(System.in);

        // Solicita o valor de n
        System.out.print("Digite um valor inteiro positivo para n: ");
        int n = Ler.nextInt();

        // Verifica se n é positivo
        if (n <= 0) {
            System.out.println("Erro, o valor de n deve ser maior que 0.");
            return;
        }

        // Calcula a soma da série harmônica
        double soma = SerieHarmonica.calcularSoma(n);
        System.out.printf("A soma da série harmônica até %d é: %.5f\n", n, soma);
    }

    
    public static void Questao4() {
        Scanner Ler = new Scanner(System.in);

        System.out.println("Olá usuário! Vamos transformar sua matriz em uma matriz transposta?");
        System.out.println("Primeiro, vamos definir a quantidade de linhas e colunas da sua matriz.");
        System.out.println("Digite o número de linhas: ");
        int linhas = Ler.nextInt();
        System.out.println("Digite o número de colunas: ");
        int colunas = Ler.nextInt();

        // Inicializa a matriz principal
        int[][] matriz = new int[linhas][colunas];

        // Recebe os elementos da matriz
        System.out.println("Agora, digite os elementos da matriz: ");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                    matriz[i][j] = Ler.nextInt();
            }
        }

        // Inicializa a matriz transposta
        int[][] transposta = new int[colunas][linhas];

        // Realiza a transposição
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta[j][i] = matriz[i][j];
            }
        }

        // Exibe a matriz transposta
        System.out.println("A matriz transposta é: ");
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                System.out.print(transposta[i][j] + " ");
            }
            System.out.println();
        }
    }

}
