package Desenvolvimento;

public class FidelidadeFeV implements IValoravel{

    public static final double DESCONTO_FIDELIDADE = 0.20;

    @Override
    public double getDesconto() {
        return DESCONTO_FIDELIDADE;
    }
    
}
