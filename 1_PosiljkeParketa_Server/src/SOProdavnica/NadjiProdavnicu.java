/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOProdavnica;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import static OpstaSO.OpsteIzvrsenjeSistemskeOperacije.broker;
import opstiDomen.OpstiDomenskiObjekat;

/**
 *
 * @author bogda
 */
public class NadjiProdavnicu extends OpsteIzvrsenjeSistemskeOperacije{
    boolean signal = false;
    OpstiDomenskiObjekat odo = null;
    int id;

    public boolean getSignal() {
        return signal;
    }

    public OpstiDomenskiObjekat getOdo() {
        return odo;
    }

    public NadjiProdavnicu(int id, OpstiDomenskiObjekat odo) {
        this.id = id;
        this.odo = odo;
        opsteIzvrsenjeSOIzvestaj();
    }

    @Override
    public boolean izvrsiSO() {
        odo.setPrimarniKljuc(id);
        OpstiDomenskiObjekat odoProvera = broker.nadjiObjekat(odo);
        if (odoProvera != null) {
            signal = true;
            odo = odoProvera;
        } else {
            odo = null;
        }
        return signal;
    }
}
