package domen;

import opstiDomen.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mesto extends OpstiDomenskiObjekat implements Serializable {

    private int idMesto;
    private String naziv;
    private int brojProdavnica;

    public Mesto(int idMesto, String naziv, int brojProdavnica) {
        this.idMesto = idMesto;
        this.naziv = naziv;
        this.brojProdavnica = brojProdavnica;
    }

    public Mesto() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojProdavnica() {
        return brojProdavnica;
    }

    public void setBrojProdavnica(int brojProdavnica) {
        this.brojProdavnica = brojProdavnica;
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
        final Mesto other = (Mesto) obj;
        return this.idMesto == other.idMesto;
    }

    @Override
    public String getVrednostAtributa() {
        return idMesto + ", " + (naziv == null ? null : "'" + naziv + "'") + ", " + brojProdavnica;
    }

    @Override
    public String getImeKlase() {
        return "Mesto";
    }

    @Override
    public String getWhereKlauzulu() {
        return "idMesto = " + idMesto;
    }

    @Override
    public String getImePoBrojuKolone(int brojKolone) {
        String kolone[] = {"idMesto", "naziv", "brojProdavnica"};
        return kolone[brojKolone];
    }

    @Override
    public OpstiDomenskiObjekat getDomenskiObjekat(ResultSet rs) throws SQLException {
        return new Mesto(rs.getInt("idMesto"), rs.getString("naziv"), rs.getInt("brojProdavnica"));
    }

    @Override
    public int getPrimarniKljuc() {
        return idMesto;
    }

    @Override
    public void setPrimarniKljuc(int id) {
        idMesto = id;
    }

    @Override
    public String setVrednostAtributa() {
        return "idMesto = " + idMesto + ", naziv = '" + naziv + "', brojProdavnica = " + brojProdavnica;
    }

    @Override
    public String getWhereKlauzuluOsvezavanjeKljuca() {
        return "true";
    }

    @Override
    public String getPrimarniKljucZaOrderBy() {
        return "idMesto";
    }

    @Override
    public Object[] getNizAtributa() {
        Object[] niz = {idMesto, naziv, brojProdavnica};
        return niz;
    }

}
