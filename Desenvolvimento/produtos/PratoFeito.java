package Desenvolvimento.produtos;

public class PratoFeito extends Produto{
    public static double PRECO_ATUAL_ALTERADO = 15;

    public PratoFeito(){
        calculaAnosUltimaAlteracao();
        setPrecoDeVenda(PRECO_ATUAL_ALTERADO);
    }

    @Override
    public String getDescricao() {
        return "Prato Feito "+ String.valueOf(getPrecoDeVenda());
    }

    @Override
    public double getPrecoAtualProduto() {
        return PRECO_ATUAL_ALTERADO;
    }

    @Override
    public void setPrecoAtualProduto(double novoPreco) {
        PratoFeito.PRECO_ATUAL_ALTERADO = novoPreco;
        
    }
}
