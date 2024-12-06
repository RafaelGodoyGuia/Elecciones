package dominio;

public class Candidato {
    private String nombre;
    private int votos;

    public Candidato (String nombre) {
        this.nombre = nombre;
    }

    public Candidato (int votos) {
        this.votos = votos;
    }

    public Candidato () {
        this.votos = 0;
    }

    public String getNombre () {
        return (this.nombre);
    }

    public int getVotos () {
        return (this.votos);
    }

    public void incrementarVotos () {
        this.votos++;
    }

    public void resetearVotos () {
        this.votos = 0;
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nombre).append(" con ").append(this.votos);
        return (sb.toString());
    }
}
