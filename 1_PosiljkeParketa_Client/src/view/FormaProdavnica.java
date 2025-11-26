package view;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import domen.Mesto;
import domen.Prodavnica;
import komunikacija.KlijentKomunikacija;
import modelTable.TableModelProdavnica;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaProdavnica extends javax.swing.JDialog {

    private List<Prodavnica> prodavniceZaTabelu = new LinkedList<Prodavnica>();

    public FormaProdavnica(java.awt.Frame parent, boolean modal, String operacija) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tableProdavnice.getTableHeader().setReorderingAllowed(false);

        if (operacija == "kreiraj") {
            btnKreiraj.setVisible(true);
            btnPretrazi.setVisible(false);
            btnPromeni.setVisible(false);
            btnObrisi.setVisible(false);
            txtNaziv.setVisible(true);
            txtAdresa.setVisible(true);
            cmbMesto.setVisible(true);
            btnPrikaziSveProdavnice.setVisible(false);
            lblNaziv.setVisible(true);
            lblAdresa.setVisible(true);
            lblMesto.setVisible(true);

            popuniCmbMesto();
            popuniTabeluSvimProdavnicama();
            tableProdavnice.setRowSelectionAllowed(false);
            tableProdavnice.setColumnSelectionAllowed(false);
        } else if (operacija == "pretrazi") {
            btnKreiraj.setVisible(false);
            btnPretrazi.setVisible(true);
            btnPromeni.setVisible(false);
            btnObrisi.setVisible(false);
            txtNaziv.setVisible(true);
            txtAdresa.setVisible(true);
            cmbMesto.setVisible(true);
            btnPrikaziSveProdavnice.setVisible(true);
            lblNaziv.setVisible(true);
            lblAdresa.setVisible(true);
            lblMesto.setVisible(true);

            popuniCmbMesto();
            popuniTabeluSvimProdavnicama();
            tableProdavnice.setRowSelectionAllowed(false);
            tableProdavnice.setColumnSelectionAllowed(false);
        } else if (operacija == "promeni") {
            btnKreiraj.setVisible(false);
            btnPretrazi.setVisible(true);
            btnPromeni.setVisible(true);
            btnObrisi.setVisible(false);
            txtNaziv.setVisible(true);
            txtAdresa.setVisible(true);
            cmbMesto.setVisible(true);
            lblNaziv.setVisible(true);
            lblAdresa.setVisible(true);
            lblMesto.setVisible(true);
            tableProdavnice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            btnPrikaziSveProdavnice.setVisible(true);

            popuniCmbMesto();
            popuniTabeluSvimProdavnicama();
        } else if (operacija == "obrisi") {
            btnKreiraj.setVisible(false);
            btnPretrazi.setVisible(true);
            btnPromeni.setVisible(false);
            btnObrisi.setVisible(true);
            txtNaziv.setVisible(true);
            txtAdresa.setVisible(true);
            cmbMesto.setVisible(true);
            btnPrikaziSveProdavnice.setVisible(true);
            lblNaziv.setVisible(true);
            lblAdresa.setVisible(true);
            lblMesto.setVisible(true);

            popuniCmbMesto();
            popuniTabeluSvimProdavnicama();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGlavni = new javax.swing.JLabel();
        btnKreiraj = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblAdresa = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        lblMesto = new javax.swing.JLabel();
        cmbMesto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProdavnice = new javax.swing.JTable();
        btnPrikaziSveProdavnice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblGlavni.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGlavni.setText("Prodavnica");

        btnKreiraj.setText("Kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        lblNaziv.setText("Naziv:");

        lblAdresa.setText("Adresa:");

        lblMesto.setText("Mesto:");

        tableProdavnice.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableProdavnice);

        btnPrikaziSveProdavnice.setText("Prikazi Sve Prodavnice");
        btnPrikaziSveProdavnice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziSveProdavniceActionPerformed(evt);
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
                        .addComponent(lblGlavni)
                        .addGap(18, 18, 18)
                        .addComponent(btnKreiraj)
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblNaziv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNaziv))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblMesto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblAdresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPrikaziSveProdavnice))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGlavni)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPretrazi)
                    .addComponent(btnPromeni)
                    .addComponent(btnObrisi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNaziv)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdresa)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMesto)
                            .addComponent(cmbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnPrikaziSveProdavnice))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        kreirajProdavnicu(txtNaziv.getText(), txtAdresa.getText(), (Mesto) cmbMesto.getSelectedItem());
        popuniTabeluSvimProdavnicama();
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        pretraziProdavnice((Mesto) cmbMesto.getSelectedItem(), txtNaziv.getText(), txtAdresa.getText());
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.SVE_PRODAVNICE);
        kz.setParametar(null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        prodavniceZaTabelu = (List<Prodavnica>) so.getParametar();
        int brojReda = tableProdavnice.getSelectedRow();
        if (brojReda != -1) {
            int idProdavnica = (int) tableProdavnice.getValueAt(brojReda, 0) - 1;
            Prodavnica prodavnica = prodavniceZaTabelu.get(idProdavnica);
            promeniProdavnicu(prodavnica);
        } else {
            JOptionPane.showMessageDialog(this, "Odaberite red u tabeli", "GRESKA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.SVE_PRODAVNICE);
        kz.setParametar(null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        prodavniceZaTabelu = (List<Prodavnica>) so.getParametar();
        int[] brojeviReda = tableProdavnice.getSelectedRows();
        List<Prodavnica> prodavnice = new LinkedList<>();
        if (brojeviReda[0] != -1) {
            for (int i = 0; i < brojeviReda.length; i++) {
                int idProdavnica = (int) tableProdavnice.getValueAt(brojeviReda[i], 0) - 1;
                Prodavnica prodavnica = prodavniceZaTabelu.get(idProdavnica);
                prodavnice.add(prodavnica);
            }
            int odgovor = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da obrisete prodavnice?", "Potvrda", JOptionPane.YES_NO_OPTION);
            if (odgovor == JOptionPane.YES_OPTION) {
                obrisiProdavnicu(prodavnice);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Odaberite red u tabeli", "GRESKA", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPrikaziSveProdavniceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziSveProdavniceActionPerformed
        popuniTabeluSvimProdavnicama();
    }//GEN-LAST:event_btnPrikaziSveProdavniceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPrikaziSveProdavnice;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<Mesto> cmbMesto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdresa;
    private javax.swing.JLabel lblGlavni;
    private javax.swing.JLabel lblMesto;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JTable tableProdavnice;
    private javax.swing.JTextField txtAdresa;
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

    private void popuniTabeluSvimProdavnicama() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(OperacijeENUM.SVE_PRODAVNICE);
        kz.setParametar(null);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        prodavniceZaTabelu = (List<Prodavnica>) so.getParametar();

        TableModelProdavnica model = new TableModelProdavnica(prodavniceZaTabelu);
        tableProdavnice.setModel(model);
    }

    private void kreirajProdavnicu(String naziv, String adresa, Mesto mesto) {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.SVE_PRODAVNICE, null);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Prodavnica> listaProdavnica = (List<Prodavnica>) so.getParametar();
        for (Prodavnica p : listaProdavnica) {
            if (p.getNaziv().equals(naziv)) {
                JOptionPane.showMessageDialog(this, "Prodavnica sa tim nazivom vec postoji", "GRESKA", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (p.getAdresa().equals(adresa) && p.getMesto() == mesto.getPrimarniKljuc()) {
                JOptionPane.showMessageDialog(this, "Prodavnica na toj lokaciji vec postoji", "GRESKA", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Object[] niz = {naziv, adresa, mesto};
        kz = new KlijentskiZahtev(OperacijeENUM.KREIRAJ_PRODAVNICU, niz);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void pretraziProdavnice(Mesto mesto, String naziv, String adresa) {
        Object[] niz = {naziv, adresa, mesto};
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_PRODAVNICE, niz);

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        prodavniceZaTabelu = (List<Prodavnica>) so.getParametar();
        TableModelProdavnica model = new TableModelProdavnica(prodavniceZaTabelu);
        tableProdavnice.setModel(model);
    }

    private void promeniProdavnicu(Prodavnica prodavnica) {
        FormaPromeniProdavnicu forma = new FormaPromeniProdavnicu(this, true, prodavnica);
        forma.setVisible(true);
        popuniTabeluSvimProdavnicama();
    }

    private void obrisiProdavnicu(List<Prodavnica> prodavnice) {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.OBRISI_PRODAVNICE, prodavnice);
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        popuniTabeluSvimProdavnicama();
    }
}
