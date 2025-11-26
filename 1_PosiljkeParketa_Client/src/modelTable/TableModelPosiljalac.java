package modelTable;

import domen.Posiljalac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPosiljalac extends AbstractTableModel {

    private List<Posiljalac> listaPosiljalaca;
    private String[] kolone = {"ime", "prezime", "datum rodjenja"};

    public TableModelPosiljalac(List<Posiljalac> listaPosiljalaca) {
        this.listaPosiljalaca = listaPosiljalaca;
    }

    @Override
    public int getRowCount() {
        return listaPosiljalaca.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Posiljalac p = listaPosiljalaca.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getIme();
            case 1:
                return p.getPrezime();
            case 2:
                return p.getDatumRodjenja();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
