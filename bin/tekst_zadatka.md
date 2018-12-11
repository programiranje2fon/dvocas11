#Laboratorijske vežbe – dvočas br. 11

##Zadatak 1
*(radi ga laborant u saradnji sa studentima)*

Napraviti javnu klasu **TekstualniFajlovi** u paketu **zadatak1** koja ima:

1. Javnu statičku metodu **ucitajIVratiTekst** koja učitava i vraća tekst iz tekstualnog fajla čiji se naziv zadaje kao ulazni parametar metode. Ukoliko dodje do greške prilikom učitavanja baciti odgovarajući izuzetak iz metode.

2. Javnu statičku metodu **upisiTekst** koja u fajl čiji je naziv zadat kao ulazni parametar metode upisuje dva Stringa - “Danas je lep dan.” i “Možda će temperatura biti iznad nule.” i to tako da svaki String bude u posebnom redu.
Ukoliko dodje do greške prilikom učitavanja baciti odgovarajući izuzetak iz metode.

Napraviti javnu klasu **ProveraTekstualnihFajlova** u paketu **zadatak1** koja proverava rad metoda klase **TekstualniFajlovi** i to citanje iz fajla **tekst.txt** a upisivanje u fajl **tekst2.txt**


##Zadatak 2
*(radi ga laborant u saradnji sa studentima)*

Napraviti javnu klasu **Osoba** u paketu **zadatak2** koja može da bude serijalizovana i ima

1. Privatne atribute ime i prezime.

2. Javni konstruktor koji prihvata parametre ime i prezime kojima inicijalizuje odgovarajuće atribute objekta.

3. Odgovarajuće javne get metode za ove atribute.

4. Redefinisati metodu **toString** tako da vraća vrednosti atributa ime i prezime (koristiti automatski generisanu metodu)

5. Redefinisati metodu **equals** koristeći automatski generisanu metodu


Napraviti javnu klasu **BazaOsoba** u paketu **zadatak2** koja ima:

1. Privatni atribut **osobe** koji predstavlja listu objekata klase **Osoba**. Ovu listu je potrebno
odmah inicijalizovati.

2. Javnu metodu **dodajOsobu** koja kao ulazni argument dobija objekat klase **Osoba** i unosi ga u listu.

3. Javnu metodu **sacuvaUFajl** koja upisuje (serijalizuje) sve osobe iz grupe u fajl čije se ime zadaje kao ulazni parametar metode. Ukoliko dodje do greške prilikom učitavanja baciti odgovarajući izuzetak iz metode.

4. Javnu metodu **ucitajIzFajla** koja učitava (deserijalizuje) sve osobe iz fajla čije se ime zadaje kao ulazni parametar metode, i puni listu **osobe** i vraća je kao povratnu vrednost metode. Pre učitavanja je potrebno isprazniti listu **osobe**.
Ukoliko dodje do greške prilikom učitavanja baciti odgovarajući izuzetak iz metode.

5. Javnu metodu **vratiOsobe** koja vraća listu osoba koje se trenutno nalaze u bazi.

Napraviti javnu klasu **ProveraBazeOsoba** u paketu **zadatak2** koja proverava rad klase **BazaOsoba** i to dodavanje nekoliko osoba u bazu, čuvanje u fajl i čitanje iz fajla. 


##Zadatak 3
*(studenti rade sami)*

Postojećoj klasi **BazaOsoba** dodati:

1. Metodu **pronadjiOsobe** koja kao ulazne parametre prima dva stringa **ime** i **prezime**, i serijalizuje u fajl "pretraga.ser"
sve osobe koje imaju zadato ime ili zadato prezime.  

Proveriti rad metode **pronadjiOsobe** pozivom iz klase **ProveraBazeOsoba**.
