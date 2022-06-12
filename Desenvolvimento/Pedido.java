package Desenvolvimento;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    public static int MAX_PRODUTOS = 10;
    public static int MIN_PRODUTOS = 1;

    public static int identificadorPedidos = 0;

    private int ID;
    private double avaliacaoNota; //considerar nota de 1 à 5 podendo ser com casas decimais ex: 2,5 / 3,2 / 3,0 e etc
    private Cliente cliente;
    private List<Produto> produtos;
    private double valorTotal;
    private double desconto;
    private LocalDate dataPedido;
    private double valorBruto;

    public Pedido(List<Produto> produtos, Cliente cliente,double desconto ) throws ExcecaoQuantidadeDeProdutosIrregular{
        setProdutos(produtos);
        setValorTotal(desconto);
        setDataPedido(LocalDate.now());
        identificadorPedidos++;
        setID(identificadorPedidos);
        
    }

    public void setProdutos(List<Produto> produtos) throws ExcecaoQuantidadeDeProdutosIrregular {
        if(produtos.size() >= MIN_PRODUTOS && produtos.size() <= MAX_PRODUTOS){
            this.produtos = produtos;
        }else{
            throw new ExcecaoQuantidadeDeProdutosIrregular(produtos.size());
        }
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // public String gerarNotaPedido(){ como se fosse um recibo diferente do que esta no gerarRelatorioDetalhadoPedido()
        
    //  Necessario Finalizar desenvolvimento!
          
       
    // }

    public void setValorTotal(double desconto) {

        double valorDosItens = 0;

        for (Produto produto : produtos) {
            valorDosItens += produto.getPrecoBase();
        }

        double descontoTotal =  valorDosItens * desconto;

        this.desconto = descontoTotal;

        this.valorBruto = valorDosItens;

        this.valorTotal = valorDosItens - descontoTotal;
    }

    public String gerarRelatorioGeralPedido(){

        String relatorioTotalGeralPedido = "";

        relatorioTotalGeralPedido += "\nID: "+ getID();
        relatorioTotalGeralPedido += "|| Valor: "+ getValorTotal();
        relatorioTotalGeralPedido += "|| Data: "+ getDataPedido();

        return relatorioTotalGeralPedido;
    }

    public void receberAvaliacao(double avaliacao){
        this.avaliacaoNota = avaliacao;
    }

    public String gerarRelatorioDetalhadoPedido(){
        
        String relatorioDetalhadoPedido = "";

        relatorioDetalhadoPedido += "\nID: "+ getID();
        
        for (Produto produto : produtos) {
            
            relatorioDetalhadoPedido += "\n"+ produto.getNome()+ " Valor: "+ String.valueOf(produto.getPrecoBase());

        }

        relatorioDetalhadoPedido += "\nValor Bruto: "+ getValorBruto()+ "|| Desencontos: "+ getDesconto()+ "|| Valor Total: "+ getValorTotal();

        return relatorioDetalhadoPedido;

    }

    public double getValorTotal() {
        return valorTotal;
    }
    

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
   }

   public void setID(int ID) {
       this.ID = ID;
   }

   public int getID() {
       return ID;
   }

   public double getValorBruto() {
       return valorBruto;
   }

   public double getDesconto() {
       return desconto;
   }

   public Cliente getCliente() {
       return cliente;
   }

   public double getAvaliacaoNota() {
       return avaliacaoNota;
   }
   
}
