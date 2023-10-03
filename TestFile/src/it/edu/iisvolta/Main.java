package it.edu.iisvolta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String risp;
		Negozio n=new Negozio();
		Portfolio pf=new Portfolio();
		
		do {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Gestione prodotti\n");
			System.out.println("1 - Visualizza prodotti");
			System.out.println("2 - Carica prodotti");
			System.out.println("3 - Salva prodotti");
			System.out.println("4 - Aggiungi prodotto");
			System.out.println("5 - Visualizza Clienti");
			System.out.println("6 - Carica clienti");
			System.out.println("7 - Salva clienti");
			System.out.println("8 - Aggiungi cliente");
			System.out.println("\n9 - Esci");
			System.out.print("Inserisci la tua scelta: ");
			System.out.println();
			risp=sc.nextLine();
			switch(risp) {
			case "1":
				for(Prodotto p:n.elencoProdotti())
				{
					System.out.println("Prodotto: "+p.getDescrizione());
					System.out.println(" Prezzo: "+p.getPrezzo());
					System.out.println(" Quantità: "+p.getQuantità()+"\n");
				}
				break;
			case "2":
				n.carica("prodotti.csv");
				break;
			case "3":
				n.salva("prodotti.csv");
				break;
			case "4":
				Prodotto nuovoProd=new Prodotto();
				System.out.println("Inserisci la descrizione: ");
				nuovoProd.setDescrizione(sc.nextLine());
				System.out.println("Inserisci il prezzo: ");
				nuovoProd.setPrezzo(Double.parseDouble(sc.nextLine()));
				System.out.println("Inserisci la quantità: ");
				nuovoProd.setQuantità(Integer.parseInt(sc.nextLine()));
				n.aggiungiProdotto(nuovoProd);
				break;
			case "5":
				for(Cliente c:pf.elencoClienti())
				{
					System.out.println("Numero: "+c.getNumero());
					System.out.println(" Nome: "+c.getNome());
					System.out.println(" Cognome: "+c.getCognome()+"\n");
				}
				break;
			case "6":
				pf.carica("clienti.csv");
				break;
			case "7":
				pf.salva("clienti.csv");
				break;
			case "8":
				Cliente nuovoCliente=new Cliente();
				System.out.println("Inserisci il numero: ");
				nuovoCliente.setNumero(Integer.parseInt(sc.nextLine()));
				System.out.println("Inserisci il nome: ");
				nuovoCliente.setNome(sc.nextLine());
				System.out.println("Inserisci il cognome: ");
				nuovoCliente.setCognome(sc.nextLine());
				pf.aggiungiCliente(nuovoCliente);
				break;
			case "9":
				System.out.println("Arrivederci");
				break;
			default:
				System.out.println("Scelta non valida");
				break;
			}
		}while(!risp.equals("9"));
	}

}
