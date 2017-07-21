package cursofyb.test.appresto;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PedidoService extends Service {
    public PedidoService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
