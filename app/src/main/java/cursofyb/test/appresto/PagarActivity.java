package cursofyb.test.appresto;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class PagarActivity extends AppCompatActivity {
    private static final String LOGNAME = "LAB3.pagarActy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(LOGNAME,"Entra a pagar");
        Log.d(LOGNAME,"Extras: "+getIntent().getExtras());
        String dato = getIntent().getExtras().getString("PEDIDO_COMPLETO");
        if(dato.equalsIgnoreCase("true")){
            Log.d(LOGNAME,"Limpia Notificacion");
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.cancel(999);
        }
    }

}
