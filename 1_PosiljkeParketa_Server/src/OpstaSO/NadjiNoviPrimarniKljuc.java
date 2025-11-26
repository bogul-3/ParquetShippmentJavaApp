package OpstaSO;

import opstiDomen.OpstiDomenskiObjekat;

public class NadjiNoviPrimarniKljuc extends OpsteIzvrsenjeSistemskeOperacije {

    boolean signal = false;
    OpstiDomenskiObjekat odo;
    int id;

    public NadjiNoviPrimarniKljuc(OpstiDomenskiObjekat odo, boolean stavka) {
        this.odo = odo;
        opsteIzvrsenjeSOIzvestaj();
    }

    public boolean getSignal() {
        return signal;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean izvrsiSO() {
        int id = broker.nadjiNoviPrimarniKljuc(odo);
        if (id != -1) {
            signal = true;
            this.id = id;
        }
        return signal;
    }

}
