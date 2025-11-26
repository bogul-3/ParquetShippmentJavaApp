/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOProdavnica;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import static OpstaSO.OpsteIzvrsenjeSistemskeOperacije.broker;
import domen.Prodavnica;
import opstiDomen.OpstiDomenskiObjekat;

/**
 *
 * @author bogda
 */
public class KreirajProdavnicu extends OpsteIzvrsenjeSistemskeOperacije{
    boolean signal = false;
    OpstiDomenskiObjekat odo;

    public KreirajProdavnicu(OpstiDomenskiObjekat odo) {
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
            
            Prodavnica prodavnica = (Prodavnica) odo;
            broker.updateBrojProdavnica(prodavnica, "+");
        }
        return signal;
    }

}
