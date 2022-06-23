package Desenvolvimento.cliente;

import Desenvolvimento.cliente.contracts.IClient;
import Desenvolvimento.cliente.fidelidade.FidelidadeContext;

public class ClienteFactory {
    public static IClient createClient(String CPF, String nome) {
        final FidelidadeContext fidelidade = new FidelidadeContext();
        final Cliente cliente = new Cliente(fidelidade, CPF, nome);
        final ClienteProxy clienteProxy = new ClienteProxy(cliente, fidelidade);

        return clienteProxy;
    }
}
