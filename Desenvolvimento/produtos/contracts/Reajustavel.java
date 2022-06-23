package Desenvolvimento.produtos.contracts;

public  interface Reajustavel {
    public static double REAJUSTE_BASE = 0.1;

    public static double reajustarPreco(double precoAtual);
}
