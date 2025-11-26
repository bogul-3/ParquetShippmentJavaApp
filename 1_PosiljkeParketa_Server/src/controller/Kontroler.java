package controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import domen.Mesto;
import opstiDomen.OpstiDomenskiObjekat;
import domen.Parket;
import domen.Posiljalac;
import domen.Potvrda;
import domen.Prodavnica;
import domen.Skladiste;
import domen.StavkaPotvrde;
import java.util.Date;
import java.util.LinkedList;
import SOPosiljalac.NadjiSvePosiljaoce;
import SOMesto.NadjiMesto;
import SOMesto.NadjiSvaMesta;
import SOParket.NadjiParket;
import SOParket.NadjiSveParkete;
import SOParket.PretraziParkete;
import SOParket.PromeniParket;
import SOPosiljalac.NadjiPosiljaocaID;
import SOPosiljalac.PrijavaPosiljaoca;
import SOPotvrda.KreirajPotvrdu;
import SOPotvrda.NadjiPotvrdu;
import SOPotvrda.NadjiSvePotvrde;
import SOPotvrda.PretraziPotvrde;
import SOPotvrda.PromeniPotvrdu;
import SOProdavnica.KreirajProdavnicu;
import SOProdavnica.NadjiProdavnicu;
import SOProdavnica.NadjiSveProdavnice;
import SOProdavnica.ObrisiProdavnice;
import SOProdavnica.PretraziProdavnice;
import SOProdavnica.PromeniProdavnicu;
import SOSkladiste.UbaciSkladiste;
import SOSkladiste.NadjiSvaSkladista;

public class Kontroler {

    private static Kontroler instance;

    public Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Posiljalac proveriKredencijale(String korIme, String lozinka) throws Exception {
        if (!proveriValidnostMaila(korIme)) {
            throw new Exception("Niste uneli validan email");
        }
        if (korIme.length() > 50 || lozinka.length() > 20) {
            throw new Exception("Email moze imati maksimalno 50 karaktera, a lozinka 20");
        }

        Posiljalac p = vratiPosiljaoca(korIme, lozinka);
        if (p != null) {
            return p;
        }

        throw new Exception("Korisnik ne postoji");
    }

    private boolean proveriValidnostMaila(String korIme) {
        final String emailRegex = "^(?=.{1,40}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern patern = Pattern.compile(emailRegex);
        Matcher matcher = patern.matcher(korIme);
        return matcher.matches();
    }

    public Posiljalac vratiPosiljaoca(String korIme, String lozinka) throws Exception {
        PrijavaPosiljaoca operacija = new PrijavaPosiljaoca(new Posiljalac(), korIme, lozinka);

        if (operacija.getSignal() == false) {
            throw new Exception("Posiljaoc sa ovim korisnickim imenom i sifrom ne postoji");
        }
        List<OpstiDomenskiObjekat> listaPosiljalaca = operacija.getListaObjekata();
        for (OpstiDomenskiObjekat p : listaPosiljalaca) {
            String email = (String) p.getNizAtributa()[3];
            String sifra = (String) p.getNizAtributa()[4];
            if (email.equals(korIme) && sifra.equals(lozinka)) {
                return (Posiljalac) p;
            }
        }
        throw new Exception("Greska u pronalazenju posiljaoca");
    }

    public List<Prodavnica> vratiSveProdavnice() throws Exception {
        NadjiSveProdavnice operacija = new NadjiSveProdavnice(new Prodavnica());

        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju svih prodavnica");
        }

        List<Prodavnica> prodavnice = new LinkedList<>();
        List<OpstiDomenskiObjekat> listaObjekata = operacija.getListaObjekata();

        for (int i = 0; i < listaObjekata.size(); i++) {
            OpstiDomenskiObjekat odo = listaObjekata.get(i);
            prodavnice.add((Prodavnica) odo);
        }

