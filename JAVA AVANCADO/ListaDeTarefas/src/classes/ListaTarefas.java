package classes;

import java.util.Arrays;

public class ListaTarefas {
    private int tamanhoLista;
    private String nomeLista;
    private Tarefa[] ListaTarefas;

    public ListaTarefas(int tamanhoLista) {
        this.setTamanhoLista(tamanhoLista);
        this.setListaTarefas(new Tarefa[tamanhoLista]);
    }

    public boolean adicionarTarefa(Tarefa tarefa) {
        if (tarefa.getOrdem() < 0 || tarefa.getOrdem() >= this.getTamanhoLista()) {
            return false;
        }
        for (int i = 0; i < this.getTamanhoLista(); i++) {
            if (this.ListaTarefas[i] == null) {
                this.ListaTarefas[i] = tarefa;
                return true;
            } else if (this.ListaTarefas[i].getOrdem() == tarefa.getOrdem()) {
                break;
            }
        }
        return false;
    }

    public Tarefa buscarTarefa(int ordem) {
        for (Tarefa t : this.ListaTarefas) {
            if (t != null && t.getOrdem() == ordem) {
                return t;
            }
        }
        return null;
    }

    public boolean alterarOrdemTarefa(int ordemAntiga, int ordemDesejada) {

        Tarefa escolhida = this.buscarTarefa(ordemAntiga);
        Tarefa afetada = this.buscarTarefa(ordemDesejada);
        if (escolhida == null || afetada == null) {
            return false;
        }
        escolhida.setOrdem(ordemDesejada);
        afetada.setOrdem(ordemAntiga);
        return true;
    }


    public Tarefa[] getListaTarefas() {
        return ListaTarefas;
    }

    public int getTamanhoLista() {
        return tamanhoLista;
    }

    public void setTamanhoLista(int tamanhoLista) {
        this.tamanhoLista = tamanhoLista;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public void setListaTarefas(Tarefa[] listaTarefas) {
        ListaTarefas = listaTarefas;
    }
}