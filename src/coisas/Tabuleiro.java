package coisas;

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

    public static void preencherTabuleiroManual(char[][] tabuleiro) {
        //aqui precisa ter os navios definidos pra colocar
        for (int i=0; i< tabuleiro.length;i++){
            for (int j=0; j<tabuleiro[i].length;j++){
                //aqui pergunta "onde colocar o navio..." e recebe as coordenadas
//                System.out.print(" "+ tabuleiro[i][j]);
            }
            System.out.println();
        }
    }

    public static void preencherTabuleiroAutomatico(char[][] tabuleiro) {
        //aqui precisa ter os navios definidos pra colocar
        for (int i=0; i< tabuleiro.length;i++){
            for (int j=0; j<tabuleiro[i].length;j++){
                //aqui pergunta "onde colocar o navio..." e recebe as coordenadas
//                System.out.print(" "+ tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
}
