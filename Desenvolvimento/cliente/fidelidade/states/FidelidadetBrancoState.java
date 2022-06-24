package Desenvolvimento.cliente.fidelidade.states;

import Desenvolvimento.cliente.fidelidade.contracts.IFidelidadeState;

public class FidelidadetBrancoState  implements IFidelidadeState {
    public static final double DESCONTO = 0;

    @Override
    public double calcularDesconto(double preco) {
        return preco * DESCONTO;
    }
    
}
