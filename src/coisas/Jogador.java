package coisas;

public class Jogador {
    private String nome;
    public char[][] tabuleiro;
    public int pontuacao;

    public Jogador(char[][] tabuleiro, int pontuacao) {
        this.tabuleiro = tabuleiro;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
