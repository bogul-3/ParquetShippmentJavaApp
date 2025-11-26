package view;

import java.util.List;
import domen.Mesto;
import domen.Prodavnica;
import javax.swing.JOptionPane;
import komunikacija.KlijentKomunikacija;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaPromeniProdavnicu extends javax.swing.JDialog {

    public FormaPromeniProdavnicu(java.awt.Dialog parent, boolean modal, Prodavnica prodavnica) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        popuniCmbMesto();
        txtIdProdavnica.setText(Integer.toString(prodavnica.getPrimarniKljuc()));
        txtNaziv.setText(prodavnica.getNaziv());
        txtAdresa.setText(prodavnica.getAdresa());

        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_MESTO_ID, prodavnica.getMesto());
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Mesto mesto = (Mesto) so.getParametar();
        postaviCmbMesto(mesto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGlavna = new javax.swing.JLabel();
        lblIdProdavnica = new javax.swing.JLabel();
        txtIdProdavnica = new javax.swing.JTextField();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblAdresa = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        lblMesto = new javax.swing.JLabel();
        cmbMesto = new javax.swing.JComboBox<>();
        btnPromeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblGlavna.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGlavna.setText("Prodavnica");

        lblIdProdavnica.setText("Id:");

        txtIdProdavnica.setEditable(false);
        txtIdProdavnica.setEnabled(false);

        lblNaziv.setText("Naziv:");

        lblAdresa.setText("Adresa:");

        lblMesto.setText("Mesto:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMesto)
                                    .addComponent(lblAdresa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMesto, 0, 116, Short.MAX_VALUE)
                                    .addComponent(txtAdresa)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNaziv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNaziv))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblGlavna))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(lblIdProdavnica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdProdavnica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnPromeni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGlavna)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProdavnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdProdavnica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresa)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMesto)
                    .addComponent(cmbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPromeni)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        Mesto mesto = (Mesto) cmbMesto.getSelectedItem();
        Prodavnica prodavnica = new Prodavnica(Integer.parseInt(txtIdProdavnica.getText()), txtNaziv.getText(), txtAdresa.getText(),
                mesto.getPrimarniKljuc());

        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.SVE_PRODAVNICE, null);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Prodavnica> listaProdavnica = (List<Prodavnica>) so.getParametar();
        for (Prodavnica p : listaProdavnica) {
            if (prodavnica.getNaziv().equals(p.getNaziv()) && prodavnica.getAdresa().equals(p.getAdresa())
                    && p.getMesto() == prodavnica.getMesto()) {
                JOptionPane.showMessageDialog(this, "Takva prodavnica vec postoji", "GRESKA", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        promeniProdavnicu(prodavnica);
        dispose();
    }//GEN-LAST:event_btnPromeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<Mesto> cmbMesto;
    private javax.swing.JLabel lblAdresa;
    private javax.swing.JLabel lblGlavna;
    private javax.swing.JLabel lblIdProdavnica;
    private javax.swing.JLabel lblMesto;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtIdProdavnica;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void popuniCmbMesto() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.SVA_MESTA);
        kz.setParametar(null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Mesto> listaMesta = (List<Mesto>) so.getParametar();
        for (Mesto m : listaMesta) {
            cmbMesto.addItem(m);
        }
    }

    private void postaviCmbMesto(Mesto mesto) {
        for (int i = 0; i < cmbMesto.getItemCount(); i++) {
            Mesto m = cmbMesto.getItemAt(i);
            if (m.equals(mesto)) {
                cmbMesto.setSelectedItem(m);
            }
        }
    }

    private void promeniProdavnicu(Prodavnica prod) {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PROMENI_PRODAVNICU, prod);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
