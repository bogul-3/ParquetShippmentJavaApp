package view;

import domen.Posiljalac;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import komunikacija.KlijentKomunikacija;
import modelTable.TableModelPosiljalac;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaPosiljalac extends javax.swing.JDialog {

    public FormaPosiljalac(JFrame parent, boolean modal, Posiljalac posiljalac) {
        super(parent, modal);
        initComponents();
        lblPosilljalac.setText("Ulogovan: " + posiljalac.getIme() + " " + posiljalac.getPrezime());
        setLocationRelativeTo(null);
        ubaciPosiljaoceUTabelu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePosiljalac = new javax.swing.JTable();
        lblPosilljalac = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablePosiljalac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablePosiljalac);

        lblPosilljalac.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPosilljalac.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPosilljalac))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPosilljalac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPosilljalac;
    private javax.swing.JTable tablePosiljalac;
    // End of variables declaration//GEN-END:variables

    private void ubaciPosiljaoceUTabelu() {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.SVI_POSILJAOCI, null);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
        }

        List<Posiljalac> listaPosiljalaca = (List<Posiljalac>) so.getParametar();
        TableModelPosiljalac model = new TableModelPosiljalac(listaPosiljalaca);
        tablePosiljalac.setModel(model);
    }
}
