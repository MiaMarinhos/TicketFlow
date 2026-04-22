package pe.edu.pucp.ticketflow;

// IMPORTS
// MODEL
import pe.edu.pucp.ticketflow.compra.model.Compra;
import pe.edu.pucp.ticketflow.compra.model.EstadoCompra;
import pe.edu.pucp.ticketflow.compra.model.GestorCompras;
import pe.edu.pucp.ticketflow.compra.model.MetodoPago;
import pe.edu.pucp.ticketflow.distrito.model.Distrito;
import pe.edu.pucp.ticketflow.evento.model.Categoria;
import pe.edu.pucp.ticketflow.evento.model.EstadoEvento;
import pe.edu.pucp.ticketflow.evento.model.EstadoPublicacion;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.evento.model.GestorEvento;
import pe.edu.pucp.ticketflow.pago.model.EstadoPago;
import pe.edu.pucp.ticketflow.pago.model.GestorPagos;
import pe.edu.pucp.ticketflow.pago.model.Pago;
import pe.edu.pucp.ticketflow.puntos_bonus.model.PuntosBonus;
import pe.edu.pucp.ticketflow.region.model.Region;
import pe.edu.pucp.ticketflow.solicitud.model.EstadoSolicitud;
import pe.edu.pucp.ticketflow.solicitud.model.GestorSolicitud;
import pe.edu.pucp.ticketflow.solicitud.model.Solicitud;
import pe.edu.pucp.ticketflow.usuario.model.Administrador;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;
import pe.edu.pucp.ticketflow.usuario.model.Banco;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;
import pe.edu.pucp.ticketflow.usuario.model.EstadoPerfil;
import pe.edu.pucp.ticketflow.usuario.model.Genero;
import pe.edu.pucp.ticketflow.usuario.model.GestorUsuario;
import pe.edu.pucp.ticketflow.usuario.model.TipoPerfil;
import pe.edu.pucp.ticketflow.usuario.model.Usuario;

// DAO
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

// DAOIMPL
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

