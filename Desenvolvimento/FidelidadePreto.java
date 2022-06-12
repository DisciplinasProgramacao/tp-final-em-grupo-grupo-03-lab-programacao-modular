package Desenvolvimento;

public class FidelidadePreto implements IValoravel {

    public static final double DESCONTO_FIDELIDADE = 0.10;

    @Override
    public double getDesconto() {
        return DESCONTO_FIDELIDADE;
    }
    
}
