package fr.upmc.agent;

import fr.upmc.environnement.Map;

public class FeuReproducteur extends PokeReproducteur {

	public FeuReproducteur(int x, int y, Map m, int type, int life) {
		super(x, y, m, type, life, "Feu", 50);
		// TODO Auto-generated constructor stub
		deposeOeuf = 0;
	}

	@Override
	public void doStep() {
		// TODO Auto-generated method stub
		
		deplacementReproducteur();
		stepDone = true;
	}
}
