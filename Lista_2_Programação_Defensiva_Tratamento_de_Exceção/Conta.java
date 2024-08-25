import javax.swing.JOptionPane;

public class Conta {
    private static final double LIMITE_BANCO = 200.00; // Limite extra do banco (Crédito)

    private double saldo;
    private String nome, cpf;

    public Conta(String nome, String cpf, double saldo) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSaldo(saldo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = (saldo < 0) ? 0 : saldo;
    }

    public void deposita(double valor) {
        setSaldo((valor < 0) ? saldo : saldo + valor);
    }

    public void saca(double valor) throws SaldoInsuficienteException {
        double saldoDisponivel = getSaldo() + LIMITE_BANCO;

        // Verifica se o valor de saque é menor ou igual ao saldo disponível incluindo o limite
        if (valor <= saldoDisponivel) {
            if (valor > getSaldo()) {
                double valorLimite = valor - getSaldo();
                setSaldo(0); // Zera o saldo
                JOptionPane.showMessageDialog(null, "Atenção: você está entrando no limite do banco em R$ " + valorLimite);
            } else {
                setSaldo(getSaldo() - valor);
            }
        } else {
            throw new SaldoInsuficienteException("Seu saldo mais o limite disponível é: R$ " + saldoDisponivel + "\nVocê tentou sacar: R$ " + valor);
        }
    }

    public String toString() {
        return "Cliente: " + this.nome + "\nCPF: " + this.cpf + "\nSaldo: " + this.saldo;
    }
}