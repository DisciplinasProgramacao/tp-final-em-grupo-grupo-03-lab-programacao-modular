package Desenvolvimento.produtos.ProdutosComAcrescimo;

import java.util.List;

import Desenvolvimento.produtos.acrescimos.Acrescimo;

public class Sanduiche extends ProdutoComAdcionais {

    public static double PRECO_ATUAL_ALTERADO = 12;
    private boolean paoArtesanal;

    public Sanduiche(boolean paoArtesanal){
        calculaAnosUltimaAlteracao();
        this.paoArtesanal = paoArtesanal;
        setPrecoDeVendaPizza(PRECO_ATUAL_ALTERADO);
    }

    private void setPrecoDeVendaPizza(double preco){
        if(paoArtesanal){
            setPrecoDeVenda(preco+2);
        }else{
            setPrecoDeVenda(preco);
        }
    }

    @Override
    public String getDescricao() {
        String descricao = "Sanduiche";
        if(paoArtesanal){
            descricao += "Pao Artesanal (02.00)";
        }
        List<Acrescimo> acrescimos = getAcrescimos();

        for (Acrescimo acrescimo : acrescimos) {
            descricao += acrescimo.getDescricao();
        }

        descricao += " || Valor total = " + String.valueOf(getPrecoDeVenda());

        return descricao;
    }

    @Override 
    public  void setPrecoAtualProduto(double precoAlterado){
        Sanduiche.PRECO_ATUAL_ALTERADO = precoAlterado;
    }

    @Override
    public double getPrecoAtualProduto() {
        return Sanduiche.PRECO_ATUAL_ALTERADO;
    }

    
}
