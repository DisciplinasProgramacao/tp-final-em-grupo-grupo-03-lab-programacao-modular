package Desenvolvimento.Acrescimos;

import Desenvolvimento.IComestivel;

public abstract class AAcrescimoDecorator implements IComestivel {
    
    private IComestivel comestivel;

    public AAcrescimoDecorator(IComestivel comestivel){
        if (comestivel == null) 
			throw new RuntimeException("Acrescimo deve estar associado a uma comida.");
        this.comestivel = comestivel;
    }

    @Override
    public double precoTotal() {
       return comestivel.precoTotal();
    }

    @Override
    public String getDescricao(){
        return comestivel.getDescricao();
    }

}
