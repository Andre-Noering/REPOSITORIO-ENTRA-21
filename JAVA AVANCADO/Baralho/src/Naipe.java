public enum Naipe {
    OUROS("OUROS"), ESPADAS("ESPADAS"), COPAS("COPAS"), PAUS("PAUS");

    private String naipe;
    Naipe(String a){
        naipe = a;
    }
    public String getNaipe(){
        return this.naipe;
    }
}
