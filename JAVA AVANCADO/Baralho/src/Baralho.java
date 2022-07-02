import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    private ArrayList<Carta> cartas;
    public Baralho(){
        for (Naipe n:Naipe.values()){
            int valorCarta=1;
            for (ValorCarta v:ValorCarta.values()){
                Carta c=new Carta();
                c.setValorCarta(v);
                c.setNaipe(n);
                c.setValorReal(valorCarta);
                this.getCartas().add(c);
                valorCarta++;
            }
        }
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(this.cartas);
    }

    public Carta getFromTop(){
        return this.cartas.remove(0);
    }

    public Carta getFromBottom(){
        return this.cartas.remove(this.cartas.size()-1);
    }
    public Carta searchCard(Naipe naipe, ValorCarta valor){
        return this.cartas.stream().filter(
                carta -> naipe.equals(carta.getNaipe())&& valor.equals(carta.getValorCarta())
        ).findFirst().orElse(null);
    }
    public Carta searchCard(Naipe naipe, int valorReal){
        return this.cartas.stream().filter(
                carta -> naipe.equals(carta.getNaipe())&& valorReal==carta.getValorReal()
        ).findFirst().orElse(null);
    }

    //GETTERS & SETTERS


    public ArrayList getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList cartas) {
        this.cartas = cartas;
    }
}
