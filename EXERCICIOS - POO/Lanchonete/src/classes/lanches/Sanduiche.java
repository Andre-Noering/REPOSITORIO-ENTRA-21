package classes.lanches;

import java.util.Locale;

public abstract class Sanduiche extends Lanche{
    private String[] adicionais= new String[10];

    public String[] getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String[] adicionais) {
        this.adicionais = adicionais;
    }

    public void adicionarAdicional(String adicional){
        for (int i = 0; i < 10; i++) {
            if (this.adicionais[i]==null) {
                adicionais[i] = adicional;
                break;
            }
        }
    }

}

