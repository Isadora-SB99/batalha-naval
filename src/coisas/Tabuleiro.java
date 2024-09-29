package coisas;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

    public static char[] coordenadaLetras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int l = 0; l < tabuleiro.length; l++) {
            for (int c = 0; c < tabuleiro[l].length; c++) {
                tabuleiro[l][c] = '.';
            }
        }
    }

    public static void imprimeCoordenadaLetras() {
        System.out.print("  ");
        for (char letra : coordenadaLetras) {
            System.out.print(" " + letra + " ");
        }
        System.out.println();
    }

    public static void imprimirTabuleiro(char[][] tabuleiro) {
        imprimeCoordenadaLetras();
        for (int l = 0; l < tabuleiro.length; l++) {
            System.out.print((l) + " ");
            for (int c = 0; c < tabuleiro[l].length; c++) {
                System.out.print(" " + tabuleiro[l][c] + " ");
            }
            System.out.println();
        }
    }

    public static boolean posicionarNavio(char[][] tabuleiro, Integer navio, char orientacao, int linha, int coluna) {
        for (int i = 0; i < navio; i++) {
            if (orientacao == 'H') {
                if (tabuleiro[linha][coluna + i] == '.') {
                    tabuleiro[linha][coluna + i] = navio.toString().charAt(0);
                } else {
                    for (int j = navio; j > 0; j--) {
                        if (tabuleiro[linha][coluna + j] != '.' && tabuleiro[linha][coluna + j] != navio.toString().charAt(0)){
                            //ainda não tá perfeito, mas já tá melhor
                            continue;
                        }
                        tabuleiro[linha][coluna + j] = '.';
                    }
                    return false;
                }
            } else {
                if (tabuleiro[linha + i][coluna] == '.') {
                    tabuleiro[linha + i][coluna] = navio.toString().charAt(0);
                } else {
                    for (int j = navio; j > 0; j--) {
                        if (tabuleiro[linha + j][coluna] != '.' && tabuleiro[linha + j][coluna] != navio.toString().charAt(0)) {
                            //ainda não tá perfeito, mas já tá melhor
                            continue;
                        }
                        tabuleiro[linha + j][coluna] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void preencherTabuleiroManual(char[][] tabuleiro) {
        Scanner read = new Scanner(System.in);
        int[] navios = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};

        imprimirTabuleiro(tabuleiro);

        for (Integer navio : navios) {
            char orientacao = '.';
            int linha = -1;
            char colunaChar = '0';

            while (orientacao != 'H' && orientacao != 'V') {
                System.out.print("Em qual sentido deseja posicionar o navio de " + navio + " posições? (H - horizontal / V - vertical) ");
                orientacao = read.next().toUpperCase().charAt(0);
            }

            System.out.println("Informe a posição inicial do navio:");
            if (orientacao == 'H') {
                while (linha < 0 || linha > 9) {
                    System.out.print("linha (0-9): ");
                    linha = read.nextInt();
                }
                while (colunaChar < 65 || colunaChar > 75 - navio) {
                    System.out.print("coluna (A-" + (char) (75 - navio) + "): ");
                    colunaChar = read.next().toUpperCase().charAt(0);
                }
            } else {
                while (linha < 0 || linha > 10 - navio) {
                    System.out.print("linha (0-" + (10 - navio) + "): ");
                    linha = read.nextInt();
                }
                while (!(colunaChar > 65) || colunaChar > 75) {
                    System.out.print("coluna (A-J): ");
                    colunaChar = read.next().toUpperCase().charAt(0);
                }
            }

                int coluna = converteColuna(colunaChar);

                posicionado = posicionarNavio(tabuleiro, navio, orientacao, linha, coluna);
                if (!posicionado) {
                    System.out.println("Posição inválida, tente novamente.");

                }
            }
            imprimirTabuleiro(tabuleiro);
        }
    }

    public static void preencherTabuleiroAutomatico(char[][] tabuleiro) {
        Random random = new Random();

        int[] navios = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};

        for (Integer navio : navios) {
            char orientacao = random.nextBoolean() ? 'H' : 'V';
            int linha = random.nextInt(0, orientacao == 'H' ? 10 : 10 - navio);
            int coluna = random.nextInt(0, orientacao == 'H' ? 10 - navio : 10);

                posicionado = posicionarNavio(jogador.tabuleiro, navio, orientacao, linha, coluna);
            }


        }


    }

    private static int converteColuna(char colunaChar) {
        for (int i = 0; i < coordenadaLetras.length; i++) {
            if (colunaChar == coordenadaLetras[i]) {
                return i;
            }
        }
        throw new RuntimeException("coluna inválida");
    }
}
