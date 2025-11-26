package view;

import domen.Parket;
import java.util.List;
import domen.DrvoENUM;
import java.awt.Frame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import komunikacija.KlijentKomunikacija;
import modelTable.tableModelParket;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaParket extends javax.swing.JDialog {

    public FormaParket(Frame parent, boolean modal, String operacija) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cmbDrvo.setModel(new DefaultComboBoxModel(DrvoENUM.values()));
        tableParket.getTableHeader().setReorderingAllowed(false);
        popuniTabeluParketa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaslov = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableParket = new javax.swing.JTable();
        lblDimenzije = new javax.swing.JLabel();
        txtDimenzijeVelika = new javax.swing.JTextField();
        lblCrta = new javax.swing.JLabel();
        txtDimenzijeMala = new javax.swing.JTextField();
        lblDrvo = new javax.swing.JLabel();
        cmbDrvo = new javax.swing.JComboBox<>();
        btnPretraziParket = new javax.swing.JButton();
        btnVratiSve = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaslov.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNaslov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNaslov.setText("Parket");

        tableParket.setModel(new javax.swing.table.DefaultTableModel(
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
        tableParket.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tableParket);

        lblDimenzije.setText("Dimenzije:");

        lblCrta.setText("-");

        lblDrvo.setText("Drvo:");

        btnPretraziParket.setText("Pretrazi");
        btnPretraziParket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziParketActionPerformed(evt);
            }
        });

        btnVratiSve.setText("Prikazi Sve");
        btnVratiSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiSveActionPerformed(evt);
            }
        });

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNaslov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDimenzije)
                                    .addComponent(lblDrvo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDimenzijeVelika, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCrta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDimenzijeMala, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmbDrvo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnPromeni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPretraziParket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVratiSve, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNaslov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDimenzije)
                            .addComponent(txtDimenzijeVelika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCrta)
                            .addComponent(txtDimenzijeMala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDrvo)
                            .addComponent(cmbDrvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPretraziParket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVratiSve)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPromeni))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziParketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziParketActionPerformed
        String dimenzije = txtDimenzijeVelika.getText() + ":" + txtDimenzijeMala.getText();
        DrvoENUM drvo = (DrvoENUM) cmbDrvo.getSelectedItem();
        if (dimenzije.equals(":")) {
            pretraziParket(drvo.name(), dimenzije);
            return;
        }
        try {
            int i = Integer.parseInt(txtDimenzijeVelika.getText());
            int j = Integer.parseInt(txtDimenzijeMala.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Morate uneti brojeve", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtDimenzijeVelika.getText().length() != 3) {
            JOptionPane.showMessageDialog(this, "Prva dimenzija parketa mora biti trocifrena", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtDimenzijeMala.getText().length() != 2) {
            JOptionPane.showMessageDialog(this, "Druga dimenzija parketa mora biti dvocifrena", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        pretraziParket(drvo.name(), dimenzije);
    }//GEN-LAST:event_btnPretraziParketActionPerformed

    private void btnVratiSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiSveActionPerformed
        popuniTabeluParketa();
    }//GEN-LAST:event_btnVratiSveActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.SVI_PARKETI, null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Parket> listaParketa = (List<Parket>) so.getParametar();
        int brojReda = tableParket.getSelectedRow();
        if (brojReda != -1) {
            int idParket = (int) tableParket.getValueAt(brojReda, 0) -1;
            Parket parket = listaParketa.get(idParket);
            promeniParket(parket);
        } else {
            JOptionPane.showMessageDialog(this, "Odaberite red u tabeli", "GRESKA", JOptionPane.ERROR_MESSAGE);
        }
        popuniTabeluParketa();
    }//GEN-LAST:event_btnPromeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPretraziParket;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JButton btnVratiSve;
    private javax.swing.JComboBox<String> cmbDrvo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCrta;
    private javax.swing.JLabel lblDimenzije;
    private javax.swing.JLabel lblDrvo;
    private javax.swing.JLabel lblNaslov;
    private javax.swing.JTable tableParket;
    private javax.swing.JTextField txtDimenzijeMala;
    private javax.swing.JTextField txtDimenzijeVelika;
    // End of variables declaration//GEN-END:variables

    private void popuniTabeluParketa() {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.SVI_PARKETI, null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Parket> listaParketa = (List<Parket>) so.getParametar();
        tableModelParket model = new tableModelParket(listaParketa);
        tableParket.setModel(model);
    }

    private void pretraziParket(String drvo, String dimenzije) {
        String[] niz = {drvo, dimenzije};
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_PARKETE, niz);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Parket> listaParketa = (List<Parket>) so.getParametar();
        tableModelParket model = new tableModelParket(listaParketa);
        tableParket.setModel(model);
    }

    private void promeniParket(Parket parket) {
        FormaPromeniParket fpp = new FormaPromeniParket(this, true, parket);
        fpp.setVisible(true);
    }
}
