package classes.lanches;

import java.util.Locale;

public class MiniPizza extends Lanche {
    private boolean recheada;
    private String saborBorda;
    private String saborPizza;

    public MiniPizza() {
        this.adicionarIngrediente("Massa");
        this.adicionarIngrediente("Queijo");
        this.adicionarIngrediente("Molho de tomate");
        this.setTipo("Mini Pizza");
    }

    public void adicionarSaborEIngredientes(String sabor) {
        this.setSaborPizza(sabor);
        switch (sabor.toUpperCase(Locale.ROOT)){
            case "4 QUEIJOS":
                this.adicionarIngrediente("Cheddar");
                this.adicionarIngrediente("Catupiry");
                this.adicionarIngrediente("Provolone");
                break;
            case "CALABRESA":
                this.adicionarIngrediente("Calabresa");
                break;
            case "FRANGO COM CATUPIRY":
                this.adicionarIngrediente("Frango");
                this.adicionarIngrediente("Catupiry");
                break;
            case "MARGUERITA":
                this.adicionarIngrediente("Tomate");
                this.adicionarIngrediente("Manjericão");
                break;
            case "PORTUGUESA":
                this.adicionarIngrediente("Cebola");
                this.adicionarIngrediente("Presunto");
                this.adicionarIngrediente("Ovo");
                break;
        }
    }

    public void setRecheada(boolean recheada){
        this.recheada=recheada;
    }
    public boolean isRecheada(){
        return this.recheada;
    }
    public void setSaborBorda(String saborBorda){
        this.saborBorda=saborBorda;
    }
    public String getSaborBorda(){
        return this.saborBorda;
    }
    public void setSaborPizza(String saborPizza){
        this.saborPizza=saborPizza;
    }
    public String getSaborPizza(){
        return this.saborPizza;
    }
}
