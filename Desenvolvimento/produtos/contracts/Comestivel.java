package Desenvolvimento.produtos.contracts;

import java.util.ArrayList;
import java.util.List;

import Desenvolvimento.produtos.acrescimos.Acrescimo;

public abstract class Comestivel implements IPrecificavel {
    private List<Acrescimo> acrescimos = new ArrayList<Acrescimo>();

    public void adicionarAcrescimo(Acrescimo acrescimo) {
        this.acrescimos.add(acrescimo);
    }

    public double calcularPrecoTotalDeAcrescimos() {
        return this.acrescimos.stream().mapToDouble((acrescimo) -> acrescimo.getPreco()).sum();
    }

    public List<Acrescimo> getAcrescimos() {
        return acrescimos;
    }
}