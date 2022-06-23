package Desenvolvimento.cliente;

import java.util.List;
import java.util.function.Function;

import Desenvolvimento.cliente.contracts.IClient;
import Desenvolvimento.cliente.fidelidade.FidelidadeContext;
import Desenvolvimento.cliente.fidelidade.states.FidelidadeFVState;
import Desenvolvimento.cliente.fidelidade.states.FidelidadePrataState;
import Desenvolvimento.cliente.fidelidade.states.FidelidadePretoState;
import Desenvolvimento.pedido.Pedido;
import Desenvolvimento.pedido.extratos.ExtratoPedidoResumido;

public class ClienteProxy implements IClient {

    private IClient client;
    private FidelidadeContext fidelidade;

    public ClienteProxy(IClient client, FidelidadeContext fidelidadeContext) {
        this.client = client;
    }

    @Override
    public List<ExtratoPedidoResumido> extratoHistoricoDePedidos() {
        return this.client.extratoHistoricoDePedidos();
    }

    @Override
    public List<ExtratoPedidoResumido> extratoPedidosDeXMesese(int quantidadeDeMeses) {
        return this.client.extratoPedidosDeXMesese(quantidadeDeMeses);
    }

    @Override
    public ExtratoPedidoResumido extratoPedido(String pedidoId) {
        return this.client.extratoPedido(pedidoId);
    }

    @Override
    public double calcularDesconto(double preco) {
        return this.client.calcularDesconto(preco);
    }

    @Override
    public Pedido pedirPedido() {
        final Pedido pedido = this.client.pedirPedido();
        setFidelidadeState();
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

    private void setFidelidadeState() {
        final int quantidadeDePedidos = this.client.extratoHistoricoDePedidos().size();
        final Function<Integer, Double> totalValorDoValorDosPedidosDeXMeses = (Integer meses) -> this.client
                .extratoPedidosDeXMesese(meses).stream()
                .mapToDouble((pedido) -> pedido.getValor()).sum();

        if (quantidadeDePedidos == 4 || totalValorDoValorDosPedidosDeXMeses.apply(0) == 100) {
            this.fidelidade.setFidelidadeState(new FidelidadePrataState());
        } else if (quantidadeDePedidos == 10 || totalValorDoValorDosPedidosDeXMeses.apply(1) == 250) {
            this.fidelidade.setFidelidadeState(new FidelidadePretoState());
        } else if (quantidadeDePedidos == 50 || totalValorDoValorDosPedidosDeXMeses.apply(5) == 600) {
            this.fidelidade.setFidelidadeState(new FidelidadeFVState());
        }

    }
}
