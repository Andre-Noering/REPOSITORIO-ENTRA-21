import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Carta> baralho = new ArrayList<>();
        for (Naipe n:Naipe.values()){
            for (ValorCarta v:ValorCarta.values()){
                Carta c=new Carta(n,v);
                baralho.add(c);
            }
        }
        for (Carta c:baralho){
            System.out.println(c.getValorCarta()+" DE "+c.getNaipe());
            System.out.println();
        }
    }
}
