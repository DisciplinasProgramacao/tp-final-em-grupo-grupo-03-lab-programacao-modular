package Desenvolvimento.cliente;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;

import Desenvolvimento.ControladorDeArquivos;
import Desenvolvimento.cliente.contracts.IClient;
import Desenvolvimento.cliente.fidelidade.FidelidadeContext;
import Desenvolvimento.cliente.fidelidade.states.FidelidadeFVState;
import Desenvolvimento.cliente.fidelidade.states.FidelidadePrataState;
import Desenvolvimento.cliente.fidelidade.states.FidelidadePretoState;
import Desenvolvimento.pedido.Pedido;
import Desenvolvimento.produtos.Produto;

public class ClienteProxy implements IClient {

    private IClient client;
    private FidelidadeContext fidelidade;

    public ClienteProxy(IClient client, FidelidadeContext fidelidadeContext) {
        this.client = client;
        salvarCliente();
    }

    @Override
    public List<String> extratoHistoricoDePedidos() {
        return this.client.extratoHistoricoDePedidos();
    }

    @Override
    public String extratoPedido(String pedidoId) {
        return this.client.extratoPedido(pedidoId);
    }

    @Override
    public double calcularDesconto(double preco) {
        return this.client.calcularDesconto(preco);
    }

    @Override
    public Pedido pedirPedido(List<Produto> produtos) {
        final Pedido pedido = this.client.pedirPedido(produtos);
        setFidelidadeState();
        salvarCliente();
        return pedido;
    }

    @Override
    public String getIdentificador() {
        return this.client.getIdentificador();
    }

    @Override
    public void avaliarPedido(String pedidoId, int nota) {
        this.client.avaliarPedido(pedidoId, nota);
    }

    @Override
    public double avaliacaoMediaDosPedidos() {
        return this.client.avaliacaoMediaDosPedidos();
    }

    @Override
    public List<Pedido> getPedidos() {
        return this.client.getPedidos();
    }

    private void setFidelidadeState() {
        final LocalDate now = LocalDate.now();
        final int quantidadeDePedidos = this.client.extratoHistoricoDePedidos().size();
        final Function<Integer, Double> totalValorDoValorDosPedidosDeXMeses = (Integer meses) -> this.client
                .getPedidos()
                .stream()
                .filter((pedido) -> {
                    final int monthsPassed = Period.between(pedido.getDataPedido(), now).getMonths();
                    return monthsPassed <= meses;

                })
                .mapToDouble((pedido) -> pedido.getValorTotal())
                .sum();

        if (quantidadeDePedidos == 4 || totalValorDoValorDosPedidosDeXMeses.apply(0) == 100) {
            this.fidelidade.setFidelidadeState(new FidelidadePrataState());
        } else if (quantidadeDePedidos == 10 || totalValorDoValorDosPedidosDeXMeses.apply(1) == 250) {
            this.fidelidade.setFidelidadeState(new FidelidadePretoState());
        } else if (quantidadeDePedidos == 50 || totalValorDoValorDosPedidosDeXMeses.apply(5) == 600) {
            this.fidelidade.setFidelidadeState(new FidelidadeFVState());
        }

    }

    private void salvarCliente() {
        try {
            ControladorDeArquivos.salvarClient("Desenvolvimento/data/clients.bin", this.client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.client.toString();
    }
}
