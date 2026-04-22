package pe.edu.pucp.ticketflow;

// IMPORTS
// MODEL
import jdk.jfr.Configuration;
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
        RegionDAO regionDAO = new RegionDAOimpl();
        DistritoDAO distritoDAO = new DistritoDAOimpl();
        UsuarioDAO usuarioDAO = new UsuarioDAOimpl();
        PuntosBonusDAO puntosBonusDAO = new PuntosBonusDAOimpl();
        AdministradorDAO adminDAO = new AdministradorDAOimpl();

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
            // ENTIDAD 3: USUARIO
            // ====================================================================
            System.out.println("\n--- TEST ENTIDAD: USUARIO ---");
            Date fechaHoy = new Date(System.currentTimeMillis());

            // A) CREATE
            Usuario usuario = new Usuario(
                    0,
                    "Luis",
                    "Soto",
                    "Gomez",
                    "999888777",
                    "luis.soto@ticketflow.com",
                    "pass123",
                    fechaHoy,
                    35,
                    "CLIENTE",
                    "10101010",
                    disLeido.getIdDistrito(),
                    regLeida.getIdRegion()
            );

            usuario = usuarioDAO.create(usuario);
            int idUsu = usuario.getIdUsuario();
            System.out.println("1. INSERT: Usuario creado con ID: " + idUsu);

            // B) READ
            Usuario usuLeido = usuarioDAO.read(idUsu);
            System.out.println("2. READ: Usuario leído de BD: "
                    + usuLeido.getNombre() + " "
                    + usuLeido.getApellidoPaterno()
                    + " | Correo: " + usuLeido.getCorreoElectronico());

            // C) UPDATE
            usuLeido.setTelefono("900000000");
            usuarioDAO.update(usuLeido);
            System.out.println("3. UPDATE: Teléfono modificado a: "
                    + usuarioDAO.read(idUsu).getTelefono());

            // D) LIST
            List<Usuario> listaUsuarios = usuarioDAO.listAll();
            System.out.println("4. LIST: Total de usuarios en BD: " + listaUsuarios.size());


            // ====================================================================
            // ENTIDAD 4: ADMINISTRADOR
            // ====================================================================
            System.out.println("\n--- TEST ENTIDAD: ADMINISTRADOR ---");

            // A) CREATE
            Administrador admin = new Administrador(
                    0,
                    "Luis",
                    "Soto",
                    "Gomez",
                    "999888777",
                    "luis.soto@ticketflow.com",
                    "pass123",
                    fechaHoy,
                    35,
                    "ADMIN",
                    "10101010",
                    disLeido.getIdDistrito(),
                    regLeida.getIdRegion(),
                    "5001"
            );

            // Primero se crea en Usuario
            admin = (Administrador) usuarioDAO.create(admin);

            // Luego se crea en Administrador
            admin = adminDAO.create(admin);

            int idAdmin = admin.getIdUsuario();
            System.out.println("1. INSERT: Admin creado con ID: " + idAdmin);

            // B) READ
            Administrador adminLeido = adminDAO.read(idAdmin);

            System.out.println("2. READ: Admin leído de BD: "
                    + adminLeido.getNombre() + " "
                    + adminLeido.getApellidoPaterno()
                    + " | Correo: " + adminLeido.getCorreoElectronico()
                    + " | Código Admin: " + adminLeido.getCodigoAdmin());

            // C) UPDATE
            adminLeido.setTelefono("900000000");   // Usuario
            adminLeido.setCodigoAdmin("9999");     // Administrador

            // Actualizar Usuario (datos base)
            usuarioDAO.update(adminLeido);

            // Actualizar Administrador (datos específicos)
            adminDAO.update(adminLeido);

            Administrador actualizado = adminDAO.read(idAdmin);

            System.out.println("3. UPDATE: "
                    + actualizado.getNombre()
                    + " | Tel: " + actualizado.getTelefono()
                    + " | Código: " + actualizado.getCodigoAdmin());

            // D) LIST
            List<Administrador> listaAdmins = adminDAO.listAll();
            System.out.println("4. LIST: Total de administradores en BD: " + listaUsuarios.size());

            // ====================================================================
            // BLOQUE DELETE: ELIMINACIÓN EN CASCADA INVERSA
            // ====================================================================
            System.out.println("\n==================================================");
            System.out.println("   INICIANDO PRUEBAS DE ELIMINACIÓN (DELETE)");
            System.out.println("==================================================");
            System.out.println("Borrando de hijo a padre para no romper llaves foráneas...");

            // Primero borrar la parte Administrador
            adminDAO.delete(idAdmin);
            System.out.println("- Administrador eliminado (ID: " + idAdmin + "). Resultado read: "
                    + (adminDAO.read(idAdmin) == null ? "null" : "Error"));

            // Luego borrar el Usuario asociado al Administrador
            usuarioDAO.delete(idAdmin);
            System.out.println("- Usuario del Administrador eliminado (ID: " + idAdmin + "). Resultado read: "
                    + (usuarioDAO.read(idAdmin) == null ? "null" : "Error"));

            usuarioDAO.delete(idUsu);
            System.out.println("- Usuario eliminado (ID: " + idUsu + "). Resultado read: "
                    + (usuarioDAO.read(idUsu) == null ? "null" : "Error"));

            distritoDAO.delete(idDis);
            System.out.println("- Distrito eliminado (ID: " + idDis + "). Resultado read: "
                    + (distritoDAO.read(idDis) == null ? "null" : "Error"));

            regionDAO.delete(idReg);
            System.out.println("- Región eliminada (ID: " + idReg + "). Resultado read: "
                    + (regionDAO.read(idReg) == null ? "null" : "Error"));

            System.out.println("\n** TODAS LAS PRUEBAS FINALIZADAS CON ÉXITO **");

        } catch (Exception e) {
            System.err.println("\n[ERROR CRÍTICO] La prueba falló en la ejecución de la Base de Datos:");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
