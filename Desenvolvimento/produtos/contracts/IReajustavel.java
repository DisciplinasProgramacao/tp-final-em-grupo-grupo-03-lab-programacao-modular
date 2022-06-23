package Desenvolvimento.produtos.contracts;

public interface IReajustavel {
    public static final double AJUSTE_INFLACAO = 0.10;
    
    public double reajustarPreco(double precoAtual);

}
