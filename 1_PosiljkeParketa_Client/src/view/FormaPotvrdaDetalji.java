package view;

import domen.Parket;
import domen.Posiljalac;
import domen.Potvrda;
import domen.Prodavnica;
import domen.StavkaPotvrde;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.KlijentKomunikacija;
import modelTable.TableModelStavka;
import operacije.OperacijeENUM;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class FormaPotvrdaDetalji extends javax.swing.JDialog {

    Potvrda potvrda;

    public FormaPotvrdaDetalji(FormaPotvrda parent, boolean modal, Potvrda potvrda) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.potvrda = potvrda;

        txtDatum.setText(potvrda.getDatum().toString());
        txtProsecnaKolicina.setText(String.valueOf(potvrda.getProsecnaKolicina()));

        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_POSILJAOCA_ID, potvrda.getPosiljalac());
        System.out.println("Posiljalac: " + potvrda.getPosiljalac());
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Posiljalac posiljalac = (Posiljalac) so.getParametar();
        txtPosiljalac.setText(posiljalac.toString());

        kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_PRODAVNICU_ID, potvrda.getProdavnica());
        KlijentKomunikacija.getInstance().posaljiZahtev(kz);
        so = KlijentKomunikacija.getInstance().primiOdgovor();
        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Prodavnica prodavnica = (Prodavnica) so.getParametar();
        txtProdavnica.setText(prodavnica.toString());

        postaviModelTabeleStavka();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaslov = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        lblProsecnaKolicina = new javax.swing.JLabel();
        txtProsecnaKolicina = new javax.swing.JTextField();
        lblPosiljalac = new javax.swing.JLabel();
        txtPosiljalac = new javax.swing.JTextField();
        lblProdavnica = new javax.swing.JLabel();
        txtProdavnica = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStavke = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaslov.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNaslov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNaslov.setText("POTVRDA");
        lblNaslov.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lblDatum.setText("Datum:");

        txtDatum.setEditable(false);

        lblProsecnaKolicina.setText("Prosecna Kolicina:");

        txtProsecnaKolicina.setEditable(false);

        lblPosiljalac.setText("Posiljalac:");

        txtPosiljalac.setEditable(false);

        lblProdavnica.setText("Prodavnica:");

        txtProdavnica.setEditable(false);

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
        jScrollPane1.setViewportView(tableStavke);

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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPosiljalac)
                                .addComponent(lblProsecnaKolicina)
                                .addComponent(lblProdavnica))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(lblDatum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProdavnica, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtPosiljalac)
                                    .addComponent(txtProsecnaKolicina)
                                    .addComponent(txtDatum))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(lblDatum)
                            .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProsecnaKolicina)
                            .addComponent(txtProsecnaKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPosiljalac)
                            .addComponent(txtPosiljalac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProdavnica)
                            .addComponent(txtProdavnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblNaslov;
    private javax.swing.JLabel lblPosiljalac;
    private javax.swing.JLabel lblProdavnica;
    private javax.swing.JLabel lblProsecnaKolicina;
    private javax.swing.JTable tableStavke;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtPosiljalac;
    private javax.swing.JTextField txtProdavnica;
    private javax.swing.JTextField txtProsecnaKolicina;
    // End of variables declaration//GEN-END:variables

    private void postaviModelTabeleStavka() {
        KlijentskiZahtev kz = new KlijentskiZahtev(OperacijeENUM.PRETRAZI_POTVRDU_ID, potvrda.getPrimarniKljuc());

        KlijentKomunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KlijentKomunikacija.getInstance().primiOdgovor();

        if (so.getException() != null) {
            JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        potvrda = (Potvrda) so.getParametar();
        List<StavkaPotvrde> stavkeZaTabelu = potvrda.getListaStavki();
        List<Parket> listaParketa = new LinkedList<Parket>();

        for (StavkaPotvrde s : stavkeZaTabelu) {
            kz.setParametar(s.getParket());
            kz.setOperacija(OperacijeENUM.PRETRAZI_PARKET_ID);

            KlijentKomunikacija.getInstance().posaljiZahtev(kz);
            if (so.getException() != null) {
                JOptionPane.showMessageDialog(this, so.getException().getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
                listaParketa = null;
                return;
            }

            so = KlijentKomunikacija.getInstance().primiOdgovor();
            Parket p = (Parket) so.getParametar();
            listaParketa.add(p);
        }

        TableModelStavka model = new TableModelStavka(stavkeZaTabelu, listaParketa);
        tableStavke.setModel(model);
    }
}
