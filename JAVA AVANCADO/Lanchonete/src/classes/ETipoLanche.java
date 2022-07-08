package classes;

public enum ETipoLanche {
XSALADA(1, "XSalada"),
    XBURGUER(2,"XBurguer"),
    MISTO_QUENTE(3,"Misto Quente"),
    HOT_DOG(4,"Hot Dog"),
    MINI_PIZZA(5,"Mini-Pizza"),
    PIZZA(6,"Pizza");

private int valorOpcao;
private String descricao;
ETipoLanche(int valor, String descricao){
    valorOpcao=valor;
    this.descricao=descricao;
}

    public String getDescricao() {
        return descricao;
    }


    public int getValorOpcao() {
        return valorOpcao;
    }


}
