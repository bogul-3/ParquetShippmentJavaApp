package komunikacija;

import controller.Kontroler;
import domen.Mesto;
import domen.Parket;
import domen.Posiljalac;
import domen.Potvrda;
import domen.Prodavnica;
import domen.Skladiste;
import domen.StavkaPotvrde;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class KomunikacijaServer extends Thread {

    private Socket soket;

    public KomunikacijaServer(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {
        while (soket != null && !soket.isClosed()) {
            try {
                KlijentskiZahtev kz = primiZahtev();
                ServerskiOdgovor so = new ServerskiOdgovor();
                if (kz != null) {
                    switch (kz.getOperacija()) {
                        case PRIJAVA_POSILJAOCA:
                            String[] kredencijali = (String[]) kz.getParametar();
                            Posiljalac posiljalac;
                             {
                                try {
                                    posiljalac = Kontroler.getInstance().proveriKredencijale(kredencijali[0], kredencijali[1]);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(posiljalac);
                                so.setException(null);
                            }
                            break;
                        case SVI_PARKETI: {
                            List<Parket> listaParketa = null;
                            try {
                                listaParketa = Kontroler.getInstance().vratiSveParkete();
                            } catch (Exception ex) {
                                so.setParametar(null);
                                so.setException(ex);
                                break;
                            }
                            so.setParametar(listaParketa);
                            so.setException(null);
                            break;
                        }
                        case KREIRAJ_POTVRDU: {
                            Potvrda p = (Potvrda) kz.getParametar();
                            try {
                                Kontroler.getInstance().kreirajPotvrdu(p);
                            } catch (Exception ex) {
                                so.setParametar(null);
                                so.setException(ex);
                                break;
                            }
                            so.setParametar(p);
                            so.setException(null);
                            break;
                        }
                        case SVE_PRODAVNICE:
                            List<Prodavnica> listaProdavnica = null;
                             {
                                try {
                                    listaProdavnica = Kontroler.getInstance().vratiSveProdavnice();
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(listaProdavnica);
                                so.setException(null);
                                break;
                            }
                        case SVE_POTVRDE:
                            List<Potvrda> listaPotvrda = null;
                             {
                                try {
                                    listaPotvrda = Kontroler.getInstance().vratiSvePotvrde();
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(listaPotvrda);
                                so.setException(null);
                                break;
                            }
                        case PRETRAZI_POTVRDE:
                            List<Potvrda> listaPretrazenihPotvrda = null;
                            Object[] nizZaPretragu = (Object[]) kz.getParametar();
                            Prodavnica prodavnica = (Prodavnica) nizZaPretragu[0];
                            Date datum = (Date) nizZaPretragu[1];
                             {
                                try {
                                    listaPretrazenihPotvrda = Kontroler.getInstance().pretraziPotvrde(prodavnica, datum);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(listaPretrazenihPotvrda);
                                so.setException(null);
                                break;
                            }
                        case SVI_POSILJAOCI:
                            List<Posiljalac> listaPosiljaoca = null;
                             {
                                try {
                                    listaPosiljaoca = Kontroler.getInstance().vratiSvePosiljaoce();
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(listaPosiljaoca);
                                so.setException(null);
                                break;
                            }
                        case PRETRAZI_POTVRDU_ID:
                            Potvrda potvrdaPronadjena = null;
                             {
                                try {
                                    potvrdaPronadjena = Kontroler.getInstance().vratiPotvrdu((int) kz.getParametar());
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(potvrdaPronadjena);
                                so.setException(null);
                                break;
                            }
                        case PROMENI_POTVRDU:
                            Potvrda potvrdaZaPromenu = (Potvrda) kz.getParametar();
                             {
                                try {
                                    Kontroler.getInstance().promeniPotvrdu(potvrdaZaPromenu);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(null);
                                so.setException(null);
                                break;
                            }
                        case PRETRAZI_PARKETE:
                            String[] nizZaParkete = (String[]) kz.getParametar();
                            String drvo = nizZaParkete[0];
                            String dimenzije = nizZaParkete[1];
                            List<Parket> listaParketa = null;
                             {
                                try {
                                    listaParketa = Kontroler.getInstance().pretraziParkete(drvo, dimenzije);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(listaParketa);
                                so.setException(null);
                                break;
                            }
                        case UBACI_SKLADISTE:
                            String[] nizZaSkladista = (String[]) kz.getParametar();
                            String nazivSkladista = nizZaSkladista[0];
                            String adresaSkladista = nizZaSkladista[1];

                             {
                                try {
                                    Kontroler.getInstance().ubaciSkladiste(nazivSkladista, adresaSkladista);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(null);
                                so.setException(null);
                                break;
                            }
                        case SVA_MESTA:
                            List<Mesto> listaMesta = null;
                             {
                                try {
                                    listaMesta = Kontroler.getInstance().vratiSvaMesta();
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(listaMesta);
                                so.setException(null);
                                break;
                            }
                        case KREIRAJ_PRODAVNICU:
                            Object[] nizZaKreiranjeProdavnice = (Object[]) kz.getParametar();
                            String nazivProdavnice = (String) nizZaKreiranjeProdavnice[0];
                            String adresaProdavnice = (String) nizZaKreiranjeProdavnice[1];
                            Mesto mestoProdavnice = (Mesto) nizZaKreiranjeProdavnice[2];

                             {
                                try {
                                    Kontroler.getInstance().kreirajProdavnicu(nazivProdavnice, adresaProdavnice, mestoProdavnice);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(null);
                                so.setException(null);
                                break;
                            }
                        case PRETRAZI_PRODAVNICE:
                            Object[] nizZaPretragaProdavnice = (Object[]) kz.getParametar();
                            String nazivProdavnicePretraga = (String) nizZaPretragaProdavnice[0];
                            String adresaProdavnicePretraga = (String) nizZaPretragaProdavnice[1];
                            Mesto mestoProdavnicePretraga = (Mesto) nizZaPretragaProdavnice[2];
                            List<Prodavnica> listaProdavnicaPretraga = null;

                             {
                                try {
                                    listaProdavnicaPretraga = Kontroler.getInstance().
                                            pretraziProdavnice(mestoProdavnicePretraga, nazivProdavnicePretraga, adresaProdavnicePretraga);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(listaProdavnicaPretraga);
                                so.setException(null);
                                break;
                            }
                        case OBRISI_PRODAVNICE:
                            List<Prodavnica> listaProdavnicaObrisi = (List<Prodavnica>) kz.getParametar();
                             {
                                try {
                                    Kontroler.getInstance().obrisiProdavnicu(listaProdavnicaObrisi);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(null);
                                so.setException(null);
                                break;
                            }
                        case PROMENI_PARKET:
                            Parket parketZaPromenu = (Parket) kz.getParametar();
                             {
                                try {
                                    Kontroler.getInstance().promeniParket(parketZaPromenu);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(null);
                                so.setException(null);
                                break;
                            }
                        case PROMENI_PRODAVNICU:
                            Prodavnica prodavnicaZaPromenu = (Prodavnica) kz.getParametar();
                             {
                                try {
                                    Kontroler.getInstance().promeniProdavnicu(prodavnicaZaPromenu);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(null);
                                so.setException(null);
                                break;
                            }
                        case PRETRAZI_POSILJAOCA_ID:
                            int idPosiljalacPretraga = (int) kz.getParametar();
                            Posiljalac posiljalacPretrazenID = null;
                             {
                                try {
                                    posiljalacPretrazenID = Kontroler.getInstance().pretraziPosiljaoca(idPosiljalacPretraga);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(posiljalacPretrazenID);
                                so.setException(null);
                                break;
                            }
                        case PRETRAZI_PRODAVNICU_ID:
                            int idProdavnicaPretraga = (int) kz.getParametar();
                            Prodavnica prodavnicaPretrazenID = null;
                             {
                                try {
                                    prodavnicaPretrazenID = Kontroler.getInstance().pretraziProdavnicu(idProdavnicaPretraga);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(prodavnicaPretrazenID);
                                so.setException(null);
                                break;
                            }
                        case PRETRAZI_MESTO_ID:
                            int idMesto = (int) kz.getParametar();
                            Mesto mestoPretrazenID = null;
                             {
                                try {
                                    mestoPretrazenID = Kontroler.getInstance().pretraziMesto(idMesto);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(mestoPretrazenID);
                                so.setException(null);
                                break;
                            }
                        case PRETRAZI_PARKET_ID:
                            int idParket = (int) kz.getParametar();
                            Parket parketPretrazenID = null;
                             {
                                try {
                                    parketPretrazenID = Kontroler.getInstance().pretraziParket(idParket);
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(parketPretrazenID);
                                so.setException(null);
                                break;
                            }
                        case SVA_SKLADISTA:
                            List<Skladiste> listaSkladista = null;
                             {
                                try {
                                    listaSkladista = Kontroler.getInstance().vratiSvaSkladista();
                                } catch (Exception ex) {
                                    so.setParametar(null);
                                    so.setException(ex);
                                    break;
                                }
                                so.setParametar(listaSkladista);
                                so.setException(null);
                                break;
                            }

                        default:
                            System.out.println("DEFAULT -> PARAMETAR: " + kz.getParametar() + "||| OPERACIJA: " + kz.getOperacija());
                    }
                    posaljiOdgovor(so);
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Greska u metodi primiZahtev: " + ex.getMessage());
            }
        }
    }

    private synchronized KlijentskiZahtev primiZahtev() throws ClassNotFoundException {
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (EOFException ex) {
            try {
                soket.close();
            } catch (IOException ex1) {
                Logger.getLogger(KomunikacijaServer.class.getName()).log(Level.SEVERE, null, ex1);
            }
            soket = null;
        } catch (IOException ex) {
            try {
                soket.close();
            } catch (IOException ex1) {
                Logger.getLogger(KomunikacijaServer.class.getName()).log(Level.SEVERE, null, ex1);
            }
            soket = null;
        }
        return null;
    }

    private synchronized void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
