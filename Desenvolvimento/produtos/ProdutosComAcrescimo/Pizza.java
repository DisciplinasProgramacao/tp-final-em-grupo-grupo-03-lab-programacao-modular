package Desenvolvimento.produtos.ProdutosComAcrescimo;

import java.util.List;

import Desenvolvimento.produtos.acrescimos.Acrescimo;


public class Pizza extends ProdutoComAdcionais {
    public static double PRECO_ATUAL_ALTERADO = 25;
    private boolean bordaRecheada;

    public Pizza(boolean bordaRecheada){
        calculaAnosUltimaAlteracao();
        this.bordaRecheada = bordaRecheada;
        setPrecoDeVendaPizza(PRECO_ATUAL_ALTERADO);
    }

    private void setPrecoDeVendaPizza(double preco){
        if(bordaRecheada){
            setPrecoDeVenda(preco+8);
        }else{
            setPrecoDeVenda(preco);
        }
    }

    @Override
    public void alterarPrecoNovoAdcional(Acrescimo acrescimo){
        setPrecoDeVenda(getPrecoDeVenda() + acrescimo.getPreco()*2); //x2 regra de negocio da pizza
    }

    @Override
    public void alterarPrecoRemoverAdcional(Acrescimo acrescimo){
        setPrecoDeVenda(getPrecoDeVenda() - acrescimo.getPreco()*2); //x2 regra de negocio da pizza
    }

    @Override
    public String getDescricao() {
        String descricao = "Pizza ";
        if(bordaRecheada){
            descricao += "Borda Recheada (8.00)";
        }
        List<Acrescimo> acrescimos = getAcrescimos();

        descricao += " Adcionais:";

        for (Acrescimo acrescimo : acrescimos) {
            descricao += acrescimo.getDescricao();
        }

        descricao += " || Valor total = " + String.valueOf(getPrecoDeVenda());

        return descricao;
    }

    @Override 
    public  void setPrecoAtualProduto(double precoAlterado){
        Pizza.PRECO_ATUAL_ALTERADO = precoAlterado;
    }

    @Override
    public double getPrecoAtualProduto() {
        return Pizza.PRECO_ATUAL_ALTERADO;
    }

    
}