package domen;

import java.io.Serializable;
import java.util.Date;

public class PosSkl implements Serializable{

    private int idPosiljalac;
    private int idSkladiste;
    private Date datum;
    private String vremeOd;
    private String vremeDo;
    private int brojSati;

    public PosSkl(int idPosiljalac, int idSkladiste, Date datum, String vremeOd, String vremeDo, int brojSati) {
        this.idPosiljalac = idPosiljalac;
        this.idSkladiste = idSkladiste;
        this.datum = datum;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.brojSati = brojSati;
    }

    @Override
    public String toString() {
        return idPosiljalac + " -> " + idSkladiste + ": " + datum;
    }

}
