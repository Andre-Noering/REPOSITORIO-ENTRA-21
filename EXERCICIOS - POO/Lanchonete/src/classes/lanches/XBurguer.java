
package classes.lanches;

public class XBurguer extends Sanduiche {
    private boolean aberto;
    public XBurguer() {
        this.adicionarIngrediente("Hamburguer");
        this.setTipo("XBurguer");
    }


    public void setAberto(boolean aberto){
        this.aberto=aberto;
    }
    public boolean isAberto(){
        return this.aberto;
    }
}