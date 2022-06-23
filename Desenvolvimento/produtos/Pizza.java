package Desenvolvimento.produtos;

import java.time.LocalDate;

import Desenvolvimento.produtos.contracts.Comestivel;

public class Pizza extends Comestivel {
    private LocalDate dataDeCriacao = LocalDate.now();
    private double PRECO_FIXO = 25;
    private boolean bordaRecheada;

    Pizza(boolean bordaRecheada){
        this.bordaRecheada = bordaRecheada;
        setPrecoFixo();
    }

    @Override
    public void setPrecoFixo(){
        if(bordaRecheada){
            PRECO_FIXO += 8.00;
        }
    }

    @Override
    public double precoTotal() {
        return 0;
    }

    @Override
    public String getDescricao() {
        String descricao = "Pizza (25.00) ";
        if(bordaRecheada){
            descricao = ", Borda Recheada (8.00)";
        }
        return descricao;
    }

    @Override
    public void reajustarPreco(int anosPassados) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getPrecoFixo() {
        return PRECO_FIXO;
    }

    @Override
    public double calcularPrecoTotalDeAcrescimos(){
        return getAcrescimos().stream().mapToDouble((acrescimo) -> acrescimo.getPreco() * 2).sum();
    }
    
}