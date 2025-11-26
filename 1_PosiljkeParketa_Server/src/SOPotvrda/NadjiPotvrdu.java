/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOPotvrda;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import static OpstaSO.OpsteIzvrsenjeSistemskeOperacije.broker;
import domen.Potvrda;
import domen.StavkaPotvrde;
import java.util.LinkedList;
import java.util.List;
import opstiDomen.OpstiDomenskiObjekat;

/**
 *
 * @author bogda
 */
public class NadjiPotvrdu extends OpsteIzvrsenjeSistemskeOperacije{
     boolean signal = false;
    Potvrda odo = null;
    int id;

    public boolean getSignal() {
        return signal;
    }

    public Potvrda getOdo() {
        return odo;
    }

    public NadjiPotvrdu(int id, Potvrda odo) {
        this.id = id;
        this.odo = odo;
        opsteIzvrsenjeSOIzvestaj();
    }

    @Override
    public boolean izvrsiSO() {
        odo.setPrimarniKljuc(id);
        Potvrda odoProvera = (Potvrda) broker.nadjiObjekat(odo);
        if (odoProvera != null) {
            signal = true;
            odo = odoProvera;
        } else {
            odo = null;
        }
        
        String whereKlauzula = "idPotvrda = " + odo.getPrimarniKljuc();
        
        List<StavkaPotvrde> listaStavkiBaza = broker.nadjiStavke(new StavkaPotvrde(), whereKlauzula);
        odo.setListaStavki(listaStavkiBaza);
        return signal;
    }
    
    
}
