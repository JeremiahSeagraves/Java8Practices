package roberto;

public enum CategoriaPregunta {
    MATEMATICAS(1, "Matemáticas"),
    GRAMATICA(2, "Gramática"),
    SIN_ASIGNAR(999, "Sin asignar");

    public final int id;
    public final String nombre;

    CategoriaPregunta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public static CategoriaPregunta obtenerPorId(int id) {
        for (CategoriaPregunta categoria : CategoriaPregunta.values()) {
            if (categoria.getId() == id)
                return categoria;
        }
        return SIN_ASIGNAR;
    }
}
