package domen;

import opstiDomen.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StavkaPotvrde extends OpstiDomenskiObjekat implements Serializable {

    private int idPotvrda;
    private int idStavka;
    private double kolicina;
    private int idParket;

    public StavkaPotvrde() {
    }

    public StavkaPotvrde(int idPotvrda, int idStavka, double kolicina, int idParket) {
        this.idPotvrda = idPotvrda;
        this.idStavka = idStavka;
        this.kolicina = kolicina;
        this.idParket = idParket;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final StavkaPotvrde other = (StavkaPotvrde) obj;
        if (this.idPotvrda != other.idPotvrda) {
            return false;
        }
        return this.idStavka == other.idStavka;
    }


    public int getPotvrda() {
        return idPotvrda;
    }

    public void setPotvrda(int potvrda) {
        this.idPotvrda = potvrda;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public int getParket() {
        return idParket;
    }

    public void setParket(int parket) {
        this.idParket = parket;
    }

    @Override
    public String toString() {
        return " - " + kolicina;
    }

    @Override
    public String getVrednostAtributa() {
        return idPotvrda + ", " + idStavka + ", " + kolicina + ", " + idParket;
    }

    @Override
    public String getImeKlase() {
        return "stavkaPotvrde";
    }

    @Override
    public String getWhereKlauzulu() {
        return "idPotvrda = " + idPotvrda + " AND idStavka = " + idStavka;
    }

    @Override
    public String getImePoBrojuKolone(int brojKolone) {
        String kolone[] = {"idPotvrda", "idStavka", "kolicina", "idParket"};
        return kolone[brojKolone];
    }

    @Override
    public OpstiDomenskiObjekat getDomenskiObjekat(ResultSet rs) throws SQLException {
        return new StavkaPotvrde(rs.getInt("idPotvrda"), rs.getInt("idStavka"), rs.getDouble("kolicina"), rs.getInt("idParket"));
    }

    @Override
    public int getPrimarniKljuc() {
        return idStavka;
    }

    @Override
    public void setPrimarniKljuc(int id) {
        idStavka = id;
    }

    @Override
    public String setVrednostAtributa() {
        return "idPotvrda = " + idPotvrda + ", idStavka = " + idStavka + ", kolicina = " + kolicina
                + ", idParket = " + idParket;
    }

    @Override
    public String getWhereKlauzuluOsvezavanjeKljuca() {
        return "idPotvrda = " + idPotvrda;
    }

    @Override
    public String getPrimarniKljucZaOrderBy() {
        return "idPotvrda, idStavka";
    }

    @Override
    public Object[] getNizAtributa() {
        Object[] niz = {idPotvrda, idStavka, kolicina, idParket};
        return niz;
    }

}
