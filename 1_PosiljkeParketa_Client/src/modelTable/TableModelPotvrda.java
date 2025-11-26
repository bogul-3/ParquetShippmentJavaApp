package modelTable;

import domen.Posiljalac;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.Potvrda;
import domen.Prodavnica;
import javax.swing.JOptionPane;
import komunikacija.KlijentKomunikacija;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class TableModelPotvrda extends AbstractTableModel {

    private List<Potvrda> listaPotvrda;
    private String[] kolone = {"idPotvrda", "datum", "prosecnaKolicina", "posiljalac", "prodavnica"};

    public TableModelPotvrda(List<Potvrda> listaPotvrda) {
        this.listaPotvrda = listaPotvrda;
    }

    @Override
    public int getRowCount() {
        return listaPotvrda.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Potvrda potvrda = listaPotvrda.get(rowIndex);

        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_POSILJAOCA_ID, potvrda.getPosiljalac());
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            System.out.println("GRESKA U PRETRAZI POSILJAOCA");
            return null;
        }
        Posiljalac posiljalac = (Posiljalac) so.getParametar();

        kz.setOperacija(OperacijeENUM.PRETRAZI_PRODAVNICU_ID);
        kz.setParametar(potvrda.getProdavnica());
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            System.out.println("GRESKA U PRETRAZI PRODAVNICE");
            return null;
        }
        Prodavnica prodavnica = (Prodavnica) so.getParametar();

        switch (columnIndex) {
            case 0:
                return potvrda.getPrimarniKljuc();
            case 1:
                return potvrda.getDatum();
            case 2:
                return potvrda.getProsecnaKolicina();
            case 3:
                return posiljalac;
            case 4:
                return prodavnica;
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Potvrda> getListaPotvrda() {
        return listaPotvrda;
    }

    public void setListaPotvrda(List<Potvrda> listaPotvrda) {
        this.listaPotvrda = listaPotvrda;
    }
}
