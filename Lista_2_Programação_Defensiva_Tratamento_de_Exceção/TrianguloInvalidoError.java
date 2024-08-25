// Exceção personalizada para triângulos inválidos
class TrianguloInvalidoError extends Exception {
    public TrianguloInvalidoError(String message) {
        super(message);
    }
}