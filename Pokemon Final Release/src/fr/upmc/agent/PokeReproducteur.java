package fr.upmc.agent;
import java.util.ArrayList;

import fr.upmc.Start;
import fr.upmc.environnement.Map;


public abstract class PokeReproducteur extends Pokemon {
	protected boolean isAlive;
	protected int deposeOeuf;
	
	protected int x_oeuf, y_oeuf;
	public PokeReproducteur(int x, int y, Map m, int type, int life, String string, int age){
		super(x, y, m, type, life, string, age);
		isAlive = true;
	}
	
	@Override
	public void step() {
		int back_x = this.x, back_y = this.y;
		if(Start.date%2==0){
			doStep();
			// Affichage du predateur
			afficherPokemon(this);
		}
		this.age++;
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
			}
		}
		evolution();
	}
	
	// orientation reproducteur:
	// les reproducteurs ne vont se deplacer qu'autour de l'oeuf si jamais il y en a un
	// sinon les reproducteurs se deplacent en fonction des monstres presents autour de lui
	
	public void deplacementReproducteur(){
		// On definit les orientations possibles
		boolean nordLibre = isCaseValide(x,y-1);
		boolean sudLibre = isCaseValide(x,y+1);
		boolean estLibre = isCaseValide(x+1,y);
		boolean ouestLibre = isCaseValide(x-1,y);
		
		ArrayList<Integer> orientationsPossibles = new ArrayList<Integer>();
		if(nordLibre)
			orientationsPossibles.add(0);
		if(sudLibre)
			orientationsPossibles.add(2);
		if(estLibre)
			orientationsPossibles.add(1);
		if(ouestLibre)
			orientationsPossibles.add(3);

		if(orientationsPossibles.size() > 0){
			// On regarde s'il y a un Pokemon autour
			Pokemon voisin = map.getNearestPokemon(x, y, vision);
			if(voisin == null){
				orientation = random(orientationsPossibles);
			}
			else{
				if(isProie(voisin)){
					direction = choisirDirection(this.x,this.y,voisin.x,voisin.y);
					int orientation_tmp = fuit(direction, orientationsPossibles);
					if(orientation_tmp < 0) return;
					else orientation = orientation_tmp;
				}
				else
					orientation = random(orientationsPossibles);
			}
			//orientation = choisirOrientation(this.x,this.y,voisin.x,voisin.y,orientationPossibles,isProie(voisin.x,voisin.y));
			if(orientation == -1)
				return;

			map.setPokemon(this.x, this.y, null);
			// met a jour: la position du reproducteur (depend de l'orientation)

			switch ( orientation ) 
			{
			case 0: // nord	
				y = ( y - 1 + map.getHeight() ) % map.getHeight();
				break;
			case 1:	// est
				x = ( x + 1 + map.getWidth() ) % map.getWidth();
				break;
			case 2:	// sud
				y = ( y + 1 + map.getHeight() ) % map.getHeight();
				break;
			case 3:	// ouest
				x = ( x - 1 + map.getWidth() ) % map.getWidth();
				break;
			case 4:
				break;
			}
			// Ajouter la valeur de l'indice du pokemon a la case suivante
			map.setPokemon(this.x, this.y, this);
	}
		else {
			// aucune orientation possible
		}
		
	}
	
	public void deplacementReproducteurEau(){
		// On definit les orientations possibles
		boolean nordLibre = isCaseValideEau(x,y-1);
		boolean sudLibre = isCaseValideEau(x,y+1);
		boolean estLibre = isCaseValideEau(x+1,y);
		boolean ouestLibre = isCaseValideEau(x-1,y);
		
		ArrayList<Integer> orientationsPossibles = new ArrayList<Integer>();
		if(nordLibre)
			orientationsPossibles.add(0);
		if(sudLibre)
			orientationsPossibles.add(2);
		if(estLibre)
			orientationsPossibles.add(1);
		if(ouestLibre)
			orientationsPossibles.add(3);

		if(orientationsPossibles.size() > 0){
			// On regarde s'il y a un Pokemon autour
			Pokemon voisin = map.getNearestPokemon(x, y, vision);
			if(voisin == null){
				orientation = random(orientationsPossibles);
			}
			else{
				if(isProie(voisin)){
					direction = choisirDirection(this.x,this.y,voisin.x,voisin.y);
					int orientation_tmp = fuit(direction, orientationsPossibles);
					if(orientation_tmp < 0) return;
					else orientation = orientation_tmp;
				}
				else
					orientation = random(orientationsPossibles);
			}
			//orientation = choisirOrientation(this.x,this.y,voisin.x,voisin.y,orientationPossibles,isProie(voisin.x,voisin.y));
			if(orientation == -1)
				return;

			map.setPokemon(this.x, this.y, null);
			// met a jour: la position du reproducteur (depend de l'orientation)

			switch ( orientation ) 
			{
			case 0: // nord	
				y = ( y - 1 + map.getHeight() ) % map.getHeight();
				break;
			case 1:	// est
				x = ( x + 1 + map.getWidth() ) % map.getWidth();
				break;
			case 2:	// sud
				y = ( y + 1 + map.getHeight() ) % map.getHeight();
				break;
			case 3:	// ouest
				x = ( x - 1 + map.getWidth() ) % map.getWidth();
				break;
			case 4:
				break;
			}
			// Ajouter la valeur de l'indice du pokemon a la case suivante
			map.setPokemon(this.x, this.y, this);
	}
		else {
			// aucune orientation possible
		}
		
	}
	
	public int deposeOeuf(int back_x, int back_y){
		// On verifie qu'il n'y a rien sur les coordonnees ou on va deposer l'oeuf
		if(map.isObstacle(back_x, back_y) || map.isPokemon(back_x, back_y))
			return -1;
		else {
			x_oeuf = back_x;
			y_oeuf = back_y;
			if(this.getElement() == "Eau")
				new OeufEau(back_x,back_y,this.map);
			else if(this.getElement() == "Feu")
				new OeufFeu(back_x,back_y,this.map);
			else if(this.getElement() == "Feuille")
				new OeufFeuille(back_x,back_y,this.map);

			return 0;
		}
	}
	
	protected void evolution(){
		if(this.age == 75){
			map.setPokemon(this.x, this.y, null);
			if(this.getElement() == "Feu"){
				map.getPokeList()[this.x][this.y] = new FeuPredateur(this.x,this.y,this.map,6,100);
				map.getPokeList()[this.x][this.y].setStepDone(true);
			}
			else if(this.getElement() == "Eau"){
				map.getPokeList()[this.x][this.y] = new EauPredateur(this.x,this.y,this.map,3,100);
				map.getPokeList()[this.x][this.y].setStepDone(true);
			}
			else if(this.getElement() == "Feuille"){
				map.getPokeList()[this.x][this.y] = new FeuillePredateur(this.x,this.y,this.map,9,100);
				map.getPokeList()[this.x][this.y].setStepDone(true);
			}
		}
	}
}
