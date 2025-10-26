package zadatak2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BazaOsoba {
	private List<Osoba> osobe = new ArrayList<>();
	
	public void dodajOsobu(Osoba osoba) {
		osobe.add(osoba);
	}
	
	public void sacuvajUFajl(String imeFajla) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(imeFajla));

		for(Osoba osoba : osobe) {
			out.writeObject(osoba);
		}
		
		out.flush();
		out.close();		
	}
	
	public List<Osoba> ucitajIzFajla(String imeFajla) throws IOException {
		osobe.clear();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(imeFajla));
		
		try {
			while (true) {
				Osoba osoba = (Osoba) in.readObject();
				osobe.add(osoba);
			}
		} catch(EOFException eof) { }
		  catch (ClassNotFoundException e) { }
		
		
		in.close();		
		
		return osobe;
		
	}
	
	public List<Osoba> vratiOsobe() {
		return osobe;
	}
	
	public void pronadjiOsobe1(String ime, String prezime) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pretraga1.ser"))) {
			for(Osoba osoba : osobe) {
				if (osoba.getIme().equals(ime) || osoba.getPrezime().equals(prezime))
					out.writeObject(osoba);
			}
			out.flush();			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
	public void pronadjiOsobe2() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pretraga2.ser"))) {
			for(Osoba osoba : osobe) {
				if (osoba.getIme().charAt(0) == osoba.getPrezime().charAt(0))
					out.writeObject(osoba);
			}
			out.flush();			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
	public void ukloniOsobe(String prezime) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("uklonjene.ser"))) {
			Iterator<Osoba> iterator = osobe.iterator();
		    int brojac=0;
			while(iterator.hasNext()) {
		        Osoba osoba = iterator.next();
		        if(osoba.getPrezime().equals(prezime)) {
		        	out.writeObject(osoba);
		            iterator.remove();
		            brojac++;
		        }
		    }
		    out.flush();
		    System.out.print("Broj uklonjenih osoba: "+brojac);
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
	
}
