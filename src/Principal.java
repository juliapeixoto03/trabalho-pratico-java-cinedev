package cinedevsistema;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal que controla o menu do sistema CineDev.
 * Usa a classe Cinema para gerenciar a lógica de assentos.
 */
public class Principal{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        int opc;
        do {
            mostrarMenu();
            opc = lerInt("Escolha uma opção: ");
            switch (opc) {
                case 1:
                    cinema.mostrarMapa();
                    break;
                case 2:
                    comprar(cinema);
                    break;
                case 3:
                    cancelar(cinema);
                    break;
                case 4:
                    exibir(cinema);
                    break;
                case 5:
                    System.out.println("Encerrando. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opc != 5);
        scanner.close();
    }

    // Mostra o menu principal
    private static void mostrarMenu() {
        System.out.println("\n=== CineDev ===");
        System.out.println("1. Exibir Mapa de Assentos");
        System.out.println("2. Comprar Ingresso");
        System.out.println("3. Cancelar Compra de Ingresso");
        System.out.println("4. Exibir Relatório de Ocupação");
        System.out.println("5. Sair");
    }
}



