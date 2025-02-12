package tec.ispc.workflix.views.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;
import tec.ispc.workflix.utils.Apis;
import tec.ispc.workflix.utils.UsuarioService;
import tec.ispc.workflix.views.ui.adapters.UsuarioAdapter;

public class DashboardAdminVistaActivity extends AppCompatActivity {
    UsuarioService usuarioService;
    List<Usuario> listarUsuario= new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin_vista);


        listView=(ListView)findViewById(R.id.listViewAdminV);
        listAdministradores();
    }
    public void listAdministradores(){
        usuarioService= Apis.getUsuarioService();
        Call<List<Usuario>> call=usuarioService.getUsuarios();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                    if (response.isSuccessful()) {
                        List<Usuario> usuarios = response.body();
                        listarUsuario = filtrarUsuariosAdmin(usuarios);
                        listView.setAdapter(new UsuarioAdapter(DashboardAdminVistaActivity.this, R.layout.content_listar, listarUsuario));

                    }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.e("Error no pude recuperar la lista de usuarios:",t.getMessage());
            }
        });
    }
    private List<Usuario> filtrarUsuariosAdmin(List<Usuario> usuarios) {
        List<Usuario> usuariosAdmin = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.isIs_admin()) {
                usuariosAdmin.add(usuario);
            }
        }
        return usuariosAdmin;
    }
}
