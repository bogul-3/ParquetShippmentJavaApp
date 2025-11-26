package SOPosiljalac;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import java.util.List;
import opstiDomen.OpstiDomenskiObjekat;

public class NadjiSvePosiljaocePrijava extends OpsteIzvrsenjeSistemskeOperacije {

    OpstiDomenskiObjekat odo;
    String korIme;
    String lozinka;
    List<OpstiDomenskiObjekat> listaPosiljalaca;
    boolean signal = false;

    public List<OpstiDomenskiObjekat> getListaPosiljalaca() {
        return listaPosiljalaca;
    }

    public boolean getSignal() {
        return signal;
    }

    public NadjiSvePosiljaocePrijava(OpstiDomenskiObjekat odo, String korIme, String lozinka) {
        this.odo = odo;
        this.korIme = korIme;
        this.lozinka = lozinka;
        signal = opsteIzvrsenjeSOIzvestaj();
    }

    @Override
    public boolean izvrsiSO() {
        listaPosiljalaca = broker.nadjiObjekte(odo, "email LIKE '" + korIme + "' AND sifra LIKE '" + lozinka + "'");

        if (listaPosiljalaca.size() > 0) {
            signal = true;
        }
        return signal;
    }

}
