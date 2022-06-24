package Desenvolvimento.cliente.fidelidade.contracts;

import java.io.Serializable;

public interface IFidelidadeCalculavel extends Serializable {
    public double calcularDesconto(double preco);
}