package modelTable;

import domen.Parket;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.StavkaPotvrde;

public class TableModelStavka extends AbstractTableModel {

    private List<StavkaPotvrde> listaStavki;
    private List<Parket> listaParketa;
    private String[] kolone = {"idStavka", "kolicina", "parket"};

    public TableModelStavka(List<StavkaPotvrde> lista, List<Parket> listaParketa) {
        listaStavki = lista;
        this.listaParketa = listaParketa;
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

        switch (columnIndex) {
            case 0:
                return s.getPrimarniKljuc();
            case 1:
                return s.getKolicina();
            case 2:
                return listaParketa.get(rowIndex);
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
