package Desenvolvimento.Acrescimos;

import Desenvolvimento.IComestivel;

public class Ovo extends AAcrescimoDecorator{

    public Ovo(IComestivel comestivel) {
        super(comestivel);
    }

    @Override
    public double precoTotal() {
       return super.precoTotal() + 2.00;
    }

	@Override
	public String getDescricao() {
        return super.getDescricao() + ", Ovo (2,00)";
	}

}