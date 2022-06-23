package Desenvolvimento;

public class Sanduiche implements IComestivel{

    private boolean paoArtesanal;   

    public Sanduiche(boolean paoArtesanal){
        this.paoArtesanal = paoArtesanal;
    }

    @Override
    public double precoTotal() {
        double preco = 12.0;
        if(paoArtesanal){
            preco += 2.00;
        }
        return preco;
    }

    @Override
    public String getDescricao() {
        String descricao = "Sanduiche (12.0)";
        if(paoArtesanal){
            descricao = ", Pao Artesanal (2.00)";
        }
        return descricao;
    }
    
}
