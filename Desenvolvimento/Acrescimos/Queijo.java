package Desenvolvimento.Acrescimos;

import Desenvolvimento.IComestivel;

public class Queijo extends AAcrescimoDecorator{

    public Queijo(IComestivel comestivel) {
        super(comestivel);
    }

    @Override
    public double precoTotal() {
       return super.precoTotal() + 2.00;
    }

	@Override
	public String getDescricao() {
        return super.getDescricao() + ", Queijo (2,00)";
	}

}