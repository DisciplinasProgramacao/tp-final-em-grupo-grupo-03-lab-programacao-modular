package Desenvolvimento.Acrescimos;

import Desenvolvimento.IComestivel;

public class Peperoni extends AAcrescimoDecorator{

    public Peperoni(IComestivel comestivel) {
        super(comestivel);
    }

    @Override
    public double precoTotal() {
       return super.precoTotal() + 4.00;
    }

    @Override
	public String getDescricao() {
        return super.getDescricao() + ", Peperoni (4,00)";
	}

}
