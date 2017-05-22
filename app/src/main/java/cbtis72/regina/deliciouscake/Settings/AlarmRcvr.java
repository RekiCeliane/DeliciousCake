package cbtis72.regina.deliciouscake.Settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmRcvr extends BroadcastReceiver {
    public AlarmRcvr() {
    }

    @Override
    public void onReceive(Context context, Intent intent){


        Toast.makeText(context, "¡Es hora de cocinar un rico pastel!", Toast.LENGTH_SHORT).show();

    }
}
