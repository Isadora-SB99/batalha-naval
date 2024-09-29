import coisas.Jogador;

import java.util.Random;
import java.util.Scanner;

import static coisas.Tabuleiro.*;

public class Main {

    public static final int TAM = 10;

    public static final int TIROS_NECESSARIOS_VENCER = 20;

    static Jogador jogador1 = new Jogador(new char[TAM][TAM], 0, 0);
    static Jogador jogador2 = new Jogador(new char[TAM][TAM], 0, 0);

    public static void regrasDoJogo() {
        System.out.println("\n~~~Bem-vindos ao jogo de batalha naval!~~~".toUpperCase());
        System.out.println("São dois jogadores (ou um jogador e o computador)");
        System.out.println("""
                Cada jogador terá:
                     * Um navio ocupando 4 espaços
                     * Dois navios ocupando 3 espaços
                     * Três navios ocupando 2 espaços
                     * Quatro navios ocupando 1 espaço""");
        System.out.println("É possível escolher se deseja inserir os navios de forma manual ou de forma automática.");
        System.out.println("Os jogadores se alternam em turnos, escolhendo uma posição para atirar no tabuleiro do adversário.");
        System.out.println("Tiros na água imprimem '*', tiros em navios imprimem 'X'.");
        System.out.println("Vence quem afundar todos os navios do adversário primeiro.");
        System.out.println("Bom jogo e boa sorte!");
        System.out.print("Pressione qualquer tecla, depois 'ENTER' para continuar... ");
        new Scanner(System.in).next();
        System.out.println();
    }

    public static void lerNomeJogador(Jogador jogador, int num) {
        System.out.print("Jogador " + num + ", digite seu nome: ");
        jogador.setNome(new Scanner(System.in).next());
    }

    public static char definirModoJogo(char modoJogo, Scanner read) {
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

    public static void definirModoPreenchimento(Jogador jogador, Scanner read) {
        char modoPreenchimento = '.';
        while (modoPreenchimento != 'M' && modoPreenchimento != 'A') {
            System.out.print(jogador.getNome() + ", você deseja preencher o tabuleiro manualmente ou automaticamente (M - manual / A - automático): ");
            modoPreenchimento = read.next().toUpperCase().charAt(0);

            switch (modoPreenchimento) {
                case 'M':
                    preencherTabuleiroManual(jogador);
                    break;
                case 'A':
                    preencherTabuleiroAutomatico(jogador);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void inicializarTabuleiros() {
        inicializarTabuleiro(jogador1.tabuleiroPreencher);
        inicializarTabuleiro(jogador2.tabuleiroPreencher);
    }


    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        char modoJogo = '.';

        regrasDoJogo();

        modoJogo = definirModoJogo(modoJogo, read);
        inicializarTabuleiros();

        if (modoJogo == 'C') {
            preencherTabuleiroAutomatico(jogador2);
            definirModoPreenchimento(jogador1, read);
        } else {
            definirModoPreenchimento(jogador1, read);
            definirModoPreenchimento(jogador2, read);
        }

        int jogadorAtual = 1;
        while (jogador1.tirosCerteiros < TIROS_NECESSARIOS_VENCER && jogador2.tirosCerteiros < TIROS_NECESSARIOS_VENCER) {

            if (jogadorAtual == 1) {
                System.out.println("\nVez de " + jogador1.getNome());
//                imprimirTabuleiroPreencher(jogador2.tabuleiroPreencher);//pra auxilio em debug
                imprimirTabuleiroJogar(jogador2.tabuleiroJogar);
                atirar(jogador1, jogador2);
                jogadorAtual = 2;
            } else {
                System.out.println("\nVez de " + jogador2.getNome());
//                imprimirTabuleiroPreencher(jogador1.tabuleiroPreencher);//pra auxilio em debug
                imprimirTabuleiroJogar(jogador1.tabuleiroJogar);
                if (jogador2.getNome().equals("Computador")) {
                    atirarComputador(jogador2, jogador1);
                } else {
                    atirar(jogador2, jogador1);
                }
                jogadorAtual = 1;
            }
        }

        imprimePontuacao();

        imprimeTabuleirosFinal();
    }

    private static void atirar(Jogador jogadorAtual, Jogador inimigo) {
        Scanner read = new Scanner(System.in);
        int linha = -1;
        char colunaChar = '.';

        while (linha < 0 || linha > 9) {
            System.out.print("linha (0-9): ");
            linha = read.nextInt();
        }
        while (colunaChar < 65 || colunaChar > 74) {
            System.out.print("coluna (A-" + (char) (74) + "): ");
            colunaChar = read.next().toUpperCase().charAt(0);
        }

        int coluna = converteColuna(colunaChar);

        if (inimigo.tabuleiroPreencher[linha][coluna] == '.' || inimigo.tabuleiroPreencher[linha][coluna] == '*') {
            System.out.println("Tiro na água!");
            inimigo.tabuleiroJogar[linha][coluna] = '*';
        } else {
            System.out.println("Tiro certeiro!");
            inimigo.tabuleiroJogar[linha][coluna] = 'X';
            jogadorAtual.tirosCerteiros++;
            jogadorAtual.pontuacao++;
        }
    }

    private static void atirarComputador(Jogador jogadorAtual, Jogador inimigo) {
        Random random = new Random();
        int linha = random.nextInt(0, 10);
        int coluna = random.nextInt(0, 10);

        if (inimigo.tabuleiroPreencher[linha][coluna] == '.' || inimigo.tabuleiroPreencher[linha][coluna] == '*') {
            System.out.println("Tiro na água!");
            inimigo.tabuleiroJogar[linha][coluna] = '*';
        } else {
            System.out.println("Tiro certeiro!");
            inimigo.tabuleiroJogar[linha][coluna] = 'X';
            jogadorAtual.tirosCerteiros++;
            jogadorAtual.pontuacao++;
        }
    }

    private static void imprimePontuacao(){
        System.out.println("\n\n~~~~Pontuação final~~~~".toUpperCase());
        System.out.println(jogador1.getNome() + ": " + jogador1.pontuacao);
        System.out.println(jogador2.getNome() + ": " + jogador2.pontuacao);
        if (jogador1.pontuacao > jogador2.pontuacao) {
            System.out.println(jogador1.getNome() + " venceu!");
        } else if (jogador2.pontuacao > jogador1.pontuacao) {
            System.out.println(jogador2.getNome() + " venceu!");
        }
    }

    public static void imprimeTabuleirosFinal() {
        System.out.println("\n\ntabuleiro "+jogador1.getNome());
        imprimirTabuleiroPreencher(jogador1.tabuleiroPreencher);
        imprimirTabuleiroJogar(jogador1.tabuleiroJogar);

        System.out.println("\n\ntabuleiro "+jogador2.getNome());
        imprimirTabuleiroPreencher(jogador2.tabuleiroPreencher);
        imprimirTabuleiroJogar(jogador2.tabuleiroJogar);
    }
}
