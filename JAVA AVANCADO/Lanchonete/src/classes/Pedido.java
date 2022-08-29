package classes;

import classes.*;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Lanche> lanches = new ArrayList();
    public void imprimirComanda() {
        for (Lanche l : this.getLanches()) {
            l.mostrarDetalhesComanda();
            System.out.println("-INGREDIENTES-");
            for (String ingrediente : l.getIngrediente()) {
                System.out.println(ingrediente);
            }
            System.out.printf("Valor: R$%.2f\n", l.getValor());
        }
        System.out.printf("Valor total do pedido: R$%.2f\n", this.calcularValorTotal());
        System.out.println("------------------------------------");
    }


    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Lanche lanche : this.getLanches()) {
            valorTotal += lanche.getValor();
        }
        return valorTotal;
    }


    public void adicionarLanche(Lanche lanche) {
        this.lanches.add(lanche);
    }


    public ArrayList<Lanche> getLanches() {
        return this.lanches;
    }
}