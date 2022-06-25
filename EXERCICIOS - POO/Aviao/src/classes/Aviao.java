package classes;

import java.util.ArrayList;

public class Aviao implements MeioTransporte {
    private ArrayList<AssentoVoo> assentos = new ArrayList<>();

    public Aviao(int linhasCadeirasLuxo, int linhasCadeirasEconomicas) {
        String cod = "";
        String letrasLuxo = "ABCD";
        for (int i = 1; i <= linhasCadeirasLuxo; i++) {
            for (int j = 0; j < 4; j++) {
                AssentoVoo a = new AssentoVoo();
                a.setClasse("Luxo");
                if (i<10){
                a.setCodigo(letrasLuxo.charAt(j) + String.valueOf(i));
                assentos.add(a);
            }
        }
        String letrasEco = "ABCDEF";
        for (int i = 1; i <= linhasCadeirasEconomicas; i++) {
            for (int j = 0; j < 6; j++) {
                AssentoVoo a = new AssentoVoo();
                a.setClasse("Econômico");
                a.setCodigo(letrasEco.charAt(j) + String.valueOf(i));
                assentos.add(a);
            }
        }
    }

    //GETTERS & SETTERS

    public ArrayList<AssentoVoo> getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<AssentoVoo> assentos) {
        this.assentos = assentos;
    }

    @Override
    public boolean verificaOcupacao(String assento) {
        AssentoVoo a = (AssentoVoo) getAssento(assento);
        if (a != null) {
            return a.isOcupado();
        }
        return false;
    }

    @Override
    public int quantidadeLivre() {
        int livres = 0;
        for (AssentoVoo a : assentos) {
            if (!a.isOcupado()) {
                livres += 1;
            }
        }
        return livres;
    }

    @Override
    public void mostrarAssentos() {
        for (int i = 1; i <= this.assentos.size(); i++) {
            AssentoVoo a = assentos.get(i - 1);
            if (a.getClasse().equalsIgnoreCase("luxo")) {
                if (a.isOcupado()) {
                    System.out.print("[XX] ");
                } else {
                    System.out.printf("[%s] ", a.getCodigo());

                }
                if (i % 4 == 0) {
                    System.out.println();
                } else if (i % 2 == 0) {
                    System.out.print("|| ");
                }
            } else {
                if (a.isOcupado()) {
                    System.out.print("[XX] ");
                } else {
                    System.out.printf("[%s] ", a.getCodigo());

                }
                if (i % 6 == 0) {
                    System.out.println();
                } else if (i % 3 == 0) {
                    System.out.print("|| ");
                }
            }
        }
    }

    @Override
    public Assento getAssento(String assento) {
        for (AssentoVoo a : assentos) {
            if (a.getCodigo().equalsIgnoreCase(assento)) {
                return a;
            }
        }
        return null;
    }

    public Assento getAssento(String assento, String classe) {
        for (AssentoVoo a : assentos) {
            if (a.getCodigo().equalsIgnoreCase(assento) && a.getClasse().equalsIgnoreCase(classe)) {
                return a;
            }
        }
        return null;
    }
}