package it.edu.iisvolta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Negozio {
	private ArrayList<Prodotto> elencoProdotti=new ArrayList<Prodotto>();
	
	public void aggiungiProdotto(Prodotto p) {
		if(p.getPrezzo()>0 && p.getQuantità()>0 && p.getDescrizione().length()>0)
			elencoProdotti.add(p);
	}
	
	public void salva(String nomeFile) {
				try {
					FileWriter fw=new FileWriter("prodotti.csv");
					for(Prodotto p:elencoProdotti)
						fw.write(
								p.getDescrizione()+";"+
								p.getPrezzo()+";"+
								p.getQuantità()+"\n"
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
				Prodotto p=new Prodotto();
				p.setDescrizione(dati[0]);
				p.setPrezzo(Double.parseDouble(dati[1]));
				p.setQuantità(Integer.parseInt(dati[2]));
				elencoProdotti.add(p);
			}
			sc.close();
			System.out.println("\n\nLettura terminata.");
		} catch (FileNotFoundException e) {
			System.out.println("Si è verificato un errore in fase di lettura!"); 
			e.printStackTrace();
		}
	}
	
	public Iterable<Prodotto> elencoProdotti() {
		return this.elencoProdotti;
	}
}
