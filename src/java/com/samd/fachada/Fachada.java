package com.samd.fachada;

import com.samd.dao.PreguntaDao;
import com.samd.dao.PreguntaDaoImp;
import com.samd.dao.TemaDao;
import com.samd.dao.TemaDaoImp;
import com.samd.dao.TeoricoDao;
import com.samd.dao.TeoricoDaoImp;
import com.samd.dao.UsuarioDao;
import com.samd.dao.UsuarioDaoImp;
import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.excepciones.UsuarioExcepcion;
import com.samd.modelo.Pregunta;
import com.samd.modelo.Tema;
import com.samd.modelo.Teorico;
import com.samd.modelo.TipoUsuario;
import com.samd.modelo.Usuario;
import com.samd.utiles.Correo;
import com.samd.utiles.GeneradorDeContrasenia;
import java.util.List;

public class Fachada {

    private static Fachada instancia = null;

    public Fachada() {
    }

    public static Fachada getInstancia() {

        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

//    *****************************Metodos de Administracion de Usuarios**********************************
    public List<Usuario> getListaUsuarios() throws Exception {
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        return usuarioDao.listarUsuarios();
    }

    public boolean existeUsuario(Usuario usuario) throws PersistenciaExcepcion {

        boolean existe = false;
        UsuarioDao usuarioDao = new UsuarioDaoImp();

        if (usuarioDao.existeUsuario(usuario) != null) {

            existe = true;
        }
        return existe;
    }

    public void ingresarUsuario(Usuario usuario) throws PersistenciaExcepcion, UsuarioExcepcion {
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.ingresarUsuario(usuario);
    }

    public void eliminarUsuario(Usuario usuario) throws Exception {
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.eliminarUsuario(usuario);
    }

    public void modificarUsuario(Usuario usuario) throws PersistenciaExcepcion {

        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.modificarUsuario(usuario);
    }

    public List<TipoUsuario> cargarCompoTipoUsuario() throws PersistenciaExcepcion {

        UsuarioDao usuarioDao = new UsuarioDaoImp();
        return usuarioDao.cargarComboTipoUsuario();
    }

    public Usuario validarUsuario(Usuario usuario) throws PersistenciaExcepcion {
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        return usuarioDao.validarUsuario(usuario);
    }

    public void cambiarContrasenia(Usuario usuario) throws PersistenciaExcepcion {
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.cambiarContrasenia(usuario);

    }

    public void olvidoContrasenia(Usuario usuario) throws PersistenciaExcepcion {

        String mensaje;
        UsuarioDao usuarioDao = new UsuarioDaoImp();

        Usuario usuarioAux = new Usuario();

        usuarioAux = obtenerUsuario(usuario.getCedula());

        usuarioAux.setContrasenia(GeneradorDeContrasenia.getPassword());

        usuarioDao.cambiarContrasenia(usuarioAux);

        mensaje = "Se ha restablecido la contraseña del Usuario: " + usuarioAux.getCedula() + " a: " + usuarioAux.getContrasenia();
        Correo correo = new Correo();
        correo.setDestinatario(usuario.getCorreoElectronico());
        correo.setAsunto("Cambio de Contraseña");
        correo.setMensaje(mensaje);

        correo.enviarCorreo();

    }

    public Usuario obtenerUsuario(int cedula) throws PersistenciaExcepcion {

        UsuarioDao usuarioDao = new UsuarioDaoImp();
        return usuarioDao.obtenerUsuario(cedula);
    }

//    *******************************Fin de Administracion de Usuarios*************************************
//    *******************************Administración de Temas **********************************************
    public void ingresarTema(Tema tema) throws PersistenciaExcepcion {

        TemaDao temaDao = new TemaDaoImp();
        temaDao.ingresarTema(tema);
    }

    public List<Tema> cargarComboTema() throws PersistenciaExcepcion {
        TemaDao temaDao = new TemaDaoImp();
        return temaDao.cargarComboTema();

    }

    public List<Tema> listarTemas() throws PersistenciaExcepcion {
        TemaDao temaDao = new TemaDaoImp();
        return temaDao.listarTemas();
    }

    public void eliminarTema(Tema tema) throws PersistenciaExcepcion {
        TemaDao temaDao = new TemaDaoImp();
        temaDao.eliminarTema(tema);

    }

    public void modificarTema(Tema tema) throws PersistenciaExcepcion {

        TemaDao temaDao = new TemaDaoImp();
        temaDao.modificarTema(tema);
    }

//*********************************** Fin Administración de Temas *****************************************
//*********************************** Administraciòn de Teorico********************************************
    public void ingresarTeorico(Teorico teorico) throws PersistenciaExcepcion {

        TeoricoDao teoricoDao = new TeoricoDaoImp();
        teoricoDao.ingresarTeorico(teorico);
    }

    public List<Teorico> listarTeoricos() throws PersistenciaExcepcion {
        TeoricoDao teoricoDao = new TeoricoDaoImp();
        return teoricoDao.listarTeoricos();
    }

    public void eliminarTeorico(Teorico teorico) throws PersistenciaExcepcion {
        TeoricoDao teoricoDao = new TeoricoDaoImp();
        teoricoDao.eliminarTeorico(teorico);

    }

    public void modificarTeorico(Teorico teorico) throws PersistenciaExcepcion {

        TeoricoDao teoricoDao = new TeoricoDaoImp();
        teoricoDao.modificarTeorico(teorico);

    }

    public List<Teorico> retornarTeoricosTema(Tema tema) throws PersistenciaExcepcion {

        TeoricoDao teoricoDao = new TeoricoDaoImp();
        return teoricoDao.retornarTeoricosTema(tema);

    }

    public Teorico retornarTeoricoPorId(int numero) throws PersistenciaExcepcion {

        TeoricoDao teoricoDao = new TeoricoDaoImp();
        return teoricoDao.retornarTeoricoPorId(numero);

    }
//********************************** Gestion Preguntas ****************************************************

    public void ingresarPregunta(Pregunta pregunta) throws PersistenciaExcepcion {

        PreguntaDao preguntaDao = new PreguntaDaoImp();
        preguntaDao.ingresarPregunta(pregunta);

    }

    public List<Pregunta> listarPreguntas() throws PersistenciaExcepcion {

        PreguntaDao preguntaDao = new PreguntaDaoImp();
        return preguntaDao.listarPreguntas();
    }

    public void eliminarPregunta(Pregunta pregunta) throws PersistenciaExcepcion {
        PreguntaDao preguntaDao = new PreguntaDaoImp();
        preguntaDao.eliminarPregunta(pregunta);
    }

//********************************** Gestion Preguntas ****************************************************
}
