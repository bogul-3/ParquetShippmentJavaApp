package SOPosiljalac;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import java.util.List;
import opstiDomen.OpstiDomenskiObjekat;

public class NadjiSvePosiljaoce extends OpsteIzvrsenjeSistemskeOperacije {

    OpstiDomenskiObjekat odo;
    List<OpstiDomenskiObjekat> listaObjekata = null;
    boolean signal = false;

    public boolean getSignal() {
        return signal;
    }

    public List<OpstiDomenskiObjekat> getListaObjekata() {
        return listaObjekata;
    }

    public NadjiSvePosiljaoce(OpstiDomenskiObjekat odo) {
        this.odo = odo;
        signal = opsteIzvrsenjeSOIzvestaj();
    }

    @Override
    public boolean izvrsiSO() {
        listaObjekata = broker.nadjiObjekte(odo, "true");
        if (listaObjekata != null && listaObjekata.size() > 0) {
            signal = true;
        }
        return signal;
    }

}
