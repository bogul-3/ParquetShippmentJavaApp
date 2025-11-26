package opstiDomen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class OpstiDomenskiObjekat implements Serializable {

    abstract public String getVrednostAtributa();
    abstract public String setVrednostAtributa();
    abstract public String getImeKlase();
    abstract public String getWhereKlauzulu();
    abstract public String getImePoBrojuKolone(int brojKolone);
    abstract public OpstiDomenskiObjekat getDomenskiObjekat(ResultSet rs) throws SQLException;
    abstract public int getPrimarniKljuc();
    abstract public void setPrimarniKljuc(int id);
    //ZA UPDATE PRIMARNOG KLJUCA
    abstract public String getWhereKlauzuluOsvezavanjeKljuca();
    abstract public String getPrimarniKljucZaOrderBy();
    abstract public Object[] getNizAtributa();
}
