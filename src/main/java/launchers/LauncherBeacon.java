package launchers;

import entities.BeaconServer;

import javax.bluetooth.LocalDevice;
import java.io.IOException;

/**
 * Created by cazala on 04/01/17.
 */
public class LauncherBeacon {
    public static void main(String[] args) throws IOException {
        System.out.println("===== Server Starting =====");
        //display local device address and name
        LocalDevice localDevice = LocalDevice.getLocalDevice();
        System.out.println("Address: "+localDevice.getBluetoothAddress());
        System.out.println("Name: "+localDevice.getFriendlyName());
        System.out.println("Hello, I am a beacon !");

        BeaconServer SPPServer=new BeaconServer();
        SPPServer.startServer();

    }
}
