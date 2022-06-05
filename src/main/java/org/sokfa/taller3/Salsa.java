package org.sokfa.taller3;

import java.util.Calendar;

/**
 * Clase para crear canciones de género Salsa.
 *
 * @version 1.0.0 2022-06-04
 *
 * @author DANIEL PEREZ VITOLA - dapevi97@gmail.com
 *
 * @since 1.0.1
 *
 */
public class Salsa extends Songs {

    /**
     * Constructor de la clase.
     *
     * @param id Id de la canción.
     * @param title Título de la canción.
     * @param date Fecha de la canción.
     * @param duration Duración de la canción.
     * @param cover Nombre la imagen de la portada.
     * @param description Descripción de la canción.
     */
    public Salsa(String id, String title, Calendar date, double duration, String cover, String description) {
        super(id, title, date, duration, cover, description);
        super.setGender("Salsa");
    }
}
