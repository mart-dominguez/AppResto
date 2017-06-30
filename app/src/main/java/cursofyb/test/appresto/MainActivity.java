package cursofyb.test.appresto;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import cursofyb.test.appresto.modelo.Plato;
import cursofyb.test.appresto.modelo.TipoPlato;

public class MainActivity extends AppCompatActivity {

    private Spinner tipoPlato;
    private ArrayAdapter<TipoPlato> adaptadorTipoPlato;
    private ArrayList<Plato> listaPlatos;
    private EditText nombre;
    private EditText precio;
    private EditText descripcion;
    private Button btnGuardar;
    private Button btnNuevo;
    private Button btnCancelar;
    private boolean flagPlatoNuevo;
    private Plato platoNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.nombre = (EditText) findViewById(R.id.txtNombrePlato);
        this.precio  = (EditText) findViewById(R.id.txtPrecio);
        this.descripcion = (EditText) findViewById(R.id.txtDescripcion);;
        this.btnGuardar = (Button) findViewById(R.id.btnGuardar);
        this.btnNuevo = (Button) findViewById(R.id.btnGuardar);
        this.btnCancelar= (Button) findViewById(R.id.btnCancelar);

        tipoPlato = (Spinner) findViewById(R.id.cmbTipoPlato);
        tipoPlato.setOnItemSelectedListener(cmbTipoPlatoListener );
        adaptadorTipoPlato = new ArrayAdapter<TipoPlato>(this,android.R.layout.simple_spinner_dropdown_item,this.obtenerListaPlato());
        tipoPlato.setAdapter(adaptadorTipoPlato);
        this.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flagPlatoNuevo){
                    platoNuevo.setDescripcion(descripcion.getText().toString());
                    platoNuevo.setNombre(nombre.getText().toString());
                    platoNuevo.setPrecio(Double.parseDouble(precio.getText().toString()));
                    listaPlatos.add(platoNuevo);
                }
                limpiarForm();
            }
        });

        this.btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                platoNuevo = new Plato();
                flagPlatoNuevo=true;
            }
        });

        this.btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarForm();
            }
        });
    };

    private void limpiarForm(){
        platoNuevo=null;
        flagPlatoNuevo=false;
        descripcion.setText("");
        nombre.setText("");
        precio.setText("0.0");

    }

    private AdapterView.OnItemSelectedListener cmbTipoPlatoListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if(flagPlatoNuevo){
                platoNuevo.setTipo((TipoPlato)adapterView.getItemAtPosition(i));
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_carta) {
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_plato) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private TipoPlato[] obtenerListaPlato(){
        TipoPlato[] arreglo = new TipoPlato[5];
        arreglo[0]=new TipoPlato("Entrada");
        arreglo[1]=new TipoPlato("Principal");
        arreglo[2]=new TipoPlato("Postre");
        arreglo[3]=new TipoPlato("Minuta");
        arreglo[4]=new TipoPlato("Bebida");
        return arreglo;
    }
}
