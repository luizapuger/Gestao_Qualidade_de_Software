public class Sequencia {
    private int n;
    private int m;

    // Inicializar n e m
    public Sequencia(int n, int m) {
        this.n = n;
        this.m = m;
    }

    // Exibir sequência
    public void exibirSequencia() {
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                // Crescente
                for (int j = 0; j <= n; j++) {
                    System.out.print(j + " ");
                }
            } else {
                // Decrescente
                for (int j = n; j >= 0; j--) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
