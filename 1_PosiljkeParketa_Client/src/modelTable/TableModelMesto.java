package modelTable;

import domen.Mesto;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelMesto extends AbstractTableModel {

    private List<Mesto> listaMesta = new LinkedList<>();
    private String[] kolone = {"Naziv", "Broj Prodavnica"};

    public TableModelMesto(List<Mesto> listaMesta) {
        this.listaMesta = listaMesta;
    }

    @Override
    public int getRowCount() {
        return listaMesta.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mesto mesto = listaMesta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mesto.getNaziv();
            case 1:
                return mesto.getBrojProdavnica();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
