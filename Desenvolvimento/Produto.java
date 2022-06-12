package Desenvolvimento;

public  class Produto {
    private double precoBase; //apenas criei dessa forma para realizar os testes na classe APLICACAO por favor seguir o escopo do trabalho!
    private String nome;

    public Produto(double preco, String nome){
        this.precoBase = preco;
        this.nome = nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public String getNome() {
        return nome;
    }
}
