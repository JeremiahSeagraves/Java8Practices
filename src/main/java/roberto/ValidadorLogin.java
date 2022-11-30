package roberto;

import java.io.IOException;
import java.util.List;

public class ValidadorLogin {

    public static boolean esUsuarioValido(String usuario, String contrasena) throws IOException {
        List<Usuario> usuarios = Lector.leerUsuarios("usuarios.csv");
        for (Usuario unUsuario : usuarios) {
            if(unUsuario.getUsuario().equals(usuario)){
                return unUsuario.getContrasena().equals(contrasena);
            }
        }
        return false;
    }
}
