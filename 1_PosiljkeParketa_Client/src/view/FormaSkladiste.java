package view;

import domen.Skladiste;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.KlijentKomunikacija;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaSkladiste extends javax.swing.JDialog {

    public FormaSkladiste(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSkladiste = new javax.swing.JLabel();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblAdresa = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        btnUbaci = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblSkladiste.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSkladiste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkladiste.setText("Skladiste");

        lblNaziv.setText("Naziv:");

        lblAdresa.setText("Adresa:");

        btnUbaci.setText("Ubaci");
        btnUbaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbaciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAdresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdresa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSkladiste, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNaziv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNaziv)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnUbaci)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSkladiste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresa)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUbaci, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbaciActionPerformed
        ubaciSkladiste(txtNaziv.getText(), txtAdresa.getText());
    }//GEN-LAST:event_btnUbaciActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUbaci;
    private javax.swing.JLabel lblAdresa;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblSkladiste;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void ubaciSkladiste(String naziv, String adresa) {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.SVA_SKLADISTA, null);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Skladiste> listaSkladista = (List<Skladiste>) so.getParametar();
        for (Skladiste s : listaSkladista) {
            if (s.getNaziv().equals(naziv)) {
                JOptionPane.showMessageDialog(this, "Skladiste sa tim imenom vec postoji", "GRESKA", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (s.getAdresa().equals(adresa)) {
                JOptionPane.showMessageDialog(this, "Skladiste sa tom adresom vec postoji", "GRESKA", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String[] niz = {naziv, adresa};
        kz = new KlijentskiZahtev(OperacijeENUM.UBACI_SKLADISTE, niz);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Uspesno ubaceno skladiste", "USPEH", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
