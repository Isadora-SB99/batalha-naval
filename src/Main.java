import coisas.Jogador;

import java.util.Scanner;

import static coisas.Tabuleiro.*;

public class Main {

    public static final int TAM = 10;
    static Jogador jogador1 = new Jogador(new char[TAM][TAM], 0);
    static Jogador jogador2 = new Jogador(new char[TAM][TAM], 0);

    public static void regrasDoJogo(){
        System.out.println("\n~~~Bem-vindos ao jogo de batalha naval!~~~".toUpperCase());
        System.out.println("São dois jogadores (ou um jogador e o computador)");
        System.out.println("Cada jogador terá:\n" +
                "     * Um navio ocupando 4 espaços\n" +
                "     * Dois navios ocupando 3 espaços\n" +
                "     * Três navios ocupando 2 espaços\n" +
                "     * Quatro navios ocupando 1 espaço");
        System.out.println("Também é possível escolher se deseja inserir os barcos de forma manual ou de forma automática.");
        System.out.println("Tiros na água imprimem '*', tiros em navios imprimem o número da quantidade de posições do navio.");
        System.out.println("Vence quem afundar todos os navios do adversário primeiro.");
        System.out.println("Bom jogo e boa sorte!");
        System.out.print("Pressione qualquer tecla, depois 'ENTER' para continuar... ");
        new Scanner(System.in).next().charAt(0);
        System.out.println();
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

    public static char definirModoPreenchimento(Jogador jogador, Scanner read){
        char modoPreenchimento = '.';
        while (modoPreenchimento != 'M' && modoPreenchimento != 'A') {
            System.out.print(jogador.getNome()+", você deseja preencher o tabuleiro manualmente ou automaticamente (M - manual / A - automático): ");
            modoPreenchimento = read.next().toUpperCase().charAt(0);

            switch (modoPreenchimento) {
                case 'M':
                    preencherTabuleiroManual(jogador.tabuleiro);
                    break;
                case 'A':
                    preencherTabuleiroAutomatico(jogador.tabuleiro);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        return modoPreenchimento;
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
            definirModoPreenchimento(jogador1, read);
        }else{
            //pergunta pros dois jogadores se querem preencher automatico ou manual
            definirModoPreenchimento(jogador1, read);
            definirModoPreenchimento(jogador2, read);
        }


        System.out.println("tabuleiro "+jogador1.getNome());
        imprimirTabuleiro(jogador1.tabuleiro);

        System.out.println("tabuleiro "+jogador2.getNome());
        imprimirTabuleiro(jogador2.tabuleiro);
    }
}
