package classes;

import java.util.ArrayList;
import java.util.Locale;

public class Estante {
    private int capMaxima;
    private ArrayList<Item> itensEstante;


    public Estante(int capacidadeMaxima) {
        setCapMaxima(capacidadeMaxima);
        setItensEstante(new ArrayList<>());
    }

    public boolean estanteCheia() {
        return this.getCapMaxima() == this.quantidadeItens();
    }

    public int quantidadeItens() {
        return getItensEstante().size();
    }

    public Item buscarItem(String titulo) {
        for (Item item : getItensEstante()) {
            if (item.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public boolean adicionarItem(Item item) {
        if (!this.estanteCheia()) {
            this.getItensEstante().add(item);
            return true;
        }
        return false;
    }

    public Item removerItem(int posicao) {
        Item item = getItensEstante().get(posicao);
        this.getItensEstante().remove(posicao);
        return item;
    }

    //GETTERS E SETTERS
    public int getCapMaxima() {
        return capMaxima;
    }

    public void setCapMaxima(int capMaxima) {
        this.capMaxima = capMaxima;
    }

    public ArrayList<Item> getItensEstante() {
        return itensEstante;
    }

    public void setItensEstante(ArrayList<Item> itensEstante) {
        this.itensEstante = itensEstante;
    }
}
