package cursofyb.test.appresto;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cursofyb.test.appresto.modelo.Plato;

public class ListaPlatos extends AppCompatActivity {

    private final String LOG_D="LISTA_PLATOS_LOGGER";

    private ListaPlatosAdapter adaptador;
    private ListView listaPlatos;
    private Button btnVolver;
    private final int CODIGO_ALTA = 100;
    private final int CODIGO_EDICION = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_platos);

        this.listaPlatos = (ListView) findViewById(R.id.listaPlatos);
        this.adaptador = new ListaPlatosAdapter(this,MainActivity.listaPlatos);
        this.listaPlatos.setAdapter(this.adaptador);
        Log.d(LOG_D," lista platos: "+MainActivity.listaPlatos);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaPlatos.this,MainActivity.class);
                //startActivity(i);
                startActivityForResult(i, CODIGO_ALTA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Comprobamos si el resultado de la segunda actividad es "RESULT_CANCELED".
        if (resultCode == RESULT_CANCELED) {
            // Si es así mostramos mensaje de cancelado por pantalla.
            Toast.makeText(this, "Resultado cancelado", Toast.LENGTH_SHORT)
                    .show();
        } else {
            // De lo contrario, recogemos el resultado de la segunda actividad.
            Plato plato= (Plato) data.getExtras().getSerializable("PLATO");
            // Y tratamos el resultado en función de si se lanzó para rellenar el
            // nombre o el apellido.
            switch (requestCode) {
                case CODIGO_ALTA:
                    MainActivity.listaPlatos.add(plato);
                    this.adaptador.notifyDataSetChanged();
                    break;
                case CODIGO_EDICION:
                    break;
            }
        }
    }

}
