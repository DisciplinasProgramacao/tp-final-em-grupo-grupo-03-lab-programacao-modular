package Desenvolvimento.pedido;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import Desenvolvimento.cliente.*;
import Desenvolvimento.produtos.*;

public class Pedido implements Serializable {

    public static int MAX_PRODUTOS = 10;
    public static int MIN_PRODUTOS = 1;

    public static int identificadorPedidos = 0;

    private String ID;
    private double avaliacaoNota;
    private Cliente cliente;
    private List<Produto> produtos;
    private double valorTotal;
    private double desconto;
    private LocalDate dataPedido;
    private double valorBruto;

    public Pedido(List<Produto> produtos, Cliente cliente, double desconto) {
        setProdutos(produtos);
        setCliente(cliente);
        setDesconto(desconto);
        setValorTotal(calculaDesconto(desconto));
        setDataPedido(LocalDate.now());
        identificadorPedidos++;
        ID = String.valueOf(identificadorPedidos);

    }

    public String getID() {
        return ID;
    }

    public double getAvaliacaoNota() {
        return avaliacaoNota;
    }

    public void setAvaliacaoNota(double avaliacaoNota) {
        this.avaliacaoNota = avaliacaoNota;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        if (produtos.size() >= MIN_PRODUTOS && produtos.size() <= MAX_PRODUTOS) {
            this.produtos = produtos;
        } else {
            // gerar excecao
        }
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public String getExtrato() {
        String notaPedido = "";

        notaPedido += String.format("\n%15s: %50s", "Cliente", cliente.getNome());
        notaPedido += String.format("\n%s:\n", "Produtos");

        for (Produto p : produtos) {
            notaPedido += String.format("\n%15s;", p.getDescricao());
        }

        notaPedido += String.format("\n%15s: %12s", "Data", getDataPedido().toString());
        notaPedido += String.format("\n%15s: %5.2f", "Desconto", getDesconto());
        notaPedido += String.format(" || %15s: %5.2f", "Valor Bruto", getValorBruto());
        notaPedido += String.format("\n%15s: %5.2f", "Valor Total", getValorTotal());

        return notaPedido;
    }

    public double calculaDesconto(double desconto) {

        double valorDosItens = 0;

        for (Produto p : produtos) {
            valorDosItens += p.getPrecoDeVenda();
        }

        double descontoTotal = valorDosItens * desconto;

        this.desconto = descontoTotal;

        this.valorBruto = valorDosItens;

        return valorDosItens - descontoTotal;
    }

    public String getExtratoResumido() {

        String relatorioTotalGeralPedido = "";

        relatorioTotalGeralPedido += "\nID: " + getID();
        relatorioTotalGeralPedido += " || Valor: " + getValorTotal();
        relatorioTotalGeralPedido += " || Data: " + getDataPedido();

        return relatorioTotalGeralPedido;
    }

    public void receberAvaliacao(double avaliacao) {
        this.avaliacaoNota = avaliacao;
    }

}