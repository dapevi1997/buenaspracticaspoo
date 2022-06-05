package org.sokfa.taller3;

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
        
        System.out.println("************************************************");
        System.out.println("BIBLIOTECA DE CANCIONES");
        System.out.println("");
        library.showLibray();
        System.out.println("************************************************");

    }
}
