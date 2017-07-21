package cursofyb.test.appresto;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class HacerPedidoIntentService extends IntentService {
    private static final String LOGNAME = "LAB3.hacerPdidoSrv";

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String HACER_PEDIDO = "cursofyb.test.appresto.action.HACER_PEDIDO";

    // TODO: Rename parameters
    private static final String ID_PLATO = "cursofyb.test.appresto.extra.PARAM1";

    //Crear un handler
    private Handler handlerNotificacion= null;


    public HacerPedidoIntentService() {
        super("HacerPedidoIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionHacerPedido(Context context, String param1) {
        Intent intent = new Intent(context, HacerPedidoIntentService.class);
        intent.setAction(HACER_PEDIDO);
        intent.putExtra(ID_PLATO, param1);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (HACER_PEDIDO.equals(action)) {
                final String param1 = intent.getStringExtra(ID_PLATO);
                handlerNotificacion = new Handler();
                handleActionHacerPedido(param1);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionHacerPedido(String param1)  {
        // TODO: Handle action Foo
        // hacer q el hilo demore y luego genere una notificacion
        final String nombre = param1;
        Log.d(LOGNAME,"entro");
        try {
            Thread.currentThread().sleep(2000);
            Log.d(LOGNAME,"mando handler");
            handlerNotificacion.post(new Runnable() {
                @Override
                public void run() {
                    //lanzar un broadcast receiver
                    Log.d(LOGNAME,"manda broadcas");

                    Intent intent = new Intent();
                    intent.setAction(ReceptorPedidoListo.accion);
                    intent.putExtra("PLATO",nombre);
                    sendBroadcast(intent);
                    Log.d(LOGNAME,"mando broadcast");

                }
            });
            Log.d(LOGNAME,"sale servicio");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
