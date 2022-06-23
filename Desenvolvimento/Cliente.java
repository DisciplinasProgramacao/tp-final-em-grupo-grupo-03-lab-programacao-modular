// package Desenvolvimento;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// public class Cliente{

//     private String nome;
//     private String CPF;
//     private double avaliacaoMediaPedidos;   
//     private int quantidadeAvaliacoes;
//     private IValoravel fidelidade;
//     private List<Pedido> historicoPedidos;

//     public Cliente(String nome, String CPF){

//         historicoPedidos =  new ArrayList<Pedido>();
//         setNome(nome);
//         setCPF(CPF);
//         setQuantidadeAvaliacoes(0);
//     }

//     private void descobrirNivelFidelidade(){ //de acordo com o escopo do trabalho, logica calcula automaticamente qual o nivel de fidelidade do usuario

//         if(historicoPedidos.size() >= 50 || calculaGastosMeses(6) > 600 ){

//             this.fidelidade = new FidelidadeFeV();

//         }else if(historicoPedidos.size() >= 10 || calculaGastosMeses(2) > 250){

//             this.fidelidade = new FidelidadePreto();

//         }else if(historicoPedidos.size() >= 4 || calculaGastosMeses(1) >= 100){
            
//             this.fidelidade = new FidelidadePrata();

//         }else{
            
//             this.fidelidade = new FidelidadeBranco();

//         }

//     }

//     private void setNome(String nome){
//         this.nome = nome;
//     }

//     public void setCPF(String CPF) {
//         this.CPF = CPF;
//     }


//     public void realizarPedido(List<Produto> produtos){

//         try{

//             descobrirNivelFidelidade();

//             Pedido pedidoEmAndamento = new Pedido(produtos, this, fidelidade.getDesconto());

//             historicoPedidos.add(pedidoEmAndamento);


//         }catch(ExcecaoQuantidadeDeProdutosIrregular e){

//             System.out.println(e + "\n");

//         }

//     }

//     private double calculaGastosMeses(int quantidadeMeses){
        
//         LocalDate dataAtual =  LocalDate.now();

//         LocalDate dataInical = descobreDataInicialFidelidade(dataAtual,quantidadeMeses);

//         double totalGastoNoPeriodo = 0;

//         for (Pedido pedido : historicoPedidos) {
//             if(pedido.getDataPedido().isAfter(dataInical)){
//                 totalGastoNoPeriodo += pedido.getValorTotal();
//             }
//         }
        
//         return totalGastoNoPeriodo;

//     }

//     private LocalDate descobreDataInicialFidelidade(LocalDate dataAtual, int quantidadeMeses){

//         LocalDate dataAuxiliar;

//             if(dataAtual.getMonthValue() - quantidadeMeses <= 0 ){

//                 dataAuxiliar =  dataAtual.withYear(dataAtual.getYear()-1);
//                 dataAuxiliar = dataAuxiliar.withMonth(12);

//                 return dataAuxiliar;

//             }else{
//                 dataAuxiliar = dataAtual.withMonth(dataAtual.getMonthValue()-1);

//                 return dataAuxiliar;
//             }
//     }

//     public void avaliarPedidoFeito(Pedido pedidoAAvaliar,double nota){

//         for (Pedido pedido : historicoPedidos) { //garante que o cliente não avalie um pedido que não é dele!
//             if(pedidoAAvaliar == pedido){
//                 pedido.receberAvaliacao(nota); //considerar nota de 1 à 5 podendo ser numeros com casas decimais
//             }
//         }

//         atualizaMediaAvaliacoes(nota);
//     }

//     private void atualizaMediaAvaliacoes(double nota){
        
//         double acumuladoAvaliacoes = getQuantidadeAvaliacoes() * getAvaliacaoMediaPedidos();

//         setQuantidadeAvaliacoes(getQuantidadeAvaliacoes() + 1 );

//         double novaMediaAvaliacoes = (acumuladoAvaliacoes+nota) / (getQuantidadeAvaliacoes());

//         setAvaliacaoMediaPedidos(novaMediaAvaliacoes);

//     }


//     public String gerarRelatorioPedidos(){
        
//         String relatorioTotal = "Relatorio dos pedidos: ";

//         for (Pedido pedido : historicoPedidos) {
            
//             relatorioTotal += pedido.gerarRelatorioGeralPedido();

//         }

//         return relatorioTotal;

//     }


//     public String gerarRelatorioEspecifico(Pedido pedido){

//         String relatorioEspecifico = "Relatorio do pedido: ";

//         relatorioEspecifico += pedido.gerarRelatorioDetalhadoPedido();

//         return relatorioEspecifico;

//     }

//     public List<Pedido> getHistoricoPedidos() {
//         return historicoPedidos;
//     }

//     public String getCPF() {
//         return CPF;
//     }

//     public String getNome() {
//         return nome;
//     }

//     public double getAvaliacaoMediaPedidos() {
//         return avaliacaoMediaPedidos;
//     }

//     public int getQuantidadeAvaliacoes() {
//         return quantidadeAvaliacoes;
//     }

//     public void setQuantidadeAvaliacoes(int quantidadeAvaliacoes) {
//         this.quantidadeAvaliacoes = quantidadeAvaliacoes;
//     }

//     public void setAvaliacaoMediaPedidos(double avaliacaoMediaPedidos) {
//         this.avaliacaoMediaPedidos = avaliacaoMediaPedidos;
//     }
// }