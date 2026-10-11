# Pošiljke Parketa - Java Application

Ovo je Java desktop aplikacija zasnovana na **Klijent-Server** arhitekturi, namenjena praćenju i upravljanju pošiljkama parketa. Projekat prikazuje simulaciju distribuiranog sistema gde višestruki klijenti komuniciraju sa centralnim serverom radi obrade i skladištenja podataka u bazu.

---

## 🛠 Tehnologije i Biblioteke

* **Jezik:** Java (JDK 8+)
* **Baza podataka:** MySQL / MariaDB
* **Komunikacija:** Sockets / Networking (Klijent-Server komunikacija)
* **Korisnički interfejs:** Java Swing / AWT
* **Dodatne biblioteke:**
  * `mysql-connector-j` – JDBC drajver za konekciju sa MySQL bazom.
  * `jcalendar` – Swing komponente za odabir datuma.
  * `json` – Biblioteka za rad sa JSON formatom podataka.

---

## 📁 Struktura Projekta

Projekat je podeljen na tri glavne komponente (modula) i prateće resurse:

```
├── 1_PosiljkeParketa_Client/    # Klijentska aplikacija (GUI i logika klijenta)
├── 1_PosiljkeParketa_Server/    # Serverska aplikacija (Obrada zahteva i rad sa bazom)
├── PosiljkeParketa_Common/     # Zajednički modeli, klase i transfer objekti (DTO)
├── mysql-connector-j-9.1.0/    # MySQL JDBC drajver
├── jcalendar-1.4.jar           # Biblioteka za odabir datuma u GUI-ju
├── json-20200518.jar           # JSON parser
└── posiljkeBaza.sql            # SQL skripta za kreiranje strukture baze i početnih podataka
```

---

## ⚙️ Podešavanje i Pokretanje

### 1. Priprema baze podataka
1. Pokrenite vaš lokalni MySQL server (npr. preko XAMPP-a, WAMP-a ili samostalnog MySQL servisa).
2. Uvezite (importujte) fajl `posiljkeBaza.sql` u vaš MySQL DBMS kako biste kreirali potrebnu bazu i tabele:
   ```bash
   mysql -u root -p < posiljkeBaza.sql
   ```

### 2. Konfiguracija konekcije
Uverite se da su u serverskom delu aplikacije (`1_PosiljkeParketa_Server`) podešeni odgovarajući podaci za konekciju na vašu lokalnu bazu (URL, username, password).

### 3. Redosled pokretanja
1. **Pokrenite Server:** Najpre pokrenite serversku aplikaciju (`1_PosiljkeParketa_Server`). Server će se pokrenuti i slušati dolazne konekcije klijenata na definisanom portu.
2. **Pokrenite Klijenta:** Nakon što je server aktivan, pokrenite klijentsku aplikaciju (`1_PosiljkeParketa_Client`) kako biste pristupili korisničkom interfejsu.

---

## 📝 Funkcionalnosti

* Logovanje i autentifikacija korisnika.
* Unos, izmena i pregled pošiljki parketa.
* Višenitna obrada klijentskih zahteva na serveru.
* Interaktivni grafički interfejs sa opcijama izbora datuma i pretrage.

---

## 🔒 Napomena o bezbednosti

Ovaj projekat je razvijen u edukativne/demonstracione svrhe sa **mock (testnim) podacima** na lokalnom okruženju (`localhost`).
