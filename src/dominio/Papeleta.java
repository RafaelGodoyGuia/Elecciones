package dominio;

import dominio.Eleccion;
import java.util.ArrayList;

public class Papeleta {
    private ArrayList<Candidato> listaPreferencias;

    public Candidato obtenerPrimeraPreferencia () {
        return (listaPreferencias.getFirst());
    }

    public ArrayList<Candidato> getListaPreferencias () {
        return (this.listaPreferencias);
    }

    public void setListaPreferencias(ArrayList<Candidato> listaPreferencias) {
        this.listaPreferencias = listaPreferencias;
    }

    public void eliminarCandidato (Candidato candidato) {
        listaPreferencias.remove(candidato);
    }

}
