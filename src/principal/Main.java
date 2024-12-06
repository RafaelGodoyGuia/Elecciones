package principal;

import control.SistemaElecciones;
import presentacion.Interfaz;

public class Main {
    public static void main (String[] argv) {
        Interfaz.interfaz(new SistemaElecciones());
    }
}
