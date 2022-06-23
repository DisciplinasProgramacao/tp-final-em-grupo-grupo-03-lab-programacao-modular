package Desenvolvimento.cliente;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import Desenvolvimento.cliente.contracts.IClient;
import Desenvolvimento.cliente.fidelidade.FidelidadeContext;
import Desenvolvimento.pedido.Pedido;
import Desenvolvimento.pedido.extratos.ExtratoPedidoResumido;

public class Cliente implements IClient {

    private String CPF;
    private String nome;
    private FidelidadeContext fidelidade;
    private List<Pedido> pedidos;

    public Cliente(FidelidadeContext fidelidade, String CPF, String nome) {
        this.CPF = CPF;
        this.nome = nome;
        this.fidelidade = fidelidade;
    }

    @Override
    public List<ExtratoPedidoResumido> extratoHistoricoDePedidos() {
        return pedidos.stream().map((pedido) -> ExtratoPedidoResumido.fromPedido(pedido)).collect(Collectors.toList());
    }

    @Override
    public List<ExtratoPedidoResumido> extratoPedidosDeXMesese(int quantidadeDeMeses) {
        final LocalDate now = LocalDate.now();
        return pedidos.stream().filter((pedido) -> {
            final Period period = Period.between(pedido.getData(), now);
            return period.getMonths() <= quantidadeDeMeses;
        }).map((pedido) -> ExtratoPedidoResumido.fromPedido(pedido)).collect(Collectors.toList());
    }

    @Override
    public ExtratoPedidoResumido extratoPedido(String pedidoId) {
        final Pedido pedidoEncontrado = getPedidoPorId(pedidoId);
        if (pedidoEncontrado != null) {
            return ExtratoPedidoResumido.fromPedido(pedidoEncontrado);
        }
        return null;
    }

    @Override
    public double calcularDesconto(double preco) {
        return fidelidade.calcularDesconto(preco);
    }

    @Override
    public Pedido pedirPedido() {
        final Pedido pedido = new Pedido();
        this.pedidos.add(pedido);
        return pedido;
    }

    @Override
    public void avaliarPedido(String pedidoId, int nota) {
        final Pedido pedidoEncontrado = getPedidoPorId(pedidoId);
        if (pedidoEncontrado != null) {
            pedidoEncontrado.setAvaliacao(nota);
        } else {
            throw new IllegalArgumentException("Pedido não encontrado");
        }

    }

    private Pedido getPedidoPorId(String pedidoId) {
        return pedidos.stream().filter((pedido) -> pedido.getId().equals(pedidoId)).findFirst()
                .get();
    }

    @Override
    public double avaliacaoMediaDosPedidos() {
        return pedidos.stream().mapToInt((pedido) -> pedido.getAvaliacao()).average().getAsDouble();
    }

    @Override
    public String getIdentificador() {
        return CPF;
    }

}
