package dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Eleccion {
    private ArrayList<Candidato> candidatos;
    private ArrayList<Papeleta> papeletas;

    public ArrayList<Papeleta> getPapeletas () {
        return (this.papeletas);
    }

    public ArrayList<Candidato> getCandidatos () {
        return (this.candidatos);
    }

    public void setCandidatos (ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public void setPapeletas (ArrayList<Papeleta> papeletas) {
        this.papeletas = papeletas;
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
        int votos = papeletas.size();
        Candidato candidatoConMenosVotos = new Candidato();
        for(Candidato candidato : candidatos) {
            if (votos > candidato.getVotos()) {
                votos = candidato.getVotos();
                candidatoConMenosVotos = candidato;
            }
        }
        candidatos.remove(candidatoConMenosVotos);
        for (Papeleta papeleta : papeletas) {
            papeleta.eliminarCandidato(candidatoConMenosVotos);
        }
        for (Candidato candidato : candidatos) {
            candidato.resetearVotos();
        }
    }

    public boolean comprobarMayoriaAbsoluta () {
        for (Candidato candidato : candidatos) {
            if ((float)candidato.getVotos() / (float)papeletas.size() < 0.50) {
                return (false);
            }
        }
        return (true);
    }

    public boolean validarPapeletas () {
        for (Papeleta papeleta : papeletas) {
            if (papeleta.getListaPreferencias().size() != candidatos.size())
                return (false);
            for (int i = 0; i < papeleta.getListaPreferencias().size(); i++) {
                for (int j = i + 1; j < papeleta.getListaPreferencias().size(); j++) {
                    if (papeleta.getListaPreferencias().get(i).equals(papeleta.getListaPreferencias().get(j)))
                        return (false);
                }
            }
        }
        return (true);
    }
}
