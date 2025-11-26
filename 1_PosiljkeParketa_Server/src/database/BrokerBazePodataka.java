package database;

import opstiDomen.OpstiDomenskiObjekat;
import java.util.List;

public abstract class BrokerBazePodataka {

    String imeBaze;

    public abstract boolean napraviKonekciju();

    public abstract void zatvoriKonekciju();

    public abstract boolean commitTransakcije();

    public abstract boolean rollbackTransakcije();

    public abstract boolean insertObjekat(OpstiDomenskiObjekat odo);

    public abstract boolean updateObjekat(OpstiDomenskiObjekat odo);

    public abstract boolean updateObjekat(OpstiDomenskiObjekat odo, String whereKlauzula);

    public abstract boolean deleteObjekat(OpstiDomenskiObjekat odo);

    public abstract boolean deleteViseObjekata(OpstiDomenskiObjekat odo, String uslov);

    public abstract OpstiDomenskiObjekat nadjiObjekat(OpstiDomenskiObjekat odo);

    public abstract List<OpstiDomenskiObjekat> nadjiObjekte(OpstiDomenskiObjekat odo, String uslov);

    public abstract boolean updateObjekat(OpstiDomenskiObjekat odo, OpstiDomenskiObjekat odoPomocni);

    public abstract List<OpstiDomenskiObjekat> osveziPrimarneKljuceve(OpstiDomenskiObjekat odo);

    public abstract int nadjiNoviPrimarniKljuc(OpstiDomenskiObjekat odo);
}
