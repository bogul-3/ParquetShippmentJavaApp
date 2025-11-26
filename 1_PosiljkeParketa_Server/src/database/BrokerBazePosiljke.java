package database;

import domen.Prodavnica;
import domen.StavkaPotvrde;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import opstiDomen.OpstiDomenskiObjekat;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Properties;
import postavke.Postavke;

public class BrokerBazePosiljke extends BrokerBazePodataka {

    Connection konekcija = null;

    public BrokerBazePosiljke() {

    }

    @Override
    public boolean napraviKonekciju() {

        try {
            Postavke postavke = new Postavke();
            Properties p = postavke.getProperties();
            InputStream in = null;
            try {
                in = new FileInputStream("Postavke.properties");
            } catch (FileNotFoundException ex) {
                System.out.println("Ne mogu da ubacim postavke u input stream");
                Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                p.load(in);
            } catch (IOException ex) {
                System.out.println("Ne mogu da postavim elemente u Properties objekat");
                Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
            }
            konekcija = DriverManager.getConnection(p.getProperty("dbURL"), p.getProperty("user"), p.getProperty("pass"));
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Ne mogu da napravim vezu sa bazom");
            Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public void zatvoriKonekciju() {
        close(konekcija, null, null);
    }

    private void close(Connection konekcija, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (konekcija != null) {
            try {
                konekcija.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean commitTransakcije() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean rollbackTransakcije() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean insertObjekat(OpstiDomenskiObjekat odo) {
        String upit = "INSERT INTO " + odo.getImeKlase() + " VALUES ( " + odo.getVrednostAtributa() + ")";
        System.out.println(upit);

        return executeUpdate(upit);
    }

    @Override
    public boolean updateObjekat(OpstiDomenskiObjekat odo) {
        String upit = "UPDATE " + odo.getImeKlase() + " SET " + odo.setVrednostAtributa() + " WHERE " + odo.getWhereKlauzulu();
        return executeUpdate(upit);
    }

    @Override
    public boolean deleteObjekat(OpstiDomenskiObjekat odo) {
        String upit = "DELETE FROM " + odo.getImeKlase() + " WHERE " + odo.getWhereKlauzulu();
        return executeUpdate(upit);
    }

    @Override
    public boolean deleteViseObjekata(OpstiDomenskiObjekat odo, String uslov) {
        String upit = "DELETE FROM " + odo.getImeKlase() + " WHERE " + uslov;
        return executeUpdate(upit);
    }

    @Override
    public OpstiDomenskiObjekat nadjiObjekat(OpstiDomenskiObjekat odo) {
        Statement st = null;
        ResultSet rs = null;
        String upit = "SELECT * FROM " + odo.getImeKlase() + " WHERE " + odo.getWhereKlauzulu();

        boolean signal = false;

        try {
            st = konekcija.createStatement();
            rs = st.executeQuery(upit);
            signal = rs.next();

            if (signal == true) {
                odo = odo.getDomenskiObjekat(rs);
            } else {
                odo = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return odo;
    }

    @Override
    public List<OpstiDomenskiObjekat> nadjiObjekte(OpstiDomenskiObjekat odo, String uslov) {
        Statement st = null;
        ResultSet rs = null;
        String upit = "SELECT * FROM " + odo.getImeKlase() + " WHERE " + uslov;

        List<OpstiDomenskiObjekat> listaObjekata = new LinkedList<>();

        try {
            st = konekcija.createStatement();
            rs = st.executeQuery(upit);

            while (rs.next()) {
                listaObjekata.add(odo.getDomenskiObjekat(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return listaObjekata;
    }

    @Override
    public List<OpstiDomenskiObjekat> osveziPrimarneKljuceve(OpstiDomenskiObjekat odo) {
        Statement st = null;
        ResultSet rs = null;
        String upit = "SELECT * FROM " + odo.getImeKlase() + " WHERE " + odo.getWhereKlauzuluOsvezavanjeKljuca()
                + " order by " + odo.getPrimarniKljucZaOrderBy();
        List<OpstiDomenskiObjekat> listaObjekata = new LinkedList<>();
        int brojac = 1;

        try {
            st = konekcija.createStatement();
            rs = st.executeQuery(upit);
            while (rs.next()) {
                OpstiDomenskiObjekat pomocniODO = odo.getDomenskiObjekat(rs);
                OpstiDomenskiObjekat praviODO = odo.getDomenskiObjekat(rs);
                praviODO.setPrimarniKljuc(brojac++);
                listaObjekata.add(odo);
                updateObjekat(praviODO, pomocniODO);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return listaObjekata;
    }

    private boolean executeUpdate(String upit) {
        Statement st = null;
        boolean signal = false;
        try {
            st = konekcija.createStatement();
            int rowcount = st.executeUpdate(upit);
            if (rowcount > 0) {
                signal = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            close(null, st, null);
        }
        return signal;
    }

    @Override
    public boolean updateObjekat(OpstiDomenskiObjekat odo, String whereKlauzula) {
        String upit = "UPDATE " + odo.getImeKlase() + "SET " + odo.setVrednostAtributa() + " WHERE " + whereKlauzula;
        return executeUpdate(upit);
    }

    @Override
    public int nadjiNoviPrimarniKljuc(OpstiDomenskiObjekat odo) {
        int kljuc = -1;
        Statement st;
        String upit = "SELECT MAX(" + odo.getPrimarniKljucZaOrderBy() + ") AS kljuc FROM " + odo.getImeKlase();
        try {
            st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(upit);
            boolean signal = rs.next();
            if (signal) {
                return rs.getInt("kljuc") + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kljuc;
    }

    @Override
    public boolean updateObjekat(OpstiDomenskiObjekat odo, OpstiDomenskiObjekat odoPomocni) {
        String upit = "UPDATE " + odo.getImeKlase() + " SET " + odo.setVrednostAtributa() + " WHERE " + odoPomocni.getWhereKlauzulu();
        return executeUpdate(upit);
    }

    public boolean updateBrojProdavnica(Prodavnica p, String znak) {
        String upit = "UPDATE mesto SET brojProdavnica = brojProdavnica " + znak + " 1 WHERE idMesto = " + p.getMesto();
        return executeUpdate(upit);
    }
    
    
     public List<StavkaPotvrde> nadjiStavke(StavkaPotvrde stavka, String uslov) {
        Statement st = null;
        ResultSet rs = null;
        String upit = "SELECT * FROM " + stavka.getImeKlase() + " WHERE " + uslov;

        List<StavkaPotvrde> listaStavki = new LinkedList<>();

        try {
            st = konekcija.createStatement();
            rs = st.executeQuery(upit);

            while (rs.next()) {
                listaStavki.add((StavkaPotvrde) stavka.getDomenskiObjekat(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePosiljke.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return listaStavki;
    }
}
