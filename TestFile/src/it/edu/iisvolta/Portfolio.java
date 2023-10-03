package it.edu.iisvolta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Portfolio {
	private ArrayList<Cliente> elencoClienti=new ArrayList<Cliente>();
	
	public void aggiungiCliente(Cliente c) {
		if(c.getNumero()>0 && c.getNome().length()>0 && c.getCognome().length()>0)
			elencoClienti.add(c);
	}
	
	public void salva(String nomeFile) {
				try {
					FileWriter fw=new FileWriter("clienti.csv");
					for(Cliente c:elencoClienti)
						fw.write(
								c.getNumero()+";"+
								c.getNome()+";"+
								c.getCognome()+"\n"
								);
					fw.close();
					System.out.println("File correttamente creato\n");
				} catch (IOException e) {
					System.out.println("Si è verificato un errore in fase di creazione file!");
					e.printStackTrace();
				}
	}
	
	public void carica(String nomeFile) {
		File f=new File(nomeFile);
		String[] dati;
		try {
			Scanner sc=new Scanner(f);		
			String riga;
			while (sc.hasNextLine()) { 
				riga=sc.nextLine();		
				dati=riga.split(";");	
				Cliente c=new Cliente();
				c.setNumero(Integer.parseInt(dati[0]));
				c.setNome(dati[1]);
				c.setCognome(dati[2]);
				elencoClienti.add(c);
			}
			sc.close();
			System.out.println("\n\nLettura terminata.");
		} catch (FileNotFoundException e) {
			System.out.println("Si è verificato un errore in fase di lettura!"); 
			e.printStackTrace();
		}
	}
	
	public Iterable<Cliente> elencoClienti() {
		return this.elencoClienti;
	}
}
