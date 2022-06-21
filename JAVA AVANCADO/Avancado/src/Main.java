import java.net.PortUnreachableException;
import java.security.PublicKey;
import java.util.*;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ex3();
    }

    public static void ex1() {
        ArrayList inteiros = new ArrayList();
        while (true) {
            System.out.print("Informe um valor inteiro: ");
            int num = in.nextInt();
            inteiros.add(num);
            if (num == 0) {
                break;
            }
        }
        System.out.println("Valores: ");
        System.out.println(inteiros);
    }

    public static void ex2() {
        ArrayList<Integer> inteiros = new ArrayList();
        double soma = 0.0;
        int somaImp = 0;
        int somaPar = 0;
        while (true) {
            System.out.print("Informe um valor inteiro: ");
            int num = in.nextInt();
            inteiros.add(num);
            if (num == 0) {
                break;
            }
        }
        for (Integer i : inteiros) {
            soma += i;
            if (i % 2 == 1) {
                somaImp += i;
            } else {
                somaPar += i;
            }
        }
        System.out.println("Valores: ");
        System.out.println(inteiros);
        System.out.println("Média: " + soma / inteiros.size());
        System.out.println("Soma dos pares: " + somaPar);
        System.out.println("Soma dos ímpares: " + somaImp);
    }

    public static void ex3() {
        ArrayList<String> lista = new ArrayList();
        while (true) {
            System.out.println("Digite uma palavra: ");
            String pal = in.nextLine();
            if (pal.equalsIgnoreCase("sair")) {
                break;
            }
            lista.add(pal);
        }
        System.out.println("Digite a quantidade de letras: ");
        int num = in.nextInt();
        for (int i = 0; i < lista.size(); i++) {
            String palavra = lista.get(i);
            if (palavra.length() < num) {
                lista.remove(palavra);
                i--;
            }
        }
        System.out.println(lista);
    }
}

