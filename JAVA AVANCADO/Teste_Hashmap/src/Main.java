import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Double> produtos = new HashMap<>();
        boolean executa = true;
        while (executa) {
            System.out.print("Menu: \n1 - Cadastrar produto\n2 - Buscar produto\n0 - Sair\n");
            int escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 0:
                    executa = false;
                    break;
                case 1:
                    System.out.println("Informe o nome do produto: ");
                    String produto = in.nextLine().toLowerCase();
                    if (produtos.containsKey(produto)) {
                        System.out.println("Produto já existente! Deseja atualizar o valor? (S/N)");
                        if (in.nextLine().equalsIgnoreCase("N")) {
                            continue;
                        }
                    }
                    System.out.println("Informe o valor: ");
                    Double valor = in.nextDouble();
                    produtos.put(produto, valor);
                    break;
                case 2:
                    if (produtos.isEmpty()){
                        System.out.println("Não há produtos cadastrados!");
                        break;
                    }
                    System.out.println("Informe o produto a ser buscado: ");
                    String busca=in.nextLine().toLowerCase();
                    if (produtos.containsKey(busca)){
                        System.out.println(busca + ": R$"+produtos.get(busca));
                    } else {
                        System.out.println("Produto '"+busca+"' não encontrado!");
                    }
                    break;
                case 3:
                    System.out.println(produtos);
                    break;
                case 4:
                    if (produtos.isEmpty()){
                        System.out.println("Não há produtos cadastrados!");
                        break;
                    }
                    System.out.println("Informe o produto a ser buscado: ");
                    String remove=in.nextLine().toLowerCase();
                    if (produtos.containsKey(remove)){
                        produtos.remove(remove);
                    } else {
                        System.out.println("Produto '" + remove + "' não encontrado!");
                    }
                    break;
                default:
                    System.out.println("Informe um valor válido: ");
                    break;
            }
        }
    }
}
