package view;

import domen.Posiljalac;
import java.awt.GridBagLayout;

public class FormaGlavna extends javax.swing.JFrame {

    private Posiljalac posiljalac;

    public FormaGlavna(Posiljalac p) {
        initComponents();
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        this.posiljalac = p;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGlavna = new javax.swing.JLabel();
        menuBarGlavna = new javax.swing.JMenuBar();
        menuDokument = new javax.swing.JMenu();
        menuPotvrda = new javax.swing.JMenu();
        itemKreirajPotvrda = new javax.swing.JMenuItem();
        itemPretraziPotvrda = new javax.swing.JMenuItem();
        itemPromeniPotvrda = new javax.swing.JMenuItem();
        menuPruzalacUsluge = new javax.swing.JMenu();
        itemPosiljalac = new javax.swing.JMenuItem();
        menuPrimalacUsluge = new javax.swing.JMenu();
        menuProdavnica = new javax.swing.JMenu();
        itemKreirajProdavnica = new javax.swing.JMenuItem();
        itemPretraziProdavnica = new javax.swing.JMenuItem();
        itemPromeniProdavnica = new javax.swing.JMenuItem();
        itemObrisiProdavnica = new javax.swing.JMenuItem();
        menuSifarnici = new javax.swing.JMenu();
        menuSkladiste = new javax.swing.JMenu();
        itemUbaciSkladiste = new javax.swing.JMenuItem();
        menuParket = new javax.swing.JMenu();
        itemPretraziParket = new javax.swing.JMenuItem();
        itemPromeniParket = new javax.swing.JMenuItem();
        menuMesto = new javax.swing.JMenu();
        itemMesto = new javax.swing.JMenuItem();
        menuOProgramu = new javax.swing.JMenu();
        itemOProgramu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGlavna.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGlavna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGlavna.setText("Odaberite operaciju koju želite da izvršite");

        menuDokument.setText("Dokumenti");

        menuPotvrda.setText("Potvrda");

        itemKreirajPotvrda.setText("Kreiraj Potvrdu");
        itemKreirajPotvrda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemKreirajPotvrdaActionPerformed(evt);
            }
        });
        menuPotvrda.add(itemKreirajPotvrda);

        itemPretraziPotvrda.setText("Pretrazi Potvrdu");
        itemPretraziPotvrda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPretraziPotvrdaActionPerformed(evt);
            }
        });
        menuPotvrda.add(itemPretraziPotvrda);

        itemPromeniPotvrda.setText("Promeni Potvrdu");
        itemPromeniPotvrda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPromeniPotvrdaActionPerformed(evt);
            }
        });
        menuPotvrda.add(itemPromeniPotvrda);

        menuDokument.add(menuPotvrda);

        menuBarGlavna.add(menuDokument);

        menuPruzalacUsluge.setText("Pruzalac Usluge");

        itemPosiljalac.setText("Posiljalac");
        itemPosiljalac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPosiljalacActionPerformed(evt);
            }
        });
        menuPruzalacUsluge.add(itemPosiljalac);

        menuBarGlavna.add(menuPruzalacUsluge);

        menuPrimalacUsluge.setText("Primalac Usluge");

        menuProdavnica.setText("Prodavnica");

        itemKreirajProdavnica.setText("Kreiraj Prodavnicu");
        itemKreirajProdavnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemKreirajProdavnicaActionPerformed(evt);
            }
        });
        menuProdavnica.add(itemKreirajProdavnica);

        itemPretraziProdavnica.setText("Pretrazi Prodavnicu");
        itemPretraziProdavnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPretraziProdavnicaActionPerformed(evt);
            }
        });
        menuProdavnica.add(itemPretraziProdavnica);

        itemPromeniProdavnica.setText("Promeni Prodavnicu");
        itemPromeniProdavnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPromeniProdavnicaActionPerformed(evt);
            }
        });
        menuProdavnica.add(itemPromeniProdavnica);

        itemObrisiProdavnica.setText("Obrisi Prodavnicu");
        itemObrisiProdavnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemObrisiProdavnicaActionPerformed(evt);
            }
        });
        menuProdavnica.add(itemObrisiProdavnica);

        menuPrimalacUsluge.add(menuProdavnica);

        menuBarGlavna.add(menuPrimalacUsluge);

        menuSifarnici.setText("Sifarnici");

        menuSkladiste.setText("Skladiste");

        itemUbaciSkladiste.setText("Ubaci Skladiste");
        itemUbaciSkladiste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUbaciSkladisteActionPerformed(evt);
            }
        });
        menuSkladiste.add(itemUbaciSkladiste);

        menuSifarnici.add(menuSkladiste);

        menuParket.setText("Parket");

        itemPretraziParket.setText("Pretrazi Parket");
        itemPretraziParket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPretraziParketActionPerformed(evt);
            }
        });
        menuParket.add(itemPretraziParket);

        itemPromeniParket.setText("Promeni Parket");
        itemPromeniParket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPromeniParketActionPerformed(evt);
            }
        });
        menuParket.add(itemPromeniParket);

        menuSifarnici.add(menuParket);

        menuMesto.setText("Mesto");

        itemMesto.setText("Pretrazi Mesto");
        itemMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMestoActionPerformed(evt);
            }
        });
        menuMesto.add(itemMesto);

        menuSifarnici.add(menuMesto);

        menuBarGlavna.add(menuSifarnici);

        menuOProgramu.setText("O Programu");
        menuOProgramu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOProgramuActionPerformed(evt);
            }
        });

        itemOProgramu.setText("Opis Programa");
        itemOProgramu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOProgramuActionPerformed(evt);
            }
        });
        menuOProgramu.add(itemOProgramu);

        menuBarGlavna.add(menuOProgramu);

        setJMenuBar(menuBarGlavna);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGlavna, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblGlavna)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemKreirajPotvrdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemKreirajPotvrdaActionPerformed
        FormaPotvrda fp = new FormaPotvrda(this, true, posiljalac, "kreiraj");
        fp.setVisible(true);
    }//GEN-LAST:event_itemKreirajPotvrdaActionPerformed

    private void itemPretraziPotvrdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPretraziPotvrdaActionPerformed
        FormaPotvrda fp = new FormaPotvrda(this, true, posiljalac, "pretrazi");
        fp.setVisible(true);
    }//GEN-LAST:event_itemPretraziPotvrdaActionPerformed

    private void itemPromeniPotvrdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPromeniPotvrdaActionPerformed
        FormaPotvrda fp = new FormaPotvrda(this, true, posiljalac, "promeni");
        fp.setVisible(true);
    }//GEN-LAST:event_itemPromeniPotvrdaActionPerformed

    private void itemPosiljalacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPosiljalacActionPerformed
        FormaPosiljalac fp = new FormaPosiljalac(this, true, posiljalac);
        fp.setVisible(true);
    }//GEN-LAST:event_itemPosiljalacActionPerformed

    private void itemKreirajProdavnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemKreirajProdavnicaActionPerformed
        FormaProdavnica fp = new FormaProdavnica(this, true, "kreiraj");
        fp.setVisible(true);
    }//GEN-LAST:event_itemKreirajProdavnicaActionPerformed

    private void itemPretraziProdavnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPretraziProdavnicaActionPerformed
        FormaProdavnica fp = new FormaProdavnica(this, true, "pretrazi");
        fp.setVisible(true);
    }//GEN-LAST:event_itemPretraziProdavnicaActionPerformed

    private void itemPromeniProdavnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPromeniProdavnicaActionPerformed
        FormaProdavnica fp = new FormaProdavnica(this, true, "promeni");
        fp.setVisible(true);
    }//GEN-LAST:event_itemPromeniProdavnicaActionPerformed

    private void itemObrisiProdavnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemObrisiProdavnicaActionPerformed
        FormaProdavnica fp = new FormaProdavnica(this, true, "obrisi");
        fp.setVisible(true);
    }//GEN-LAST:event_itemObrisiProdavnicaActionPerformed

    private void itemUbaciSkladisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUbaciSkladisteActionPerformed
        FormaSkladiste fs = new FormaSkladiste(this, true);
        fs.setVisible(true);
    }//GEN-LAST:event_itemUbaciSkladisteActionPerformed

    private void itemPretraziParketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPretraziParketActionPerformed
        FormaParket fp = new FormaParket(this, true, "pretrazi");
        fp.setVisible(true);
    }//GEN-LAST:event_itemPretraziParketActionPerformed

    private void itemPromeniParketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPromeniParketActionPerformed
        FormaParket fp = new FormaParket(this, true, "promeni");
        fp.setVisible(true);
    }//GEN-LAST:event_itemPromeniParketActionPerformed

    private void itemMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMestoActionPerformed
        FormaMesto fm = new FormaMesto(this, true);
        fm.setVisible(true);
    }//GEN-LAST:event_itemMestoActionPerformed

    private void menuOProgramuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOProgramuActionPerformed

    }//GEN-LAST:event_menuOProgramuActionPerformed

    private void itemOProgramuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOProgramuActionPerformed
        FormaOProgramu fop = new FormaOProgramu(this, true);
        fop.setVisible(true);
    }//GEN-LAST:event_itemOProgramuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemKreirajPotvrda;
    private javax.swing.JMenuItem itemKreirajProdavnica;
    private javax.swing.JMenuItem itemMesto;
    private javax.swing.JMenuItem itemOProgramu;
    private javax.swing.JMenuItem itemObrisiProdavnica;
    private javax.swing.JMenuItem itemPosiljalac;
    private javax.swing.JMenuItem itemPretraziParket;
    private javax.swing.JMenuItem itemPretraziPotvrda;
    private javax.swing.JMenuItem itemPretraziProdavnica;
    private javax.swing.JMenuItem itemPromeniParket;
    private javax.swing.JMenuItem itemPromeniPotvrda;
    private javax.swing.JMenuItem itemPromeniProdavnica;
    private javax.swing.JMenuItem itemUbaciSkladiste;
    private javax.swing.JLabel lblGlavna;
    private javax.swing.JMenuBar menuBarGlavna;
    private javax.swing.JMenu menuDokument;
    private javax.swing.JMenu menuMesto;
    private javax.swing.JMenu menuOProgramu;
    private javax.swing.JMenu menuParket;
    private javax.swing.JMenu menuPotvrda;
    private javax.swing.JMenu menuPrimalacUsluge;
    private javax.swing.JMenu menuProdavnica;
    private javax.swing.JMenu menuPruzalacUsluge;
    private javax.swing.JMenu menuSifarnici;
    private javax.swing.JMenu menuSkladiste;
    // End of variables declaration//GEN-END:variables
}
