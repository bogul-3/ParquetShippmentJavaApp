package view;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Properties;
import javax.swing.JOptionPane;
import komunikacija.PokreniServer;
import postavke.Postavke;

public class FormaServer extends javax.swing.JFrame {

    PokreniServer ps = null;
    Postavke postavke = new Postavke();

    public FormaServer() {
        initComponents();
        setLocationRelativeTo(null);
        btnPromeniPostavke.setEnabled(true);

        try {
            InputStream in = null;
            in = new FileInputStream("Postavke.properties");
            postavke.getProperties().load(in);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FormaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaslov = new javax.swing.JLabel();
        btnPokreni = new javax.swing.JButton();
        btnZaustavi = new javax.swing.JButton();
        lblStanjeServer = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        lblImeBaze = new javax.swing.JLabel();
        btnPromeniPostavke = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNaslov.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNaslov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNaslov.setText("Server");

        btnPokreni.setText("Pokreni Server");
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        btnZaustavi.setText("Zaustavi Server");
        btnZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaustaviActionPerformed(evt);
            }
        });

        lblStanjeServer.setBackground(new java.awt.Color(0, 0, 0));
        lblStanjeServer.setForeground(new java.awt.Color(255, 51, 51));
        lblStanjeServer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStanjeServer.setText("Server nije pokrenut");

        lblPort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPort.setText("Port: ");

        lblImeBaze.setText("Ime Baze Podataka:");

        btnPromeniPostavke.setText("Promeni Postavke");
        btnPromeniPostavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniPostavkeActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnPokreni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZaustavi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblImeBaze))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblStanjeServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPromeniPostavke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNaslov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPokreni)
                    .addComponent(lblStanjeServer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZaustavi)
                    .addComponent(lblPort))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImeBaze)
                    .addComponent(btnPromeniPostavke))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniActionPerformed
        btnPromeniPostavke.setEnabled(false);
        try {
            InputStream in = null;
            in = new FileInputStream("Postavke.properties");
            postavke.getProperties().clear();
            postavke.getProperties().load(in);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FormaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (ps == null) {
            ps = new PokreniServer();
            ps.start();
            lblStanjeServer.setText("Server je pokrenut");
            lblStanjeServer.setForeground(Color.GREEN);
            JOptionPane.showMessageDialog(this, "Uspesno pokrenut server", "USPEH", JOptionPane.INFORMATION_MESSAGE);
            lblPort.setText(String.valueOf(lblPort.getText() + ps.getServerSoket().getLocalPort()));
            lblImeBaze.setText(lblImeBaze.getText() + " " + postavke.getProperties().getProperty("dbName"));
            return;
        }
        JOptionPane.showMessageDialog(this, "Server je vec pokrenut", "GRESKA", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnPokreniActionPerformed

    private void btnZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaustaviActionPerformed
        btnPromeniPostavke.setEnabled(true);
        ps.close();
        lblStanjeServer.setText("Server nije pokrenut");
        lblStanjeServer.setForeground(Color.RED);
        ps = null;
        lblPort.setText("Port: ");
        lblImeBaze.setText("Ime Baze Podataka: ");

        JOptionPane.showMessageDialog(this, "Uspesno ugasen server", "GRESKA", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnZaustaviActionPerformed

    private void btnPromeniPostavkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniPostavkeActionPerformed
        if (ps != null) {
            JOptionPane.showMessageDialog(this, "Ne mozete menjati postavke za pokrenut server", "GRESKA", JOptionPane.ERROR_MESSAGE);
        }

        new FormaPromenaPostavki(this, true).setVisible(true);
    }//GEN-LAST:event_btnPromeniPostavkeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreni;
    private javax.swing.JButton btnPromeniPostavke;
    private javax.swing.JButton btnZaustavi;
    private javax.swing.JLabel lblImeBaze;
    private javax.swing.JLabel lblNaslov;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblStanjeServer;
    // End of variables declaration//GEN-END:variables
}
