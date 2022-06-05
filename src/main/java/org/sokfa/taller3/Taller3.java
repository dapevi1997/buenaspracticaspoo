package org.sokfa.taller3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase contenedora del método main.
 *
 * @version 1.0.0 2022-06-04
 *
 * @author DANIEL PEREZ VITOLA - dapevi97@gmail.com
 *
 * @since 1.0.1
 *
 */
public class Taller3 {

    public static void main(String[] args) {
        /**
         * Instancia de la clase Scanner para manejar las entradas del usuario.
         */
        Scanner in = new Scanner(System.in);
        /**
         * Instancia de la clase Library para mostrar y manejar la biblioteca de
         * canciones.
         */
        Library library = new Library();

        /**
         * Variable para almacenar los arreglos retornados por algúnos métodos.
         */
        List<Songs> songs = new ArrayList<>();
        /**
         * Variable para almacenar la elección del usuario
         */
        int selected;
        /**
         * Bandera para salir de la apliación solo hasta que el usuario lo
         * decida.
         */
        boolean flag = true;
        /**
         * Ciclo while para hacer el bucle infinito hasta que el jugador decida.
         */
        do {

            library.showLibray();
            selected = library.chooseOption();
            /**
             * Estructura condicional para realizar comportamientos con la
             * biblioteca de canciones.
             */
            switch (selected) {
                case 1:
                    library.playList();
                    System.out.println("Pulse la tecla enter para continuar...");
                    in.nextLine();
                    break;

                case 2: {
                    library.filterByGender();
                    System.out.println("Pulse la tecla enter para continuar...");
                    in.nextLine();
                    break;
                }
                case 3: {
                    library.filterByYear();
                    System.out.println("Pulse la tecla enter para continuar...");
                    in.nextLine();
                    break;
                }
                case 4:

                    library.organizeByDuration("asc");
                    System.out.println("Pulse la tecla enter para continuar...");
                    in.nextLine();

                    break;
                case 5:
                    library.organizeByDuration("des");
                    System.out.println("Pulse la tecla enter para continuar...");
                    in.nextLine();
                    break;
                case 6:
                    library.organizeByDate("asc");
                    System.out.println("Pulse la tecla enter para continuar...");
                    in.nextLine();
                    break;
                case 7:
                    library.organizeByDate("des");
                    System.out.println("Pulse la tecla enter para continuar...");
                    in.nextLine();
                    break;
                case 8:
                    System.exit(0);
                default:
                    break;
            }
        } while (flag);

    }

}
