
package cinedevsistema;
    /**
 * Classe que representa a sala de cinema.
 * 
 * A sala é modelada como uma matriz bidimensional (10 x 20):
 * - Cada posição da matriz é um assento.
 * - 'L' significa Livre.
 * - 'X' significa Ocupado.
 * 
 * Métodos principais:
 * - mostrarMapa(): exibe todos os assentos com status.
 * - comprar(): marca um assento como ocupado.
 * - cancelar(): libera um assento.
 * - contarOcupados(): retorna a quantidade de assentos vendidos.
 */
public class Cinema {
    private final int linhas = 10;   // número de fileiras
    private final int colunas = 20;   // número de assentos por fileira
    private final char[][] lugar;  // matriz de assentos

    // inicializa todos os assentos como livres (L)
    public Cinema() {
        lugar = new char[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                lugar[i][j] = 'L'; // inicialemnte todos livres 
            }
        }
    }

    // Exibe o mapa de assentos para facilitar a escolha e visualização do usuário
    public void mostrarMapa() {
        System.out.print("    Assentos:");
        for (int j = 1; j <= colunas; j++) {
            System.out.printf("%3d", j);
        }
        System.out.println();
        for (int i = 0; i < linhas; i++) {
            System.out.printf("Fileira %2d:", i + 1);
            for (int j = 0; j < colunas; j++) {
                System.out.print("[" + lugar[i][j] + "]");
            }
            System.out.println();
        }
    }

    // Verifica se um assento é válido, retorna true se for valido, se não false
    public boolean évalido(int fila, int assento) {
        return fila >= 1 && fila <= linhas && assento >= 1 && assento <= colunas;
    }

    // Verifica se um assento está ocupado, mas primeiro garnte que ele é valido
    public boolean ocupado(int fila, int assento) {
        if (!évalido(fila, assento)) return false;
        return lugar[fila - 1][assento - 1] == 'X';
    }

    // Compra um ingresso (marca como X) retorna false se o acento ka estiver ocupado ou invalido
    public boolean comprar(int fila, int assento) {
        if (!évalido(fila, assento)) return false;
        if (ocupado(fila, assento)) return false;
        lugar[fila - 1][assento - 1] = 'X';
        return true;
    }

    // Cancela a compra (marca como L novamente), aó pode cancelar se o assento ja estava ocupado
    public boolean cancelar(int fila, int assento) {
        if (!évalido(fila, assento)) return false;
        if (!ocupado(fila, assento)) return false;
        lugar[fila - 1][assento - 1] = 'L';
        return true;
    }

    // Retorna o total de assentos da sala 
    public int totalAssentos() {
        return linhas * colunas;
    }

    // Conta quantos assentos estão ocupados no momento
    public int contarOcupados() {
        int ocupados = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (lugar[i][j] == 'X') ocupados++;
            }
        }
        return ocupados;
    }
}
