package Desenvolvimento.produtos;

public enum TipoBebida {
    AGUA(2),
    SUCO(5),
    REFRIGERANTE(5),
    CERVEJA(8);

    private int preco;

    private TipoBebida(int preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

    public String getDescricao(){
        return this.name().toLowerCase();
    }
}
