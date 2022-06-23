package Desenvolvimento.Acrescimos;

import Desenvolvimento.IComestivel;
import Desenvolvimento.Pizza;

public class Bacon extends AAcrescimoDecorator{

    public Bacon(IComestivel comestivel) {
        super(comestivel);
    }

    @Override
    public double precoTotal() {
        if( super.getComestivelPai() instanceof Pizza){
            return super.precoTotal() + 6.00;
        }else{
            return super.precoTotal() + 3.00;
        }
       
    }

	@Override
	public String getDescricao() {

        if( super.getComestivelPai() instanceof Pizza){
            return super.getDescricao() + ", Bacon (6,00)";
        }else{
            return super.getDescricao() + ", Bacon (3,00)";
        }
	}


}