package Desenvolvimento.produtos.Bebidas;

import Desenvolvimento.produtos.Produto;

public class Agua extends Produto {

    public static double PRECO_ATUAL_ALTERADO = 02;

    public Agua(){
        calculaAnosUltimaAlteracao();
        setPrecoDeVenda(PRECO_ATUAL_ALTERADO);
    }

    @Override
    public String getDescricao() {
        return "Agua "+ String.valueOf(getPrecoDeVenda());
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
