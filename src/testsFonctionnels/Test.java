package testsFonctionnels;

import java.util.ArrayList;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.JeuDeCartes;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Joueur;
import jeu.Sabot;
import utils.Utils;

public class Test {
	public static void main(String[] args) {
		Carte accident = new Attaque(3,Type.ACCIDENT);
		Carte essence = new Attaque(3,Type.ESSENCE);
		Carte reparation=new Parade(3,Type.ACCIDENT);
		Carte asDuVolant=new Botte(1,Type.FEU);
		Borne centKM=new Borne(10, 100);
		Borne milleKM=new Borne(10, 1000);

		Sabot sabot= new Sabot();
		DebutLimite lim= new DebutLimite(4);
		FinLimite lim2 = new FinLimite(1);
		Joueur joueur =new Joueur("Michel");
		
		
//		System.out.println(joueur.getLimite());
//		joueur.getLimites().add(lim);
//		System.out.println(joueur.getLimite());
//		joueur.getLimites().add(lim2);
//		System.out.println(joueur.getLimite());
//		joueur.getLimites().add(lim);
//		joueur.getBottes().add((Botte) asDuVolant);
//		System.out.println(joueur.getLimite());
		joueur.getZoneDeJeu().getPileBataille().add((new Attaque (1,Type.FEU)));
		System.out.println(joueur.estBloque());
		joueur.getZoneDeJeu().getBottes().add(new Botte(0, Type.FEU));
		System.out.println(joueur.estBloque());
		joueur.getZoneDeJeu().getPileBataille().add(new Attaque(0, Type.ACCIDENT));
		System.out.println(joueur.estBloque());
		joueur.getZoneDeJeu().getBottes().add(new Botte(0, Type.ACCIDENT));
		System.out.println(joueur.estBloque());
		joueur.getZoneDeJeu().getPileBataille().add(new Attaque(0, Type.ESSENCE));
		System.out.println(joueur.estBloque());
		joueur.getZoneDeJeu().getPileBataille().add(new Parade(0, Type.ESSENCE));
		System.out.println(joueur.estBloque());
		joueur.getZoneDeJeu().getBottes().clear();
		System.out.println(joueur.estBloque());
		joueur.getZoneDeJeu().getPileBataille().add(new Parade(0, Type.FEU));
		System.out.println(joueur.estBloque());


//		joueur.getBornes().add(centKM);
//		joueur.getBornes().add(milleKM);
//		
//		System.out.println(joueur.getKM());
		
//		sabot.ajouterFamilleCarte(accident,reparation,asDuVolant);
//		while(!sabot.estVide()) {
//			System.out.println("Je pioche "+sabot.piocher().toString());
//		}
		
		
//		System.out.println(accident.equals(asDuVolant));
//		System.out.println(accident.equals(accident));
//		System.out.println(lim.equals(lim));
//		System.out.println(essence.equals(accident));
//		JeuDeCartes jeu=new JeuDeCartes();
//		ArrayList<Carte> cartes=jeu.getListeCartes();
//		System.out.println(cartes.size());
//				for(Carte carte:cartes){
//			System.out.println(carte.toString());
//			
//		}
//		System.out.println(Utils.extraire(cartes));
//		ArrayList<Carte> cartes2 =(ArrayList<Carte>) Utils.melanger(cartes);
//		System.out.println(cartes2.size());
//		System.out.println(Utils.verifierMelange(cartes2, new JeuDeCartes().getListeCartes()));
//		System.out.println(Utils.rassembler(cartes2));
		
		
	}
}
