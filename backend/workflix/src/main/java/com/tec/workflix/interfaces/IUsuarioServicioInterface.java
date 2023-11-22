package com.tec.workflix.interfaces;

import com.tec.workflix.models.Servicio;
import com.tec.workflix.models.Usuario;
import com.tec.workflix.models.UsuarioServicio;

import java.util.List;
import java.util.Map;

public interface IUsuarioServicioInterface {

    public List<Map<String, Object>> listar();

    public int actualizarServicio(UsuarioServicio usuarioServicio);

}
