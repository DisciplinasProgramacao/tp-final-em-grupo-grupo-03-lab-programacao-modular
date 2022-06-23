package Desenvolvimento;

import java.util.LinkedHashSet;
import java.util.Set;

public class ReajusteObserver {
    private static final ReajusteObserver instance = new ReajusteObserver();
    private Set<IReajustavel> reajustaveis = new LinkedHashSet<IReajustavel>();

    private ReajusteObserver(){
    }

    public static ReajusteObserver getInstance(){
        return instance;
    }

    public void observeReajustavel(IReajustavel reajustavel){
        this.reajustaveis.add(reajustavel);
    }

    public void notifyReajustaveis(double reajuste){
        reajustaveis.stream().forEach((reajustavel) -> reajustavel.reajustarPreco(reajuste));
    }
}
