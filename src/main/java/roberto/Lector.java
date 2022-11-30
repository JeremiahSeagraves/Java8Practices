package roberto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lector {

    public static List<Pregunta> leerPreguntas(String nombreArchivo) throws IOException {
        List<Pregunta> preguntas = new ArrayList<>();
        for (String[] unaLinea :leerArchivo(nombreArchivo, "\\|")) {
            List<Respuesta> respuestas = List.of(
                    new Respuesta(unaLinea[1], false),
                    new Respuesta(unaLinea[2], false),
                    new Respuesta(unaLinea[3], false)
            );
            respuestas.get(Integer.parseInt(unaLinea[4]) - 1).setCorrecta(true);
            preguntas.add(new Pregunta(unaLinea[0], respuestas));
        }
        return preguntas;
    }

    public static List<Usuario> leerUsuarios(String nombreArchivo) throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        for (String[] unaLinea :leerArchivo(nombreArchivo, ",")) {
            usuarios.add(new Usuario(unaLinea[0], unaLinea[1]));
        }
        return usuarios;
    }

    private static List<String[]> leerArchivo(String nombreArchivo, String separador) throws IOException {
        List<String[]> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineas.add(line.split(separador));
            }
        }
        return lineas;
    }
}
