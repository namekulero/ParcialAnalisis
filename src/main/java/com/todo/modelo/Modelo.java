package com.todo.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Modelo {
    private static HashMap<String, Libro> mapTitulos = new HashMap<>();
    private static HashMap<String, ArrayList<Libro>> mapAutores = new HashMap<>();
    private static HashMap<String, ArrayList<Libro>> mapCategorias = new HashMap<>();
    
    public static boolean buscarLibro(String titulo) {
        return mapTitulos.containsKey(titulo);
    }

    public static boolean buscarDisponibilidad(String titulo) {
        return mapTitulos.get(titulo).isDisponible();
    }

    public static void reservarLibro(String titulo) {
        Libro reserva = mapTitulos.get(titulo);
        reserva.setDisponible(false);
        mapTitulos.put(reserva.getTitulo(), reserva);
    }
    
    public static void devolverLibro(String titulo) {
        Libro reserva = mapTitulos.get(titulo);
        reserva.setDisponible(true);
        mapTitulos.put(reserva.getTitulo(), reserva);
    }

    public static boolean agregarLibro(String titulo, String autor, String categoria) {
        Libro nuevo = new Libro(titulo, autor, categoria);
        mapTitulos.put(titulo, nuevo);
        
//        if(mapAutores.containsKey(autor)) {
//            ArrayList<Libro> listaAutor = mapAutores.get(autor);
//            for(Libro libro: listaAutor) {
//                if(libro.getTitulo() == titulo) {
//                    return false;
//                }
//            }
//            
//            listaAutor.add(nuevo);
//            mapAutores.put(autor, listaAutor);
//        }
//        
//        if(mapCategorias.containsKey(categoria)) {
//            ArrayList<Libro> listaCategoria = mapCategorias.get(categoria);
//            for(Libro libro: listaCategoria) {
//                if(libro.getTitulo() == titulo) {
//                    return false;
//                }
//            }
//            
//            listaCategoria.add(nuevo);
//            mapCategorias.put(categoria, listaCategoria);
//        }
        
        return true;
    }

    public static boolean eliminarLibro(String titulo) {
        mapTitulos.remove(titulo);
        return true;
    }
}
