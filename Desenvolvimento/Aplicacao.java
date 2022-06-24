package Desenvolvimento;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Desenvolvimento.cliente.*;
import Desenvolvimento.cliente.contracts.*;
import Desenvolvimento.pedido.*;
import Desenvolvimento.produtos.*;
import Desenvolvimento.produtos.Bebidas.*;
import Desenvolvimento.produtos.ProdutosComAcrescimo.Pizza;
import Desenvolvimento.produtos.ProdutosComAcrescimo.ProdutoComAdcionais;
import Desenvolvimento.produtos.ProdutosComAcrescimo.Sanduiche;
import Desenvolvimento.produtos.acrescimos.*;

public class Aplicacao {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<IClient> clientes = new LinkedHashSet<IClient>();

        IClient clienteAtual = null;

        List<Produto> produtosNoPedido = new ArrayList<Produto>();

        int value = 0;

        while (value == 0) {
            System.out.println("---------------------------------");
            System.out.println("0) Sair");
            System.out.println("1) Cadastrar cliente.");
            System.out.println("2) Escolher cliente.");
            System.out.println("---------------------------------");
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    value = -1;
                    break;
                case 1:
                    System.out.println("Digite seu CPF: ");
                    String CPF = scanner.next();
                    System.out.println("Digite seu nome: ");
                    String nome = scanner.next();
                    clientes.add(ClienteFactory.createClient(CPF, nome));
                    break;
                case 2:
                    System.out.println("---------------------------------");
                    System.out.println("Qual o CPF do cliente: ");
                    String identificador = scanner.next();
                    final IClient cliente = clientes.stream()
                            .filter((cli) -> cli.getIdentificador().equals(identificador)).findFirst().get();
                    if (cliente == null) {
                        throw new RuntimeException(
                                "Nao existe cliente com esse codigo na base, favor tentar novamente.");
                    } else {
                        clienteAtual = cliente;
                    }
                    int value_2 = 0;

                    while (value_2 == 0) {
                        System.out.println("---------------------------------");
                        System.out.println("0) Sair");
                        System.out.println("1) Pedir pedido");
                        System.out.println("2) Ver extato");
                        System.out.println("---------------------------------");
                        int option_2 = scanner.nextInt();

                        switch (option_2) {
                            case 0:
                                value_2 = -1;
                                break;
                            case 1:
                                int value_3 = 0;
                                while (value_3 == 0) {
                                    System.out.println("---------------------------------");
                                    System.out.println("0) Sair");
                                    System.out.println("1) Adicionar produto");
                                    System.out.println("2) Finalizar");
                                    System.out.println("---------------------------------");
                                    int option_3 = scanner.nextInt();

                                    switch (option_3) {
                                        case 0:
                                            value_3 = -1;
                                            break;
                                        case 1:
                                            int value_4 = 0;
                                            while (value_4 == 0) {
                                                System.out.println("---------------------------------");
                                                System.out.println("0) Sair");
                                                System.out.println("1) Agua");
                                                System.out.println("2) Cerveja");
                                                System.out.println("3) Refrigerante");
                                                System.out.println("4) Suco");
                                                System.out.println("5) Pizza");
                                                System.out.println("6) Sanduiche");
                                                System.out.println("7) Prato Feito");
                                                System.out.println("---------------------------------");
                                                int option_4 = scanner.nextInt();

                                                switch (option_4) {
                                                    case 0:
                                                        value_4 = -1;
                                                    case 1:
                                                        produtosNoPedido.add(new Agua());
                                                        break;
                                                    case 2:
                                                        produtosNoPedido.add(new Cerveja());
                                                        break;
                                                    case 3:
                                                        produtosNoPedido.add(new Refrigerante());
                                                        break;
                                                    case 4:
                                                        produtosNoPedido.add(new Suco());
                                                        break;
                                                    case 5:
                                                        ProdutoComAdcionais pizza;
                                                        System.out
                                                                .println("Gostaria de borda recheada?(Sim(1) Nao(0))");
                                                        int bordaRecheada = scanner.nextInt();
                                                        if (bordaRecheada == 1) {
                                                            pizza = new Pizza(true);
                                                        } else {
                                                            pizza = new Pizza(false);
                                                        }
                                                        int value_5 = 0;
                                                        while (value_5 == 0) {
                                                            System.out.println("Gostaria de algum adicional: ");
                                                            System.out.println("---------------------------------");
                                                            System.out.println("0) Nao");
                                                            System.out.println("1) Bacon");
                                                            System.out.println("2) Batata Palha");
                                                            System.out.println("3) Ovo");
                                                            System.out.println("4) Peperoni");
                                                            System.out.println("5) Picles");
                                                            System.out.println("6) Queijo");
                                                            System.out.println("7) Palmito");
                                                            System.out.println("---------------------------------");

                                                            int option_5 = scanner.nextInt();
                                                            switch (option_5) {
                                                                case 0:
                                                                    value_5 = -1;
                                                                    break;
                                                                case 1:
                                                                    pizza.adicionarAcrescimo(Acrescimo.BACON);
                                                                    break;
                                                                case 2:
                                                                    pizza.adicionarAcrescimo(Acrescimo.BATATA_PALHA);
                                                                    break;
                                                                case 3:
                                                                    pizza.adicionarAcrescimo(Acrescimo.OVO);
                                                                    break;
                                                                case 4:
                                                                    pizza.adicionarAcrescimo(Acrescimo.PEPERONI);
                                                                    break;
                                                                case 5:
                                                                    pizza.adicionarAcrescimo(Acrescimo.PICLES);
                                                                    break;
                                                                case 6:
                                                                    pizza.adicionarAcrescimo(Acrescimo.QUEIJO);
                                                                    break;
                                                                case 7:
                                                                    pizza.adicionarAcrescimo(Acrescimo.PALMITO);
                                                                    break;
                                                            }
                                                        }
                                                        produtosNoPedido.add(pizza);
                                                        break;
                                                    case 6:
                                                        ProdutoComAdcionais sanduiche;
                                                        System.out.println("Gostaria de pao artesanal?(Sim(1) Nao(0))");
                                                        int paoArtesanal = scanner.nextInt();
                                                        if (paoArtesanal == 1) {
                                                            sanduiche = new Sanduiche(true);
                                                        } else {
                                                            sanduiche = new Sanduiche(false);
                                                        }
                                                        int value_6 = 0;
                                                        while (value_6 == 0) {
                                                            System.out.println("Gostaria de algum adicional: ");
                                                            System.out.println("---------------------------------");
                                                            System.out.println("0) Nao");
                                                            System.out.println("1) Bacon");
                                                            System.out.println("2) Batata Palha");
                                                            System.out.println("3) Ovo");
                                                            System.out.println("4) Peperoni");
                                                            System.out.println("5) Picles");
                                                            System.out.println("6) Queijo");
                                                            System.out.println("7) Palmito");
                                                            System.out.println("---------------------------------");

                                                            int option_6 = scanner.nextInt();
                                                            switch (option_6) {
                                                                case 0:
                                                                    value_6 = -1;
                                                                    break;
                                                                case 1:
                                                                    sanduiche.adicionarAcrescimo(Acrescimo.BACON);
                                                                    break;
                                                                case 2:
                                                                    sanduiche
                                                                            .adicionarAcrescimo(Acrescimo.BATATA_PALHA);
                                                                    break;
                                                                case 3:
                                                                    sanduiche.adicionarAcrescimo(Acrescimo.OVO);
                                                                    break;
                                                                case 4:
                                                                    sanduiche.adicionarAcrescimo(Acrescimo.PEPERONI);
                                                                    break;
                                                                case 5:
                                                                    sanduiche.adicionarAcrescimo(Acrescimo.PICLES);
                                                                    break;
                                                                case 6:
                                                                    sanduiche.adicionarAcrescimo(Acrescimo.QUEIJO);
                                                                    break;
                                                                case 7:
                                                                    sanduiche.adicionarAcrescimo(Acrescimo.PALMITO);
                                                                    break;
                                                            }
                                                        }
                                                        produtosNoPedido.add(sanduiche);
                                                        break;
                                                    case 7:
                                                        produtosNoPedido.add(new PratoFeito());
                                                        break;
                                                }
                                            }
                                            break;
                                        case 2:
                                            clienteAtual.pedirPedido(produtosNoPedido);
                                            value_3 = -1;
                                            break;
                                    }
                                }
                                break;

                            case 2:
                                int value_7 = 0;
                                while (value_7 == 0) {
                                    System.out.println("Qual extrato voce deseja visualizar: ");
                                    System.out.println("---------------------------------");
                                    System.out.println("0) Sair");
                                    System.out.println("1) Extrato historico pedidos");
                                    System.out.println("2) Extrato detalhado");
                                    System.out.println("---------------------------------");
                                    int option_7 = scanner.nextInt();
                                    switch (option_7) {
                                        case 0:
                                            value_7 = -1;
                                            break;
                                        case 1:
                                            System.out.println(clienteAtual.extratoHistoricoDePedidos());
                                            break;
                                        case 2:
                                            System.out.println("Qual o id do pedido: ");
                                            String idPedido = scanner.next();
                                            System.out.println(clienteAtual.extratoPedido(idPedido));
                                            break;
                                    }
                                }
                        }
                    }
                    break;
            }
        }
    }

}
