package classes;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Item implements Criavel {
    private String titulo;
    private String genero;
    private double valorVenda;
    private double valorLocacao;
    private boolean emprestado;
    private ArrayList<Avaliacao> avaliacoes;

    public void avaliar(){
        Scanner in=new Scanner(System.in);
        Avaliacao a=new Avaliacao();
        System.out.print("Informe seu nome: ");
        a.setNome(in.nextLine());
        System.out.print("Qual sua nota para o filme/livro: (0 a 5): ");
        a.setRating(in.nextDouble());
        in.nextLine();
        System.out.print("Digite seu feedback: ");
        a.setFeedback(in.nextLine());
        avaliacoes.add(a);
    }
    public double getTotalRating(){
        double totalRating=0.0;
        int qtdAvaliacoes=0;
        for (Avaliacao a:avaliacoes){
            if (a!=null){
                totalRating+=a.getRating();
                qtdAvaliacoes+=1;
            }
        }
        return totalRating/qtdAvaliacoes;
    }


    //GETTERS E SETTERS

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public Item montarItem(Scanner in) {
        System.out.print("Digite o título: ");
        this.setTitulo(in.nextLine());
        System.out.print("Digite o gênero: ");
        this.setGenero(in.nextLine());
        System.out.print("Digite o valor de locação: R$");
        this.setValorLocacao(in.nextDouble());
        in.nextLine();
        System.out.print("Digite o valor de venda: R$");
        this.setValorVenda(in.nextDouble());
        in.nextLine();
        return this;
    }

    @Override
    public void mostrarDetalhes() {

    }
}
