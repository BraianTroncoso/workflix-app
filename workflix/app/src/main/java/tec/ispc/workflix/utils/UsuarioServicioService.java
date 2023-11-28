package tec.ispc.workflix.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tec.ispc.workflix.models.UsuarioServicio;

public interface UsuarioServicioService {
    @GET("listar")
    Call<List<UsuarioServicio>> getUsuariosServicios();
    @POST("actualizar/{id}")
    Call<UsuarioServicio>updateUsuariosPrestaciones(@Body UsuarioServicio usuarioServicio, @Path("id") int id);
}
