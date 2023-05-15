package com.todo.vista;

import com.todo.controlador.Controlador;
import java.util.Scanner;

public class Vista {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        System.out.println("¿Desea ingresar como usuario (1) o como administrador (2)?");

        switch (Integer.parseInt(sc.nextLine())) {
            default:
                System.out.println("Ingrese una opción válida--\n");
                break;
            case 1:
                menuUsuario();
                break;
            case 2:
                menuAdmin();
                break;
        }
    }

    private static void menuUsuario() {
        while (true) {
            System.out.println("Escoja la opción a ejecutar:");
            System.out.println("1. Buscar libro");
            System.out.println("2. Reservar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Salir del programa");

            switch (Integer.parseInt(sc.nextLine())) {
                default:
                    System.out.println("Ingrese una opción válida--\n");
                    break;
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    reservarLibro();
                    break;
                case 3:
                    devolverLibro();
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void menuAdmin() {
        while (true) {
            System.out.println("Escoja la opción a ejecutar:");
            System.out.println("1. Buscar libro");
            System.out.println("2. Reservar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Agregar nuevo libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Salir del programa");

            switch (Integer.parseInt(sc.nextLine())) {
                default:
                    System.out.println("Ingrese una opción válida--\n");
                    break;
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    reservarLibro();
                    break;
                case 3:
                    devolverLibro();
                    break;
                case 4:
                    agregarLibro();
                    break;
                case 5:
                    eliminarLibro();
                    break;
                case 6:
                    return;
            }
        }
    }

    private static void buscarLibro() {
        System.out.println("Ingrese el nombre del libro a buscar:");
        String titulo = sc.nextLine();
        if (Controlador.buscarLibro(titulo)) {
            System.out.print("El libro se encuentra registrado en la librería ");
            if (Controlador.buscarDisponibilidad(titulo)) {
                System.out.println("y se encuentra disponible");
            } else {
                System.out.println("pero no se encuentra disponible");
            }
        } else {
            System.out.println("ERROR: El libro ingresado no se encontró");
        }
    }

    private static void reservarLibro() {
        System.out.println("Ingrese el nombre del libro a reservar:");
        String titulo = sc.nextLine();
        if (Controlador.buscarLibro(titulo)) {
            if (Controlador.buscarDisponibilidad(titulo)) {
                Controlador.reservarLibro(titulo);
                System.out.println("El libro buscado fue reservado exitosamente");
            } else {
                System.out.println("El libro buscado no se encuentra disponible, inténtalo más tarde");
            }
        } else {
            System.out.println("ERROR: El libro ingresado no se encontró");
        }
    }

    private static void devolverLibro() {
        System.out.println("Ingrese el nombre del libro a devolver:");
        String titulo = sc.nextLine();
        if (Controlador.buscarLibro(titulo)) {
            if (!Controlador.buscarDisponibilidad(titulo)) {
                Controlador.devolverLibro(titulo);
                System.out.println("El libro fue devuelto exitosamente");
            } else {
                System.out.println("El libro se encuentra disponible en la biblioteca");
            }
        } else {
            System.out.println("ERROR: El libro ingresado no se encontró");
        }
    }

    private static void agregarLibro() {
        System.out.println("Ingrese el nombre del libro a agregar a la librería:");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el nombre del autor del libro:");
        String autor = sc.nextLine();
        System.out.println("Ingrese la categoría del libro:");
        String categoria = sc.nextLine();
        if (!Controlador.buscarLibro(titulo)) {
            if (Controlador.agregarLibro(titulo, autor, categoria)) {
                System.out.println("El libro fue añadido exitosamente");
            } else {
                System.out.println("ERROR: Algo salió mal ingresando el libro a la biblioteca");
            }
        } else {
            System.out.println("ERROR: El libro ingresado ya se encuentra en la biblioteca");
        }
    }

    private static void eliminarLibro() {
        System.out.println("Ingrese el nombre del libro a eliminar:");
        String titulo = sc.nextLine();
        if (Controlador.buscarLibro(titulo)) {
            if (Controlador.eliminarLibro(titulo)) {
                System.out.println("El libro fue eliminado exitosamente");
            } else {
                System.out.println("ERROR: Algo salió mal eliminando el libro de la biblioteca");
            }
        } else {
            System.out.println("ERROR: El libro ingresado no se encontró");
        }
    }
}
