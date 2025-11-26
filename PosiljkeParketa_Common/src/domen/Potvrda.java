package domen;

import opstiDomen.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Potvrda extends OpstiDomenskiObjekat implements Serializable {

    private int idPotvrda;
    private Date datum;
    private double prosecnaKolicina;
    private int idPosiljalac;
    private int idProdavnica;
    private List<StavkaPotvrde> listaStavki;

    public Potvrda() {
    }

    public Potvrda(int idPotvrda, Date datum, double prosecnaKolicina, int idPosiljalac, int idProdavnica) {
        this.idPotvrda = idPotvrda;
        this.datum = datum;
        this.prosecnaKolicina = prosecnaKolicina;
        this.idPosiljalac = idPosiljalac;
        this.idProdavnica = idProdavnica;
    }

    public Potvrda(int idPotvrda, Date datum, double prosecnaKolicina, int idPosiljalac, int idProdavnica, List<StavkaPotvrde> listaStavki) {
        this.idPotvrda = idPotvrda;
        this.datum = datum;
        this.idPosiljalac = idPosiljalac;
        this.idProdavnica = idProdavnica;
        this.prosecnaKolicina = prosecnaKolicina;
        this.listaStavki = listaStavki;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getProsecnaKolicina() {
        return prosecnaKolicina;
    }

    public void setProsecnaKolicina(double prosecnaKolicina) {
        this.prosecnaKolicina = prosecnaKolicina;
    }

    public int getPosiljalac() {
        return idPosiljalac;
    }

    public void setPosiljalac(int idPosiljalac) {
        this.idPosiljalac = idPosiljalac;
    }

    public int getProdavnica() {
        return idProdavnica;
    }

    public void setProdavnica(int idProdavnica) {
        this.idProdavnica = idProdavnica;
    }

    public List<StavkaPotvrde> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaPotvrde> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public String toString() {
        return datum + ": " + idPosiljalac + " -> " + idProdavnica;
    }

    @Override
    public String getVrednostAtributa() {
        return idPotvrda + ", '" + (datum == null ? null : getSQLDatum(datum)) + "', " + prosecnaKolicina + ", "
                + idPosiljalac + ", " + idProdavnica;
    }

    @Override
    public String getImeKlase() {
        return "Potvrda";
    }

    @Override
    public String getWhereKlauzulu() {
        return "idPotvrda = " + idPotvrda;
    }

    @Override
    public String getImePoBrojuKolone(int brojKolone) {
        String kolone[] = {"idPotvrda", "datum", "prosecnaKolicina", "idPosiljalac", "idProdavnica"};
        return kolone[brojKolone];
    }

    @Override
    public OpstiDomenskiObjekat getDomenskiObjekat(ResultSet rs) throws SQLException {
        return new Potvrda(rs.getInt("idPotvrda"), rs.getDate("datum"), rs.getDouble("prosecnaKolicina"),
                rs.getInt("idPosiljalac"), rs.getInt("idProdavnica"));
    }

    @Override
    public int getPrimarniKljuc() {
        return idPotvrda;
    }

    @Override
    public void setPrimarniKljuc(int id) {
        idPotvrda = id;
    }

    public java.util.Date getSQLDatum(java.util.Date datum) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        this.datum = java.sql.Date.valueOf(sm.format(datum));
        return this.datum;
    }

    @Override
    public String setVrednostAtributa() {
        return "idPotvrda = " + idPotvrda + ", datum = '" + getSQLDatum(datum) + "', prosecnaKolicina = " + prosecnaKolicina
                + ", idPosiljalac = " + idPosiljalac + ", idProdavnica = " + idProdavnica;
    }

    @Override
    public String getWhereKlauzuluOsvezavanjeKljuca() {
        return "true";
    }

    @Override
    public String getPrimarniKljucZaOrderBy() {
        return "idPotvrda";
    }

    @Override
    public Object[] getNizAtributa() {
        Object[] niz = {idPotvrda, datum, prosecnaKolicina, idPosiljalac, idProdavnica};
        return niz;
    }
}
