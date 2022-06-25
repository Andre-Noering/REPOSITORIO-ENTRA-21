import classes.Onibus;

public class Main{
    public static void main(String[] args) {
        Onibus a = new Onibus(4);
        a.getAssento("7").ocupar();
        a.getAssento("12").ocupar();
        a.mostrarAssentos();
    }
}