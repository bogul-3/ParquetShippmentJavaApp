package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author bogda
 */
public class KlijentKomunikacija {

    Socket soket;
    private static KlijentKomunikacija instance;

    private KlijentKomunikacija() {
        try {
            soket = new Socket("localhost", 9001);
        } catch (IOException ex) {
            System.out.println("Greska pri povezivanju: " + ex.getMessage());
        }
    }

    public Socket getSoket() {
        return soket;
    }

    public static KlijentKomunikacija getInstance() {
        if (instance == null) {
            instance = new KlijentKomunikacija();
        }
        return instance;
    }

    public synchronized void posaljiZahtev(KlijentskiZahtev kz) {
        try {
            if (soket == null || soket.isClosed()) {
                JOptionPane.showMessageDialog(null, "Nemoguce ostvariti konekciju sa serverom", "GREKSA", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(kz);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(KlijentKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized ServerskiOdgovor primiOdgovor() {
        if (soket == null || soket.isClosed()) {
            JOptionPane.showMessageDialog(null, "Nemoguce ostvariti konekciju sa serverom", "GREKSA", JOptionPane.ERROR_MESSAGE);
            return new ServerskiOdgovor(null, new Exception("Nemoguce ostvariti konekciju sa serverom"));
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            return (ServerskiOdgovor) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(KlijentKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
