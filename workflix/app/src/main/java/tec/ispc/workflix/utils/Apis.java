package tec.ispc.workflix.utils;

public class Apis {

    // Colocar la IP Local de su servidor
    public static final String URL_001="http://192.168.0.125:8080/servicios/";
    public static final String URL_002="http://192.168.0.125:8080/usuarios/";

    public static final String URL_003="http://192.168.0.125:8080/prestaciones/";



    public static ServicioService getServicioService(){
        return Cliente.getCliente(URL_001).create(ServicioService.class);
    }
    public static UsuarioService getUsuarioService(){
        return Cliente.getCliente(URL_002).create(UsuarioService.class);
    }

    public static UsuarioServicioService getUsuarioServicioService(){
        return Cliente.getCliente(URL_003).create(UsuarioServicioService.class);
    }
}
