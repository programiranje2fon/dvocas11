#Laboratorijske vežbe – dvočas br. 11


##Zadatak 1
*(radi ga laborant u saradnji sa studentima)*

1. Napisati klasu **TekstualniFajlovi** u paketu **zadatak1** koja ima:

2. Javnu statičku metodu **ucitajIVratiTekst** koja učitava i vraća tekst iz tekstualnog fajla čiji se naziv zadaje kao ulazni parametar metode.
(ručno kreiranje txt fajlova u Eclipse okruženju, i rad sa tekstualnim fajlovima –
BufferedReader, PrintWriter, FileReader, FileWriter, readLine...)

3. Javnu statičku metodu **upisiTekst** koja u fajl čiji je naziv zadat kao ulazni parametar metode upisuje dva Stringa - “Danas je lep dan.” i “Možda će
temperatura biti iznad nule.” i to tako da svaki String bude u posebnom redu. (println
metoda)

4. Napisati klasu **ProveraTekstualnihFajlova** u paketu **zadatak1** koja proverava rad metoda klase **TekstualniFajlovi** i to citanje iz fajla **tekst.txt** a upisivanje u fajl **tekst2.txt**

##Zadatak 2
*(radi ga laborant u saradnji sa studentima)*

1. Napraviti klasu **Osoba** u paketu **zadatak2** koja može da bude serijalizovana i ima
(serijalizacija i interfejs Serializable, immutable objekti):

2. Privatne atribute ime i prezime.

3. Konstruktor koji prihvata parametre ime i prezima kojima inicijalizuje odgovarajuće atribute objekta.

4. Odgovarajuće javne get metode za ove atribute.

5. Redefinisati metodu **toString** tako da vraća vrednosti atributa ime i prezime (koristiti automatski generisanu metodu)

6. Redefinisati metodu **equals** koristeći automatski generisanu metodu

7. Napraviti klasu **BazaOsoba** u paketu **zadatak2** koja ima:

8. Privatni atribut **osobe** koji predstavlja listu objekata klase **Osoba**. Ovu listu je potrebno
odmah inicijalizovati.

9. Javnu metodu **dodajOsobu** koja kao ulazni argument dobija objekat klase **Osoba** i unosi ga u listu.

10. Javnu metodu **sacuvaUFajl** koja upisuje (serijalizuje) sve osobe iz grupe u fajl cije se ima zadaje kao ulazni parametar metode.
(ObjectOutputStream i writeObject, serijalizovani fajlovi se ne mogu ručno pisati ni čitati, serijalizacijom se automatski čuvaju i objekti na koje osnovni objekti pokazuju)

11. Javnu metodu **ucitajIzFajla** koja učitava (deserijalizuje) sve osobe iz fajla čije se ime zadaje kao ulazni parametar metode, i puni listu **osobe** i vraća je kao povratnu vrednost metode. Pre učitavanja je potrebno isprazniti listu **osobe**. (ObjectInputStream i readObject, kraj fajla se može
pronaći samo kada bude bačen EOFException, deserijalizacijom se automatski učitavaju
i objekti na koje osnovni objekti pokazuju)

12. Javnu metodu **vratiOsobe** koja vraća listu osoba koje se trenutno nalaze u bazi.

13. Napraviti klasu **ProveraBazeOsoba** u paketu **zadatak2** koja proverava rad klase **BazaOsoba** i to dodavanje nekoliko osoba u bazu, čuvanje u fajl i čitanje iz fajla. 

