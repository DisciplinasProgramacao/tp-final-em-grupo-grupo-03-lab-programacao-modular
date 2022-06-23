package Desenvolvimento.produtos.acrescimos;

public enum TipoAcrescimo {
    BACON(3),
    BATATA_PALHA(2),
    OVO(2),
    PEPERONI(4),
    PICLES(2),
    QUEIJO(2),
    PALMITO(3);

    private int preco;

    private TipoAcrescimo(int preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

    public String getDescricao(){
        return this.name().toLowerCase();
    }
}
