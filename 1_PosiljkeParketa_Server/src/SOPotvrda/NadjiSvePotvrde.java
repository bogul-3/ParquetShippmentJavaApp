/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOPotvrda;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import static OpstaSO.OpsteIzvrsenjeSistemskeOperacije.broker;
import java.util.List;
import opstiDomen.OpstiDomenskiObjekat;

/**
 *
 * @author bogda
 */
public class NadjiSvePotvrde extends OpsteIzvrsenjeSistemskeOperacije {

    OpstiDomenskiObjekat odo;
    List<OpstiDomenskiObjekat> listaObjekata = null;
    boolean signal = false;

    public boolean getSignal() {
        return signal;
    }

    public List<OpstiDomenskiObjekat> getListaObjekata() {
        return listaObjekata;
    }

    public NadjiSvePotvrde(OpstiDomenskiObjekat odo) {
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
