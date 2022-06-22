import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, ArrayList<Carro>> lista = new HashMap<>();
        boolean executa = true;
        while (executa) {
            System.out.print("Menu: \n1 - Ver a lista de carros disponíveis para venda \n2 - Adicionar um carro para a lista\n3 - Vender um carro\n0 - Encerrar\n");
            int escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 1:
                    if (lista.isEmpty()) {
                        System.out.println("Ainda não há carros na lista!");
                        break;
                    }
                    for (String i : lista.keySet()) {
                        System.out.println("-----------------");
                        System.out.println("Carros da marca: " + i);
                        System.out.println("---------------------------------------");
                        for (Carro c : lista.get(i)) {
                            System.out.println(c.getModelo() + ": R$" + c.getValorVenda());
                        }
                    }
                    break;
                case 2:
                    Carro carro = new Carro();
                    System.out.println("Informe a marca do carro: ");
                    String marca = in.nextLine();
                    if (lista.containsKey(marca)) {
                        System.out.println("Informe o modelo do carro: ");
                        carro.setModelo(in.nextLine());
                        System.out.println("Informe o valor de venda: ");
                        carro.setValorVenda(in.nextDouble());
                        lista.get(marca).add(carro);
                    } else {
                        ArrayList<Carro> a = new ArrayList<>();
                        System.out.println("Informe o modelo do carro: ");
                        carro.setModelo(in.nextLine());
                        System.out.println("Informe o valor de venda: ");
                        carro.setValorVenda(in.nextDouble());
                        a.add(carro);
                        lista.put(marca, a);
                    }
                    break;
                case 3:
                    System.out.println("Informe a marca do carro a ser vendido: ");
                    String marcaRemov = in.nextLine();
                    if (lista.containsKey(marcaRemov)) {
                        System.out.println("Informe o modelo a ser vendido: ");
                        String modelo = in.nextLine();
                        for (Carro c : lista.get(marcaRemov)) {
                            if (c.getModelo().equalsIgnoreCase(modelo)) {
                                System.out.println("O valor do carro é de R$" + c.getValorVenda());
                                System.out.println("Deseja realizar a venda? (S/N)");
                                if (in.nextLine().equalsIgnoreCase("S")) {
                                    lista.get(marcaRemov).remove(c);
                                    System.out.println("Carro vendido!");
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Não há nenhum carro da marca informada.");
                    }
                    if (lista.get(marcaRemov).isEmpty()){
                        lista.remove(marcaRemov);
                    }
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
}
