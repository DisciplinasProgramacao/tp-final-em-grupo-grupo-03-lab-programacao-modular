package Desenvolvimento;

import java.util.ArrayList;
import java.util.List;

import Desenvolvimento.Acrescimos.*;

public class Aplicacao {
    public static void main(String[]args){


        // Cliente Cliente1 = new Cliente("Thiago", "39702476836");

        // Produto produto1 = new Produto(32,"sanduiche");
        // Produto produto2 = new Produto(24, "fanta");
        // Produto produto3 = new Produto(10, "coca");
        // Produto produto4 = new Produto(20, "pizza");
        // Produto produto5 = new Produto(40, "pizzaGrande");

        // List<Produto> produtosPedido1 =  new ArrayList<Produto>();

        // produtosPedido1.add(produto1);

        // List<Produto> produtosPedido2 =  new ArrayList<Produto>();

        // produtosPedido2.add(produto2);

        // List<Produto> produtosPedido3 =  new ArrayList<Produto>();

        // produtosPedido3.add(produto3);

        // List<Produto> produtosPedido4 =  new ArrayList<Produto>();

        // produtosPedido4.add(produto4);

        // List<Produto> produtosPedido5 =  new ArrayList<Produto>();
        
        // produtosPedido5.add(produto5);



        // Cliente1.realizarPedido(produtosPedido1);
        // Cliente1.realizarPedido(produtosPedido2);
        // Cliente1.realizarPedido(produtosPedido3);
        // Cliente1.realizarPedido(produtosPedido4);        
        // Cliente1.realizarPedido(produtosPedido5);

        // System.out.println("\n");

        // System.out.println(Cliente1.gerarRelatorioPedidos()); 

        // List<Pedido> pedidos = Cliente1.getHistoricoPedidos();

        // for (Pedido p : pedidos) {

        //     System.out.println("\n");

        //     System.out.println(Cliente1.gerarRelatorioEspecifico(p));   
        // }

        // System.out.println("\n");
        
        IComestivel pizza =  new Pizza(false);

        System.out.println(pizza.precoTotal());
        System.out.println(pizza.getDescricao());

        pizza = new Bacon(pizza);
        pizza =  new Peperoni(pizza);

        System.out.println(pizza.precoTotal());
        System.out.println(pizza.getDescricao());

        System.out.println("===================================================");

        IComestivel sanduiche = new Sanduiche(false);

        System.out.println(sanduiche.precoTotal());
        System.out.println(sanduiche.getDescricao());

        sanduiche = new Bacon(sanduiche);

        System.out.println(sanduiche.precoTotal());
        System.out.println(sanduiche.getDescricao());

        System.out.println("===================================================");

        Bebida bebida = Bebida.CERVEJA;

        System.out.println(bebida.precoTotal());
        System.out.println(bebida.getTipo());

        System.out.println("===================================================");

    }
}
