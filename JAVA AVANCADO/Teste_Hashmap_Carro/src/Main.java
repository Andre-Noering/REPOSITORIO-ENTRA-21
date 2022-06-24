import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static HashMap<String, ArrayList<Carro>> lista = new HashMap<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executa = true;
        while (executa) {
            System.out.print("Menu: \n1 - Ver a lista de carros disponíveis para venda \n2 - Adicionar um carro para a lista\n3 - Vender um carro\n0 - Encerrar\n");
            int escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 1:
                    verCarros();
                    break;
                case 2:
                    adicionaCarro();
                    break;
                case 3:
                    vendeCarro();
                    break;
                case 0:
                    executa = false;
                    break;
                default:
                    System.out.println("Valor inválido informado.");
                    break;
            }
        }
    }

    public static void verCarros() {
        if (lista.isEmpty()) {
            System.out.println("Ainda não há carros na lista!");
        } else {
            for (String i : lista.keySet()) {
                System.out.println("-----------------");
                System.out.println("Carros da marca: " + i.toUpperCase());
                System.out.println("---------------------------------------");
                for (Carro c : lista.get(i)) {
                    System.out.println(c.getModelo().toUpperCase() + ": R$" + c.getValorVenda());
                }
            }
        }
    }

    public static void adicionaCarro() {
        Carro carro = new Carro();
        System.out.println("Informe a marca do carro: ");
        String marca = in.nextLine().toLowerCase();
        System.out.println("Informe o modelo do carro: ");
        carro.setModelo(in.nextLine().toLowerCase());
        System.out.println("Informe o valor de venda: ");
        carro.setValorVenda(in.nextDouble());
        if (lista.containsKey(marca)) {
            lista.get(marca).add(carro);
        } else {
            ArrayList<Carro> a = new ArrayList<>();
            a.add(carro);
            lista.put(marca, a);
        }
        System.out.println("Carro adicionado!");
        System.out.println();
    }

    public static void vendeCarro() {
        if (lista.isEmpty()) {
            System.out.println("Não há carros em estoque!");
        } else {
            System.out.println("Informe a marca do carro a ser vendido: ");
            String marcaRemov = in.nextLine().toLowerCase();
            boolean encontrado=false;
            if (lista.containsKey(marcaRemov.toLowerCase())) {
                System.out.println("Informe o modelo a ser vendido: ");
                String modelo = in.nextLine().toLowerCase();
                for (Carro c : lista.get(marcaRemov)) {
                    if (c.getModelo().equals(modelo)) {
                        encontrado=true;
                        System.out.println("O valor do carro é de R$" + c.getValorVenda());
                        System.out.println("Deseja realizar a venda? (S/N)");
                        if (in.nextLine().equalsIgnoreCase("S")) {
                            lista.get(marcaRemov).remove(c);
                            System.out.println("Carro vendido!");
                            if (lista.get(marcaRemov).isEmpty()) {
                                lista.remove(marcaRemov);
                            }
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Não há nenhum carro da marca informada.");
            }
            if (!encontrado){
                System.out.println("Modelo não encontrado!");
            }

        }
    }
}
