public class Produto {
    // Atributos
    private int id;
    private String descricao;
    private float preco;
    private int quant;
    private static int cont = 0;

    // Construtor já sabendo as informações do produto
    public Produto(String d, float p, int q) {
        this.id = ++cont; // Incrementa e atribui um ID único
        this.descricao = d;
        this.preco = p;
        this.quant = q;
    }
    // Construtor sem informações definidas do produto - "Vazia"
    public Produto() {
        this.id = ++cont; // Incrementa e atribui um ID único
        this.descricao = "";
        this.preco = 0.0f;
        this.quant = 0;
    }
    // Retorna o ID único do produto.
    public int getId() {
        return id;
    }
    // Define a quantidade de unidades do produto.
    public void setQuant(int q) {
        this.quant = q;
    }
    // Confirma se o produto está em estoque.
    public boolean emEstoque() {
        return quant > 0;
    }
    // Define a descrição do produto.
    public void setDescricao(String d) {
        this.descricao = d;
    }
    // Define o preço do produto.
    public void setPreco(float p) {
        this.preco = p;
    }
    // Retorna quantos produtos já foram criados ao todo.
    public static int getCont() {
        return cont;
    }
}
