package roberto;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RobertoTest {

    public static void main(String[] args) {

    }

    public void test() throws IOException {
        List<Pregunta> preguntas = Lector.leerPreguntas("preguntas.csv");

        for (Pregunta pregunta: preguntas) {
            System.out.println(pregunta.getPregunta() + " - " + pregunta.getCategoria().nombre);
            System.out.println(Arrays.toString(pregunta.getRespuestas().toArray()));
        }

//        Escritor.guardarCredenciales("usuarios.csv", "Roberto123", "panchito");

        System.out.println(ValidadorLogin.esUsuarioValido("Roberto123","panchitoX"));
        System.out.println(ValidadorLogin.esUsuarioValido("Roberto123","panchitoY"));
        System.out.println(ValidadorLogin.esUsuarioValido("Roberto123","panchito"));
    }

}
