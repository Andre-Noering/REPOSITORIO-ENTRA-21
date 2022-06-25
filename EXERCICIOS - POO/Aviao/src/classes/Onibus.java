package classes;

import java.util.ArrayList;

public class Onibus implements MeioTransporte {
    private ArrayList<AssentoOnibus> assentos = new ArrayList<>();
    private boolean leito;

    public Onibus(int linhasCadeiras) {
        for (int i = 1; i <= linhasCadeiras * 4; i++) {
            AssentoOnibus a = new AssentoOnibus();
            a.setLugar(String.valueOf(i));
            assentos.add(a);
        }
    }
    //GETTERS & SETTERS

    public ArrayList<AssentoOnibus> getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<AssentoOnibus> assentos) {
        this.assentos = assentos;
    }

    @Override
    public boolean verificaOcupacao(String assento) {
        AssentoOnibus a = (AssentoOnibus) getAssento(assento);
        if (a != null) {
            return a.isOcupado();
        }
        return false;
    }

    @Override
    public int quantidadeLivre() {
        int livres = 0;
        for (AssentoOnibus a : this.assentos) {
            if (!a.isOcupado()) {
                livres++;
            }
        }
        return livres;
    }

    @Override
    public void mostrarAssentos() {
        for (int i = 1; i <= this.assentos.size(); i++) {
            if (this.assentos.get(i-1).isOcupado()) {
                System.out.print("[XX] ");
            } else {
                if (i < 10) {
                    System.out.printf("[0%d] ", i);
                } else {
                    System.out.printf("[%d] ", i);
                }

            }
            if (i % 4 == 0) {
                System.out.println();
            } else if (i % 2 == 0) {
                System.out.print("|| ");
            }
        }
    }

    @Override
    public Assento getAssento(String assento) {
        for (AssentoOnibus a : this.assentos) {
            if (a.getLugar().equalsIgnoreCase(assento)) {
                return a;
            }
        }
        return null;
    }
}
