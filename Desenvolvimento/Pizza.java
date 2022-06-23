package Desenvolvimento;

import Desenvolvimento.Acrescimos.Bacon;

public class Pizza implements IComestivel{

    private boolean bordaRecheada;

    Pizza(boolean bordaRecheada){
        this.bordaRecheada = bordaRecheada;
    }

    @Override
    public double precoTotal() {
        double preco = 25;
        if(bordaRecheada){
            preco += 8.00;
        }
        return preco;
    }

    @Override
    public String getDescricao() {
        String descricao = "Pizza (25.00) ";
        if(bordaRecheada){
            descricao = ", Borda Recheada (8.00)";
        }
        return descricao;
    }
    
}