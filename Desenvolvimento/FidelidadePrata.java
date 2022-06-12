package Desenvolvimento;

public class FidelidadePrata implements IValoravel{

    public static final double DESCONTO_FIDELIDADE = 0.05;

    @Override
    public double getDesconto() {
        return DESCONTO_FIDELIDADE;
    }

}