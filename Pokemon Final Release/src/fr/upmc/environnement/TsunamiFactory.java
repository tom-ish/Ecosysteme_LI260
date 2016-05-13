package fr.upmc.environnement;

import java.util.ArrayList;

import fr.upmc.agent.Pokemon;

public class TsunamiFactory {

	private Map map;
	private int height;
	private int width;
	private int eau = CaseType.VILLE_WATER.getIdentifiant();
	private int eauInondee = CaseType.VILLE_WATER_INONDEE.getIdentifiant();
	private int lave = CaseType.VILLE_LAVE.getIdentifiant();



	public TypeEvenement typeEvenement() {
		return TypeEvenement.TSUNAMI;
	}

	public TsunamiFactory(Map m) {
		this.map = m;
		height = map.getHeight();
		width = map.getWidth();
		update();
	}
	
	public void update() {
		debutTsunami();
	}

	public void debutTsunami() {
		int height = map.myWorld[0].length;
		int width = map.myWorld.length;
		int [][]buffer = new int[width][height];
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
			
				
				if ((map.myWorld[x][y] == eau || map.myWorld[x][y] == eauInondee) && (y > 0 && y < height) 
						&& (CaseType.isInondable(map.myWorld[x][y - 1], map.mapType) 
						&& map.myWorld[x][y - 1] != lave)) {
					if( map.isPokemon(x, y - 1) == true && (map.getPokemon(x, y - 1).getElement() == "Feu" || map.getPokemon(x, y - 1).getElement() == "Feuille")){
						map.getPokeList()[x][y - 1] = null;
					}
						buffer[x][y - 1] = eauInondee;
				} else {
					buffer[x][y] = map.myWorld[x][y];
				}		
			}
		}
				// met a jour l'automate cellulaire (pour la prochaine etape)
				
			

		//affichage du nouveau tableau
		for (int i = 0; i < map.myWorld.length; i++) {
			for (int j = 0; j < map.myWorld[0].length; j++) {
				map.myWorld[i][j] = buffer[i][j];
			}
		}

	}



}
