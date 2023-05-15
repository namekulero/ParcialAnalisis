package com.todo.controlador;

import com.todo.modelo.Modelo;

public class Controlador {

    public static boolean buscarLibro(String titulo) {
        return Modelo.buscarLibro(titulo);
    }

    public static boolean buscarDisponibilidad(String titulo) {
        return Modelo.buscarDisponibilidad(titulo);
    }

    public static void reservarLibro(String titulo) {
        Modelo.reservarLibro(titulo);
    }

    public static void devolverLibro(String titulo) {
        Modelo.devolverLibro(titulo);
    }

    public static boolean agregarLibro(String titulo, String autor, String categoria) {
        return Modelo.agregarLibro(titulo, autor, categoria);
    }

    public static boolean eliminarLibro(String titulo) {
        return Modelo.eliminarLibro(titulo);
    }
    
}
