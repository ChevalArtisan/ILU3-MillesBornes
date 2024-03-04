package testsFonctionnels;

import java.util.ArrayList;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.JeuDeCartes;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Sabot;
import utils.Utils;

public class Test {
	public static void main(String[] args) {
		Carte accident = new Attaque(3,Type.ACCIDENT);
		Carte essence = new Attaque(3,Type.ESSENCE);
		Carte reparation=new Parade(3,Type.ACCIDENT);
		Carte asDuVolant=new Botte(1,Type.ACCIDENT);
		Sabot sabot= new Sabot();
		DebutLimite lim= new DebutLimite(4);
		FinLimite lim2 = new FinLimite(1);
		
//		sabot.ajouterFamilleCarte(accident,reparation,asDuVolant);
//		while(!sabot.estVide()) {
//			System.out.println("Je pioche "+sabot.piocher().toString());
//		}
		
		
//		System.out.println(accident.equals(asDuVolant));
//		System.out.println(accident.equals(accident));
//		System.out.println(lim.equals(lim));
//		System.out.println(essence.equals(accident));
		JeuDeCartes jeu=new JeuDeCartes();
		ArrayList<Carte> cartes=jeu.getListeCartes();
		System.out.println(cartes.size());
		//		for(Carte carte:cartes){
//			System.out.println(carte.toString());
//			
//		}
//		System.out.println(utils.extraire(cartes));
		ArrayList<Carte> cartes2 =(ArrayList<Carte>) Utils.melanger(cartes);
		System.out.println(cartes2.size());
		System.out.println(Utils.verifierMelange(cartes2, new JeuDeCartes().getListeCartes()));
		System.out.println(Utils.rassembler(cartes2));
	}
}
