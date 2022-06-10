package classes;

import java.util.Scanner;

public abstract class Item {
    private String titulo;
    private String genero;
    private double valor;
    private Avaliacao[] avaliacoes=new Avaliacao[30];
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
        for (int i=0;i<getAvaliacoes().length;i++){
            if (getAvaliacoes()[i]==null){
                getAvaliacoes()[i]=a;
                break;
            }
        }
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Avaliacao[] getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Avaliacao[] avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
