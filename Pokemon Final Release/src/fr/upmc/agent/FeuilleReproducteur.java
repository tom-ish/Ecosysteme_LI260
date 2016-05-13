package fr.upmc.agent;

import fr.upmc.environnement.Map;

public class FeuilleReproducteur extends PokeReproducteur {

	public FeuilleReproducteur(int x, int y, Map m, int type, int life) {
		super(x, y, m, type, life, "Feuille", 50);
		// TODO Auto-generated constructor stub
		deposeOeuf = 0;
	}

	@Override
	public void doStep() {
		// TODO Auto-generated method stub
		int back_x = this.x, back_y = this.y;
		
		if(this.age < 75){
			deplacementReproducteur();
			if(this.age == 74){
				switch(orientation){
				case 0:
					back_y = this.y+1;
					break;
				case 1:
					back_x = this.x-1;
					break;
				case 2:
					back_y = this.y-1;
					break;
				case 3:
					back_x = this.x+1;
					break;
				}
				if(deposeOeuf == 0){
					deposeOeuf(back_x,back_y);
					deposeOeuf++;

					map.setPokemon(this.x, this.y, null);
					evolution();
				}
			}
		}
		stepDone = true;
	}
}
