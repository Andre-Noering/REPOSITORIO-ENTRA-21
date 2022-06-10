import classes.*;

import java.util.Scanner;


public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Estante estante = new Estante(5);
        System.out.printf("Você deseja adicionar um item na estante ou avaliar um item?\n(1 - Adicionar | 2 - Avaliar | 3 - Parar): ");
        int opcao = in.nextInt();
        while (true) {
            if (opcao == 3) {
                break;
            }
            in.nextLine();
            switch (opcao) {
                case 1:
                    estante.adicionarItem(mainCadastraItem());
                    break;
                case 2:
                    System.out.println("Digite o título (ou parte dele) do item que você deseja avaliar: ");
                    Item avaliado = estante.buscarItem(in.nextLine());
                    if (avaliado != null) {
                        avaliado.avaliar();
                    }
            }
            System.out.println("A estante tem " + estante.quantidadeItens() + " itens.");
            if (estante.estanteCheia()){
                System.out.println("A estante está cheia!");
            }
            for (int j = 0; j < 5; j++) {
                Item itemf = estante.getItensEstante()[j];
                if (itemf != null) {
                    if (itemf instanceof Livro) {
                        System.out.println(itemf.getTitulo() + "(" + itemf.getGenero() + "): " + ((Livro) itemf).getAnoPublicacao() + " - " + ((Livro) itemf).getAutor());
                    } else {
                        System.out.println(itemf.getTitulo() + "(" + itemf.getGenero() + "): " + ((DVD) itemf).getAnoLancamento() + " - " + ((DVD) itemf).getDiretor());
                    }

                    System.out.println("Posição na estante: " + j);
                }
            }

        }
    }

    public static Item mainCadastraItem() {
        Item item = null;
        System.out.println("Digite o tipo de item (1-Livro/2-DVD):");
        int tipo = in.nextInt();
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
        System.out.println("Digite o título: ");
        item.setTitulo(in.nextLine());
        System.out.println("Digite o gênero: ");
        item.setGenero(in.nextLine());
        System.out.println("Digite o valor: ");
        item.setValor(in.nextDouble());
        if (item instanceof Livro) {
            Livro lItem = ((Livro) item);
            System.out.println("Digite o autor: ");
            lItem.setAutor(in.nextLine());
            System.out.println("Digite a quantidade de páginas: ");
            lItem.setQtdePaginas(in.nextInt());
            System.out.println("Digite o ano de publicação: ");
            lItem.setAnoPublicacao(in.nextInt());
            in.nextLine();
            System.out.println("Digite a edição do livro: ");
            lItem.setEdicao(in.nextInt());
            in.nextLine();
        } else {
            DVD dItem = ((DVD) item);
            System.out.println("Digite o diretor do filme: ");
            dItem.setDiretor(in.nextLine());
            System.out.println("Digite a duração do filme: ");
            dItem.setDuracao(in.nextDouble());
            in.nextLine();
            System.out.println("Digite o ano de lançamento do filme: ");
            dItem.setAnoLancamento(in.nextInt());
            in.nextLine();
        }
        return item;
    }

}

