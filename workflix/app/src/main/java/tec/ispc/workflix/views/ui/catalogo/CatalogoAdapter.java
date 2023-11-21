package tec.ispc.workflix.views.ui.catalogo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;

public class CatalogoAdapter extends RecyclerView.Adapter<CatalogoAdapter.CatalogoViewHolder> {
    private List<Usuario> listaDeUsuarios;
    private Bitmap bitmap;

    private Context context;

    public CatalogoAdapter(List<Usuario> listaDeUsuarios, Context context) {
        this.listaDeUsuarios = listaDeUsuarios;
        this.context = context;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        listaDeUsuarios = usuarios;
        notifyDataSetChanged();
    };
    @Override
    public CatalogoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_profesional, parent, false);
        return new CatalogoViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return listaDeUsuarios.size();
    }

    public class CatalogoViewHolder extends RecyclerView.ViewHolder {
        public Button perfilServicio;
        public TextView perfilNombre;
        public TextView perfilDescripcion;
        public ImageView imagenFoto;
        public Button botonConsultar;


        public CatalogoViewHolder(View itemView) {
            super(itemView);
            perfilServicio = itemView.findViewById(R.id.perfilServicio);
            perfilNombre = itemView.findViewById(R.id.perfilNombre);
            perfilDescripcion = itemView.findViewById(R.id.perfilDescripcion);
            imagenFoto = itemView.findViewById(R.id.imagenFoto);
            botonConsultar = itemView.findViewById(R.id.botonConsultar);
        }

    };
    @Override
    public void onBindViewHolder(CatalogoViewHolder holder, int position) {
        Usuario usuario = listaDeUsuarios.get(position); // Obtener el usuario desde la lista
        int referencia = usuario.getId();

        String nombreCompleto = usuario.getNombre() + " " + usuario.getApellido();
        holder.perfilServicio.setText(usuario.getProfesion());
        holder.perfilNombre.setText(nombreCompleto);
        holder.perfilDescripcion.setText(usuario.getDescripcion());
        String foto = usuario.getFoto();
        Log.d("RUTA DE IMAGEN", "Ruta de la imagen: " + foto);
        // Agregando permisos cuando es android 6 o superior
        try {
            if (ContextCompat.checkSelfPermission(holder.itemView.getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) holder.itemView.getContext(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);
            } else {
                // Accede a la imagen aquí
                Picasso.get().invalidate(foto);
                Picasso.get().load(foto).into(holder.imagenFoto);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        };
        holder.botonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTarjetaAmpliadaActivity(position);
            }
        });
    };
    private void abrirTarjetaAmpliadaActivity(int position) {
        Usuario usuario = listaDeUsuarios.get(position);
        Intent intent = new Intent(context, TarjetaAmpliadaActivity.class);

        // Pasa los datos individuales del usuario a través del Intent
        intent.putExtra("nombreCompleto", usuario.getNombre() + " " + usuario.getApellido());
        intent.putExtra("imagenURL", usuario.getFoto());
        intent.putExtra("descripcion", usuario.getDescripcion());
        intent.putExtra("correo", usuario.getCorreo());
        intent.putExtra("telefono", usuario.getTelefono());
        intent.putExtra("ciudad", usuario.getCiudad());
        intent.putExtra("provincia", usuario.getProvincia());
        intent.putExtra("servicio", usuario.getProfesion());
        // Agrega más extras según sea necesario

        context.startActivity(intent);
    }
};