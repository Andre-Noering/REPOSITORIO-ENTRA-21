import classes.ChecklistItem;
import classes.ListaTarefas;
import classes.Tarefa;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Qtd de tarefas: ");
        ListaTarefas lt=new ListaTarefas(in.nextInt());
        in.nextLine();
        System.out.println("Informe um nome para a lista de tarefas: ");
        lt.setNomeLista(in.nextLine());
        while (true){
            lt.adicionarTarefa(criarTarefa());
            System.out.println("Mais tarefas? (S/N):");
            String add=in.nextLine();
            if (add.equalsIgnoreCase("N")){
                break;
            }
        }
    }

    public static Tarefa criarTarefa() {
        Tarefa t = new Tarefa();
        System.out.println("Digite o nome da tarefa: ");
        t.setNome(in.nextLine());
        System.out.println("Digite a descrição da tarefa: ");
        t.setDescricao(in.nextLine());
        System.out.println("Digite a ordem da tarefa: ");
        t.setOrdem(in.nextInt());
        in.nextLine();
        System.out.println("Tarefa tem checklist? (S/N): ");
        String checklist = in.nextLine();
        if (checklist.equalsIgnoreCase("S")) {
            System.out.println("Tamanho da checklist: ");
            t.criarChecklist(in.nextInt());
            in.nextLine();
            while (true){
                ChecklistItem item=new ChecklistItem();
                System.out.println("Nome: ");
                item.setNome(in.nextLine());
                System.out.println("Descrição: ");
                item.setDescricao(in.nextLine());
                t.adicionarChecklistItem(item);

                System.out.println("Mais algum item? (S/N):");
                String add=in.nextLine();
                if (add.equalsIgnoreCase("N")){
                    break;
                }
            }
        }
        return t;

    }
}