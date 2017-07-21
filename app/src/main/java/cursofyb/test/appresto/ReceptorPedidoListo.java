package cursofyb.test.appresto;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

public class ReceptorPedidoListo extends BroadcastReceiver {

    public final static String accion = "cursofyb.test.appresto.PEDIDO_LISTO";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        crearNotificacion(context,intent.getStringExtra("PLATO"));
    }

    private void crearNotificacion(Context ctx,String msg){
        NotificationManager managerNotif = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(ctx,PagarActivity.class);
        intent.putExtra("PEDIDO_COMPLETO","true");
        PendingIntent pi = PendingIntent.getActivity(ctx,0,intent,0);
        NotificationCompat.Builder constructorNotif ;
        constructorNotif = (NotificationCompat.Builder) new NotificationCompat.Builder(ctx)
                    .setSmallIcon(R.drawable.pedido)
                    .setContentTitle("Pedido Listo")
                    .setContentText("Pedido "+msg+" listo!!")
                .setContentIntent(pi);
        managerNotif.notify(999,constructorNotif.build());

    }

}
