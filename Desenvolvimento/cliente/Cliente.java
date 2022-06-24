package Desenvolvimento.cliente;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Desenvolvimento.cliente.contracts.IClient;
import Desenvolvimento.cliente.fidelidade.FidelidadeContext;
import Desenvolvimento.pedido.Pedido;
import Desenvolvimento.produtos.Produto;

public class Cliente implements IClient {

    private String CPF;
    private String nome;
    private FidelidadeContext fidelidade;
    private List<Pedido> pedidos;

    public Cliente(FidelidadeContext fidelidade, String CPF, String nome) {
        this.CPF = CPF;
        this.nome = nome;
        this.fidelidade = fidelidade;
        pedidos = new ArrayList<Pedido>();
    }

    @Override
    public List<String> extratoHistoricoDePedidos() {
        return pedidos.stream().map((pedido) -> pedido.getExtratoResumido()).collect(Collectors.toList());
    }

    @Override
    public String extratoPedido(String pedidoId) {
        final Pedido pedidoEncontrado = getPedidoPorId(pedidoId);
        if (pedidoEncontrado != null) {
            return pedidoEncontrado.getExtrato();
        }
        return null;
    }

    @Override
    public double calcularDesconto(double preco) {
        return fidelidade.calcularDesconto(preco);
    }

    @Override
    public Pedido pedirPedido(List<Produto> produtosDesejados) {
        double precoPedido = 0;
        for (Produto produto : produtosDesejados) {
            precoPedido += produto.getPrecoDeVenda();
        }
        final Pedido pedido = new Pedido(produtosDesejados, this, fidelidade.calcularDesconto(precoPedido));
        this.pedidos.add(pedido);
        return pedido;
    }

    @Override
    public void avaliarPedido(String pedidoId, int nota) {
        final Pedido pedidoEncontrado = getPedidoPorId(pedidoId);
        if (pedidoEncontrado != null) {
            pedidoEncontrado.setAvaliacaoNota(nota);
        } else {
            throw new IllegalArgumentException("Pedido não encontrado");
        }

    }

    private Pedido getPedidoPorId(String pedidoId) {
        return pedidos.stream().filter((pedido) -> pedido.getID().equals(pedidoId)).findFirst()
                .get();
    }

    public String getNome() {
        return nome;
    }

    @Override
    public double avaliacaoMediaDosPedidos() {
        return pedidos.stream().mapToDouble((pedido) -> pedido.getAvaliacaoNota()).average().getAsDouble();
    }

    @Override
    public String getIdentificador() {
        return CPF;
    }

    @Override
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " | CPF: " + getIdentificador();
    }

}
