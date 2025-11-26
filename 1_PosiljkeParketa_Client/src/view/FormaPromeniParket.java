package view;

import domen.DrvoENUM;
import domen.Parket;
import java.awt.Dialog;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import komunikacija.KlijentKomunikacija;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaPromeniParket extends javax.swing.JDialog {

    Parket parket;

    public FormaPromeniParket(Dialog parent, boolean modal, Parket parket) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        String dimenzije = parket.getDimenzije();
        String[] niz = dimenzije.split(":");
        this.parket = parket;

        cmbDrvo.setModel(new DefaultComboBoxModel(DrvoENUM.values()));
        cmbDrvo.setSelectedItem(this.parket.getDrvo());

        txtDimenzijeVelika.setText(niz[0]);
        txtDimenzijeMala.setText(niz[1]);

        for (DrvoENUM drvo : DrvoENUM.values()) {
            if (drvo.name().equals(parket.getDrvo())) {
                cmbDrvo.setSelectedItem(drvo);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaslov = new javax.swing.JLabel();
        cmbDrvo = new javax.swing.JComboBox<>();
        lblDrvo = new javax.swing.JLabel();
        lblDimenzije = new javax.swing.JLabel();
        txtDimenzijeVelika = new javax.swing.JTextField();
        txtDimenzijeMala = new javax.swing.JTextField();
        lblCrta = new javax.swing.JLabel();
        btnPromeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaslov.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNaslov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNaslov.setText("Parket");

        lblDrvo.setText("Drvo:");

        lblDimenzije.setText("Dimenzije:");

        lblCrta.setText("-");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDrvo)
                            .addComponent(lblDimenzije))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDimenzijeVelika, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCrta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDimenzijeMala, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbDrvo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPromeni, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNaslov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDrvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDrvo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDimenzije)
                    .addComponent(txtDimenzijeVelika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCrta)
                    .addComponent(txtDimenzijeMala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPromeni)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        String dimenzije = txtDimenzijeVelika.getText() + ":" + txtDimenzijeMala.getText();
        DrvoENUM drvo = (DrvoENUM) cmbDrvo.getSelectedItem();
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
        Parket p = new Parket(parket.getPrimarniKljuc(), dimenzije, drvo);
        promeniParket(p);
    }//GEN-LAST:event_btnPromeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<String> cmbDrvo;
    private javax.swing.JLabel lblCrta;
    private javax.swing.JLabel lblDimenzije;
    private javax.swing.JLabel lblDrvo;
    private javax.swing.JLabel lblNaslov;
    private javax.swing.JTextField txtDimenzijeMala;
    private javax.swing.JTextField txtDimenzijeVelika;
    // End of variables declaration//GEN-END:variables

    private void promeniParket(Parket p) {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.SVI_PARKETI, null);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();
        
        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        List<Parket> listaParketa = (List<Parket>) so.getParametar();
        for(Parket parket : listaParketa){
            if(p.getDimenzije().equals(parket.getDimenzije()) && p.getDrvo().equals(parket.getDrvo())){
                JOptionPane.showMessageDialog(this, "Takav parket vec postoji", "GRESKA", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        
        
        kz = new KlijentskiZahtev(OperacijeENUM.PROMENI_PARKET, p);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dispose();
    }
}
