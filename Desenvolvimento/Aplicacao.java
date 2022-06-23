package Desenvolvimento;

import Desenvolvimento.produtos.Pizza;
import Desenvolvimento.produtos.Sanduiche;
import Desenvolvimento.produtos.Bebidas.Agua;
import Desenvolvimento.produtos.acrescimos.*;


public class Aplicacao {
    public static void main(String[]args){

        Pizza  pizza1 =  new Pizza(true);

        Sanduiche Hamburguer1 =  new Sanduiche(false);

        Acrescimo Bacon  = new Acrescimo(TipoAcrescimo.BACON);

        pizza1.adicionarAcrescimo(Bacon);

        System.out.println(pizza1.getDescricao());

        System.out.println(Hamburguer1.getDescricao());

        Agua agua1 =  new Agua();

        System.out.println(agua1.getDescricao());

       
    }
}
