import coisas.Jogador;

import java.util.Scanner;

import static coisas.Tabuleiro.*;

public class Main {

    public static final int TAM = 10;
    static Jogador jogador1 = new Jogador(new char[TAM][TAM], 0);
    static Jogador jogador2 = new Jogador(new char[TAM][TAM], 0);

    public static void regrasDoJogo(){
        //imprimir regras/instruções pro jogador
    }

    public static void lerNomeJogador(Jogador jogador, int num){
        System.out.print("Jogador "+num+", digite seu nome: ");
        jogador.setNome(new Scanner(System.in).next());
    }

    public static char definirModoJogo(char modoJogo, Scanner read){
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
        return modoJogo;
    }

    public static void inicializarTabuleiros(){
        inicializarTabuleiro(jogador1.tabuleiro);
        inicializarTabuleiro(jogador2.tabuleiro);
    }


    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        char modoJogo = '.';

        regrasDoJogo();

        modoJogo = definirModoJogo(modoJogo, read);
        inicializarTabuleiros();

        if (modoJogo == 'C'){
            preencherTabuleiroAutomatico(jogador2.tabuleiro);
            //aqui pergunta se jogador 1 quer preencher automatico ou manual
        }else{
            //pergunta pros dois jogadores se querem preencher automatico ou manual
        }


        System.out.println("tabuleiro "+jogador1.getNome());
        imprimirTabuleiro(jogador1.tabuleiro);

        System.out.println("tabuleiro "+jogador2.getNome());
        imprimirTabuleiro(jogador2.tabuleiro);
    }
}
