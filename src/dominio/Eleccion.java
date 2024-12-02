package dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Eleccion {
    private ArrayList<Candidato> candidatos;
    private ArrayList<Papeleta> papeletas;

    public ArrayList<papeletas> getPapeletas () {
        return (this.papeletas);
    }
    public void realizarRecuento() {
        for (Papeleta papeleta : papeletas) {
            for (Candidato candidato : candidatos) {
                if (papeleta.getListaPreferencias().getFirst().getNombre().equals(candidato.getNombre())) {
                    candidato.incrementarVotos();
                }
            }
        }
    }

    public void eliminarCandidatoConMenosVotos () {

    }

    public boolean comprobarMayoriaAbsoluta () {

    }

    public boolean validarPapeletas () {
        for (Papeleta papeleta : papeletas) {
            for (Candidato candidato : papeleta.getListaPreferencias()) {
                for (int i = 0; i < papeleta.getListaPreferencias().size(); i++) {
                    for (int j = i + 1; i < papeleta.getListaPreferencias().size(); j++) {
                        if (papeleta.getListaPreferencias().get(i).equals(papeleta.getListaPreferencias().get(j)))
                            return (false);
                    }
                }
            }
        }
        return (true);
    }
}
