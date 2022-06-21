package classes.lanches;

import java.util.Locale;
import java.util.Scanner;

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

    @Override
    public void mostrarDetalhesComanda() {
        System.out.println("====" + this.getTipo() + " - " + this.getSaborBorda() + "====");
        if (this.isRecheada()) {
            System.out.println("-- COM BORDA RECHEADA: " + this.getSaborBorda().toUpperCase() + " --");
        }
    }
    @Override
    public void montarDetalhesLanche(Scanner in) {
        System.out.println("Escolha o sabor da pizza:");
        System.out.println("(1) - 4 Queijos");
        System.out.println("(2) - Calabresa");
        System.out.println("(3) - Frango c/ catupiry");
        System.out.println("(4) - Marguerita");
        System.out.println("(5) - Portuguesa");
        int sabor = in.nextInt();
        in.nextLine();
        switch (sabor) {
            case 1:
                this.adicionarSaborEIngredientes("4 queijos");
                break;
            case 2:
                this.adicionarSaborEIngredientes("calabresa");
                break;
            case 3:
                this.adicionarSaborEIngredientes("frango c/ catupiry");
                break;
            case 4:
                this.adicionarSaborEIngredientes("marguerita");
                break;
            case 5:
                this.adicionarSaborEIngredientes("portuguesa");
                break;
            default:
                System.err.println("Escolha um sabor válido");
        }
        System.out.println("Com borda recheada? (S/N)");
        String aberto = in.nextLine();
        this.setRecheada(aberto.equalsIgnoreCase("S"));
        if (this.isRecheada()) {
            System.out.println("Qual o sabor da borda?");
            this.setSaborBorda(in.nextLine());
        }
    }
}
