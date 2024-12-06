package control;

import dominio.Candidato;
import dominio.Eleccion;
import dominio.Papeleta;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static presentacion.Interfaz.interfaz;

public class SistemaElecciones {
    private Eleccion eleccion;

    public Eleccion iniciarEleccion () {
        //Se crean los objetos candidato y papeleta y se añaden a eleccion
        Eleccion eleccion = new Eleccion();
        eleccion.setCandidatos(introducirCandidatos());
        eleccion.setPapeletas(introducirPapeletas(introducirPapeleta(new Candidato("Candidato1"), new Candidato("Candidato2"), new Candidato("Candidato3")),
                introducirPapeleta(new Candidato("Candidato3"), new Candidato("Candidato2"), new Candidato("Candidato1")),
                introducirPapeleta(new Candidato("Candidato2"), new Candidato("Candidato3"), new Candidato("Candidato1"))));
        //Se validan las papeletas
        if (!eleccion.validarPapeletas())
            return (null);
        //Recuento con comprobarMayoriaAbsoluta()
        //Eliminación y nuevo recuento con el boolean de comprobarMa...
        do  {
            eleccion.realizarRecuento();
            if (!eleccion.comprobarMayoriaAbsoluta()) {
                eleccion.eliminarCandidatoConMenosVotos();
            }
        }while(eleccion.comprobarMayoriaAbsoluta());
        return (eleccion);
    }

    public void mostrarResultados (Eleccion eleccion) {
        Candidato candidatoMostrar = new Candidato(eleccion.getPapeletas().size());
        for (Candidato candidato : eleccion.getCandidatos()) {
            if (candidato.getVotos() > candidatoMostrar.getVotos()) {
                candidatoMostrar = candidato;
            }
        }
        System.out.println(candidatoMostrar.toString());
    }

    public ArrayList<Candidato> introducirCandidatos() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        candidatos.add(new Candidato("Candidato1"));
        candidatos.add(new Candidato("Candidato2"));
        candidatos.add(new Candidato("Candidato3"));
        return (candidatos);
    }

    public ArrayList<Papeleta> introducirPapeletas(Papeleta... papeletas) {
        return (new ArrayList<>(Arrays.asList(papeletas)));
    }

    public Papeleta introducirPapeleta(Candidato... candidatos) {
        Papeleta papeleta = new Papeleta();
        papeleta.setListaPreferencias(new ArrayList<>());
        for (Candidato candidato : candidatos) {
            papeleta.getListaPreferencias().add(candidato);
        }
        return (papeleta);
    }
}