import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.util.List;


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

        // --- INICIALIZACIÓN DE DAOs ---
        RegionDAOimpl regionDAO = new RegionDAOimpl();
        DistritoDAOimpl distritoDAO = new DistritoDAOimpl();
        AdministradorDAOimpl adminDAO = new AdministradorDAOimpl();
        AnfitrionDAOimpl anfitrionDAO = new AnfitrionDAOimpl();
        EventoDAOimpl eventoDAO = new EventoDAOimpl();

        System.out.println("==================================================");
        System.out.println("   INICIANDO PRUEBAS CRUD - TICKETFLOW (LAB 5)");
        System.out.println("==================================================\n");

        try {
            // ====================================================================
            // ENTIDAD 1: REGIÓN
            // ====================================================================
            System.out.println("--- TEST ENTIDAD: REGION ---");
            // A) CREATE
            Region region = new Region(0, "Lima Prueba");
            region = regionDAO.create(region);
            int idReg = region.getIdRegion();
            System.out.println("1. INSERT: Región creada con ID: " + idReg);

            // B) READ
            Region regLeida = regionDAO.read(idReg);
            System.out.println("2. READ: Región leída de BD: " + regLeida.getNombre());

            // C) UPDATE
            regLeida.setNombre("Lima Metropolitana Modificada");
            regionDAO.update(regLeida);
            System.out.println("3. UPDATE: Nombre modificado a: " + regionDAO.read(idReg).getNombre());

            // D) LIST
            List<Region> listaRegiones = regionDAO.listAll();
            System.out.println("4. LIST: Total de regiones en BD: " + listaRegiones.size());


            // ====================================================================
            // ENTIDAD 2: DISTRITO
            // ====================================================================
            System.out.println("\n--- TEST ENTIDAD: DISTRITO ---");
            // A) CREATE
            Distrito distrito = new Distrito(0, "San Miguel Prueba", regLeida);
            distrito = distritoDAO.create(distrito);
            int idDis = distrito.getIdDistrito();
            System.out.println("1. INSERT: Distrito creado con ID: " + idDis);

            // B) READ
            Distrito disLeido = distritoDAO.read(idDis);
            System.out.println("2. READ: Distrito leído de BD: " + disLeido.getNombre() + " (Región ID: " + disLeido.getRegion().getIdRegion() + ")");

            // C) UPDATE
            disLeido.setNombre("Pueblo Libre Modificado");
            distritoDAO.update(disLeido);
            System.out.println("3. UPDATE: Nombre modificado a: " + distritoDAO.read(idDis).getNombre());

            // D) LIST
            List<Distrito> listaDistritos = distritoDAO.listAll();
            System.out.println("4. LIST: Total de distritos en BD: " + listaDistritos.size());


            // ====================================================================
            // ENTIDAD 3: USUARIO - ADMINISTRADOR
            // ====================================================================
            System.out.println("\n--- TEST ENTIDAD: ADMINISTRADOR ---");
            Date fechaHoy = new Date(System.currentTimeMillis());

            // A) CREATE
            Administrador admin = new Administrador(0, "Luis", "Soto", "Gomez", "999888777",
                    "luis.soto@ticketflow.com", "pass123", fechaHoy, 35,
                    TipoPerfil.ADMINISTRADOR.name(), "10101010", disLeido.getIdDistrito(), regLeida.getIdRegion(), 5001);
            admin = adminDAO.create(admin);
            int idAdmin = admin.getIdUsuario();
            System.out.println("1. INSERT: Admin creado con ID: " + idAdmin);

            // B) READ
            Administrador adminLeido = adminDAO.read(idAdmin);
            System.out.println("2. READ: Admin leído de BD, Correo: " + adminLeido.getCorreoElectronico());

            // C) UPDATE
            adminLeido.setTelefono("900000000"); // Cambiamos el teléfono
            adminDAO.update(adminLeido);
            System.out.println("3. UPDATE: Teléfono modificado a: " + adminDAO.read(idAdmin).getTelefono());

            // D) LIST
            List<Administrador> listaAdmins = adminDAO.listAll();
            System.out.println("4. LIST: Total de Administradores en BD: " + listaAdmins.size());


            // ====================================================================
            // ENTIDAD 4: USUARIO - ANFITRIÓN
            // ====================================================================
            System.out.println("\n--- TEST ENTIDAD: ANFITRION ---");

            // A) CREATE
            Anfitrion anfitrion = new Anfitrion(0, "Pedro", "Castillo", "Rojas", "911222333",
                    "pedro.eventos@gmail.com", "pass456", fechaHoy, 40,
                    TipoPerfil.ANFITRION.name(), "20202020", disLeido.getIdDistrito(), regLeida.getIdRegion(),
                    "Eventos Pro S.A.C.", "20600012345", "0011-0123-45678901", Banco.BBVA);
            anfitrion = anfitrionDAO.create(anfitrion);
            int idAnf = anfitrion.getIdUsuario();
            System.out.println("1. INSERT: Anfitrión creado con ID: " + idAnf);

            // B) READ
            Anfitrion anfLeido = anfitrionDAO.read(idAnf);
            System.out.println("2. READ: Anfitrión leído de BD, Empresa: " + anfLeido.getRazonSocial());

            // C) UPDATE
            anfLeido.setBank(Banco.BCP); // Cambiamos de banco
            anfitrionDAO.update(anfLeido);
            System.out.println("3. UPDATE: Banco modificado a: " + anfitrionDAO.read(idAnf).getBank());

            // D) LIST
            List<Anfitrion> listaAnfitriones = anfitrionDAO.listAll();
            System.out.println("4. LIST: Total de Anfitriones en BD: " + listaAnfitriones.size());


            // ====================================================================
            // ENTIDAD 5: EVENTO
            // ====================================================================
            System.out.println("\n--- TEST ENTIDAD: EVENTO ---");

            // A) CREATE (Usando los objetos leídos previamente para asegurar integridad)
            Evento evento = new Evento(0, "Concierto de Prueba", Categoria.Concierto,
                    LocalDate.of(2024, 12, 24), "2 horas", LocalTime.of(20, 0), LocalTime.of(22, 0),
                    EstadoEvento.ACEPTADO, "Av. La Marina 123", "Teatro Prueba",
                    150.00, "url_poster.jpg", 100, 0, 0.0,
                    0.0, anfLeido,"Descripción detallada del concierto de prueba.",disLeido,
                    EstadoPublicacion.En_revision);

            evento = eventoDAO.create(evento);
            int idEve = evento.getIdEvento();
            System.out.println("1. INSERT: Evento creado con ID: " + idEve);

            // B) READ
            Evento eveLeido = eventoDAO.read(idEve);
            if (eveLeido != null) {
                System.out.println("2. READ: Datos recuperados correctamente.");
                // Demostramos navegabilidad: Evento -> Anfitrión -> Nombre
                System.out.println("     - Organizador: " + eveLeido.getAnfi().getNombre());
                // Demostramos navegabilidad: Evento -> Distrito -> Región -> Nombre
                System.out.println("     - Ubicación: " + eveLeido.getDiscrito().getNombre() +
                        " (" + eveLeido.getDiscrito().getRegion().getNombre() + ")");
            }

            // C) UPDATE
            double nuevoPrecio = 299.99;
            eveLeido.setPrecioEntrada(nuevoPrecio);
            eventoDAO.update(eveLeido);
            Evento eveActualizado = eventoDAO.read(idEve);
            if (eveActualizado.getPrecioEntrada() == nuevoPrecio) {
                System.out.println("3. UPDATE: Precio actualizado y verificado en BD: S/ " + nuevoPrecio);
            }

            // D) LIST
            List<Evento> listaEventos = eventoDAO.listAll();
            System.out.println("4. LIST: Total de Eventos en BD: " + listaEventos.size());



            // ====================================================================
            // BLOQUE DELETE: ELIMINACIÓN EN CASCADA INVERSA
            // ====================================================================
            System.out.println("\n==================================================");
            System.out.println("   INICIANDO PRUEBAS DE ELIMINACIÓN (DELETE)");
            System.out.println("==================================================");
            System.out.println("Borrando de hijo a padre para no romper llaves foráneas...");

            eventoDAO.delete(idEve);
            System.out.println("- Evento eliminado (ID: " + idEve + "). Resultado read: " + (eventoDAO.read(idEve) == null ? "null" : "Error"));

            anfitrionDAO.delete(idAnf);
            System.out.println("- Anfitrión eliminado (ID: " + idAnf + "). Resultado read: " + (anfitrionDAO.read(idAnf) == null ? "null" : "Error"));

            adminDAO.delete(idAdmin);
            System.out.println("- Administrador eliminado (ID: " + idAdmin + "). Resultado read: " + (adminDAO.read(idAdmin) == null ? "null" : "Error"));

            distritoDAO.delete(idDis);
            System.out.println("- Distrito eliminado (ID: " + idDis + "). Resultado read: " + (distritoDAO.read(idDis) == null ? "null" : "Error"));

            regionDAO.delete(idReg);
            System.out.println("- Región eliminada (ID: " + idReg + "). Resultado read: " + (regionDAO.read(idReg) == null ? "null" : "Error"));

            System.out.println("\n*** TODAS LAS PRUEBAS FINALIZADAS CON ÉXITO ***");

        } catch (Exception e) {
            System.err.println("\n[ERROR CRÍTICO] La prueba falló en la ejecución de la Base de Datos:");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
