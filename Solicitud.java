
import java.util.UUID;

public class Solicitud {
    private UUID id;
    private String usuario;
    private String conjuntoDatos;

    public Solicitud(String usuario, String conjuntoDatos) {
        this.id = UUID.randomUUID();
        this.usuario = usuario;
        this.conjuntoDatos = conjuntoDatos;
    }

    public UUID getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getConjuntoDatos() {
        return conjuntoDatos;
    }
}
