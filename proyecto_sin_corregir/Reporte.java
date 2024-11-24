
import java.util.UUID;

public class Reporte {
    private UUID id;
    private Solicitud solicitud;
    private String contenido;

    public Reporte(Solicitud solicitud, String contenido) {
        this.id = UUID.randomUUID();
        this.solicitud = solicitud;
        this.contenido = contenido;
    }

    public UUID getId() {
        return id;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public String getContenido() {
        return contenido;
    }
}