package domen;

import opstiDomen.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Posiljalac extends OpstiDomenskiObjekat implements Serializable {

    private int idPosiljalac;
    private String ime;
    private String prezime;
    private String email;
    private String sifra;
    private Date datumRodjenja;

    public Posiljalac(int idPosiljalac, String ime, String prezime, String email, String sifra, Date datumRodjenja) {
        this.idPosiljalac = idPosiljalac;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
        this.datumRodjenja = datumRodjenja;
    }

    public Posiljalac() {
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
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
        final Posiljalac other = (Posiljalac) obj;
        return this.idPosiljalac == other.idPosiljalac;
    }

    @Override
    public String getVrednostAtributa() {
        return idPosiljalac + ", " + (ime == null ? null : "'" + ime + "'") + ", " + (prezime == null ? null : "'" + prezime + "'")
                + ", " + (email == null ? null : "'" + email + "'") + ", " + (sifra == null ? null : "'" + sifra + "'") + ", "
                + (datumRodjenja == null ? null : "'" + getSQLDatum(datumRodjenja) + "'");
    }

    public java.util.Date getSQLDatum(java.util.Date datum) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        this.datumRodjenja = java.sql.Date.valueOf(sm.format(datum));
        return this.datumRodjenja;
    }

    @Override
    public String getImeKlase() {
        return "Posiljalac";
    }

    @Override
    public String getWhereKlauzulu() {
        return "idPosiljalac = " + idPosiljalac;
    }

    @Override
    public String getImePoBrojuKolone(int brojKolone) {
        String kolone[] = {"idPosiljalac", "ime", "prezime", "email", "sifra", "datumRodjenja"};
        return kolone[brojKolone];
    }

    @Override
    public OpstiDomenskiObjekat getDomenskiObjekat(ResultSet rs) throws SQLException {
        return new Posiljalac(rs.getInt("idPosiljalac"), rs.getString("ime"),
                rs.getString("prezime"), rs.getString("email"), rs.getString("sifra"), rs.getDate("datumRodjenja"));
    }

    @Override
    public int getPrimarniKljuc() {
        return idPosiljalac;
    }

    @Override
    public void setPrimarniKljuc(int id) {
        idPosiljalac = id;
    }

    @Override
    public String setVrednostAtributa() {
        return "idPosiljalac = " + idPosiljalac + ", ime = '" + ime + "', prezime = '" + prezime + "', email = '" + email + "',"
                + " sifra = '" + sifra + "', datumRodjenja = '" + getSQLDatum(datumRodjenja) + "'";
    }

    @Override
    public String getWhereKlauzuluOsvezavanjeKljuca() {
        return "true";
    }

    @Override
    public String getPrimarniKljucZaOrderBy() {
        return "idPosiljalac";
    }

    @Override
    public Object[] getNizAtributa() {
        Object[] niz = {idPosiljalac, ime, prezime, email, sifra, datumRodjenja};
        return niz;
    }
}
