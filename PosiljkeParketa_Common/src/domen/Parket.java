package domen;

import opstiDomen.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Parket extends OpstiDomenskiObjekat implements Serializable {

    private int idParket;
    private String dimenzije;
    private DrvoENUM drvo;

    public Parket() {
    }

    public Parket(int idParket, String dimenzije, DrvoENUM drvo) {
        this.idParket = idParket;
        this.dimenzije = dimenzije;
        this.drvo = drvo;
    }

    public String getDimenzije() {
        return dimenzije;
    }

    public void setDimenzije(String dimenzije) {
        this.dimenzije = dimenzije;
    }

    public DrvoENUM getDrvo() {
        return drvo;
    }

    public void setDrvo(DrvoENUM drvo) {
        this.drvo = drvo;
    }

    @Override
    public String toString() {
        return drvo + ": " + dimenzije;
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
        final Parket other = (Parket) obj;
        return this.idParket == other.idParket;
    }

    @Override
    public String getVrednostAtributa() {
        return idParket + ", " + (dimenzije == null ? null : "'" + dimenzije + "'") + drvo;
    }

    @Override
    public String getImeKlase() {
        return "Parket";
    }

    @Override
    public String getWhereKlauzulu() {
        return "idParket = " + idParket;
    }

    @Override
    public String getImePoBrojuKolone(int brojKolone) {
        String kolone[] = {"idParket", "dimenzije", "drvo"};
        return kolone[brojKolone];
    }

    @Override
    public OpstiDomenskiObjekat getDomenskiObjekat(ResultSet rs) throws SQLException {
        return new Parket(rs.getInt("idParket"), rs.getString("dimenzije"), DrvoENUM.valueOf(rs.getString("drvo")));
    }

    @Override
    public int getPrimarniKljuc() {
        return idParket;
    }

    @Override
    public void setPrimarniKljuc(int id) {
        idParket = id;
    }

    @Override
    public String setVrednostAtributa() {
        return "idParket = " + idParket + ", dimenzije = '" + dimenzije + "', drvo = '" + drvo + "'";
    }

    @Override
    public String getWhereKlauzuluOsvezavanjeKljuca() {
        return "true";
    }

    @Override
    public String getPrimarniKljucZaOrderBy() {
        return "idParket";
    }

    @Override
    public Object[] getNizAtributa() {
        Object[] niz = {idParket, dimenzije, drvo};
        return niz;
    }

}
