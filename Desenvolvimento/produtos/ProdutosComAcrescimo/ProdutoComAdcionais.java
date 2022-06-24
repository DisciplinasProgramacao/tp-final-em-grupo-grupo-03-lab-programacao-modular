package Desenvolvimento.produtos.ProdutosComAcrescimo;

import java.util.ArrayList;
import java.util.List;

import Desenvolvimento.produtos.*;
import Desenvolvimento.produtos.acrescimos.*;

public abstract class ProdutoComAdcionais extends Produto {
    private List<Acrescimo> acrescimos = new ArrayList<Acrescimo>();


    public void adicionarAcrescimo(Acrescimo acrescimo) {
        this.acrescimos.add(acrescimo);
        alterarPrecoNovoAdcional(acrescimo);

    }

    public void removeAcrescimo(Acrescimo acrescimo){
        acrescimos.remove(acrescimo);
        alterarPrecoRemoverAdcional(acrescimo);
    }

    public List<Acrescimo> getAcrescimos() {
        return acrescimos;
    }

    public void alterarPrecoNovoAdcional(Acrescimo acrescimo){
        setPrecoDeVenda(getPrecoDeVenda() + acrescimo.getPreco());  
    }

    public void alterarPrecoRemoverAdcional(Acrescimo acrescimo){
        setPrecoDeVenda(getPrecoDeVenda() - acrescimo.getPreco());
    }
}