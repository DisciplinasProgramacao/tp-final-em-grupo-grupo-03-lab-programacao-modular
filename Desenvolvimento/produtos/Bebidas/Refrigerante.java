package Desenvolvimento.produtos.Bebidas;

import Desenvolvimento.produtos.Produto;

public class Refrigerante extends Produto {
    public static double PRECO_ATUAL_ALTERADO = 05;

    public Refrigerante(){
        calculaAnosUltimaAlteracao();
        setPrecoDeVenda(PRECO_ATUAL_ALTERADO);
    }

    @Override
    public String getDescricao() {
        return "Refrigerante " + getPrecoDeVenda();
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
