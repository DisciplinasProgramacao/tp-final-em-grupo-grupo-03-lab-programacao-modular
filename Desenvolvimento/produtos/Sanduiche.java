package Desenvolvimento.produtos;

import java.time.LocalDate;

import Desenvolvimento.produtos.acrescimos.Acrescimo;
import Desenvolvimento.produtos.contracts.Comestivel;

public class Sanduiche extends Comestivel {
    private double precoVenda;
    public static double precoAlterado = 12;
    private boolean paoArtesanal;   

    public Sanduiche(boolean paoArtesanal){

        this.paoArtesanal = paoArtesanal;
        this.precoVenda = precoAlterado;
    }



    @Override
    public String getDescricao() {
        String descricao = "Sanduiche (12.0)";
        if(paoArtesanal){
            descricao = ", Pao Artesanal (2.00)";
        }
        return descricao;
    }

    @Override
    public void reajustarPreco(double precoAtual) {
          this.precoAlterado = this.precoAlterado *  IReajustavel.REAJUSTE_BASE; 
    }

    @Override
    public double getPrecoFixo() {
        return PRECO_FIXO;
    }

    @Override
    public void setPrecoFixo() {
        if(paoArtesanal){
            PRECO_FIXO += 2.00;
        }
        
    }
    
}
