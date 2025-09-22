
package cinedevsistema;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal que controla o menu do sistema CineDev.
 * Usa a classe Cinema para gerenciar a lógica de assentos.
 */
public class Principalcinedev{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //cria uma instancia de sala de cinema 
        Cinema cinema = new Cinema();
        int opc; //variavel que guarda a opção escolhida pelo usuário 
        
        //mantém o menu rodando até o usuário escolher sair 
        do {
            mostrarMenu(); //Mostra o menu de opções
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
                    System.out.println("Encerrando. Obrigada!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opc != 5);
    }

    // Mostra o menu principal com as opções 
    private static void mostrarMenu() {
        System.out.println("\n=== CineDev ===");
        System.out.println("1. Exibir Mapa de Assentos");
        System.out.println("2. Comprar Ingresso");
        System.out.println("3. Cancelar Compra de Ingresso");
        System.out.println("4. Exibir Relatório de Ocupação");
        System.out.println("5. Sair");
    }
    
     // Lê um inteiro de forma segura, caso o usuário digite digite algo errado ai entra a classe inputmismatchexception
    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return scanner.nextInt(); //tentar ler um inteiro 
            } catch (InputMismatchException e) { //try-catch usada para lidar com exceções que acontecem durante a execução do código
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    // Comprar ingresso, pede o usuário o assento e verifica se é valido ou esta ocupado
    private static void comprar(Cinema cinema) {
        int fila = lerInt("Digite a fileira (1-10): ");
        int assento = lerInt("Digite o assento (1-20): ");
        if (cinema.comprar(fila, assento)) {
            System.out.println("Ingresso comprado com sucesso!");
        } else {
            System.out.println("Erro: assento inválido ou já ocupado.");
        }
    }
     // cancelar ingresso, pede a fileira e o assento e libera se o ingresso ja estava ocupado
    private static void cancelar(Cinema cinema) {
        int fila = lerInt("Digite a fileira (1-10): ");
        int assento = lerInt("Digite o assento (1-20): ");
        if (cinema.cancelar(fila, assento)) {
            System.out.println("Compra cancelada com sucesso!");
        } else {
            System.out.println("Erro: assento inválido ou já estava livre.");
        }
    }

}

