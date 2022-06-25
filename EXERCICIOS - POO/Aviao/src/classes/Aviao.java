package classes;

import java.util.ArrayList;

public class Aviao implements MeioTransporte {
    private ArrayList<AssentoVoo> assentos = new ArrayList<>();

    public Aviao(int linhasCadeirasLuxo, int linhasCadeirasEconomicas) {
        String cod = "";
        String letrasLuxo="ABCD";
        for (int i = 1; i <= linhasCadeirasLuxo; i++) {
            for (int j = 0; j < 4; j++) {
                AssentoVoo a = new AssentoVoo();
                a.setClasse("Luxo");
                a.setCodigo(letrasLuxo.charAt(j) + String.valueOf(i));
                assentos.add(a);
            }
        }
        String letrasEco="ABCDEF";
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
    public Assento getAssento(String assento,String classe){
        for (AssentoVoo a : assentos) {
            if (a.getCodigo().equalsIgnoreCase(assento)&&a.getClasse().equalsIgnoreCase(classe)) {
                return a;
            }
        }
        return null;
    }
}
