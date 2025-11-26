package komunikacija;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import postavke.Postavke;
import view.FormaServer;

public class PokreniServer extends Thread {

    private KomunikacijaServer nit;
    private ServerSocket serverSoket = null;
    private volatile boolean aktivan = true;

    @Override
    public void run() {
        Postavke postavke = new Postavke();
       
        
        try {
            InputStream in = new FileInputStream("Postavke.properties");
            postavke.getProperties().load(in);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FormaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        try {
            serverSoket = new ServerSocket(Integer.parseInt(postavke.getProperties().getProperty("serverSoket")));
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Server je pokrenut na portu " + serverSoket.getLocalPort());
        while (aktivan) {
            try {
                Socket s = serverSoket.accept();
                nit = new KomunikacijaServer(s);
                nit.start();
            } catch (IOException e) {
                if (aktivan) {
                    Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, e);
                } else {
                    System.out.println("Server zatvoren.");
                }
            }
        }
    }

    public void close() {
        aktivan = false;
        try {
            if (serverSoket != null && !serverSoket.isClosed()) {
                serverSoket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServerSocket getServerSoket() {
        return serverSoket;
    }

}
