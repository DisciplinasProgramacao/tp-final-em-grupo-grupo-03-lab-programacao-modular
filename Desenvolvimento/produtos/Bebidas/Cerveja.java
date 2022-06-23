package Desenvolvimento.produtos.Bebidas;

import Desenvolvimento.produtos.Produto;

public class Cerveja extends Produto{
    public static double PRECO_ATUAL_ALTERADO = 8;

    public Cerveja(){
        calculaAnosUltimaAlteracao();
        setPrecoDeVenda(PRECO_ATUAL_ALTERADO);
    }

    @Override
    public String getDescricao() {
        return "Cerveja "+getPrecoDeVenda();
    }

    @Override
    public double getPrecoAtualProduto() {
        return PRECO_ATUAL_ALTERADO;
    }

    @Override
    public void setPrecoAtualProduto(double novoPreco) {
        Agua.PRECO_ATUAL_ALTERADO = novoPreco;
        
    }
}
