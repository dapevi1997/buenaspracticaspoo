package org.sokfa.taller3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
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
    final List<Songs> songs;
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
                new GregorianCalendar(1993, Calendar.DECEMBER, 12), 4.20,
                "Título_de_amor.jpg", "Éxito nacional"));
        songs.add(new Vallenato("2", "Déjala",
                new GregorianCalendar(1993, Calendar.FEBRUARY, 19), 5.00,
                "Título_de_amor.jpg", "Segundo éxito"));
        songs.add(new Salsa("3", "Tranquilo",
                new GregorianCalendar(1996, Calendar.JULY, 15), 4.35,
                "Tranquilo.jpg", "Lanzada como solista"));
        songs.add(new Salsa("4", "Obseción",
                new GregorianCalendar(1994, Calendar.AUGUST, 30), 4.7,
                "Mirándote.jpg", "Rotundo éxito"));
        songs.add(new Merengue("5", "Te va a doler",
                new GregorianCalendar(2001, Calendar.JULY, 15), 4.35,
                "Vete_y_dile.jpg", "Lanzada como solista"));
        songs.add(new Merengue("6", "La quiero a morir",
                new GregorianCalendar(1986, Calendar.DECEMBER, 24), 5.07,
                "Mirándote.jpg", "Rotundo éxito"));
    }

    /**
     * Método para retornar el arreglos de canciones de la biblioteca principal.
     *
     * @return Arreglo de canciones.
     */
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
        int selection = 0;
        boolean flag = true;

        /**
         * Control de entradas.
         */
        do {
            try {
                System.out.println("-----------------------------------------------");
                System.out.println("Escoja una opción: ");
                System.out.println("");
                System.out.println(" 1. Crear playlist");
                System.out.println(" 2. Filtrar biblioteca por género");
                System.out.println(" 3. Filtrar biblioteca por año");
                System.out.println(" 4. Ordenar blioteca por duración (ascendente)");
                System.out.println(" 5. Ordenar biblioteca por duración (descendente)");
                System.out.println(" 6. Ordenar bilioteca por fecha (ascendente)");
                System.out.println(" 7. Ordenar biblioteca por fecha (descendente)");
                System.out.println(" 8. Salir de la apliación");
                selection = in.nextInt();
                if (selection >= 1 && selection <= 8) {

                } else {
                    throw new IllegalArgumentException("******Advertencia**"
                            + "*****\nFuera de rango\n****************"
                            + "*********");
                }
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("*******Advertencia*******");
                System.out.println("¡Debe ingresar un entero!");
                System.out.println("*************************");
                in.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (flag);

        return selection;

    }

    /**
     * Método para crear una playlist.
     *
     */
    public void playList() {
        Scanner in = new Scanner(System.in);
        List<Songs> songs = new ArrayList<>();
        String[] split;

        /**
         * Ciclo para verificar que sean número enteros los ingresados por el
         * usuario.
         */
        /**
         * Variable para almacenar la entrada del usuario.
         */
        String ids;
        boolean flag = true;
        do {
            /**
             * Control de excepciones.
             */
            try {
                System.out.println("-----------------------------------------------");
                System.out.println("Escoja las canciones escribriendo el id separado "
                        + "por comas. Ej (1,2).");
                ids = in.next();
                split = ids.split(",", -1);
                for (String split1 : split) {
                    int s = Integer.parseInt(split1);
                }
                for (int i = 0; i < this.songs.size(); i++) {

                    for (String split1 : split) {

                        if (split1.equals(this.songs.get(i).getId())) {
                            songs.add(this.songs.get(i));

                            break;
                        }

                    }

                }
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("-----------------------------------------------");
                System.out.println("Advertencia : formato no permitido.");
                System.out.println("-----------------------------------------------");
            }
        } while (flag);

        System.out.println("-----------------------------------------------");
        System.out.println("Esta es su playlist:");
        System.out.println("");
        showLibray(songs);

    }

    /**
     * Método para filtrar por género.
     *
     */
    public void filterByGender() {
        Scanner in = new Scanner(System.in);
        int selection;
        String gender = "";
        boolean flag = true;

        do {
            try {
                System.out.println("-----------------------------------------------");
                System.out.println("Escoja el género por el que desea filtrar");
                System.out.println(" 1. Vallenato");
                System.out.println(" 2. Salsa");
                System.out.println(" 3. Merengue");
                selection = in.nextInt();
                if (selection >= 1 && selection <= 3) {

                } else {
                    throw new IllegalArgumentException("******Advertencia**"
                            + "*****\nFuera de rango\n****************"
                            + "*********");
                }
                switch (selection) {
                    case 1:
                        gender = "Vallenato";
                        break;
                    case 2:
                        gender = "Salsa";
                        break;
                    case 3:
                        gender = "Merengue";
                        break;
                    default:
                        break;

                }

                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("*******Advertencia*******");
                System.out.println("¡Debe ingresar un entero!");
                System.out.println("*************************");
                in.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (flag);
        System.out.println("-----------------------------------------------");
        System.out.println("Canciones filtradas por género " + gender + ":");
        System.out.println("");
        showLibray(auxFilterByGender(gender));

    }

    /**
     * Método para filtrar las canciones de la biblioteca principal por año.
     */
    public void filterByYear() {
        Scanner in = new Scanner(System.in);
        int year = 0;
        boolean flag = true;

        do {
            try {
                System.out.println("-----------------------------------------------");
                System.out.println("Año por el que desea filtrar: ");
                year = in.nextInt();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("*******Advertencia*******");
                System.out.println("¡Debe ingresar un año válido!");
                System.out.println("*************************");
                in.next();
            }

        } while (flag);
        System.out.println("-----------------------------------------------");
        System.out.println("Canciones filtradas por año:");
        System.out.println("");
        showLibray(auxfilterByYear(year));

    }

    /**
     * Método auxiliar para filtrar por género.
     *
     * @param gender Género por el que se desea filtrar.
     * @return Arreglo de canciones filtradas.
     */
    private List<Songs> auxFilterByGender(String gender) {

        return songs.stream().filter(x -> x.getGender().equals(gender)).collect(Collectors.toList());

    }

    /**
     * Método auxiliar para filtrar por año.
     *
     * @param año Año por el que desea filtrar.
     * @return Arreglo con canciones filtradas.
     */
    public List<Songs> auxfilterByYear(int año) {

        return songs.stream().filter(x -> x.getDate().get(Calendar.YEAR) == año).collect(Collectors.toList());

    }

    /**
     * Método para organizar las canciones por duración.
     *
     * @param flow Cadena "asc" o "des" para indicar si se quiere ordenar
     * ascendente o descendete, respectivamente.
     */
    public void organizeByDuration(String flow) {

        ArrayList<Songs> auxSongs = new ArrayList<>(songs);
        /**
         * Variable auxiliar para almacenar valores.
         */
        Songs aux;
        /**
         * Bucle burbuja para ordenar el arreglo.
         */
        for (int i = 0; i < auxSongs.size() - 1; i++) {
            for (int j = 0; j < auxSongs.size() - 1; j++) {
                if (auxSongs.get(j).getDuration() > auxSongs.get(j + 1).getDuration()) {
                    aux = auxSongs.get(j);
                    auxSongs.set(j, auxSongs.get(j + 1));
                    auxSongs.set(j + 1, aux);

                }
            }
        }

        if (flow.equals("asc")) {
            System.out.println("-----------------------------------------------");
            System.out.println("Canciones ordenadas por duración (ascendente):");
            System.out.println("");
            showLibray(auxSongs);
        } else if (flow.equals("des")) {
            System.out.println("-----------------------------------------------");
            System.out.println("Canciones ordenadas por duración (descendente):");
            System.out.println("");
            showLibrayDes(auxSongs);
        }

    }

    /**
     * Método para organiar canciones por fecha.
     *
     * @param flow Cadena "asc" o "des" para indicar si se quiere ordenar
     * ascendente o descendete, respectivamente.
     */
    public void organizeByDate(String flow) {
        ArrayList<Songs> auxSongs = new ArrayList<>(songs);
        /**
         * Variable auxiliar para almacenar valores.
         */
        Songs aux;
        /**
         * Pimer bucle burbuja para ordenar el arreglo por años.
         */
        for (int i = 0; i < auxSongs.size() - 1; i++) {
            for (int j = 0; j < auxSongs.size() - 1; j++) {

                int year1, year2;
                year1 = auxSongs.get(j).getDate().get(Calendar.YEAR);
                year2 = auxSongs.get(j + 1).getDate().get(Calendar.YEAR);

                if (year1 > year2) {
                    aux = auxSongs.get(j);
                    auxSongs.set(j, auxSongs.get(j + 1));
                    auxSongs.set(j + 1, aux);
                    /**
                     * Segundo bucle burbuja para ordenar el arreglo por mes.
                     */
                    for (int k = 0; k < auxSongs.size() - 1; k++) {
                        for (int l = 0; l < auxSongs.size() - 1; l++) {
                            int month1, month2;
                            month1 = auxSongs.get(l).getDate().get(Calendar.MONTH);
                            month2 = auxSongs.get(l + 1).getDate().get(Calendar.MONTH);
                            if (month1 > month2) {
                                int year11, year22;
                                year11 = auxSongs.get(l).getDate().get(Calendar.YEAR);
                                year22 = auxSongs.get(l + 1).getDate().get(Calendar.YEAR);

                                if (year11 >= year22) {
                                    aux = auxSongs.get(l);
                                    auxSongs.set(l, auxSongs.get(l + 1));
                                    auxSongs.set(l + 1, aux);
                                }
                                /**
                                 * Tercer bucle burbuja para ordenar el arreglo
                                 * por día.
                                 */
                                for (int n = 0; n < auxSongs.size() - 1; n++) {
                                    for (int m = 0; m < auxSongs.size() - 1; m++) {
                                        int day1, day2;
                                        day1 = auxSongs.get(m).getDate().get(Calendar.DAY_OF_MONTH);
                                        day2 = auxSongs.get(m + 1).getDate().get(Calendar.DAY_OF_MONTH);
                                        if (day1 > day2) {
                                            int year111, year222, month11, month22;
                                            month11 = auxSongs.get(m).getDate().get(Calendar.MONTH);
                                            month22 = auxSongs.get(m + 1).getDate().get(Calendar.MONTH);
                                            year111 = auxSongs.get(l).getDate().get(Calendar.YEAR);
                                            year222 = auxSongs.get(l + 1).getDate().get(Calendar.YEAR);
                                            if (month11 >= month22 && year111 >= year222) {
                                                aux = auxSongs.get(m);
                                                auxSongs.set(m, auxSongs.get(m + 1));
                                                auxSongs.set(m + 1, aux);
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        /**
         * Estructura condicional para mostrar ascendente o descendentemente las
         * canciones.
         */
        if (flow.equals("asc")) {
            System.out.println("-----------------------------------------------");
            System.out.println("Canciones ordenadas por fecha (ascendente):");
            System.out.println("");
            showLibray(auxSongs);
        } else if (flow.equals("des")) {
            System.out.println("-----------------------------------------------");
            System.out.println("Canciones ordenadas por fecha (descendente):");
            System.out.println("");
            showLibrayDes(auxSongs);
        }

    }

}
