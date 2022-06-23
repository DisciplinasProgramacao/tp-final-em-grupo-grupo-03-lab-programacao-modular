package Desenvolvimento.produtos;

import java.time.Duration;
import java.time.LocalDate;

import Desenvolvimento.produtos.contracts.IReajustavel;

public abstract class Produto implements IReajustavel{
    public static  LocalDate DataUltimaAlteracaoPreco = LocalDate.of(2021, 06, 17);
    public static final int DIAS_NO_ANO = 365;
    private double precoDeVenda;

    public void setPrecoDeVenda(double precoDeVenda){
        this.precoDeVenda = precoDeVenda;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void calculaAnosUltimaAlteracao(){

        long daysBtween =  Duration.between(DataUltimaAlteracaoPreco.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();

        if(daysBtween >= DIAS_NO_ANO){
            int anosPassados =(int) daysBtween / DIAS_NO_ANO;
            for(int i = 0; i < anosPassados; i++){
                double novoPreco = reajustarPreco(getPrecoAtualProduto());
                setPrecoAtualProduto(novoPreco);
            }
        }
    }

    @Override
    public double reajustarPreco(double valorAtualProduto){
        return valorAtualProduto + valorAtualProduto * IReajustavel.AJUSTE_INFLACAO;
    }

    public String precoString(){
        return String.valueOf(getPrecoDeVenda());
    }

    public abstract String getDescricao(); 

    public abstract double getPrecoAtualProduto();

    public  abstract void setPrecoAtualProduto(double novoPreco);

}
