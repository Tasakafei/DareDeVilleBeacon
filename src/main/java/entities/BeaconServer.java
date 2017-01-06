package entities;

import javax.bluetooth.RemoteDevice;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import java.io.*;
import java.util.Scanner;

/**
 * Created by cazala on 04/01/17.
 */
public class BeaconServer {

    //start server
    public void startServer() throws IOException {

        //Create a UUID for SPP
        UUID uuid = new UUID("1101", true);
        //Create the service url
        String connectionString = "btspp://localhost:" + uuid + ";name=Sample SPP Server";

        //open server url
        StreamConnectionNotifier streamConnNotifier = (StreamConnectionNotifier) Connector.open(connectionString);

        //Wait for client connection
        System.out.println("\nServer Started...");
        StreamConnection connection;
        while (true) {
            System.out.println("Waiting for clients to connect...");
            connection = streamConnNotifier.acceptAndOpen();
            RemoteDevice dev = RemoteDevice.getRemoteDevice(connection);
//            System.out.println("Remote device address: " + dev.getBluetoothAddress());
//            System.out.println("Remote device name: " + dev.getFriendlyName(true));

            //read string from spp client
            InputStream inStream=connection.openInputStream();
            BufferedReader bReader=new BufferedReader(new InputStreamReader(inStream));

            String lineRead=bReader.readLine();
            System.out.println("Message received from device : " + lineRead + "\n");

            System.out.print("Enter distance from device > ");


            //send response to spp client
            OutputStream outStream = connection.openOutputStream();
            PrintWriter pWriter = new PrintWriter(new OutputStreamWriter(outStream));

            String messageSent = (new Scanner(System.in)).next();

            pWriter.write(messageSent+" \r\n");
//            pWriter.write("Diriges toi vers l'arbre. \r\n");
            pWriter.flush();
            pWriter.close();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("FInished");
            connection.close();
        }
    }
}