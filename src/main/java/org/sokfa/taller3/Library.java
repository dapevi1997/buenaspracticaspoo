package org.sokfa.taller3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Clase para crear y manejar la biblioteca de canciones.
 *
 * @version 1.0.0 2022-06-04
 *
 * @author DANIEL PEREZ VITOLA - dapevi97@gmail.com
 *
 * @since 1.0.1
 *
 */
public class Library {

    /**
     * Arreglo para almacenar los objetos de tipo Songs.
     */
    List<Songs> songs;
    /**
     * Atributo para manejar fechas.
     */
    Calendar date;

    /**
     * Constructor de la clase.
     */
    public Library() {
        songs = new ArrayList<>();
        songs.add(new Vallenato("1", "Mi primera cana",
                new GregorianCalendar(1993, Calendar.DECEMBER, 19), 4.20,
                "Título_de_amor.jpg", "Éxito nacional"));
        songs.add(new Vallenato("2", "Déjala",
                new GregorianCalendar(1993, Calendar.DECEMBER, 19), 5.00,
                "Título_de_amor.jpg", "Segundo éxito"));
        songs.add(new Salsa("3", "Tranquilo",
                new GregorianCalendar(1996, Calendar.JULY, 15), 4.35,
                "Tranquilo.jpg", "Lanzada como solista"));
        songs.add(new Salsa("4", "Obseción",
                new GregorianCalendar(1994, Calendar.DECEMBER, 30), 4.7,
                "Mirándote.jpg", "Rotundo éxito"));
        songs.add(new Merengue("5", "Te va a doler",
                new GregorianCalendar(2001, Calendar.JULY, 15), 4.35,
                "Vete_y_dile.jpg", "Lanzada como solista"));
        songs.add(new Merengue("6", "La quiero a morir",
                new GregorianCalendar(1986, Calendar.DECEMBER, 30), 5.07,
                "Mirándote.jpg", "Rotundo éxito"));
    }

    /**
     * Método para mostrar la biblioteca completa en consola.
     */
    public void showLibray() {
        for (int i = 0; i < songs.size(); i++) {
            
            System.out.println(songs.get(i));

        }

    }

}
