package tec.ispc.workflix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsuarioServicio {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("usuario_id")
    @Expose
    private Usuario usuario_id;

    @SerializedName("servicio_id")
    @Expose
    private Servicio servicio_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Servicio getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(Servicio servicio_id) {
        this.servicio_id = servicio_id;
    }
}
