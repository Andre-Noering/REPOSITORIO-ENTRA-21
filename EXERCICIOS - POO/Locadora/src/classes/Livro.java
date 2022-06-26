package classes;

import java.util.Scanner;

public class Livro extends Item implements Criavel{
    private String autor;
    private int qtdePaginas;
    private int anoPublicacao;
    private int edicao;

    //GETTERS E SETTERS


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQtdePaginas() {
        return qtdePaginas;
    }

    public void setQtdePaginas(int qtdePaginas) {
        this.qtdePaginas = qtdePaginas;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println(this.getTitulo() + "(" + this.getGenero() + "): " + this.getAnoPublicacao() + " - " + this.getAutor());
    }

    @Override
    public Item montarItem(Scanner in) {
        System.out.print("Digite o autor: ");
        this.setAutor(in.nextLine());
        System.out.print("Digite a quantidade de páginas: ");
        this.setQtdePaginas(in.nextInt());
        System.out.print("Digite o ano de publicação: ");
        this.setAnoPublicacao(in.nextInt());
        in.nextLine();
        System.out.print("Digite a edição do livro: ");
        this.setEdicao(in.nextInt());
        in.nextLine();
        return this;
    }
}
