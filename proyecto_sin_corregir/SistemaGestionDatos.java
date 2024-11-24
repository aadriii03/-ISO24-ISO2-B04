
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//Clase principal para el sistema de solicitudes, alertas y reportes
public class SistemaGestionDatos {

    private List<Solicitud> solicitudes;
    private List<Alerta> alertas;
    private Map<UUID, Reporte> reportes;

    public SistemaGestionDatos() {
        this.solicitudes = new ArrayList<>();
        this.alertas = new ArrayList<>();
        this.reportes = new HashMap<>();
    }

    // Método para que un usuario solicite acceso o información de calidad sobre un
    // conjunto de datos
    public Solicitud solicitarAcceso(String usuario, String conjuntoDatos) {
        Solicitud solicitud = new Solicitud(usuario, conjuntoDatos);
        solicitudes.add(solicitud);

        // Generar alerta para gestores de calidad de datos
        generarAlerta(solicitud);

        System.out.println("Solicitud creada y alerta generada.");
        return solicitud;
    }

    // Método para generar una alerta cuando se recibe una solicitud
    private void generarAlerta(Solicitud solicitud) {
        Alerta alerta = new Alerta(solicitud);
        alertas.add(alerta);

        // Simulación de envío de alerta (por ejemplo, en el panel de control)
        System.out.println("Alerta generada para solicitud de: " + solicitud.getUsuario());
    }

    // Método para que un gestor elabore y entregue un reporte de calidad
    public void entregarReporte(UUID idSolicitud, String contenidoReporte) {
        // Encontrar la solicitud
        Solicitud solicitud = buscarSolicitudPorId(idSolicitud);
        if (solicitud == null) {
            System.out.println("Solicitud no encontrada.");
            return;
        }

        // Crear y almacenar el reporte
        Reporte reporte = new Reporte(solicitud, contenidoReporte);
        reportes.put(reporte.getId(), reporte);

        // Notificar al solicitante
        notificarEntregaReporte(solicitud, reporte);
    }

    // Método para notificar al usuario solicitante sobre la disponibilidad del
    // reporte
    private void notificarEntregaReporte(Solicitud solicitud, Reporte reporte) {
        System.out.println("Reporte disponible para " + solicitud.getUsuario() + ". ID de Reporte: " + reporte.getId());
    }

    // Método de búsqueda de solicitud por su ID
    private Solicitud buscarSolicitudPorId(UUID idSolicitud) {
        return solicitudes.stream()
                .filter(solicitud -> solicitud.getId().equals(idSolicitud))
                .findFirst()
                .orElse(null);
    }

}
