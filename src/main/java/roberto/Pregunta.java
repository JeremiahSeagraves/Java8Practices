package roberto;

import java.util.List;

public class Pregunta {
    private String pregunta;
    private CategoriaPregunta categoria;
    private List<Respuesta> respuestas;

    public Pregunta(String pregunta, CategoriaPregunta categoria, List<Respuesta> respuestas) {
        this.pregunta = pregunta;
        this.categoria = categoria;
        this.respuestas = respuestas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public CategoriaPregunta getCategoria() {
        return categoria;
    }
}
