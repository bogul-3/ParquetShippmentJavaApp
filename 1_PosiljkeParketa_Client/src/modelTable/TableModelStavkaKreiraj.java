package modelTable;

import domen.Parket;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.StavkaPotvrde;
import komunikacija.KlijentKomunikacija;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class TableModelStavkaKreiraj extends AbstractTableModel {

    private List<StavkaPotvrde> listaStavki;
    private String[] kolone = {"idStavka", "kolicina", "parket"};

    public TableModelStavkaKreiraj(List<StavkaPotvrde> lista) {
        listaStavki = lista;
    }

    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPotvrde s = listaStavki.get(rowIndex);

        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_PARKET_ID, s.getParket());
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            System.out.println("GRESKA U PRETRAZI PARKETA");
            return null;
        }
        Parket parket = (Parket) so.getParametar();

        switch (columnIndex) {
            case 0:
                return s.getPrimarniKljuc();
            case 1:
                return s.getKolicina();
            case 2:
                return parket;
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<StavkaPotvrde> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaPotvrde> listaStavki) {
        this.listaStavki = listaStavki;
    }
}
