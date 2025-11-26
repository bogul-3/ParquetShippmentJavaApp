package view;

import domen.Parket;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import domen.Posiljalac;
import domen.Potvrda;
import domen.Prodavnica;
import domen.StavkaPotvrde;
import java.util.LinkedList;
import komunikacija.KlijentKomunikacija;

import modelTable.TableModelStavka;
import modelTable.TableModelStavkaKreiraj;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaPromeniPotvrdu extends javax.swing.JDialog {

    Potvrda potvrda;
    TableModelStavka model;
    StavkaPotvrde stavka;
    List<StavkaPotvrde> stavkeZaTabelu;
    List<Parket> listaParketa = new LinkedList<>();

    public FormaPromeniPotvrdu(java.awt.Dialog parent, boolean modal, Potvrda potvrda) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.potvrda = potvrda;
        txtProsek.setEnabled(false);

        popuniCmbPosiljalac();
        popuniCmbProdavnica();
        txtId.setText(Integer.toString(potvrda.getPrimarniKljuc()));
        txtProsek.setText(String.valueOf(potvrda.getProsecnaKolicina()));

        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_POSILJAOCA_ID, potvrda.getPosiljalac());
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Posiljalac posiljalac = (Posiljalac) so.getParametar();
        postaviCmbPosiljalac(posiljalac);

        kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_PRODAVNICU_ID, potvrda.getProdavnica());
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Prodavnica prodavnica = (Prodavnica) so.getParametar();
        postaviCmbProdavnica(prodavnica);

        datePicker.setDate(potvrda.getDatum());

        kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.PRETRAZI_POTVRDU_ID);
        kz.setParametar(potvrda.getPrimarniKljuc());

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        kz = new KlijentskiZahtev(OperacijeENUM.SVI_PARKETI, null);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        listaParketa = (List<Parket>) so.getParametar();

        postaviModelTabeleStavka();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaslov = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        lblProsek = new javax.swing.JLabel();
        txtProsek = new javax.swing.JTextField();
        lblPosiljalac = new javax.swing.JLabel();
        lblProdavnica = new javax.swing.JLabel();
        cmbProdavnica = new javax.swing.JComboBox<>();
        cmbPosiljalac = new javax.swing.JComboBox<>();
        btnPromeni = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        datePicker = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStavke = new javax.swing.JTable();
        btnStavka = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();
        btnDodajStavku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaslov.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNaslov.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNaslov.setText("       Potvrda                                                 Stavke");

        lblDatum.setText("Datum:");

        lblProsek.setText("Prosecna Kolicina:");

        lblPosiljalac.setText("Posiljalac:");

        lblProdavnica.setText("Prodavnica:");

        btnPromeni.setText("Promeni Potvrdu");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        lblId.setText("Id:");

        txtId.setEditable(false);

        tableStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        tableStavke.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableStavke);

        btnStavka.setText("Promeni Stavku");
        btnStavka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStavkaActionPerformed(evt);
            }
        });

        btnObrisiStavku.setText("ObrisiStavku");
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        btnDodajStavku.setText("DodajStavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lblProdavnica)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(cmbProdavnica, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lblPosiljalac)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(cmbPosiljalac, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(36, 36, 36)
                                            .addComponent(btnPromeni, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblId)
                                                .addComponent(lblDatum))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(114, 114, 114))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProsek)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProsek, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnStavka)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisiStavku)
                                .addGap(18, 18, 18)
                                .addComponent(btnDodajStavku))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNaslov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatum)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProsek)
                            .addComponent(txtProsek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPosiljalac)
                            .addComponent(cmbPosiljalac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProdavnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProdavnica))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPromeni))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStavka)
                    .addComponent(btnObrisiStavku)
                    .addComponent(btnDodajStavku))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        Date datum = datePicker.getDate();
        Posiljalac pos = (Posiljalac) cmbPosiljalac.getSelectedItem();
        Prodavnica pro = (Prodavnica) cmbProdavnica.getSelectedItem();
        double[] nizKolicinaStavki = new double[100];
        int velicina = 0;
        for (velicina = 0; velicina < model.getRowCount(); velicina++) {
            nizKolicinaStavki[velicina] = (double) model.getValueAt(velicina, 1);
        }

        Double prosek = 0.0;
        int iterator = 0;
        for (iterator = 0; iterator < velicina; iterator++) {
            prosek += nizKolicinaStavki[iterator];
        }
        prosek = prosek / iterator;

        Potvrda p = new Potvrda(Integer.parseInt(txtId.getText()), datum, prosek,
                pos.getPrimarniKljuc(), pro.getPrimarniKljuc(), stavkeZaTabelu);
        if (promeniPotvrdu(p)) {
            dispose();
        }
    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnStavkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStavkaActionPerformed
        int red = tableStavke.getSelectedRow();
        if (red < 0) {
            JOptionPane.showMessageDialog(this, "Izaberite stavku za promenu", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        StavkaPotvrde stavka = stavkeZaTabelu.get(red);
        promeniStavku(stavka);
    }//GEN-LAST:event_btnStavkaActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        int idStavke = tableStavke.getRowCount() + 1;
        FormaDodajStavka fs = new FormaDodajStavka(this, true, idStavke);
        fs.setVisible(true);
        stavka = fs.vratiStavku();
        if (stavka == null) {
            JOptionPane.showMessageDialog(this, "Niste Uneli Kolicinu Stavke", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dodajStavkuUTabelu(stavka);
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed
        stavkeZaTabelu.remove(tableStavke.getRowCount() - 1);

        List<Parket> novaListaParketa = new LinkedList<>();

        for (StavkaPotvrde s : stavkeZaTabelu) {
            for (Parket p : listaParketa) {
                if (s.getParket() == p.getPrimarniKljuc()) {
                    novaListaParketa.add(p);
                }
            }
        }

        model = new TableModelStavka(stavkeZaTabelu, novaListaParketa);
        tableStavke.setModel(model);

        double[] nizKolicinaStavki = new double[100];
        int velicina = 0;
        for (velicina = 0; velicina < model.getRowCount(); velicina++) {
            nizKolicinaStavki[velicina] = (double) model.getValueAt(velicina, 1);
        }
        Double prosek = 0.0;
        int iterator = 0;
        for (iterator = 0; iterator < velicina; iterator++) {
            prosek += nizKolicinaStavki[iterator];
        }
        prosek = prosek / iterator;
        prosek = Math.round(prosek * 10000.0) / 10000.0;

        txtProsek.setText(String.valueOf(prosek));
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JButton btnStavka;
    private javax.swing.JComboBox<Posiljalac> cmbPosiljalac;
    private javax.swing.JComboBox<Prodavnica> cmbProdavnica;
    private com.toedter.calendar.JDateChooser datePicker;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNaslov;
    private javax.swing.JLabel lblPosiljalac;
    private javax.swing.JLabel lblProdavnica;
    private javax.swing.JLabel lblProsek;
    private javax.swing.JTable tableStavke;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtProsek;
    // End of variables declaration//GEN-END:variables

    private void popuniCmbPosiljalac() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.SVI_POSILJAOCI);
        kz.setParametar(null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Posiljalac> listaPosiljaoca = (List<Posiljalac>) so.getParametar();
        for (Posiljalac p : listaPosiljaoca) {
            cmbPosiljalac.addItem(p);
        }
    }

    private void popuniCmbProdavnica() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.SVE_PRODAVNICE);
        kz.setParametar(null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Prodavnica> listaProdavnica = (List<Prodavnica>) so.getParametar();
        for (Prodavnica p : listaProdavnica) {
            cmbProdavnica.addItem(p);
        }
    }

    private void postaviCmbPosiljalac(Posiljalac posiljalac) {
        for (int i = 0; i < cmbPosiljalac.getItemCount(); i++) {
            Posiljalac pos = cmbPosiljalac.getItemAt(i);
            if (pos.equals(posiljalac)) {
                cmbPosiljalac.setSelectedItem(pos);
            }
        }
    }

    private void postaviCmbProdavnica(Prodavnica prodavnica) {
        for (int i = 0; i < cmbProdavnica.getItemCount(); i++) {
            Prodavnica pro = cmbProdavnica.getItemAt(i);
            if (pro.equals(prodavnica)) {
                cmbProdavnica.setSelectedItem(pro);
            }

        }
    }

    private boolean promeniPotvrdu(Potvrda p) {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PROMENI_POTVRDU, p);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void postaviModelTabeleStavka() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.PRETRAZI_POTVRDU_ID);
        kz.setParametar(potvrda.getPrimarniKljuc());

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        potvrda = (Potvrda) so.getParametar();
        stavkeZaTabelu = potvrda.getListaStavki();

        List<Parket> novaListaParketa = new LinkedList<>();

        for (StavkaPotvrde s : stavkeZaTabelu) {
            for (Parket p : listaParketa) {
                if (s.getParket() == p.getPrimarniKljuc()) {
                    novaListaParketa.add(p);
                }
            }
        }

        model = new TableModelStavka(stavkeZaTabelu, novaListaParketa);
        tableStavke.setModel(model);
    }

    private void promeniStavku(StavkaPotvrde stavka) {
        FormaPromeniStavkuBEZBAZE fps = new FormaPromeniStavkuBEZBAZE(this, true, stavka);
        fps.setVisible(true);

        StavkaPotvrde novaStavka = fps.vratiStavku();
        novaStavka.setPotvrda(potvrda.getPrimarniKljuc());

        int iterator = 0;
        for (StavkaPotvrde s : stavkeZaTabelu) {
            if (s.getPrimarniKljuc() == novaStavka.getPrimarniKljuc()) {
                stavkeZaTabelu.set(iterator, novaStavka);

            }
            iterator++;
        }

        List<Parket> novaListaParketa = new LinkedList<>();

        for (StavkaPotvrde s : stavkeZaTabelu) {
            for (Parket p : listaParketa) {
                if (s.getParket() == p.getPrimarniKljuc()) {
                    novaListaParketa.add(p);
                }
            }
        }

        model = new TableModelStavka(stavkeZaTabelu, novaListaParketa);
        tableStavke.setModel(model);

        double[] nizKolicinaStavki = new double[100];
        int velicina = 0;
        for (velicina = 0; velicina < model.getRowCount(); velicina++) {
            nizKolicinaStavki[velicina] = (double) model.getValueAt(velicina, 1);
        }
        Double prosek = 0.0;
        iterator = 0;
        for (iterator = 0; iterator < velicina; iterator++) {
            prosek += nizKolicinaStavki[iterator];
        }
        prosek = prosek / iterator;
        prosek = Math.round(prosek * 10000.0) / 10000.0;

        txtProsek.setText(String.valueOf(prosek));
    }

    private void dodajStavkuUTabelu(StavkaPotvrde stavka) {
        for (StavkaPotvrde s : stavkeZaTabelu) {
            if (s.getParket() == stavka.getParket()) {
                s.setKolicina(s.getKolicina() + stavka.getKolicina());
                TableModelStavkaKreiraj model = new TableModelStavkaKreiraj(stavkeZaTabelu);
                tableStavke.setModel(model);
                return;
            }
        }
        stavkeZaTabelu.add(stavka);

        TableModelStavkaKreiraj model = new TableModelStavkaKreiraj(stavkeZaTabelu);
        tableStavke.setModel(model);

        double[] nizKolicinaStavki = new double[100];
        int velicina = 0;
        for (velicina = 0; velicina < model.getRowCount(); velicina++) {
            nizKolicinaStavki[velicina] = (double) model.getValueAt(velicina, 1);
        }
        Double prosek = 0.0;
        int iterator = 0;
        for (iterator = 0; iterator < velicina; iterator++) {
            prosek += nizKolicinaStavki[iterator];
        }
        prosek = prosek / iterator;
        prosek = Math.round(prosek * 10000.0) / 10000.0;

        txtProsek.setText(String.valueOf(prosek));
    }
}
