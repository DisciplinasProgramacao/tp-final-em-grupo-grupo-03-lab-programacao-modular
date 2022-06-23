package Desenvolvimento.produtos;

import java.time.LocalDate;

import Desenvolvimento.produtos.contracts.IPrecificavel;

public class Bebida implements IPrecificavel {
    private LocalDate dataDeCriacao = LocalDate.now();
    private TipoBebida tipoBebida;
    private double PRECO_FIXO;

    public Bebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
        setPrecoFixo();
    }

    @Override
    public double precoTotal() {
        return this.tipoBebida.getPreco();
    }

    public String getDescricao() {
        return this.tipoBebida.getDescricao();
    }

    @Override
    public void reajustarPreco(int anosPassados) {

    }

    @Override
    public double getPrecoFixo() {
        return PRECO_FIXO;
    }

    @Override
    public void setPrecoFixo() {
        PRECO_FIXO = tipoBebida.getPreco();
        
    }
}
