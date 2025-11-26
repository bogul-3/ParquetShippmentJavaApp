package domen;

import opstiDomen.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Skladiste extends OpstiDomenskiObjekat implements Serializable {

    private int idSkladiste;
    private String naziv;
    private String adresa;

    public Skladiste(int idSkladiste, String naziv, String adresa) {
        this.idSkladiste = idSkladiste;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public Skladiste() {
        idSkladiste = -1;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getVrednostAtributa() {
        return idSkladiste + ", '" + (naziv == null ? null : naziv) + "', '" + (adresa == null ? null : adresa) + "'";
    }

    @Override
    public String getImeKlase() {
        return "Skladiste";
    }

    @Override
    public String getWhereKlauzulu() {
        return "idSkladiste = " + idSkladiste;
    }

    @Override
    public String getImePoBrojuKolone(int brojKolone) {
        String kolone[] = {"idSkladiste", "naziv", "adresa"};
        return kolone[brojKolone];
    }

    @Override
    public OpstiDomenskiObjekat getDomenskiObjekat(ResultSet rs) throws SQLException {
        return new Skladiste(rs.getInt("idSkladiste"), rs.getString("naziv"), rs.getString("adresa"));
    }

    @Override
    public int getPrimarniKljuc() {
        return idSkladiste;
    }

    @Override
    public void setPrimarniKljuc(int id) {
        idSkladiste = id;
    }

    @Override
    public String setVrednostAtributa() {
        return "idSkladiste = " + idSkladiste + ", naziv = '" + naziv + "', adresa = '" + adresa + "'";
    }

    @Override
    public String getWhereKlauzuluOsvezavanjeKljuca() {
        return "true";
    }

    @Override
    public String getPrimarniKljucZaOrderBy() {
        return "idSkladiste";
    }

    @Override
    public Object[] getNizAtributa() {
        Object[] niz = {idSkladiste, naziv, adresa};
        return niz;
    }

}
