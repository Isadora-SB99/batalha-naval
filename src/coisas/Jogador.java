package coisas;

public class Jogador {
    private String nome;
    public char[][] tabuleiroPreencher;
    public char[][] tabuleiroJogar;

    public int tirosCerteiros;
    public int pontuacao;

    public Jogador() {
    }

    public Jogador(char[][] tabuleiro, int tirosCerteiros, int pontuacao) {
        this.tabuleiroPreencher = tabuleiro;
        this.tirosCerteiros = tirosCerteiros;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
