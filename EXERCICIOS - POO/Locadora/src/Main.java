import classes.*;

import java.util.Scanner;


public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Loja locadora = new Loja();
        boolean loop = true;
        while (loop) {
            EMenu opcao = (EMenu) escolherOpcao(null);
            switch (opcao) {
                case SAIR -> loop = false;
                case ADICIONAR_ITEM -> adicionarItem(locadora);
                case BUSCAR_ITEM -> buscarItemETratarRetorno(locadora);
                case REMOVER_ITEM -> removerItem(locadora);
                case MOSTRAR_ITENS -> mostarItens(locadora);
                case ADICIONAR_ESTANTE -> adicionarEstante(locadora);
                default -> System.out.println("Opção não implementada!");
            }
        }
        System.out.println("Programa finalizado!");
    }

    public static IMenu escolherOpcao(Item item) {
        IMenu escolha = null;
        while (escolha == null) {
            if (item != null) {
                while (escolha == null) {
                    System.out.println(item.getTitulo() + " encontrado! Ações disponíveis: ");
                    for (EMenuItem i : EMenuItem.values()) {
                        System.out.printf("(%d) %s\n", i.getValorOpcao(), i.getDescricao());
                    }
                    escolha = EMenuItem.getByValorOpcao(in.nextInt());
                    if (escolha == null) {
                        System.err.println("Selecione uma opção válida");
                    }
                }
            } else {
                System.out.println("Selecione uma opção");
                for (EMenu menu : EMenu.values()) {
                    System.out.printf("(%d) - %s\n", menu.getValorOpcao(), menu.getDescricao());
                }
                escolha = EMenu.getByValorOpcao(in.nextInt());
            }
            in.nextLine();
            if (escolha == null) {
                System.err.println("Selecione uma opção válida!");
            }
        }
        return escolha;
    }

    // Adicionar item na estante
    public static void adicionarItem(Loja l) {
        System.out.println("Informe a estante em que o item será adicionado: ");
        String nmEstante = in.nextLine();
        Estante e = l.getEstantes().get(nmEstante);
        if (e == null) {
            System.out.println("Estante não encontrada.");
        } else {
            if (e.estanteCheia()) {
                System.err.println("Sua estante está cheia! Não é possível adicionar mais itens!");
            } else {
                Item i = null;
                int escolha = -1;
                while (escolha < 0 || escolha > 1) {
                    System.out.print("Informe o item que deseja adicionar (0 - Livro / 1 - DVD): ");
                    escolha = in.nextInt();
                    if (escolha < 0 || escolha > 1) {
                        System.err.println("Selecione uma opção válida");
                    }
                }
                in.nextLine();
                if (escolha == 0) {
                    i = new Livro();
                } else {
                    i = new DVD();
                }
                System.out.print("Informe o título: ");
                i.setTitulo(in.nextLine());
                System.out.print("Informe o gênero: ");
                i.setGenero(in.nextLine());
                System.out.print("informe o valor: R$");
                i.setValor(in.nextDouble());
                in.nextLine();
                i.montarDetalhes(in);
                if (!e.adicionarItem(i)) {
                    System.err.println("Não foi possível adicionar o item na estante!");
                } else {
                    System.out.println("Item adicionado com sucesso!");
                }
            }
        }
    }

    public static void buscarItemETratarRetorno(Loja l) {
        System.out.print("Informe o título para busca: ");
        String item = in.nextLine();
        for (String t : l.getEstantes().keySet()) {
            Estante e = l.getEstantes().get(t);
            Item i = e.buscarItem(item);
            if (i == null) {
                continue;
            } else {
                System.out.printf("Item encontrado na estante: %s", i.getTitulo());
                EMenuItem escolha = (EMenuItem) escolherOpcao(i);
                switch (escolha) {
                    case VOLTAR -> System.out.println("Retornando...");
                    case VER_AVALIACOES -> mostarAvaliacoes(i);
                    case AVALIAR_ITEM -> i.avaliar();
                    case MOSTRAR_DETALHES -> {
                        System.out.println("Título: " + i.getTitulo());
                        System.out.println("Gênero: " + i.getGenero());
                        i.mostrarDetalhes();
                        System.out.printf("Valor: R$%.2f\n", i.getValor());
                    }
                    default -> System.out.println("Não implementado!");
                }
            }
        }
    }

    public static void mostarAvaliacoes(Item i) {
        i.getAvaliacoes().forEach(a -> {
            System.out.println("Autor: " + a.getNome());
            System.out.println("Avaliação: " + a.getRating());
            System.out.println("Comentário: ");
            System.out.println(a.getFeedback());
            System.out.println("--------------------");
        });
        System.out.println("Classificação final: " + i.getTotalRating());
    }

    public static void removerItem(Loja l) {
        System.out.println("Informe a estante da qual você deseja remover o item: ");
        String estante = in.nextLine().toLowerCase();
        if (!l.getEstantes().containsKey(estante)) {
            System.out.println("Nenhuma estante encontrada!");
        } else {
            Estante e = l.getEstantes().get(estante);
            if (e.quantidadeItens() == 0) {
                System.err.println("Não é possível remover itens de uma estante vazia!");
            } else {
                int posicao = -1;
                while (posicao < 0 || posicao > e.quantidadeItens()) {
                    System.out.print("Informe a posição do item para remover: ");
                    posicao = in.nextInt();
                    if (posicao < 0 || posicao > e.quantidadeItens()) {
                        System.err.println("Selecione uma opção válida!");
                    }
                }
                in.nextLine();
                Item i = e.removerItem(posicao);
                System.out.println("Item " + i.getTitulo() + " removido!");
            }
        }
    }

    public static void mostarItens(Loja l) {
        for (String t : l.getEstantes().keySet()) {
            System.out.printf("ESTANTE: %s\n", t.toUpperCase());
            Estante e = l.getEstantes().get(t);
            if (e.quantidadeItens() == 0) {
                System.out.println("Estante vazia!");
            } else {
                for (int i = 0; i < e.quantidadeItens(); i++) {
                    Item item = e.getItens().get(i);
                    System.out.println("[" + i + "] " + item.getTitulo().toUpperCase() + " (" + item.getGenero().toUpperCase() + ")");
                }
            }
            System.out.println("------------");
        }
    }

    public static void adicionarEstante(Loja l) {
        while (true) {
            System.out.print("Informe o gênero da estante: ");
            String t = in.nextLine().toLowerCase();
            if (l.getEstantes().containsKey(t)) {
                System.out.println("Já existe uma estante desse gênero!");
            } else {
                System.out.println("Informe a capacidade máxima de itens dessa estante: ");
                int c = in.nextInt();
                in.nextLine();
                Estante e = new Estante(c);
                l.getEstantes().put(t, e);
                break;
            }
        }
    }
}
