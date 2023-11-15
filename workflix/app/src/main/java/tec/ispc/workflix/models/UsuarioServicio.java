package tec.ispc.workflix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsuarioServicio {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("usuario_id")
    @Expose
    private Usuario usuario;

    @SerializedName("servicio_id")
    @Expose
    private Servicio servicio;


}
