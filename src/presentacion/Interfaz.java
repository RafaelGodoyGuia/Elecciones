package presentacion;

import control.SistemaElecciones;
import dominio.Eleccion;

public class Interfaz {
    public static void interfaz (SistemaElecciones sistemaElecciones) {
        sistemaElecciones.mostrarResultados(sistemaElecciones.iniciarEleccion());
        }
}
