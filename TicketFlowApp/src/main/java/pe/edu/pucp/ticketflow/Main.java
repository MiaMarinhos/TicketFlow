package pe.edu.pucp.ticketflow;

import pe.edu.pucp.ticketflow.dao.AdministradorDAO;
import pe.edu.pucp.ticketflow.dao.AnfitrionDAO;
import pe.edu.pucp.ticketflow.dao.ClienteDAO;
import pe.edu.pucp.ticketflow.dao.CompraDAO;
import pe.edu.pucp.ticketflow.dao.DistritoDAO;
import pe.edu.pucp.ticketflow.dao.EventoDAO;
import pe.edu.pucp.ticketflow.dao.PagoDAO;
import pe.edu.pucp.ticketflow.dao.PuntosBonusDAO;
import pe.edu.pucp.ticketflow.dao.RegionDAO;
import pe.edu.pucp.ticketflow.dao.SolicitudDAO;
import pe.edu.pucp.ticketflow.dao.UsuarioDAO;

import pe.edu.pucp.ticketflow.dao.impl.AdministradorDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.AnfitrionDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.ClienteDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.CompraDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.DistritoDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.EventoDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.PagoDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.PuntosBonusDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.RegionDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.SolicitudDAOimpl;
import pe.edu.pucp.ticketflow.dao.impl.UsuarioDAOimpl;
import pe.edu.pucp.ticketflow.region.model.Region;
import pe.edu.pucp.ticketflow.usuario.model.Administrador;


