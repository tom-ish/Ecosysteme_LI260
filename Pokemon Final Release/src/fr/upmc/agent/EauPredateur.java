package fr.upmc.agent;
import java.util.ArrayList;

import fr.upmc.environnement.Map;


public class EauPredateur extends PokePredateur{

	public EauPredateur(int _x, int _y, Map __m, int type, int life) {
		super(_x, _y, __m, type, life, "Eau", 75);
	}

	public void doStep( )
	{
		// met a jour le predateur
		// deplacementPredateur();
		if(this.age < 1000){
			// met a jour le predateur
			// deplacementPredateur();
			if(isNextOeuf()){
				if(getX_oeuf() != -1 && getY_oeuf() != -1)
					if(map.getPokemon(getX_oeuf(), getY_oeuf()).getElement() == this.element)
						protegeOeuf(map.getPokemon(getX_oeuf(), getY_oeuf()));
					else
						mangeProie(getX_oeuf(),getY_oeuf());
			}
			else
				deplacerEau();

			stepDone = true;
		}
		
		else if(this.age == 1000){
			evolution();
			return;
		}

		// Affichage du predateur
		afficherPokemon(this);
		stepDone = true;
	}

}
