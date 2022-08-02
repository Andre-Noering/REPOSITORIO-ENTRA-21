
import classes.*;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Cliente cl = new Cliente();
        System.out.print("Insira o nome do cliente: ");
        cl.setNome(in.nextLine());
        for (int i = 0; i < 10; i++){
            cl.getPedido().adicionarLanche(montarLanche());
            if (i == 9) {
                break;
            }
            System.out.println("Deseja mais um lanche? (S/N)");
            if(in.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.println("Cliente: "+cl.getNome());
        cl.getPedido().imprimirComanda();
    }

    private static Lanche montarLanche() {
        System.out.println("-MENU: Escolha uma opção-");
        for (ETipoLanche menu : ETipoLanche.values()) {
            System.out.printf("(%d) - %s\n", menu.getValorOpcao(), menu.getDescricao());
        }
        ETipoLanche escolha = ETipoLanche.getByValorOpcao(in.nextInt());
        in.nextLine();
        Lanche lanche = null;
        switch (escolha) {
            case XSALADA -> lanche = new XSalada();
            case XBURGUER -> lanche = new XBurguer();
            case MISTO_QUENTE -> lanche = new MistoQuente();
            case HOT_DOG -> lanche = new HotDog();
            case MINI_PIZZA -> lanche = new MiniPizza();
            case PIZZA -> lanche = new Pizza();
            default -> System.err.println("Escolha uma opção válida!");
        }
        lanche.montarDetalhesLanche(in);
        System.out.print("Informe o valor do(a) "+lanche.getTipo()+": R$");
        lanche.setValor(in.nextDouble());
        in.nextLine();
        return lanche;
    }
}