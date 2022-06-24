package Desenvolvimento.cliente.fidelidade.states;

import Desenvolvimento.cliente.fidelidade.contracts.IFidelidadeState;

public class FidelidadeFVState implements IFidelidadeState {
    public static final double DESCONTO = 0.2;

    @Override
    public double calcularDesconto(double preco) {
        return preco * DESCONTO;
    }
    
}
