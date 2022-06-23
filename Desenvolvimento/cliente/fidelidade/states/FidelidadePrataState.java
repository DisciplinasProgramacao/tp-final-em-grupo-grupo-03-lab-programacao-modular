package Desenvolvimento.cliente.fidelidade.states;

import Desenvolvimento.cliente.fidelidade.contracts.IFidelidadeState;

public class FidelidadePrataState implements IFidelidadeState {
    public static final double DESCONTO = 0.05;

    @Override
    public double calcularDesconto(double preco) {
        return preco - (preco * DESCONTO);
    }

}
