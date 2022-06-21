package classes.lanches;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Lanche {
    private ArrayList<String> ingrediente = new ArrayList();
    private double valor;
    private String tipo;

    public void adicionarIngrediente(String ingrediente) {
        this.ingrediente.add(ingrediente);
    }


    public ArrayList<String> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(ArrayList<String> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getTipo(){
        return this.tipo;
    }

    public abstract void mostrarDetalhesComanda();

    public abstract void montarDetalhesLanche(Scanner in);
}