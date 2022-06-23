package Desenvolvimento;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    public static int MAX_PRODUTOS = 10;
    public static int MIN_PRODUTOS = 1;

    public static int identificadorPedidos = 0;

    private int ID;
    private double avaliacaoNota; //considerar nota de 1 a 5 podendo ser com casas decimais ex: 2,5 / 3,2 / 3,0 e etc
    private Cliente cliente;
    private List<Produto> produtos;
    private double valorTotal;
    private double desconto;
    private LocalDate dataPedido;
    private double valorBruto;

    public Pedido(List<Produto> produtos, Cliente cliente, double desconto ) throws ExcecaoQuantidadeDeProdutosIrregular{
        setProdutos(produtos);
        setCliente(cliente);
        setDesconto(desconto);
        setValorTotal(calculaDesconto(desconto));
        setDataPedido(LocalDate.now());
        setID(++identificadorPedidos);
        
    }

    public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getAvaliacaoNota() {
		return avaliacaoNota;
	}

	public void setAvaliacaoNota(double avaliacaoNota) {
		this.avaliacaoNota = avaliacaoNota;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

    public void setProdutos(List<Produto> produtos) throws ExcecaoQuantidadeDeProdutosIrregular {
        if(produtos.size() >= MIN_PRODUTOS && produtos.size() <= MAX_PRODUTOS){
            this.produtos = produtos;
        }else{
            throw new ExcecaoQuantidadeDeProdutosIrregular(produtos.size());
        }
    }

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public String gerarNotaPedido(){
       String notaPedido = "";
       
       notaPedido += String.format("\n%15s: %50s", "Cliente", cliente.getNome());
       notaPedido += String.format("\n%s:\n", "Produtos");
       
       for(Produto p : produtos) {
    	   notaPedido += String.format("\n%15s%5.2f;", p.getNome(), p.getPrecoBase());
       }
       
       notaPedido += String.format("\n%15s: %12s", "Data", getDataPedido().toString());
       notaPedido += String.format("\n%15s: %5.2f", "Desconto", getDesconto());
       notaPedido += String.format(" || %15s: %5.2f", "Valor Bruto", getValorBruto());
       notaPedido += String.format("\n%15s: %5.2f", "Valor Total", getValorTotal());
       
       return notaPedido;
	}

    public double calculaDesconto(double desconto) {

        double valorDosItens = 0;

        for (Produto p : produtos) {
            valorDosItens += p.getPrecoBase();
        }

        double descontoTotal =  valorDosItens * desconto;

        this.desconto = descontoTotal;

        this.valorBruto = valorDosItens;

        return valorDosItens - descontoTotal;
    }

    public String gerarRelatorioGeralPedido(){

        String relatorioTotalGeralPedido = "";

        relatorioTotalGeralPedido += "\nID: "+ getID();
        relatorioTotalGeralPedido += " || Valor: "+ getValorTotal();
        relatorioTotalGeralPedido += " || Data: "+ getDataPedido();

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
   
}
