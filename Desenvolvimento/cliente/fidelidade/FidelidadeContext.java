package Desenvolvimento.cliente.fidelidade;

import Desenvolvimento.cliente.fidelidade.contracts.IFidelidadeContext;
import Desenvolvimento.cliente.fidelidade.contracts.IFidelidadeState;
import Desenvolvimento.cliente.fidelidade.states.FidelidadetBrancoState;

public class FidelidadeContext implements IFidelidadeContext {
    private IFidelidadeState fidelidadeState;

    public FidelidadeContext(IFidelidadeState fidelidadeState) {
        this.fidelidadeState = fidelidadeState;
    }

    public FidelidadeContext() {
        this.fidelidadeState = new FidelidadetBrancoState();
    }

    @Override
    public void setFidelidadeState(IFidelidadeState state) {
        this.fidelidadeState = state;
    }

    @Override
    public double calcularDesconto(double preco) {
        return this.fidelidadeState.calcularDesconto(preco);
    }

}
