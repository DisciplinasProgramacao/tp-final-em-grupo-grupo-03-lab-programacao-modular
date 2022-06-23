package Desenvolvimento.pedido.extratos;

import java.time.LocalDate;

import Desenvolvimento.pedido.Pedido;

public class ExtratoPedidoResumido {
    private String id;
    private String nome;
    private double valor;
    private LocalDate data;

    public static ExtratoPedidoResumido fromPedido(Pedido pedido){
        return new ExtratoPedidoResumido();
    }
    
    // ATE PEDIDO N ESTAR PRONTO, ESSA PARADA AQ PERMANECE :)
    public ExtratoPedidoResumido(){

    }

    public ExtratoPedidoResumido(String id, String nome, double valor ,LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

}
