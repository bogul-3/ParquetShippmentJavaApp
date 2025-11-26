package domen;

import opstiDomen.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prodavnica extends OpstiDomenskiObjekat implements Serializable {

    private int idProdavnica;
    private String naziv;
    private String adresa;
    private int idMesto;

    public Prodavnica() {
    }

    public Prodavnica(int idProdavnica, String naziv, String adresa, int idMesto) {
        this.idProdavnica = idProdavnica;
        this.naziv = naziv;
        this.adresa = adresa;
        this.idMesto = idMesto;
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

    public int getMesto() {
        return idMesto;
    }

    public void setMesto(int idMesto) {
        this.idMesto = idMesto;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prodavnica other = (Prodavnica) obj;
        return this.idProdavnica == other.idProdavnica;
    }

    @Override
    public String getVrednostAtributa() {
        return idProdavnica + ", " + (naziv == null ? null : "'" + naziv + "'") + ", " + (adresa == null ? null : "'" + adresa + "'")
                + ", '" + idMesto + "'";
    }

    @Override
    public String getImeKlase() {
        return "Prodavnica";
    }

    @Override
    public String getWhereKlauzulu() {
        return "idProdavnica = " + idProdavnica;
    }

    @Override
    public String getImePoBrojuKolone(int brojKolone) {
        String kolone[] = {"idProdavnica", "naziv", "adresa", "idMesto"};
        return kolone[brojKolone];
    }

    @Override
    public OpstiDomenskiObjekat getDomenskiObjekat(ResultSet rs) throws SQLException {
        return new Prodavnica(rs.getInt("idProdavnica"), rs.getString("naziv"), rs.getString("adresa"), rs.getInt("idMesto"));
    }

    @Override
    public int getPrimarniKljuc() {
        return idProdavnica;
    }

    @Override
    public void setPrimarniKljuc(int id) {
        idProdavnica = id;
    }

    @Override
    public String setVrednostAtributa() {
        return "idProdavnica = " + idProdavnica + ", naziv = '" + naziv + "', adresa = '" + adresa + "',"
                + " idMesto = " + idMesto;
    }

    @Override
    public String getWhereKlauzuluOsvezavanjeKljuca() {
        return "true";
    }

    @Override
    public String getPrimarniKljucZaOrderBy() {
        return "idProdavnica";
    }

    @Override
    public Object[] getNizAtributa() {
        Object[] niz = {idProdavnica, naziv, adresa, idMesto};
        return niz;
    }

}
