package roberto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Escritor {

    public static boolean guardarCredenciales(String nombreArchivo, String usuario, String contrasena) {
        File csvOutputFile = new File(nombreArchivo);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.println(usuario + "," + contrasena);
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }
}
