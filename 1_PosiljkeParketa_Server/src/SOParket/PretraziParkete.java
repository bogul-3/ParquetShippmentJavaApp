/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOParket;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import static OpstaSO.OpsteIzvrsenjeSistemskeOperacije.broker;
import java.util.List;
import opstiDomen.OpstiDomenskiObjekat;

/**
 *
 * @author bogda
 */
public class PretraziParkete extends OpsteIzvrsenjeSistemskeOperacije{
    String whereKlauzula;
    OpstiDomenskiObjekat odo;
    boolean signal = false;
    List<OpstiDomenskiObjekat> listaObjekata = null;

    public boolean getSignal() {
        return signal;
    }

    public List<OpstiDomenskiObjekat> getListaObjekata() {
        return listaObjekata;
    }

    public PretraziParkete(String whereKlauzula, OpstiDomenskiObjekat odo) {
        this.whereKlauzula = whereKlauzula;
        this.odo = odo;
        signal = opsteIzvrsenjeSOIzvestaj();
    }

    @Override
    public boolean izvrsiSO() {
        listaObjekata = broker.nadjiObjekte(odo, whereKlauzula);
        if (listaObjekata != null && listaObjekata.size() > 0) {
            signal = true;
        }
        return signal;
    }
}