        if (prodavnice == null) {
            throw new Exception("Greska u pronalazenju svih prodavnica");
        }
        return prodavnice;
    }

    public void kreirajPotvrdu(Potvrda p) throws Exception {
        List<StavkaPotvrde> listaStavki = p.getListaStavki();
        Prodavnica pro = pretraziProdavnicu(p.getProdavnica());
        Posiljalac pos = pretraziPosiljaoca(p.getPosiljalac());
        Date datum = p.getDatum();

        double sumaKolicina = 0;
        for (StavkaPotvrde s : listaStavki) {
            sumaKolicina += s.getKolicina();
        }
        double prosecnaKolicina = sumaKolicina / listaStavki.size();

        p = new Potvrda(-1, datum, prosecnaKolicina, pos.getPrimarniKljuc(), pro.getPrimarniKljuc(), listaStavki);

        KreirajPotvrdu operacija = new KreirajPotvrdu(p);
        if (operacija.getSignal() == false) {
            throw new Exception("Greska pri kreiranju potvrde");
        }
    }

    public List<Parket> vratiSveParkete() throws Exception {
        NadjiSveParkete operacija = new NadjiSveParkete(new Parket());

        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju svih parketa");
        }

        List<Parket> parketi = new LinkedList<>();
        for (OpstiDomenskiObjekat odo : operacija.getListaObjekata()) {
            parketi.add((Parket) odo);
        }
        return parketi;
    }

    public List<Potvrda> pretraziPotvrde(Prodavnica prodavnica, Date datum) throws Exception {
        Potvrda p = new Potvrda();
        String whereKlauzula = "idProdavnica = " + prodavnica.getPrimarniKljuc() + " AND datum LIKE '" + p.getSQLDatum(datum) + "'";

        PretraziPotvrde operacija = new PretraziPotvrde(whereKlauzula, p);

        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pretrazi potvrde");
        }
        List<Potvrda> potvrde = new LinkedList<>();
        for (OpstiDomenskiObjekat odo : operacija.getListaObjekata()) {
            potvrde.add((Potvrda) odo);
        }
        return potvrde;
    }

    public List<Potvrda> vratiSvePotvrde() throws Exception {
        NadjiSvePotvrde operacija = new NadjiSvePotvrde(new Potvrda());
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju svih potvrda");
        }

        List<Potvrda> potvrde = new LinkedList<>();
        for (OpstiDomenskiObjekat odo : operacija.getListaObjekata()) {
            potvrde.add((Potvrda) odo);

        }
        return potvrde;
    }

    public List<Posiljalac> vratiSvePosiljaoce() throws Exception {
        NadjiSvePosiljaoce operacija = new NadjiSvePosiljaoce(new Posiljalac());

        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju svih posiljaoca");
        }

        List<Posiljalac> posiljaoci = new LinkedList<>();
        for (OpstiDomenskiObjekat odo : operacija.getListaObjekata()) {
            posiljaoci.add((Posiljalac) odo);
        }
        return posiljaoci;
    }

    public void promeniPotvrdu(Potvrda p) throws Exception {
        PromeniPotvrdu operacija = new PromeniPotvrdu(p);
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u promeni potvrde");
        }
    }

    public List<Mesto> vratiSvaMesta() throws Exception {
        NadjiSvaMesta operacija = new NadjiSvaMesta(new Mesto());

        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju svih mesta");
        }

        List<Mesto> mesta = new LinkedList<>();
        for (OpstiDomenskiObjekat odo : operacija.getListaObjekata()) {
            mesta.add((Mesto) odo);
        }
        return mesta;
    }

    public void kreirajProdavnicu(String naziv, String adresa, Mesto mesto) throws Exception {
        Prodavnica p = new Prodavnica(-1, naziv, adresa, mesto.getPrimarniKljuc());

        KreirajProdavnicu operacija = new KreirajProdavnicu(p);
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u kreiranju prodavnice");
        }
    }

    public List<Prodavnica> pretraziProdavnice(Mesto mesto, String naziv, String adresa) throws Exception {
        Prodavnica p = new Prodavnica();
        String whereKlauzula = "LOWER(naziv) LIKE LOWER('%" + naziv + "%') AND LOWER(adresa) LIKE LOWER('%" + adresa + "%') AND idMesto = "
                + mesto.getPrimarniKljuc();

        PretraziProdavnice operacija = new PretraziProdavnice(whereKlauzula, p);

        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pretrazi prodavnice");
        }
        List<Prodavnica> prodavnice = new LinkedList<>();
        for (OpstiDomenskiObjekat odo : operacija.getListaObjekata()) {
            prodavnice.add((Prodavnica) odo);
        }
        return prodavnice;
    }

    public void promeniProdavnicu(Prodavnica prod) throws Exception {
        PromeniProdavnicu operacija = new PromeniProdavnicu(prod);
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u promeni prodavnice");
        }
    }

    public void obrisiProdavnicu(List<Prodavnica> prodavnice) throws Exception {
        ObrisiProdavnice operacija = new ObrisiProdavnice(prodavnice);
        if (operacija.getSignal() == false) {
            throw new Exception("Greska prilikom brisanja prodavnica");
        }
    }

    public void ubaciSkladiste(String naziv, String adresa) throws Exception {
        Skladiste s = new Skladiste(-1, naziv, adresa);
        UbaciSkladiste operacija = new UbaciSkladiste(s);
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u kreiranju skladista");
        }
    }

    public List<StavkaPotvrde> vratiStavkePotvrde(Potvrda potvrda) throws Exception {
        NadjiPotvrdu operacija = new NadjiPotvrdu(potvrda.getPrimarniKljuc(), potvrda);

        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pretrazi stavke potvrde");
        }
        
        return operacija.getOdo().getListaStavki();
    }

    public Potvrda vratiPotvrdu(int idPotvrda) throws Exception {
        NadjiPotvrdu operacija = new NadjiPotvrdu(idPotvrda, new Potvrda());
        if (operacija.getSignal() == false) {
            throw new Exception("Nije pronadjena potvrda");
        }
        return (Potvrda) operacija.getOdo();
    }

    public List<Parket> pretraziParkete(String drvo, String dimenzije) throws Exception {
        Parket p = new Parket();
        String whereKlauzula = "dimenzije LIKE '" + dimenzije + "' AND drvo LIKE '" + drvo + "'";

        PretraziParkete operacija = new PretraziParkete(whereKlauzula, p);

        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pretrazi parketa");
        }
        List<Parket> parketi = new LinkedList<>();
        for (OpstiDomenskiObjekat odo : operacija.getListaObjekata()) {
            parketi.add((Parket) odo);
        }
        return parketi;
    }

    public void promeniParket(Parket p) throws Exception {
        PromeniParket operacija = new PromeniParket(p);
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u promeni parketa");
        }
    }

    public Posiljalac pretraziPosiljaoca(int id) throws Exception {
        NadjiPosiljaocaID operacija = new NadjiPosiljaocaID(id, new Posiljalac());
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju posiljaoca");
        }
        return (Posiljalac) operacija.getOdo();
    }

    public Prodavnica pretraziProdavnicu(int id) throws Exception {
        NadjiProdavnicu operacija = new NadjiProdavnicu(id, new Prodavnica());
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju prodavnicu");
        }
        return (Prodavnica) operacija.getOdo();
    }

    public Mesto pretraziMesto(int id) throws Exception {
        NadjiMesto operacija = new NadjiMesto(id, new Mesto());
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju mesta");
        }
        return (Mesto) operacija.getOdo();
    }

    public Parket pretraziParket(int idParket) throws Exception {
        NadjiParket operacija = new NadjiParket(idParket, new Parket());
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju parket");
        }
        return (Parket) operacija.getOdo();
    }

    public List<Skladiste> vratiSvaSkladista() throws Exception {
        NadjiSvaSkladista operacija = new NadjiSvaSkladista(new Skladiste());
        if (operacija.getSignal() == false) {
            throw new Exception("Greska u pronalazenju svih skladista");
        }

        List<Skladiste> skladista = new LinkedList<>();
        for (OpstiDomenskiObjekat odo : operacija.getListaObjekata()) {
            skladista.add((Skladiste) odo);
        }

        return skladista;
    }
}
