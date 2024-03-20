package cartes;


import java.util.ArrayList;

import cartes.Probleme.Type;

public class JeuDeCartes {
	private static Carte[] typesDeCartes= {
			new Botte(1,Type.FEU),new Botte(1,Type.ESSENCE),
			new Botte(1,Type.CREVAISON),new Botte(1,Type.ACCIDENT),
			new Attaque(5,Type.FEU),new DebutLimite(4),
			new Attaque(3,Type.ESSENCE),new Attaque(3,Type.CREVAISON),
			new Attaque(3,Type.ACCIDENT),
			new Parade(14,Type.FEU),new FinLimite(6),new Parade(6,Type.ESSENCE),
			new Parade(6,Type.CREVAISON),new Parade(6,Type.ACCIDENT),
			new Borne(10,25),new Borne(10,50),
			new Borne(10,75),new Borne(12,100),
			new Borne(4,200)
	};
	private ArrayList<Carte> listeCartes=new ArrayList<>();
	
	public ArrayList<Carte> getListeCartes() {
		return listeCartes;
	}

	public JeuDeCartes(){
		
		for (Carte carte: typesDeCartes) {
			for (int i=0; i<carte.getNombre();i++) {
				listeCartes.add(carte);
			}
		}
		listeCartes= (ArrayList<Carte>) utils.Utils.melanger(listeCartes);
	}
	
	public void checkCount() {
		//TODO 
	}
	
	
	
}
