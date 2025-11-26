package view;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import domen.Parket;
import domen.Posiljalac;
import domen.Potvrda;
import domen.Prodavnica;
import domen.StavkaPotvrde;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import komunikacija.KlijentKomunikacija;
import modelTable.TableModelPotvrda;
import modelTable.TableModelStavkaKreiraj;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaPotvrda extends javax.swing.JDialog {

    Posiljalac posiljalac;
    StavkaPotvrde stavka;
    List<StavkaPotvrde> stavkeZaTabelu = new LinkedList<StavkaPotvrde>();
    List<Potvrda> potvrdeZaTabelu = new LinkedList<Potvrda>();
    int idStavke = 1;

    public FormaPotvrda(java.awt.Frame parent, boolean modal, Posiljalac posiljalac, String operacija) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.posiljalac = posiljalac;
        popuniCmbProdavnica();
        tableStavke.getTableHeader().setReorderingAllowed(false);

        if (operacija.equals("kreiraj")) {

            btnKreiraj.setEnabled(true);
            btnPretrazi.setEnabled(false);
            btnPromeni.setEnabled(false);
            btnDodajStavku.setEnabled(true);
            btnPrikaziDetalje.setEnabled(false);
            btnSvePotvrde.setEnabled(false);

            lblTabela.setText("Stavke potvrde");

            lblProdavnica.setVisible(true);
            cmbProdavnica.setEnabled(true);

            postaviModelTabeleStavka();
        } else if (operacija.equals("pretrazi")) {
            btnKreiraj.setEnabled(false);
            btnPretrazi.setEnabled(true);
            btnPromeni.setEnabled(false);
            btnDodajStavku.setEnabled(false);
            btnPrikaziDetalje.setEnabled(true);
            btnSvePotvrde.setEnabled(true);

            lblTabela.setText("Potvrde:");

            lblProdavnica.setVisible(true);
            cmbProdavnica.setEnabled(true);

            popuniTabeluPotvrda();
        } else if (operacija.equals("promeni")) {
            btnKreiraj.setEnabled(false);
            btnPretrazi.setEnabled(true);
            btnPromeni.setEnabled(true);
            btnDodajStavku.setEnabled(false);
            btnPrikaziDetalje.setEnabled(true);
            btnSvePotvrde.setEnabled(true);

            lblTabela.setText("Potvrde:");
            tableStavke.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            lblProdavnica.setVisible(true);
            cmbProdavnica.setEnabled(true);

            datePicker.setVisible(true);
            popuniTabeluPotvrda();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPotvrda = new javax.swing.JLabel();
        btnKreiraj = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();
        cmbProdavnica = new javax.swing.JComboBox<>();
        lblProdavnica = new javax.swing.JLabel();
        panelTabela = new javax.swing.JPanel();
        lblTabela = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStavke = new javax.swing.JTable();
        btnDodajStavku = new javax.swing.JButton();
        btnPrikaziDetalje = new javax.swing.JButton();
        btnSvePotvrde = new javax.swing.JButton();
        datePicker = new com.toedter.calendar.JDateChooser();
        lblDatum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblPotvrda.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPotvrda.setText("Potvrda");

        btnKreiraj.setText("Kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        lblProdavnica.setText("Prodavnica:");

        lblTabela.setText("StavkePotvrde: ");

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

        btnDodajStavku.setText("Dodaj Stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        btnPrikaziDetalje.setText("Prikazi Detalje");
        btnPrikaziDetalje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziDetaljeActionPerformed(evt);
            }
        });

        btnSvePotvrde.setText("Prikazi Sve Potvrde");
        btnSvePotvrde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSvePotvrdeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTabelaLayout = new javax.swing.GroupLayout(panelTabela);
        panelTabela.setLayout(panelTabelaLayout);
        panelTabelaLayout.setHorizontalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSvePotvrde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrikaziDetalje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDodajStavku)
                .addContainerGap())
        );
        panelTabelaLayout.setVerticalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addGroup(panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrikaziDetalje)
                    .addComponent(btnSvePotvrde))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTabela))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblDatum.setText("Datum:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblPotvrda))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromeni, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblProdavnica)
                            .addComponent(lblDatum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProdavnica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPotvrda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPretrazi)
                    .addComponent(btnPromeni))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProdavnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProdavnica))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatum)))
                    .addComponent(panelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        if (datePicker.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Niste odabrali datum", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tableStavke.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(this, "Morate dodati stavke potvrde", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Prodavnica prodavnica = (Prodavnica) cmbProdavnica.getSelectedItem();
        if (prodavnica == null) {
            JOptionPane.showMessageDialog(this, "Niste odabrali prodavnicu", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        kreirajPotvrdu(prodavnica);
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        FormaDodajStavka fs = new FormaDodajStavka(this, true, idStavke);
        fs.setVisible(true);
        stavka = fs.vratiStavku();
        if (stavka == null) {
            JOptionPane.showMessageDialog(this, "Niste Uneli Kolicinu Stavke", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dodajStavkuUTabelu(stavka);
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        Date datum = datePicker.getDate();
        Prodavnica prodavnica = (Prodavnica) cmbProdavnica.getSelectedItem();
        pretraziPotvrde(prodavnica, datum);
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.SVE_POTVRDE);
        kz.setParametar(null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        potvrdeZaTabelu = (List<Potvrda>) so.getParametar();
        int brojReda = tableStavke.getSelectedRow();
        if (brojReda != -1) {
            int idPotvrda = (int) tableStavke.getValueAt(brojReda, 0);
            Potvrda potvrda = potvrdeZaTabelu.get(idPotvrda - 1);
            java.util.Date datum = new java.util.Date(potvrda.getDatum().getTime());
            LocalDate datumZaProveru = datum.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (datumZaProveru.isAfter(LocalDate.now())) {
                promeniPotvrdu(potvrda);
            } else {
                JOptionPane.showMessageDialog(this, "Mozete menjati samo potvrde iz buducnosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Odaberite red u tabeli", "GRESKA", JOptionPane.ERROR_MESSAGE);
        }
        popuniTabeluPotvrda();
    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnPrikaziDetaljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziDetaljeActionPerformed
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.SVE_POTVRDE);
        kz.setParametar(null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        potvrdeZaTabelu = (List<Potvrda>) so.getParametar();
        int red = tableStavke.getSelectedRow();

        if (red < 0) {
            JOptionPane.showMessageDialog(this, "Odaberite potvrdu za koju zelite detalje", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idPotvrda = (int) tableStavke.getValueAt(red, 0) - 1;
        Potvrda p = potvrdeZaTabelu.get(idPotvrda);
        FormaPotvrdaDetalji fpd = new FormaPotvrdaDetalji(this, true, p);
        fpd.setVisible(true);
    }//GEN-LAST:event_btnPrikaziDetaljeActionPerformed

    private void btnSvePotvrdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSvePotvrdeActionPerformed
        popuniTabeluPotvrda();
    }//GEN-LAST:event_btnSvePotvrdeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPrikaziDetalje;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JButton btnSvePotvrde;
    private javax.swing.JComboBox<Prodavnica> cmbProdavnica;
    private com.toedter.calendar.JDateChooser datePicker;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblPotvrda;
    private javax.swing.JLabel lblProdavnica;
    private javax.swing.JLabel lblTabela;
    private javax.swing.JPanel panelTabela;
    private javax.swing.JTable tableStavke;
    // End of variables declaration//GEN-END:variables

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

        List<Prodavnica> lista = (List<Prodavnica>) so.getParametar();
        for (Prodavnica p : lista) {
            cmbProdavnica.addItem(p);
        }
    }

    private void kreirajPotvrdu(Prodavnica pro) {
        List<StavkaPotvrde> listaStavki = new LinkedList<>();
        for (int i = 0; i < tableStavke.getRowCount(); i++) {
            int idStavke = (int) tableStavke.getValueAt(i, 0);
            double kolicina = (double) tableStavke.getValueAt(i, 1);
            Parket Parket = (Parket) tableStavke.getValueAt(i, 2);
            int idParket = Parket.getPrimarniKljuc();
            StavkaPotvrde s = new StavkaPotvrde(-1, idStavke, kolicina, idParket);
            listaStavki.add(s);
        }

        Date datumZaPotvrdu = datePicker.getDate();
        Potvrda potvrda = new Potvrda(-1, datumZaPotvrdu, -1, posiljalac.getPrimarniKljuc(), pro.getPrimarniKljuc(), listaStavki);

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.KREIRAJ_POTVRDU);
        kz.setParametar(potvrda);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Uspesno kreirana potvrda", "USPEH", JOptionPane.INFORMATION_MESSAGE);
        stavkeZaTabelu.clear();
        dispose();
    }

    private void postaviModelTabeleStavka() {
        TableModelStavkaKreiraj model = new TableModelStavkaKreiraj(stavkeZaTabelu);
        tableStavke.setModel(model);
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
        idStavke++;
        stavkeZaTabelu.add(stavka);
        TableModelStavkaKreiraj model = new TableModelStavkaKreiraj(stavkeZaTabelu);
        tableStavke.setModel(model);
    }

    private void pretraziPotvrde(Prodavnica prodavnica, Date datum) {
        popuniTabeluPotvrda();
        Object[] niz = {prodavnica, datum};

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(niz);
        kz.setOperacija(OperacijeENUM.PRETRAZI_POTVRDE);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        potvrdeZaTabelu = (List<Potvrda>) so.getParametar();
        TableModelPotvrda model = new TableModelPotvrda(potvrdeZaTabelu);
        tableStavke.setModel(model);
    }

    private void popuniTabeluPotvrda() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.SVE_POTVRDE);
        kz.setParametar(null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        potvrdeZaTabelu = (List<Potvrda>) so.getParametar();
        TableModelPotvrda model = new TableModelPotvrda(potvrdeZaTabelu);
        tableStavke.setModel(model);
    }

    private void promeniPotvrdu(Potvrda potvrda) {
        FormaPromeniPotvrdu forma = new FormaPromeniPotvrdu(this, true, potvrda);
        forma.setVisible(true);
    }

}
