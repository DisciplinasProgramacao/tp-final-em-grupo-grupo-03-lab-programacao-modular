package Desenvolvimento.produtos;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import Desenvolvimento.produtos.contracts.IPrecificavel;

public class ReajusteObserver {
    private static final ReajusteObserver instance = new ReajusteObserver();
    private Set<IPrecificavel> reajustaveis = new LinkedHashSet<IPrecificavel>();

    private ReajusteObserver(){
    }

    public static ReajusteObserver getInstance(){
        return instance;
    }

    public void observeReajustavel(IPrecificavel reajustavel){
        this.reajustaveis.add(reajustavel);
    }

    public void notifyReajustaveis(){
        reajustaveis.stream().forEach((reajustavel) -> reajustavel.reajustarPreco());
    }
}