public class Main {
    public static void main(String[] args) {
        //PRUEBA DE CONEXION BD
        /*try {
            Connection conn = DBManager.getInstance().getConnection();

            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Conexión exitosa a la base de datos");
            } else {
                System.out.println("❌ No se pudo establecer la conexión");
            }

        } catch (Exception e) {
            System.out.println("❌ Error en la conexión:");
            e.printStackTrace();
        }*/

        //SEGUIR AQUI

        // ---------------------------------------------------------
        // FASE 0: INICIALIZACIÓN DE DAOs (Asumiendo nombres estándar)
        // ---------------------------------------------------------
        RegionDAO regionDAO = new RegionDAOimpl();
        DistritoDAO distritoDAO = new DistritoDAOimpl();
        PuntosBonusDAO puntosBonusDAO = new PuntosBonusDAOimpl();

        AdministradorDAO adminDAO = new AdministradorDAOimpl();
        AnfitrionDAO anfitrionDAO = new AnfitrionDAOimpl();
        ClienteDAO clienteDAO = new ClienteDAOimpl();

        SolicitudDAO solicitudDAO = new SolicitudDAOimpl();
        EventoDAO eventoDAO = new EventoDAOImpl();
        CompraDAO compraDAO = new CompraDAOImpl();
        PagoDAO pagoDAO = new PagoDAOImpl();

        try {
            System.out.println("=== INICIANDO PRUEBA DE INTEGRACIÓN TICKETFLOW ===");

            // ---------------------------------------------------------
            // FASE 1: INFRAESTRUCTURA Y REGLAS DE NEGOCIO
            // ---------------------------------------------------------
            System.out.println("\n[1] Creando Infraestructura...");

            Region region = new Region(0, "Lima");
            region = regionDAO.create(region);
            System.out.println("  -> Región creada con ID: " + region.getIdRegion());

            Distrito distrito = new Distrito(0, "San Miguel", region);
            distrito = distritoDAO.create(distrito);
            System.out.println("  -> Distrito creado con ID: " + distrito.getIdDistrito());

            PuntosBonus puntosRegla = new PuntosBonus(0, 100, 10);
            puntosRegla = puntosBonusDAO.create(puntosRegla);
            System.out.println("  -> Regla de Puntos creada con ID: " + puntosRegla.getIdPuntosBonus());

            // ---------------------------------------------------------
            // FASE 2: ACTORES DEL SISTEMA (USUARIOS)
            // ---------------------------------------------------------
            System.out.println("\n[2] Creando Actores del Sistema...");
            java.sql.Date fechaHoy = new java.sql.Date(System.currentTimeMillis());

            Administrador admin = new Administrador(0, "Luis", "Soto", "Gomez", "999888777",
                    "luis.soto@ticketflow.com", "pass123", fechaHoy, 35,
                    TipoPerfil.ADMINISTRADOR.name(), "10101010", distrito.getIdDistrito(), region.getIdRegion(), 5001);
            admin = adminDAO.create(admin);
            System.out.println("  -> Administrador creado con ID: " + admin.getIdUsuario());

            Anfitrion anfitrion = new Anfitrion(0, "Pedro", "Castillo", "Rojas", "911222333",
                    "pedro.eventos@gmail.com", "pass456", fechaHoy, 40,
                    TipoPerfil.ANFITRION.name(), "20202020", distrito.getIdDistrito(), region.getIdRegion(),
                    "Eventos Pro S.A.C.", "20600012345", "0011-0123-45678901", Banco.BBVA);
            anfitrion = anfitrionDAO.create(anfitrion);
            System.out.println("  -> Anfitrión creado con ID: " + anfitrion.getIdUsuario());

            Cliente cliente = new Cliente(0, "Carlos", "Pérez", "Díaz", "944555666",
                    "carlos.perez@email.com", "pass789", fechaHoy, 28,
                    TipoPerfil.USUARIO.name(), "87654321", distrito.getIdDistrito(), region.getIdRegion(), 0);
            cliente = clienteDAO.create(cliente);
            System.out.println("  -> Cliente creado con ID: " + cliente.getIdUsuario());

            // ---------------------------------------------------------
            // FASE 3: FLUJO OPERATIVO (TRÁMITES)
            // ---------------------------------------------------------
            System.out.println("\n[3] Procesando Operaciones...");

            Solicitud solicitud = new Solicitud(0, "987654321", "pedro.eventos@gmail.com",
                    "Concierto de Jazz 2024 - Lima Jazz Club", null); // Asumiendo que EstadoSolicitud requiere un Enum válido
            solicitud = solicitudDAO.create(solicitud);
            System.out.println("  -> Solicitud creada con ID: " + solicitud.getIdSolicitud());

            Evento evento = new Evento(0, "Jazz Night Live", Categoria.Concierto,
                    LocalDate.of(2024, 12, 24), "2 horas", LocalTime.of(20, 0), LocalTime.of(22, 0),
                    EstadoEvento.ACEPTADO, "Av. La Marina 123", "Teatro Municipal",
                    150.00, "url_poster.jpg", 100, 0, 0.0, 0.0, anfitrion);
            evento = eventoDAO.create(evento);
            System.out.println("  -> Evento creado con ID: " + evento.getIdEvento());

            // ---------------------------------------------------------
            // FASE 4: TRANSACCIÓN Y CIERRE
            // ---------------------------------------------------------
            System.out.println("\n[4] Ejecutando Transacción Final...");

            Compra compra = new Compra(0, MetodoPago.YAPE, 2, LocalDate.now(), LocalTime.now(),
                    0, 300.00, 0.0, 300.00, EstadoCompra.CONFIRMADO, anfitrion, evento, cliente);
            compra = compraDAO.create(compra);
            System.out.println("  -> Compra registrada con ID: " + compra.getIdVenta());

            Pago pago = new Pago(0, LocalDate.now(), LocalTime.now(), 270.00,
                    EstadoPago.EN_DEUDA, anfitrion, evento);
            pago = pagoDAO.create(pago);
            System.out.println("  -> Pago generado (Deuda al Anfitrión) con ID: " + pago.getIdPago());

            System.out.println("\n=== PRUEBA DE INTEGRACIÓN FINALIZADA CON ÉXITO ===");

        } catch (Exception e) {
            System.err.println("\n[ERROR] Fallo en la prueba de integración:");
            e.printStackTrace();
        }


    }
}
