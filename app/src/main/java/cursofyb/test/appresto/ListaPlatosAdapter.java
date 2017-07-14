package cursofyb.test.appresto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cursofyb.test.appresto.modelo.Plato;


/**
 * Created by mdominguez on 14/07/17.
 */

public class ListaPlatosAdapter extends ArrayAdapter<Plato> {

    private LayoutInflater inflater;

    public ListaPlatosAdapter(Context ctx, List<Plato> lista) {
        super(ctx, R.layout.fila_plato,lista);
        this.inflater = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View filaNueva = convertView;
        if (filaNueva == null) filaNueva = inflater.inflate(R.layout.fila_plato, parent, false);
        TextView titulo = (TextView) filaNueva.findViewById(R.id.tituloPlato);
        TextView precio = (TextView) filaNueva.findViewById(R.id.precioPlato);
        Plato unPlato = this.getItem(position);
        titulo.setText(unPlato.getNombre());
        titulo.setText(unPlato.getPrecio().toString());
        return filaNueva;
    }
}
