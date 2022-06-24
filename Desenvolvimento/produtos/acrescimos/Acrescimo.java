package Desenvolvimento.produtos.acrescimos;

import java.io.Serializable;

public enum Acrescimo implements Serializable {
    BACON(3),
    BATATA_PALHA(2),
    OVO(2),
    PEPERONI(4),
    PICLES(2),
    QUEIJO(2),
    PALMITO(3);

    private int preco;

    private Acrescimo(int preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return this.preco;
    }

    public String getDescricao() {
        return " " + this.name().toLowerCase();
    }
}
