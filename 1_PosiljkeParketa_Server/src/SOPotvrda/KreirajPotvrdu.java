/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOPotvrda;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import domen.Potvrda;
import domen.StavkaPotvrde;
import java.util.LinkedList;
import java.util.List;
import opstiDomen.OpstiDomenskiObjekat;

/**
 *
 * @author bogda
 */
public class KreirajPotvrdu extends OpsteIzvrsenjeSistemskeOperacije {

    boolean signal = false;
    Potvrda potvrda;
    List<StavkaPotvrde> listaStavki = new LinkedList<>();

    public KreirajPotvrdu(Potvrda p) {
        this.potvrda = p;
        this.listaStavki = p.getListaStavki();
        opsteIzvrsenjeSO();
    }

    public boolean getSignal() {
        return signal;
    }

    public OpstiDomenskiObjekat getObjekat() {
        return potvrda;
    }

    @Override
    public boolean izvrsiSO() {
        OpstiDomenskiObjekat odoProvera = broker.nadjiObjekat(potvrda);
        int idPotvrda = broker.nadjiNoviPrimarniKljuc(potvrda);
        if (odoProvera == null) {

            if (idPotvrda != -1) {
                potvrda.setPrimarniKljuc(idPotvrda);
            } else {
                return signal;
            }
            if (broker.insertObjekat(potvrda) == true) {
                signal = true;
            }
        }

        for (StavkaPotvrde s : listaStavki) {
            s.setPotvrda(idPotvrda);

            if (broker.insertObjekat(s) == false) {
                signal = false;
                return signal;
            }
        }
        return signal;
    }
}
