package Desenvolvimento;

public class ExcecaoQuantidadeDeProdutosIrregular extends Exception {
    
    public ExcecaoQuantidadeDeProdutosIrregular(int quantidade){
        super("A quantidade "+ quantidade + "não pode ser aceitar como quantidade valida");
    }
}
