package Desenvolvimento.cliente.contracts;

import java.io.Serializable;
import java.util.List;

import Desenvolvimento.pedido.Pedido;
import Desenvolvimento.produtos.Produto;

public interface IClient extends Serializable {
    public String getIdentificador();

    public double calcularDesconto(double preco);

    public String extratoPedido(String pedidoId);

    public List<String> extratoHistoricoDePedidos();

    public Pedido pedirPedido(List<Produto> produtos);

    public void avaliarPedido(String pedidoId, int nota);

    public double avaliacaoMediaDosPedidos();

    public List<Pedido> getPedidos();
}