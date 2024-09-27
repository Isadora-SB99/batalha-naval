import coisas.Jogador;

import java.util.Scanner;

import static coisas.Tabuleiro.imprimirTabuleiro;
import static coisas.Tabuleiro.inicializarTabuleiro;

public class Main {

    static Jogador jogador1 = new Jogador(new char[10][10], 0);
    static Jogador jogador2 = new Jogador(new char[10][10], 0);

    public static void lerNomeJogador(Jogador jogador, int num){
        System.out.print("Jogador "+num+", digite seu nome: ");
        jogador.setNome(new Scanner(System.in).next());
    }


    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        char modoJogo = '.';

        while (modoJogo != 'P' && modoJogo != 'C') {
            System.out.print("Deseja jogar contra outra pessoa ou contra o computador (P - pessoa / C - computador): ");
            modoJogo = read.next().toUpperCase().charAt(0);

            switch (modoJogo) {
                case 'C':
                    lerNomeJogador(jogador1, 1);
                    jogador2.setNome("Computador");
                    break;
                case 'P':
                    lerNomeJogador(jogador1, 1);
                    lerNomeJogador(jogador2, 2);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }


        System.out.println("tabuleiro "+jogador1.getNome());
        inicializarTabuleiro(jogador1.tabuleiro);
        imprimirTabuleiro(jogador1.tabuleiro);

        System.out.println("tabuleiro "+jogador2.getNome());
        inicializarTabuleiro(jogador2.tabuleiro);
        imprimirTabuleiro(jogador2.tabuleiro);
    }
}
