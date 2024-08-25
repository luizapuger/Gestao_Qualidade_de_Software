import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Mensagem Inicial do Jpanel
        String[] opcoes = {
            "1. Operações Bancárias com Exceções (Questão 1)",
            "2. Divisão de um número (Questão 2)",
            "3. Fatorial com Limite de 20 (Questão 3)",
            "4. Tipo de Triângulo (Questão 4)",
            "5. Sair"
        };

        while (true) {
            String escolha = (String) JOptionPane.showInputDialog(
                null,
                "Selecione uma questão para executar:",
                "Menu de Questões",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            if (escolha == null || escolha.equals(opcoes[4])) {
                break; // Sai do programa se o usuário escolher "Sair" ou fechar a janela
            }
            // Loop para Jpanel (entra a partir da segunda vez que tentar executar alguma questão)
            switch (escolha) {
                case "1. Operações Bancárias com Exceções (Questão 1)":
                    Questao1();
                    break;
                case "2. Divisão de um número (Questão 2)":
                    Questao2();
                    break;
                case "3. Fatorial com Limite de 20 (Questão 3)":
                    Questao3();
                    break;
                case "4. Tipo de Triângulo (Questão 4)":
                    Questao4();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    // Método que realiza a divisão da Questão 2
    public static double divisao(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("É impossível dividir um número por zero.");
        }
        return (double) a / b;
    }

    public static void Questao1() {
        String nome = typeString("Digite o nome do cliente");
        String cpf = typeString("Digite o cpf do cliente");
        double saldo = typeDouble("Digite o saldo inicial do cliente");

        Conta c = new Conta(nome, cpf, saldo);
        double deposito = typeDouble("Digite o valor do depósito");
        c.deposita(deposito);

        double saque = typeDouble("Digite o valor do saque");
        try {
            c.saca(saque);
        } catch (SaldoInsuficienteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\nOperação não realizada!");
        }
        JOptionPane.showMessageDialog(null, c.toString());
    }

    public static void Questao2() {
        try {
            int a = typeInt("Digite o numerador:");
            int b = typeInt("Digite o denominador:");
            double resultado = divisao(a, b);
            JOptionPane.showMessageDialog(null, "O resultado de " + a + " / " + b + " é: " + resultado);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
     public static void Questao3(){
         int numero = typeInt("Digite um número para calcular o fatorial (máximo 20)");
         try {
             int resultado = fatorial(numero);
             JOptionPane.showMessageDialog(null, "O fatorial de " + numero + " é: " + resultado);
         } catch (EntradaInvalidaException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
    }

    public static int fatorial(int numero) throws EntradaInvalidaException {
        if (numero > 20) {
            throw new EntradaInvalidaException("Número inválido! O fatorial não pode ser calculado para números maiores que 20.");
        }

        int fat = 1;
        int n = 1;
        while (++n <= numero) {
            fat *= n;
        }
        return fat;
    }

    public static void Questao4() {
        try {
            double lado1 = typeDouble("Digite o tamanho do lado 1:");
            double lado2 = typeDouble("Digite o tamanho do lado 2:");
            double lado3 = typeDouble("Digite o tamanho do lado 3:");
            Triangulo t = new Triangulo(lado1, lado2, lado3);
            int tipo = t.determinarTipo();
            String tipoNome = "";
            switch (tipo) {
                case 0:
                    tipoNome = "Equilátero";
                    break;
                case 1:
                    tipoNome = "Isósceles";
                    break;
                case 2:
                    tipoNome = "Escaleno";
                    break;
            }
            JOptionPane.showMessageDialog(null, "O triângulo com lados " + lado1 + ", " + lado2 + ", " + lado3 + " é " + tipoNome);
        } catch (TrianguloInvalidoError e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    
    private static double typeDouble(String txt) {
        while (true) {
            try {
                String userInput = JOptionPane.showInputDialog(txt);
                double d = Double.parseDouble(userInput);
                return d;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite um número válido.");
            }
        }
    }

    private static String typeString(String txt) {
        return JOptionPane.showInputDialog(null, txt);
    }

    private static int typeInt(String txt) {
        while (true) {
            try {
                String userInput = JOptionPane.showInputDialog(txt);
                int i = Integer.parseInt(userInput);
                return i;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite um número inteiro válido.");
            }
        }
    }
}
