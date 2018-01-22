package xyz.digitalix.ext_example;

import android.util.Log;
import android.widget.Toast;

import com.rowl.plugdj.api.PDJExtension;
import com.rowl.plugdj.api.PlugAPI;
import com.rowl.plugdj.api.event.PDJRoomJoin;

/**
 * Created by digitalix on 22/01/2018.
 */

public class ExampleMain extends PDJExtension {

    private final static String TAG = "example-ext";

    @Override
    public boolean onEnable() {
        Log.i(TAG, "Yay! It Works!");
        Toast.makeText(getExtensionContext(), "Hello World!", Toast.LENGTH_LONG).show();
        getPlugAPI().addEventListener(this, PlugAPI.Event.ROOM_JOIN, new PlugAPI.EventListener<PDJRoomJoin>() {
            @Override
            public void onEvent(PDJRoomJoin pdjRoomJoin) {
                Toast.makeText(getExtensionContext(), "Joined: " + pdjRoomJoin.getRoomState().getMeta().getName(), Toast.LENGTH_LONG).show();
            }
        });
        return false;
    }

    @Override
    public boolean onDisable() {
        Toast.makeText(getExtensionContext(), ":'(", Toast.LENGTH_LONG).show();
        return false;
    }

}
