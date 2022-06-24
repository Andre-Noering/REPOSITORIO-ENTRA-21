package classes.lanches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Sanduiche extends Lanche {
    private HashMap<String, Double> adicionais = new HashMap<>();


    public void adicionarAdicional(double valor, String adicional) {
        this.adicionais.put(adicional, valor);
    }

    public HashMap<String, Double> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(HashMap<String, Double> adicionais) {
        this.adicionais = adicionais;
    }

    @Override
    public void mostrarDetalhesComanda() {
        if (!this.adicionais.isEmpty()) {
        System.out.println("====" + this.getTipo() + "====");
        System.out.println("-ADICIONAIS-");
            for (String adicional : this.getAdicionais().keySet()) {
                System.out.printf("%s: R$%.2f\n", adicional, this.getAdicionais().get(adicional));
            }
        }
    }

    @Override
    public void montarDetalhesLanche(Scanner in) {
        System.out.println("Deseja adicionais? (S/N)");
        String adicionais = in.nextLine();
        if (adicionais.equalsIgnoreCase("S")) {
            while (true) {
                System.out.print("Informe o adicional: ");
                String adicional = in.nextLine();
                System.out.print("Informe o valor do adicional: R$");
                this.adicionarAdicional(in.nextDouble(), adicional);
                in.nextLine();
                System.out.println("Deseja adicionar mais adicionais? (S/N)");
                String parada = in.nextLine();
                if (parada.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
    }

    @Override
    public double getValor() {
        double valorTotal = super.getValor();
        for (Double valor : adicionais.values()) {
            valorTotal += valor;
        }
        return valorTotal;
    }
}

