public enum ValorCarta {
    ÁS("1"), DOIS("2"), TRÊS("3"), QUATRO ("4"), CINCO("5"), SEIS("6"),SETE("7"),OITO("8"),NOVE("9"),DEZ("10"),VALETE("11"),DAMA("12"), REI("13");

    private String numero;
    ValorCarta(String valor){
        numero=valor;
    }

    public String getNumero(){
        return this.numero;
    }
}
