package view;

import domen.Parket;
import domen.Potvrda;
import domen.StavkaPotvrde;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KlijentKomunikacija;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaPromeniStavkuBEZBAZE extends javax.swing.JDialog {

    StavkaPotvrde stavka = null;

    public FormaPromeniStavkuBEZBAZE(java.awt.Dialog parent, boolean modal, StavkaPotvrde stavka) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.stavka = stavka;
        popuniCmbParket();
        txtKolicina.setText(String.valueOf(stavka.getKolicina()));
        System.out.println(stavka.getParket());
        cmbParket.setSelectedIndex(stavka.getParket() - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaslov = new javax.swing.JLabel();
        lblKolicina = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        lblParket = new javax.swing.JLabel();
        cmbParket = new javax.swing.JComboBox<>();
        btnPromeniStavku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblNaslov.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNaslov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNaslov.setText("Stavka Potvrde");

        lblKolicina.setText("Kolicina:");

        lblParket.setText("Parket:");

        btnPromeniStavku.setText("Promeni Stavku");
        btnPromeniStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniStavkuActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPromeniStavku)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblParket)
                                    .addComponent(lblKolicina))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKolicina)
                                    .addComponent(cmbParket, 0, 100, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNaslov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKolicina)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblParket)
                    .addComponent(cmbParket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPromeniStavku)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromeniStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniStavkuActionPerformed

        dispose();
    }//GEN-LAST:event_btnPromeniStavkuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Socket soket = KlijentKomunikacija.getInstance().getSoket();
        if (soket == null) {
            return;
        }
        if (soket != null && !soket.isClosed()) {
            try {
                soket.close();
                soket = null;
            } catch (IOException ex) {
                Logger.getLogger(FormaDodajStavka.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPromeniStavku;
    private javax.swing.JComboBox<Parket> cmbParket;
    private javax.swing.JLabel lblKolicina;
    private javax.swing.JLabel lblNaslov;
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
        return new StavkaPotvrde(-1, stavka.getPrimarniKljuc(), Double.parseDouble(txtKolicina.getText()), parket.getPrimarniKljuc());
    }
}
