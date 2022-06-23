package Desenvolvimento.cliente.contracts;

import java.util.List;

import Desenvolvimento.pedido.Pedido;
import Desenvolvimento.pedido.extratos.ExtratoPedidoResumido;

public interface IClient {
    public String getIdentificador();
    public double calcularDesconto(double preco);
    public ExtratoPedidoResumido extratoPedido(String pedidoId);
    public List<ExtratoPedidoResumido> extratoHistoricoDePedidos();
    public List<ExtratoPedidoResumido> extratoPedidosDeXMesese(int quantidadeDeMeses);
    public Pedido pedirPedido();
    public void avaliarPedido(String pedidoId, int nota);
    public double avaliacaoMediaDosPedidos();
}