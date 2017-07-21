package cursofyb.test.appresto;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import cursofyb.test.appresto.modelo.Plato;


/**
 * Created by mdominguez on 14/07/17.
 */

public class ListaPlatosAdapter extends ArrayAdapter<Plato> {
    private static final String LOGNAME = "LAB3.listaPlatoAdapter";

    private LayoutInflater inflater;
    private Context contextoActividad;

    public ListaPlatosAdapter(Context ctx, List<Plato> lista) {
        super(ctx, R.layout.fila_plato,lista);
        this.contextoActividad=ctx;
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

        Button pedir= (Button) filaNueva.findViewById(R.id.btnHacerPedido);
        pedir.setTag(position); //For passing the list item index
        pedir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(LOGNAME,"TAG POSITION : "+v.getTag().toString());
                String nombrePlato = ListaPlatosAdapter.this.getItem(Integer.parseInt(v.getTag().toString())).getNombre();
                HacerPedidoIntentService.startActionHacerPedido(contextoActividad,nombrePlato);
            }
        });
        return filaNueva;
    }
}
