package classes;

public class Pedido {
    private String nomeCliente;
    private Item[] itensPedido;

    public void finalizar(Loja loja){
        //todo
    }
    //GETTERS & SETTERS

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Item[] getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(Item[] itensPedido) {
        this.itensPedido = itensPedido;
    }
}
