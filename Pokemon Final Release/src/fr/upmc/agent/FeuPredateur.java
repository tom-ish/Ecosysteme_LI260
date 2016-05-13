package fr.upmc.agent;
import fr.upmc.environnement.Map;
import fr.upmc.environnement.MapVille;


public class FeuPredateur extends PokePredateur{

	public FeuPredateur(int _x, int _y, Map __m, int type, int life) {
		super(_x, _y, __m, type, life, "Feu", 75);
	}
	
	public void doStep( )
	{		
		if(this.y == 5 && (this.x == 5 || this.x == 6 || this.x == 7))
			MapVille.isEruptionActive = true;
		if (this.age< 1000) {
			if (map.isTsunamiActive()) {
				fuiteTsunami();
			} else {
				if(isNextOeuf()){
					if(getX_oeuf() != -1 && getY_oeuf() != -1){
						if(map.getPokemon(getX_oeuf(), getY_oeuf()).getElement() == this.element){
							protegeOeuf(map.getPokemon(getX_oeuf(), getY_oeuf()));						
						}else{
							mangeProie(getX_oeuf(),getY_oeuf());
						}
					}
	
				}
				else{		
					deplacer();	
				}
				stepDone = true;
			}
		}

		else if(this.age == 1000){
			evolution();
			return;
		}
		
		// Affichage du predateur
		afficherPokemon(this);
	}

}
