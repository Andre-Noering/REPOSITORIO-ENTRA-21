package classes;

import java.util.UUID;

public class Tarefa {
    private String uuid;
    private String nome;
    private String descricao;
    private boolean completa;
    private int ordem;



    private ChecklistItem[] checklist;

    public void criarTarefa() {
        this.setUuid(UUID.randomUUID().toString());
    }

    public void completar() {
        this.setCompleta(true);
        for(ChecklistItem item:this.getChecklist()){
            if (item!=null){
                item.completar();
            }
        }
    }

    public boolean adicionarChecklistItem(ChecklistItem item) {
        for (int i = 0; i < this.getChecklist().length; i++) {
            if (this.getChecklist()[i] == null) {
                this.getChecklist()[i] = item;
                return true;
            }
        }
        return false;
    }

    public boolean temChecklist() {
        return checklist != null;
    }

    public void criarChecklist(int tamanho) {
        this.setChecklist(new ChecklistItem[tamanho]);
    }
    //SETTERS E GETTERS


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public ChecklistItem[] getChecklist() {
        return checklist;
    }

    public void setChecklist(ChecklistItem[] checklist) {
        this.checklist = checklist;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
}
