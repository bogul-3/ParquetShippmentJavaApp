package view;

import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import domen.Posiljalac;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.KlijentKomunikacija;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaPrijava extends javax.swing.JFrame {

    public FormaPrijava() {
        initComponents();
        setResizable(false);
        setLayout(new GridBagLayout());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlavni = new javax.swing.JPanel();
        lblKorisnickoIme = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        lblLozinka = new javax.swing.JLabel();
        btnPrijava = new javax.swing.JButton();
        lblPrijava = new javax.swing.JLabel();
        passLozinka = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblKorisnickoIme.setText("Korisnicko ime:");

        txtKorisnickoIme.setMinimumSize(new java.awt.Dimension(200, 22));

        lblLozinka.setText("Lozinka:");

        btnPrijava.setText("Prijavite Se");
        btnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijavaActionPerformed(evt);
            }
        });

        lblPrijava.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPrijava.setText("PRIJAVITE SE");

        javax.swing.GroupLayout panelGlavniLayout = new javax.swing.GroupLayout(panelGlavni);
        panelGlavni.setLayout(panelGlavniLayout);
        panelGlavniLayout.setHorizontalGroup(
            panelGlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlavniLayout.createSequentialGroup()
                .addGroup(panelGlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlavniLayout.createSequentialGroup()
                        .addGroup(panelGlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKorisnickoIme, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLozinka, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passLozinka, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addGroup(panelGlavniLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(lblPrijava)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlavniLayout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addComponent(btnPrijava, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        panelGlavniLayout.setVerticalGroup(
            panelGlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlavniLayout.createSequentialGroup()
                .addComponent(lblPrijava)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKorisnickoIme)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLozinka)
                    .addComponent(passLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPrijava, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGlavni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGlavni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijavaActionPerformed
        if (txtKorisnickoIme.getText().equals("") || passLozinka.getPassword().length == 0) {
            JOptionPane.showMessageDialog(rootPane, "Unesite korisnicko ime i lozinku", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String korIme = txtKorisnickoIme.getText();
        String lozinka = String.valueOf(passLozinka.getPassword());
        proveriKredencijale(korIme, lozinka);
    }//GEN-LAST:event_btnPrijavaActionPerformed

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
                Logger.getLogger(FormaPrijava.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijava;
    private javax.swing.JLabel lblKorisnickoIme;
    private javax.swing.JLabel lblLozinka;
    private javax.swing.JLabel lblPrijava;
    private javax.swing.JPanel panelGlavni;
    private javax.swing.JPasswordField passLozinka;
    private javax.swing.JTextField txtKorisnickoIme;
    // End of variables declaration//GEN-END:variables

    private void proveriKredencijale(String korIme, String lozinka) {
        String[] niz = {korIme, lozinka};
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRIJAVA_POSILJAOCA, niz);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(rootPane, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Posiljalac p = (Posiljalac) so.getParametar();
        FormaGlavna fg = new FormaGlavna(p);
        fg.setVisible(true);
        dispose();
    }
}
