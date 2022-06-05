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
         * Variable para almacenar la elección del usuario
         */
        int selected;
        /**
         * Variable para almacenar los arreglos retornados por algúnos métodos.
         */
        List<Songs> songs;

        library.showLibray();
        selected = library.chooseOption();
        if (selected == 1) {

            /**
             * Variable para almacenar la entrada del usuario.
             */
            String ids;
            System.out.println("-----------------------------------------------");
            System.out.println("Escoja las canciones escbriendo el id separado "
                    + "por comas. Ej (1,2)");
            ids = in.next();
            songs = library.playList(ids);

            System.out.println("Esta es su playlist:");
            System.out.println("");
            library.showLibray(songs);
            System.out.println("-----------------------------------------------");
        } else if (selected == 2) {
            int selection;
            String gender = "";
            songs = library.getSongs();
            System.out.println("-----------------------------------------------");
            System.out.println("Escoja el género por el que desea filtrar");
            System.out.println(" 1. Vallenato");
            System.out.println(" 2. Salsa");
            System.out.println(" 3. Merengue");
            selection = in.nextInt();
            if (selection == 1) {
                gender = "Vallenato";
            } else if (selection == 2) {
                gender = "Salsa";

            } else if (selection == 3) {
                gender = "Merengue";
            }
            songs = library.filter(songs, gender);
            library.showLibray(songs);

        } else if (selected == 3) {
            int selection;
            songs = library.getSongs();
            System.out.println("-----------------------------------------------");
            System.out.println("Año por el que desea filtrar: ");
            selection = in.nextInt();
            songs = library.filter(songs, selection);
            library.showLibray(songs);

        } else if (selected == 4) {
            songs = library.getSongs();
            songs = library.organizeByDuration(songs);
            library.showLibray(songs);

        } else if (selected == 5) {
            songs = library.getSongs();
            songs = library.organizeByDuration(songs);
            library.showLibrayDes(songs);

        } else if (selected == 6) {
            songs = library.getSongs();
            songs = library.organizeByDate(songs);
            library.showLibray(songs);

        } else if (selected == 7) {
            songs = library.getSongs();
            songs = library.organizeByDate(songs);
            library.showLibrayDes(songs);

        }

    }

}
