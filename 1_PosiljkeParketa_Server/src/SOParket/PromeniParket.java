/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOParket;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import static OpstaSO.OpsteIzvrsenjeSistemskeOperacije.broker;
import opstiDomen.OpstiDomenskiObjekat;

/**
 *
 * @author bogda
 */
public class PromeniParket extends OpsteIzvrsenjeSistemskeOperacije{
       OpstiDomenskiObjekat odo;
    boolean signal = false;

    public boolean getSignal() {
        return signal;
    }

    public PromeniParket(OpstiDomenskiObjekat odo) {
        this.odo = odo;
        opsteIzvrsenjeSO();
    }

    @Override
    public boolean izvrsiSO() {
        OpstiDomenskiObjekat odoPretraga = broker.nadjiObjekat(odo);
        if (odoPretraga != null) {
            if (broker.updateObjekat(odo)) {
                signal = true;
            }
        }
        return signal;
    }
}
