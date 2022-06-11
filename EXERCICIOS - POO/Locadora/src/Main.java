import classes.*;

import java.util.Scanner;


public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Estante estante = new Estante(5);
        int opcao = -1;
        while (opcao != 0) {
            System.out.printf("Você deseja:\n1 - Adicionar um item à estante.\n2 - Buscar e tratar um item.\n3 - Remover um item da estante.\n4 - Ver itens na estante.\n0 - Encerrar programa.\n");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {
                case 1:
                    mainCadastraItem(estante);
                    break;
                case 2:
                    buscarEAvaliarItem(estante);
                    break;
                case 3:
                    removerItem(estante);
                    break;
                case 4:
                    mostrarItens(estante);
                    break;
            }

        }
    }

    public static void mainCadastraItem(Estante estante) {
        if (estante.estanteCheia()) {
            System.out.println("A estante está cheia! Não é possível adicionar mais itens.");
        } else {
            System.out.println("------------------------------------------------------");
            Item item = null;
            int tipo = -1;
            while (tipo < 1 || tipo > 2) {
                System.out.println("Digite o tipo de item (1-Livro/2-DVD):");
                tipo = in.nextInt();
                in.nextLine();
                switch (tipo) {
                    case 1:
                        item = new Livro();
                        break;
                    case 2:
                        item = new DVD();
                        break;
                    default:
                        System.err.println("Valor inválido");
                        break;
                }
            }
            System.out.print("Digite o título: ");
            item.setTitulo(in.nextLine());
            System.out.print("Digite o gênero: ");
            item.setGenero(in.nextLine());
            System.out.print("Digite o valor: R$");
            item.setValor(in.nextDouble());
            in.nextLine();
            System.out.println("------------------------------------------------------");
            estante.adicionarItem(item);
        }
    }

    public static void buscarEAvaliarItem(Estante estante) {
        System.out.println("------------------------------------------------------");
        System.out.print("Informe o título do item procurado: ");
        Item i = estante.buscarItem(in.nextLine());
        if (i == null) {
            System.out.println("Nenhum item encontrado!");
        } else {
            System.out.println("Primeiro resultado: " + i.getTitulo() + "\nVocê deseja: \n1 - Avaliar o item;\n2 - Ver avaliações;\n");
            int escolha = in.nextInt();
            switch (escolha) {
                case 1:
                    i.avaliar();
                    break;
                case 2:
                    System.out.println("---------------------\nAVALIAÇÕES\n---------------------");
                    for (Avaliacao a : i.getAvaliacoes()) {
                        if (a != null) {
                            System.out.println(a.getNome() + " - " + a.getRating() + "\n-----------\nFeedback: " + a.getFeedback() + "\n---------------------");
                        }
                    }
                    System.out.println("Nota geral: " + i.getTotalRating());
                    break;
            }
        }
        System.out.println("------------------------------------------------------");
    }

    public static void removerItem(Estante estante) {
        System.out.println("------------------------------------------------------");
        if (estante.quantidadeItens() == 0) {
            System.out.println("A estante está vazia. Para adicionar um item à estante, digite 1 no menu!");
        } else {
            System.out.println("Qual posição deseja remover? ");
            Item i = estante.removerItem(in.nextInt());
            if (i == null) {
                System.out.println("A posição está vazia! Para consultar a lista de itens, digite 4 no menu!");
            } else {
                System.out.println("O item " + i.getTitulo() + " foi removido.");
            }
        }
        System.out.println("------------------------------------------------------");
    }

    public static void mostrarItens(Estante estante) {
        System.out.println("------------------------------------------------------");
        System.out.println("A estante tem " + estante.quantidadeItens() + " item(ns).");
        if (estante.estanteCheia()) {
            System.out.println("A estante está cheia!");
        }
        for (int j = 0; j < 5; j++) {

            Item itemf = estante.getItensEstante()[j];
            if (itemf != null) {
                System.out.println("---------------------------");
                itemf.mostrarItem();
                System.out.println("Posição na estante: " + j);
            }
        }
        System.out.println("------------------------------------------------------");
    }
}
