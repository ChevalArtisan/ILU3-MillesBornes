package testsFonctionnels;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Sabot;

public class Test {
	public static void main(String[] args) {
		Carte accident = new Attaque(3,Type.ACCIDENT);
		Carte reparation=new Parade(3,Type.ACCIDENT);
		Carte asDuVolant=new Botte(1,Type.ACCIDENT);
		Sabot sabot= new Sabot();
		sabot.ajouterFamilleCarte(accident,reparation,asDuVolant);
		for (int i = 0; i < 8; i++) {
			System.out.println("Je pioche "+sabot.piocher().toString());
		}
		
	}
}
