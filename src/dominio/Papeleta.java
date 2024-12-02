package dominio;

import java.util.ArrayList;

public class Papeleta {
    private ArrayList<Candidato> listaPreferencias;

    public Candidato obtenerPrimeraPreferencia () {
        return (listaPreferencias.getFirst());
    }

    public ArrayList<Candidato> getListaPreferencias () {
        return (this.listaPreferencias);
    }

    public void eliminarCandidato (Candidato candidato) {
        int votos = Eleccion.getPapeletas().size();

    }
}
