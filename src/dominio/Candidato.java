package dominio;

public class Candidato {
    private String nombre;
    private int votos;

    public Candidato (String nombre) {
        this.nombre = nombre;
    }

    public Candidato () {
        this.votos = 0;
    }

    public String getNombre () {
        return (this.nombre);
    }

    public void incrementarVotos () {
        this.votos++;
    }

    public void resetearVotos () {
        this.votos = 0;
    }
}
