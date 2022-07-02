package classes;

public class Locacao extends Pedido {
    private String devolucao;

    public void estender() {
        //todo
    }

    public void devolver(Loja loja) {
        for (ItemPedido item : getItensPedido()) {
            for (Estante e : loja.getEstantes()) {
                if (!e.estanteCheia()) {
                    e.adicionarItem(item.getItem());
                    item.setEmprestado(false);
                    break;
                }
            }
        }
    }
    @Override
    public void finalizar(Loja loja){
        double valorTotal=0.0;
        for (ItemPedido item : getItensPedido()){
            System.out.printf("%s - R$%.2f", item.getTitulo(), item.getValorLocacao());
            valorTotal+=item.getValorLocacao();
            item.setEmprestado(true);
            for (Estante e:loja.getEstantes()){
                if(e.buscarItem(item.getTitulo())!=null){
                    e.getItensEstante().remove(item);
                }
            }
        }
        System.out.printf("Valor total da locação: R$%.2s\nDevolução: %s",valorTotal, devolucao);
    }
}
