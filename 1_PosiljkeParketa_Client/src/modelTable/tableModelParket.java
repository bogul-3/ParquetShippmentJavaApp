package modelTable;

import domen.Parket;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableModelParket extends AbstractTableModel {

    private List<Parket> listaParketa;
    private String[] kolone = {"id", "dimenzije", "drvo"};

    public tableModelParket(List<Parket> listaParketa) {
        this.listaParketa = listaParketa;
    }

    @Override
    public int getRowCount() {
        return listaParketa.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Parket p = listaParketa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPrimarniKljuc();
            case 1:
                return p.getDimenzije();
            case 2:
                return p.getDrvo();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
