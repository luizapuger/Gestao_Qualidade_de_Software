// Classe que representa um triângulo
class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;

    // Construtor que inicializa os lados e valida o triângulo
    public Triangulo(double lado1, double lado2, double lado3) throws TrianguloInvalidoError {
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            throw new TrianguloInvalidoError("Os lados do triângulo devem ser maiores que zero.");
        }
        if (lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado2 + lado3 <= lado1) {
            throw new TrianguloInvalidoError("Os lados fornecidos não formam um triângulo válido.");
        }
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    // Método para determinar o tipo do triângulo
    public int determinarTipo() {
        if (lado1 == lado2 && lado2 == lado3) {
            return 0; // Equilátero
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            return 1; // Isósceles
        } else {
            return 2; // Escaleno
        }
    }
}