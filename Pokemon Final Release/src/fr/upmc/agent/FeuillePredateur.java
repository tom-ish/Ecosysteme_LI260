package fr.upmc.agent;
import java.util.ArrayList;

import fr.upmc.environnement.Map;


public class FeuillePredateur extends PokePredateur{

	int cpt = -1;
	
	public FeuillePredateur(int _x, int _y, Map __m, int type, int life) {
		super(_x, _y, __m, type, life, "Feuille", 75);
	}
	
	public void doStep( )
	{
		if (this.age< 1000) {
			if (map.isTsunamiActive()) {
				fuiteTsunami();
			} 
			else {
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
					deplacer();

				if(cpt%3 == 0)
					planteGraine(this.x,this.y);
			}
			// Affichage du predateur
			afficherPokemon(this);
			stepDone = true;
			cpt++;
		}
		
		else if(this.age == 1000){
			evolution();
			return;
		}
		// Affichage du predateur
		afficherPokemon(this);
		stepDone = true;
		System.out.println("=====fin doStep() / Florizarre====");
	}
	
	public void planteGraine(int x, int y){
		int x_back = x;
		int y_back = y;
		
		// Il faut connaitre la position d'ou il vient
		switch(orientation){
		case 0:	// Le pokemon vient du bas
			x_back = x;
			y_back = y+1;
			break;
		case 1:	// Le pokemon vient de la gauche
			x_back = x-1;
			y_back = y;
			break;
		case 2:	// Le pokemon vient du haut
			x_back = x;
			y_back = y-1;
			break;
		case 3:	// Le pokemon vient de la droite
			x_back = x+1;
			y_back = y;
			break;
		}
		
		// Il faut regarder si la case d'ou il vient est une herbe
		boolean casePrecedenteHerbe = map.isHerbe(x_back, y_back);
		
		if(casePrecedenteHerbe)
			map.myWorld[x_back][y_back] = 29;
	}


}
