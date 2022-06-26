package classes;

import java.util.Scanner;

public class DVD extends Item{
    private String diretor;
    private double duracao;
    private int anoLancamento;


    //GETTERS E SETTERS


    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println(this.getTitulo() + "(" + this.getGenero() + "): " + this.getAnoLancamento() + " - " + this.getDiretor());
    }
    public Item montarItem(Scanner in){
        System.out.print("Digite o diretor do filme: ");
        this.setDiretor(in.nextLine());
        System.out.print("Digite a duração do filme: ");
        this.setDuracao(in.nextDouble());
        in.nextLine();
        System.out.print("Digite o ano de lançamento do filme: ");
        this.setAnoLancamento(in.nextInt());
        in.nextLine();
        return this;
    }
}
