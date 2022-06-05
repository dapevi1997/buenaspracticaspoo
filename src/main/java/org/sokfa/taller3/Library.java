package org.sokfa.taller3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public List<Songs> getSongs() {
        return songs;
    }

    /**
     * Método para mostrar la biblioteca completa en consola.
     */
    public void showLibray() {
        System.out.println("************************************************");
        System.out.println("BIBLIOTECA DE CANCIONES");
        System.out.println("");
        for (int i = 0; i < songs.size(); i++) {

            System.out.println(songs.get(i));

        }
        System.out.println("************************************************");

    }

    /**
     * Método para mostrar canciones almacenadas en un arreglo de tipo Songs.
     *
     * @param songs Arreglo a mostrar.
     */
    public void showLibray(List<Songs> songs) {
        for (int i = 0; i < songs.size(); i++) {
            System.out.println(songs.get(i));

        }

    }

    /**
     * Método para mostrar una lista en forma descendente.
     *
     * @param songs Arreglo de canciones a mostrar.
     */
    public void showLibrayDes(List<Songs> songs) {
        for (int i = songs.size() - 1; i >= 0; i--) {
            System.out.println(songs.get(i));

        }

    }

    /**
     * Método para pedir y retornar la selección del usuario.
     *
     * @return Selección del usuario.
     */
    public int chooseOption() {

        Scanner in = new Scanner(System.in);
        int selection;

        System.out.println("Escoja una opción: ");
        System.out.println("");
        System.out.println(" 1. Crear playlist");
        System.out.println(" 2. Filtrar por género");
        System.out.println(" 3. Filtrar por año");
        System.out.println(" 4. Ordenar por duración (ascendente)");
        System.out.println(" 5. Ordenar por duración (descendente)");
        System.out.println(" 6. Ordenar por fecha (ascendente)");
        System.out.println(" 7. Ordenar por fecha (descendente)");
        selection = in.nextInt();

        return selection;

    }

    /**
     * Método para crear una playlist.
     *
     * @param pchoises Cadena de texto que contiene el id de cada canción
     * escogida separadas por una coma.
     * @return Arreglo con las canciones seleccionadas por el usuario.
     */
    public List<Songs> playList(String pchoises) {
        List<Songs> songs = new ArrayList<>();
        String[] split = pchoises.split(",", -1);

        for (int i = 0; i < this.songs.size(); i++) {

            for (String split1 : split) {
                if (split1.equals(this.songs.get(i).getId())) {
                    songs.add(this.songs.get(i));
                    break;
                }
            }

        }
        return songs;
    }

    /**
     * Método para filtrar por género.
     *
     * @param songs Arreglo con las canciones a filrar.
     * @param gender Género a filtrar.
     * @return Arreglo con las canciones filtradas.
     */
    public List<Songs> filter(List<Songs> songs, String gender) {
        //controlar excepción de género
        return songs.stream().filter(x -> x.getGender().equals(gender)).collect(Collectors.toList());

    }

    /**
     * Método para filtrar por año.
     *
     * @param songs Arreglo de canciones a filtrar.
     * @param año Año por el que desea filtrar.
     * @return Arreglo con canciones filtradas.
     */
    public List<Songs> filter(List<Songs> songs, int año) {
        //controlar excepción de año
        return songs.stream().filter(x -> x.getDate().get(Calendar.YEAR) == año).collect(Collectors.toList());

    }

    /**
     * Método para organizar las canciones por duración.
     *
     * @param songs Arreglo de canciones a ordenar.
     * @return Arreglo con canciones ordenadas.
     */
    public List<Songs> organizeByDuration(List<Songs> songs) {
        /**
         * Variable auxiliar para almacenar valores.
         */
        Songs aux;
        /**
         * Bucle burbuja para ordenar el arreglo.
         */
        for (int i = 0; i < songs.size() - 1; i++) {
            for (int j = 0; j < songs.size() - 1; j++) {
                if (songs.get(j).getDuration() > songs.get(j + 1).getDuration()) {
                    aux = songs.get(j);
                    songs.set(j, songs.get(j + 1));
                    songs.set(j + 1, aux);

                }
            }
        }

        return songs;

    }

    /**
     * Método para organiar canciones por fecha.
     *
     * @param songs Arreglo de canciones a ordenar.
     * @return Arreglo con canciones ordenadas.
     */
    public List<Songs> organizeByDate(List<Songs> songs) {
        /**
         * Variable auxiliar para almacenar valores.
         */
        Songs aux,aux1,aux2;
        /**
         * Bucle burbuja para ordenar el arreglo.
         */
        for (int i = 0; i < songs.size() - 1; i++) {
            for (int j = 0; j < songs.size() - 1; j++) {
                if (songs.get(j).getDate().get(Calendar.YEAR) > songs.get(j + 1).getDate().get(Calendar.YEAR)) {
                    aux = songs.get(j);
                    songs.set(j, songs.get(j + 1));
                    songs.set(j + 1, aux);
                    for (int k = 0; k < songs.size() - 1; k++) {
                        for (int l = 0; l < songs.size() - 1; l++) {
                            if (songs.get(l).getDate().get(Calendar.MONTH) > songs.get(l + 1).getDate().get(Calendar.MONTH)) {
                                aux1 = songs.get(l);
                                songs.set(l, songs.get(l + 1));
                                songs.set(l + 1, aux1);

                                for (int n = 0; n < songs.size() - 1; n++) {
                                    for (int m = 0; m < songs.size() - 1; m++) {
                                        if (songs.get(m).getDate().get(Calendar.DAY_OF_MONTH) > songs.get(m + 1).getDate().get(Calendar.DAY_OF_MONTH)) {
                                            aux2 = songs.get(m);
                                            songs.set(m, songs.get(m + 1));
                                            songs.set(m + 1, aux2);

                                        }
                                    }
                                }

                            }
                        }
                    }

                }
            }
        }

        return songs;

    }

}
