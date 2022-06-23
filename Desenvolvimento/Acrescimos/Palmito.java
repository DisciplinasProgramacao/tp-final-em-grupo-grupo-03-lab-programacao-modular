package Desenvolvimento.Acrescimos;

import Desenvolvimento.IComestivel;

public class Palmito extends AAcrescimoDecorator{

    public Palmito(IComestivel comestivel) {
        super(comestivel);
    }

    @Override
    public double precoTotal() {
       return super.precoTotal() + 3.00;
    }

	@Override
	public String getDescricao() {
        return super.getDescricao() + ", Palmito (3,00)";
	}

}