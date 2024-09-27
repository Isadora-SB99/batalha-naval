package coisas;

public class Tabuleiro {

    public static void inicializarTabuleiro(char[][] tabuleiro){
        for (int i=0; i< tabuleiro.length;i++){
            for (int j=0; j<tabuleiro[i].length;j++){
                tabuleiro[i][j] = '.';
            }
        }
    }

    public static void imprimirTabuleiro(char[][] tabuleiro){
        for (int i=0; i< tabuleiro.length;i++){
            for (int j=0; j<tabuleiro[i].length;j++){
                System.out.print(" "+ tabuleiro[i][j]+" ");
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
