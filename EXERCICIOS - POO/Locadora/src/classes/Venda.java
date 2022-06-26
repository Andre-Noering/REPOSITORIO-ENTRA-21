package classes;

public class Venda extends Pedido{


    @Override
    public void finalizar(Loja loja){
        double valorTotal=0.0;
        for (ItemPedido item : getItensPedido()){
            valorTotal+=item.getValorVenda();
            for (Estante e:loja.getEstantes()){
                if(e.buscarItem(item.getTitulo())!=null){
                    e.getItensEstante().remove(item);
                }
            }
        }
        System.out.println("Valor total da venda: R$"+valorTotal);
    }
}
