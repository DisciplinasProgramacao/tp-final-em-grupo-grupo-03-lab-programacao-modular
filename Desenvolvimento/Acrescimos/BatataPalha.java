package Desenvolvimento.Acrescimos;

import Desenvolvimento.IComestivel;

public class BatataPalha extends AAcrescimoDecorator{

    public BatataPalha(IComestivel comestivel) {
        super(comestivel);
    }

    @Override
    public double precoTotal() {
       return super.precoTotal() + 2.00;
    }

	@Override
	public String getDescricao() {
        return super.getDescricao() + ", Batata Palha (2,00)";
	}

}