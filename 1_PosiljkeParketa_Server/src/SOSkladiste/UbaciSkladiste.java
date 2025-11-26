/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOSkladiste;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import static OpstaSO.OpsteIzvrsenjeSistemskeOperacije.broker;
import opstiDomen.OpstiDomenskiObjekat;

/**
 *
 * @author bogda
 */
public class UbaciSkladiste extends OpsteIzvrsenjeSistemskeOperacije{
    boolean signal = false;
    OpstiDomenskiObjekat odo;

    public UbaciSkladiste(OpstiDomenskiObjekat odo) {
        this.odo = odo;
        opsteIzvrsenjeSO();
    }

    public boolean getSignal() {
        return signal;
    }

    public OpstiDomenskiObjekat getObjekat() {
        return odo;
    }

    @Override
    public boolean izvrsiSO() {
        OpstiDomenskiObjekat odoProvera = broker.nadjiObjekat(odo);
        if (odoProvera == null) {
            int id = broker.nadjiNoviPrimarniKljuc(odo);
            if (id != -1) {
                odo.setPrimarniKljuc(id);
            } else {
                return signal;
            }
            if (broker.insertObjekat(odo) == true) {
                signal = true;
            }
        }
        return signal;
    }
}
