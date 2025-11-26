package modelTable;

import domen.Mesto;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.Prodavnica;
import komunikacija.KlijentKomunikacija;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class TableModelProdavnica extends AbstractTableModel {

    private List<Prodavnica> listaProdavnica;
    private String[] kolone = {"idProdavnica", "naziv", "adresa", "mesto"};

    public TableModelProdavnica(List<Prodavnica> listaProdavnica) {
        this.listaProdavnica = listaProdavnica;
    }

    @Override
    public int getRowCount() {
        return listaProdavnica.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prodavnica prodavnica = listaProdavnica.get(rowIndex);

        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_MESTO_ID, prodavnica.getMesto());
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            System.out.println("GRESKA U PRETRAZI MESTA");
            return null;
        }
        Mesto mesto = (Mesto) so.getParametar();

        switch (columnIndex) {
            case 0:
                return prodavnica.getPrimarniKljuc();
            case 1:
                return prodavnica.getNaziv();
            case 2:
                return prodavnica.getAdresa();
            case 3:
                return mesto;
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
