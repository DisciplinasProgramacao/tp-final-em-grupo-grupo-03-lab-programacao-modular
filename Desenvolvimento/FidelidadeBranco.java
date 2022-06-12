package Desenvolvimento;

public class FidelidadeBranco implements IValoravel {

    public static final double DESCONTO_FIDELIDADE = 0.00;

    @Override
    public double getDesconto() {
        return DESCONTO_FIDELIDADE;
    }
    
}
