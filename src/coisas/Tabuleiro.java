package coisas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    /*
     * Um navio ocupando 4 espaços
     * Dois navios ocupando 3 espaços
     * Três navios ocupando 2 espaços
     * Quatro navios ocupando 1 espaço
     * */

    public static void preencherTabuleiroManual(char[][] tabuleiro) {
        //não sei se vai ser uma lista de navio, mas igual, pra cada navio que tiver, tem que perguntar onde colocar

        List<Integer> navios = new ArrayList<>();
        //aqui precisa ter os navios definidos pra colocar
        //criar um objeto Navio com o tamanho?

        for (Object navio : navios) {
            //aqui pergunta "onde colocar o navio..." e recebe as coordenadas

        }
    }

    public static void preencherTabuleiroAutomatico(char[][] tabuleiro) {
        Random random = new Random();
        List<Integer> navios = new ArrayList<>();
        //aqui precisa ter os navios definidos pra colocar
        for (Object navio : navios) {
            //
        }
    }
}
