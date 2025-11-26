/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOPotvrda;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import static OpstaSO.OpsteIzvrsenjeSistemskeOperacije.broker;
import controller.Kontroler;
import domen.Potvrda;
import domen.StavkaPotvrde;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import opstiDomen.OpstiDomenskiObjekat;

/**
 *
 * @author bogda
 */
public class PromeniPotvrdu extends OpsteIzvrsenjeSistemskeOperacije {

    Potvrda p;
    boolean signal = false;

    public PromeniPotvrdu(Potvrda p, int rbStavka, double kolicina, int idParket) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean getSignal() {
        return signal;
    }

    public PromeniPotvrdu(Potvrda p) {
        this.p = p;
        opsteIzvrsenjeSO();
    }

    @Override
    public boolean izvrsiSO() {
        OpstiDomenskiObjekat odoPretraga = broker.nadjiObjekat(p);
        if (odoPretraga != null) {
            if (broker.updateObjekat(p)) {
                signal = true;
            }
        }
        
        String whereKlauzula = "idPotvrda = " + p.getPrimarniKljuc();
        
        List<StavkaPotvrde> listaStavkiBaza = broker.nadjiStavke(new StavkaPotvrde(), whereKlauzula);

        List<StavkaPotvrde> listaIstihStavki = new LinkedList<>();
        List<StavkaPotvrde> listaNovihStavki = new LinkedList<>(p.getListaStavki());
        List<StavkaPotvrde> listaObrisanihStavki = new LinkedList<>(listaStavkiBaza);

        listaNovihStavki.removeAll(listaStavkiBaza);
        listaObrisanihStavki.removeAll(p.getListaStavki());

        for (StavkaPotvrde s : p.getListaStavki()) {
            for (StavkaPotvrde s1 : listaStavkiBaza) {
                if (s.equals(s1)) {
                    listaIstihStavki.add(s);
                }
            }
        }

        for (StavkaPotvrde s : listaIstihStavki) {
            try {
                if (broker.updateObjekat(s)) {
                    signal = true;
                }

            } catch (Exception ex) {
                Logger.getLogger(PromeniPotvrdu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (StavkaPotvrde s : listaNovihStavki) {
            s.setPotvrda(p.getPrimarniKljuc());

            if (broker.insertObjekat(s) == false) {
                signal = false;
                return signal;
            }
        }
        
        for(StavkaPotvrde s : listaObrisanihStavki){
            if (!broker.deleteObjekat(s)) {
                 signal = false;
                 return signal;
            }
        }

        return signal;
    }
}
