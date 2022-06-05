package org.sokfa.taller3;

import java.util.Calendar;
import java.util.Objects;

/**
 * Clase padre para la creación de canciones.
 *
 * @version 1.0.0 2022-06-04
 *
 * @author DANIEL PEREZ VITOLA - dapevi97@gmail.com
 *
 * @since 1.0.1
 *
 */
public class Songs {

    /**
     * Representa la fecha en que fue lanzada la canción.
     */
    private Calendar date;
    /**
     * Representa el id único de cada canción.
     */
    private String id;
    /**
     * Representa el título de la canción.
     */
    private String title;
    /**
     * Representa la duración de la canción.
     */
    private double duration;
    /**
     * Representa el género de la canción.
     */
    private String gender;
    /**
     * Representa el nombre de la imagen de la portada del disco.
     */
    private String cover;
    /**
     * Representa una corta descripción de la canción.
     */
    private String description;

    /**
     * Constructor de la clase padre.
     *
     * @param date Feha de lanzamiento de la canción.
     * @param id Id de la canción.
     * @param title Título de la canción.
     * @param duration Duración de la canción.
     * @param cover Nombre de la imagen de la carátula del album.
     * @param description Descripción de la canción.
     */
    public Songs(String id, String title, Calendar date, double duration,
            String cover, String description) {
        this.date = Objects.requireNonNull(date);
        this.id = Objects.requireNonNull(id);
        this.title = Objects.requireNonNull(title);
        this.duration = Objects.requireNonNull(duration);
        this.cover = Objects.requireNonNull(cover);
        this.description = Objects.requireNonNull(description);
    }

    /**
     * Método para obtener la fecha de una canción.
     *
     * @return Fecha de lanzamiento de la canción.
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Método para obtener el id de una canción.
     *
     * @return Id de la canción.
     */
    public String getId() {
        return id;
    }

    /**
     * Método para obtener la duración en minutos de una canción.
     *
     * @return Duración de la canción.
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Método para obtener el género de una canción.
     *
     * @return Género de la canción.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Método para modificar el atributo genero.
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sobreescritura del método toString para mostrar información de la
     * canción.
     *
     * @return Cadena de texto de información acerca de la canción.
     */
    @Override
    public String toString() {
        return "ID: " + id + " "
                + "Título: " + title + " "
                + "Género: " + gender + " "
                + "Fecha: " + (date.get(Calendar.YEAR)) + "/"
                + (date.get(Calendar.MONTH) + 1) + "/"
                + date.get(Calendar.DAY_OF_MONTH) + " "
                + "Duración: " + duration + " "
                + "Carátula: " + cover + " "
                + "Descripción: " + description;
    }

}
