package fr.upmc.agent;
import java.util.ArrayList;

import fr.upmc.environnement.Map;


public class FeuilleProie extends PokeProie {
	int cpt;
	
	public FeuilleProie(int x, int y, Map m, int type, int life) {
		super(x, y, m, type, life,"Feuille", 25);
	}

	public void doStep()
	{		
		if (map.isTsunamiActive()){
			fuiteTsunami();
		} 
		else{
			if(this.age == 50){
				evolution();
			}
			else{
				cpt++;
				// met a jour le pokemon
				//deplacementProie();
				deplacer();
				if(cpt%5 == 0)
					planteHerbe(x,y);

				stepDone = true;
			}
		}
	}
	
	public void planteHerbe(int x, int y){
		if(map.isSable(x,y))
			map.myWorld[x][y] = 1;
	}
	
}
