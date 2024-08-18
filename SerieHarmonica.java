public class SerieHarmonica {
    // Função para a soma da série harmônica até n
    public static double calcularSoma(int n) {
        double soma = 0.0;

        for (int i = 1; i <= n; i++) {
            soma += 1.0 / i;
        }

        return soma;
    }
}
