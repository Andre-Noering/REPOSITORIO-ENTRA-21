

import classes.cliente.Cliente;
import classes.lanches.*;

import java.util.Scanner;

public class main {
    public static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        Cliente cliente=new Cliente();
        System.out.println("Insira o nome do cliente: ");
        cliente.setNome(in.nextLine());
        for (int i=0; i<10;i++){
            cliente.getPedido().adicionarLanche(montarLanche());
            if (i==9){
                System.out.println("Número máximo de lanches atingido!");
                break;
            }
            System.out.println("Deseja mais um lanche? (S/N): ");
            if (in.nextLine().equalsIgnoreCase("N")){
                break;
            }
        }
        System.out.println("Cliente: "+cliente.getNome());
        cliente.getPedido().imprimirComanda();
    }
    private static Lanche montarLanche(){
        System.out.println("-MENU: Escolha uma opção-");
        System.out.println("(1) - X-Salada");
        System.out.println("(2) - X-Burguer");
        System.out.println("(3) - Misto Quente");
        System.out.println("(4) - Hot Dog");
        System.out.println("(5) - Mini-Pizza");
        System.out.println("(6) - Pizza");
        int escolhaLanche = in.nextInt();
        Lanche lanche = null;
        switch (escolhaLanche) {
            case 1:
                lanche = new XSalada();
                break;
            case 2:
                lanche = new XBurguer();
                break;
            case 3:
                lanche = new MistoQuente();
                break;
            case 4:
                lanche = new HotDog();
                break;
            case 5:
                lanche = new MiniPizza();
                break;
            case 6:
                lanche = new Pizza();
                break;
            default:
                System.err.println("Escolha uma opção válida!");

        }
        in.nextLine();
        if (lanche instanceof Sanduiche) {
            //Pergunta se terá algum adicional e, se sim, adiciona os adicionais na lista, se for um sanduíche.
            System.out.println("Deseja algum adicional? (S/N)");
            in.nextLine();
            String qrAdicional = in.nextLine();
            if (qrAdicional.equalsIgnoreCase("S")) {
                int contadorAdicionais = 10;
                while (contadorAdicionais > 0) {
                    System.out.println("Digite o adicional ou N se não quer mais nenhum adicional: ");
                    System.out.println("(Máximo de 10 adicionais)");
                    String adicional = in.nextLine(); //Le o adicional
                    if (adicional.equals("N")) {
                        break;
                    } else {
                        ((Sanduiche) lanche).adicionarAdicional(adicional); //Adiciona o adicional
                        contadorAdicionais--;
                    }
                }
            }
            if (lanche instanceof XBurguer) {
                // Pergunta se o lanche virá aberto ou fechado, caso seja uma instância de X-Burguer
                System.out.println("Lanche aberto? (S/N)");
                String aberto = in.nextLine();
                ((XBurguer) lanche).setAberto(aberto.equalsIgnoreCase("S"));
            }
        } else {
            System.out.println("Escolha entre os sabores: ");
            System.out.println("(1) 4 queijos");
            System.out.println("(2) Calabresa");
            System.out.println("(3) Frango c/ catupiry");
            System.out.println("(4) Marguerita");
            System.out.println("(5) Portuguesa");
            int escolhaSaborP = in.nextInt();
            switch (escolhaSaborP) {
                case 1:
                    ((MiniPizza) lanche).adicionarSaborEIngredientes("4 QUEIJOS");
                    break;
                case 2:
                    ((MiniPizza) lanche).adicionarSaborEIngredientes("CALABRESA");
                    break;
                case 3:
                    ((MiniPizza) lanche).adicionarSaborEIngredientes("FRANGO C/ CATUPIRY");
                    break;
                case 4:
                    ((MiniPizza) lanche).adicionarSaborEIngredientes("MARGUERITA");
                    break;
                case 5:
                    ((MiniPizza) lanche).adicionarSaborEIngredientes("PORTUGUESA");
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
            }
            in.nextLine();
            System.out.println("Borda recheada? (S/N)");//Pergunta se quer borda recheada e, se sim, pergunta o sabor da borda, se for uma mini-pizza ou uma pizza.
            String recheada = in.nextLine();
            MiniPizza miniPizza = (MiniPizza) lanche;
            miniPizza.setRecheada(recheada.equalsIgnoreCase("S"));
            if (miniPizza.isRecheada()) {
                System.out.println("Digite o sabor da borda: ");
                miniPizza.setSaborPizza(in.nextLine());
            }

            if (lanche instanceof Pizza) {
                System.out.println("Digite o tamanho da pizza: ");
                System.out.println("XS - BROTO");
                System.out.println("SM - PEQUENA");
                System.out.println("MD - MÉDIA");
                System.out.println("LG - GRANDE");
                System.out.println("XL - FAMÍLIA");
                ((Pizza) lanche).setTamanho(in.nextLine().toUpperCase());

            }
        }
        System.out.println("Informe o valor do(a) " + lanche.getTipo() + ": R$");
        lanche.setValor(in.nextDouble());
        in.nextLine();
        return lanche;
    }
}
