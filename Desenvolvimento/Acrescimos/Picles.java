package Desenvolvimento.Acrescimos;

import Desenvolvimento.IComestivel;

public class Picles extends AAcrescimoDecorator{

    public Picles(IComestivel comestivel) {
        super(comestivel);
    }

    @Override
    public double precoTotal() {
       return super.precoTotal() + 2.00;
    }

	@Override
	public String getDescricao() {
        return super.getDescricao() + ", Picles (2,00)";
	}

}