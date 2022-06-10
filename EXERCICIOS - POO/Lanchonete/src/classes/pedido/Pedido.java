package classes.pedido;

import classes.lanches.*;

public class Pedido {
    private Lanche[] lanches = new Lanche[10];

    public void imprimirComanda() {
        for (Lanche lanche : this.getLanches()) {
            if (lanche != null) {
                if (lanche instanceof MiniPizza) {
                    MiniPizza mp = ((MiniPizza) lanche);
                    System.out.println("====" + lanche.getTipo() + " - " + ((MiniPizza) lanche).getSaborPizza() + "====");
                    if (mp.isRecheada()) {
                        System.out.println("--- COM BORDA RECHEADA: " + mp.getSaborBorda().toUpperCase() + "---");
                    }
                    System.out.println("--- SABOR: " + mp.getSaborPizza() + "---");
                    if (lanche instanceof Pizza) {
                        System.out.println("--- TAMANHO: " + ((Pizza) lanche).getTamanho() + "---");
                    }
                } else {
                    System.out.println("====" + lanche.getTipo() + "====");
                }
                if (lanche instanceof XBurguer) {
                    if (((XBurguer) lanche).isAberto()) {
                        System.out.println("---LANCHE ABERTO---");
                    }
                }
            }
            System.out.printf("Valor: R$%.2f\n", lanche.getValor());

            System.out.println("-INGREDIENTES-");
            for (String ingrediente : lanche.getIngrediente()) {
                if (ingrediente != null) {
                    System.out.println(ingrediente);
                }
            }
            if (lanche instanceof Sanduiche) {
                Sanduiche san = ((Sanduiche) lanche);
                if (san.getAdicionais().length > 0) {
                    System.out.println("---ADICIONAIS---");
                    for (String adicional : san.getAdicionais()) {
                        if (adicional != null) {
                            System.out.println(adicional.toUpperCase());

                        }
                    }
                }
            }
            System.out.println("-------------");
        }
        System.out.printf("Valor total do pedido: R$%.2f\n",this.calcularValorTotal());
    }



    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Lanche lanche : this.getLanches())
            if (lanche != null) {
                valorTotal += lanche.getValor();
            }
        return valorTotal;
    }


    public void adicionarLanche(Lanche lanche) {
        for (int i = 0; i < 10; i++) {
            if (this.lanches[i] == null) {
                this.lanches[i] = lanche;
                break;
            }
        }
    }


    public Lanche[] getLanches() {
        return this.lanches;
    }
}
