/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOProdavnica;

import OpstaSO.OpsteIzvrsenjeSistemskeOperacije;
import static OpstaSO.OpsteIzvrsenjeSistemskeOperacije.broker;
import domen.Prodavnica;
import java.util.List;

/**
 *
 * @author bogda
 */
public class ObrisiProdavnice extends OpsteIzvrsenjeSistemskeOperacije {

    List<Prodavnica> listaProdavnica = null;
    boolean signal = false;

    public boolean getSignal() {
        return signal;
    }

    public ObrisiProdavnice(List<Prodavnica> listaProdavnica) {
        this.listaProdavnica = listaProdavnica;

        opsteIzvrsenjeSO();
    }

    @Override
    public boolean izvrsiSO() {
        if (listaProdavnica != null && listaProdavnica.size() > 0) {
            for (Prodavnica p : listaProdavnica) {
                if (broker.deleteObjekat(p)) {
                    broker.updateBrojProdavnica(p, "-");
                }
            }
            broker.osveziPrimarneKljuceve(new Prodavnica());
            signal = true;
        }

        return signal;
    }
}
