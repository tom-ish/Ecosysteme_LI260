package fr.upmc.agent;
import fr.upmc.environnement.CaseType;
import fr.upmc.environnement.Map;
import fr.upmc.environnement.MapVille;


public class FeuProie extends PokeProie {

	private	int burningtree = CaseType.VILLE_BURNINGTREE.getIdentifiant();
	
	public FeuProie(int x, int y, Map m, int type, int life) {
		super(x, y, m, type, life, "Feu", 25);
	}
	
	@Override
	public void doStep()
	{	
		// met a jour le pokemon

		if (map.isTsunamiActive())
			fuiteTsunami();
		else {
			deplacer();
		}		
		
		
		if(!MapVille.pluieIsActive){
			allumeFeu();
			MapVille.feuIsActive = true;
		}
		
		stepDone = true;
	}

	public void allumeFeu(){

		// on regarde si il y a des arbres au voisinage
		if (x > 0 && x < map.getWidth() - 1 && y > 0 && y < map.getHeight() - 1){
			if(map.myWorld[x + 1][y] == 2)
				map.myWorld[x + 1][y] = burningtree; // droite
			else if(map.myWorld[x - 1][y] == 2)
				map.myWorld[x - 1][y] = burningtree; // gauche
			else if(map.myWorld[x][y + 1] == 2)
				map.myWorld[x][y + 1] = burningtree; // bas
			else if(map.myWorld[x][y - 1] == 2)
				map.myWorld[x][y - 1] = burningtree; // haut
		}
	}

}
