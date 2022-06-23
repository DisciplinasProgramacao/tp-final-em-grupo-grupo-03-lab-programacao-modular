package Desenvolvimento;

public enum Bebida implements IPrecificavel, IReajustavel{
    AGUA(2),
    SUCO(5),
    REFRIGERANTE(5),
    CERVEJA(8);

    private int preco;

    private Bebida(int preco){
        this.preco = preco;
    }

    @Override
    public double precoTotal(){
        return this.preco;
    }

    public String getTipo(){
        return this.name().toLowerCase();
    }
}
