package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.excepciones.UsuarioExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.TipoUsuario;
import com.samd.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped

public class AdminUsuariosBean {

    private List listaUsuarios;
    private Usuario usuario = new Usuario();
    private int idTipoUsuario;

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    private List<SelectItem> listaTipoUsuario;

    private final Fachada fachada = Fachada.getInstancia();

    public AdminUsuariosBean() {
        listaUsuarios = new ArrayList();

    }

    public List<SelectItem> getListaTipoUsuario() throws PersistenciaExcepcion {

        this.listaTipoUsuario = new ArrayList<>();
        List<TipoUsuario> aux = fachada.cargarCompoTipoUsuario();

        listaTipoUsuario.clear();

        for (TipoUsuario tu : aux) {
            SelectItem tipoUsuarioItem = new SelectItem(tu.getIdTipoUsuario(), tu.getDescripcion());
            this.listaTipoUsuario.add(tipoUsuarioItem);
        }

        return listaTipoUsuario;
    }

    public void setListaTipoUsuario(List<SelectItem> listaTipoUsuario) {
        this.listaTipoUsuario = listaTipoUsuario;
    }

    public List getListaUsuarios() throws Exception {
        return fachada.getListaUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setListaUsuarios(List listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void ingresarUsuario() throws UsuarioExcepcion, PersistenciaExcepcion {

        if (fachada.existeUsuario(usuario)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario ya existe", "Error"));
        } else {
            this.usuario.setIdTipo(idTipoUsuario);
            fachada.ingresarUsuario(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario ingresado correctamente", "Exito"));

        }
    }

    public void eliminarUsuario() throws Exception {
        fachada.eliminarUsuario(usuario);
    }

    public void modificarUsuario() throws Exception {
        fachada.modificarUsuario(usuario);
    }

}
