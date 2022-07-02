public class Carta {
    private Naipe naipe;
    private ValorCarta valorCarta;
    private int valorReal;
    public Carta (Naipe naipe, ValorCarta valorCarta){
        this.setNaipe(naipe);
        this.setValorCarta(valorCarta);
    }

    public int getValorReal() {
        return valorReal;
    }

    public void setValorReal(int valorReal) {
        this.valorReal = valorReal;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;
    }

    public ValorCarta getValorCarta() {
        return valorCarta;
    }

    public void setValorCarta(ValorCarta valorCarta) {
        this.valorCarta = valorCarta;
    }
}
