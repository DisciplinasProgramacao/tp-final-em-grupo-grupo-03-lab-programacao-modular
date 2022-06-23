package Desenvolvimento.produtos.acrescimos;

public class Acrescimo {
    private TipoAcrescimo tipoAcrescimo;

    public Acrescimo(TipoAcrescimo tipoAcrescimo) {
        this.tipoAcrescimo = tipoAcrescimo;
    }

    public double getPreco() {
        return this.tipoAcrescimo.getPreco();
    }

    public String getDescricao() {
        return this.tipoAcrescimo.getDescricao();
    }
}
