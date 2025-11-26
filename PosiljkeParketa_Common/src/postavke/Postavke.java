/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postavke;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bogda
 */
public class Postavke {
    private Properties p = new Properties();
    private final String FILE_NAME = "Postavke.properties";

    public Postavke() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            p.load(fis);
        } catch (FileNotFoundException ex) {
            p.setProperty("dbName", "posiljkeparketa");
            p.setProperty("dbURL", "jdbc:mysql://localhost:3306/" + p.getProperty("dbName"));
            p.setProperty("user", "root");
            p.setProperty("pass", "");
            p.setProperty("serverSoket", "9001");
            sacuvaj();
        } catch (IOException ex) {
            Logger.getLogger(Postavke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Properties getProperties() {
        return p;
    }

    public void setProperties(Properties p) {
        this.p = p;
    }

    public void sacuvaj() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            p.store(fos, null);
        } catch (IOException ex) {
            Logger.getLogger(Postavke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
