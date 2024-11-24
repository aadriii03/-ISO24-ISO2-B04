
import java.util.UUID;

public class Alerta {
    private UUID id;
    private Solicitud solicitud;

    public Alerta(Solicitud solicitud) {
        this.id = UUID.randomUUID();
        this.solicitud = solicitud;
    }

    public UUID getId() {
        return id;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }
}

