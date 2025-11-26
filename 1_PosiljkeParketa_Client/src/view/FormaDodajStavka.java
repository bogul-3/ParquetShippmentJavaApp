package view;

import java.util.List;
import domen.Parket;
import domen.StavkaPotvrde;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KlijentKomunikacija;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaDodajStavka extends javax.swing.JDialog {

    int idStavke;

    public FormaDodajStavka(java.awt.Dialog parent, boolean modal, int idStavke) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        popuniCmbParket();
        this.idStavke = idStavke;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKolicina = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        lblParket = new javax.swing.JLabel();
        cmbParket = new javax.swing.JComboBox<>();
        btnSacuvajStavku = new javax.swing.JButton();
        lblGlavna = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblKolicina.setText("Kolicina: ");

        lblParket.setText("Parket");

        btnSacuvajStavku.setText("Sacuvaj Stavku");
        btnSacuvajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajStavkuActionPerformed(evt);
            }
        });

        lblGlavna.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblGlavna.setText("Unesite Podatke O Stavki:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSacuvajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblParket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKolicina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbParket, javax.swing.GroupLayout.Alignment.LEADING, 0, 225, Short.MAX_VALUE)
                            .addComponent(txtKolicina, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(lblGlavna)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblGlavna)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKolicina)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParket)
                    .addComponent(cmbParket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajStavkuActionPerformed
        dispose();
    }//GEN-LAST:event_btnSacuvajStavkuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvajStavku;
    private javax.swing.JComboBox<Parket> cmbParket;
    private javax.swing.JLabel lblGlavna;
    private javax.swing.JLabel lblKolicina;
    private javax.swing.JLabel lblParket;
    private javax.swing.JTextField txtKolicina;
    // End of variables declaration//GEN-END:variables

    private void popuniCmbParket() {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.SVI_PARKETI, null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Parket> listaParketa = (List<Parket>) so.getParametar();
        for (Parket p : listaParketa) {
            cmbParket.addItem(p);
        }
    }

    protected StavkaPotvrde vratiStavku() {
        if (txtKolicina.getText().equals("")) {
            return null;
        }
        Parket parket = (Parket) cmbParket.getSelectedItem();
        return new StavkaPotvrde(-1, idStavke, Double.parseDouble(txtKolicina.getText()), parket.getPrimarniKljuc());
    }
}
