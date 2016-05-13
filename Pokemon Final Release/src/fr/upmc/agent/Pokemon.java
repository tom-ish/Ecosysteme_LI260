package fr.upmc.agent;
import java.util.List;
import java.util.ArrayList;

import fr.upmc.environnement.CaseType;
import fr.upmc.environnement.Map;
import fr.upmc.environnement.MapType;


public abstract class Pokemon {

	Map map;
	
	// coordonnees du pokemon
	int x;
	int y;
	int next_x;
	int next_y;
	
	int direction;
	int orientation;
	int etat;
	int life;
	int type;
	int temp_type;
	int indice;
	
	int age;
	int vision;

	String element;
	String elementNextPokemon;
	
	boolean stepDone;

	public int currentSprite;
	
	public Pokemon(int x, int y, Map m, int type, int life, String string, int age){
		this.x = x;
		this.y = y;
		this.map = m;
		this.type = type;
		this.life = life;
		temp_type = map.getTileMap(x, y);
		
		orientation = initOrientation();
		System.out.println(orientation);
		element = string;
		stepDone = false;
		vision = 10;
		this.indice = this.type*10 + this.orientation;
		this.age = age;
		
		afficherPokemon(this);

	}

	public void initPokemon(){
		int new_x, new_y;
		do{
			new_x = (int) (Math.random() * map.width);
			new_y = (int) (Math.random() * map.height);
		}while(map.isObstacle(new_x, new_y) && map.isPokemon(new_x, new_y));
	}
	
	public int initOrientation(){
		return (int)(Math.random() * 4) %4;
	}
	
	protected abstract void evolution();
	public abstract void step();
	public abstract void doStep();
	
	public void deplacer() {
				
		// Definir les orientations possibles
		boolean nordLibre = isCaseValide(x,y-1);
		boolean estLibre = isCaseValide(x+1,y);
		boolean sudLibre = isCaseValide(x,y+1);
		boolean ouestLibre = isCaseValide(x-1,y);
		
		// On ajoute les orientations possibles dans une liste d'orientation de taille variable
		ArrayList<Integer> orientationPossibles = new ArrayList<Integer>(); 
		if(nordLibre){
			orientationPossibles.add(0);
		}
		if(estLibre){
			orientationPossibles.add(1);
		}
		if(sudLibre){
			orientationPossibles.add(2);
		}
		if(ouestLibre){
			orientationPossibles.add(3);
		}	
				
		// On stocke le Pokemon voisin dans une variable qui renvoie null s'il y en a pas
		Pokemon voisin = map.getNearestPokemon(x, y, vision);
		
		if(orientationPossibles.size() > 0){
			// S'il n'y a pas de voisin alors c'est qu'il n'y a pas de pokemon dans un rayon r = champ
			if(voisin == null){
				orientation = random(orientationPossibles);
			}				
			// Si la liste des voisins n'est pas nulle, alors il y a un pokemon dans un rayon r = champ
			else {
				// La direction nous donne la position du pokemon voisin par rapport au pokemon courant
				direction = choisirDirection(this.x, this.y, voisin.x, voisin.y);
				
				if(voisin.getElement() == this.element){
					int orientation_tmp = fuit(direction, orientationPossibles);
					if(orientation_tmp < 0) return;
					else orientation = orientation_tmp;
				}
				else{
					// Si le pokemon courant est une proie par rapport au voisin alors on s'enfuit
					if(isProie(voisin) == true){
						int orientation_tmp = fuit(direction, orientationPossibles);
						if(orientation_tmp < 0) return;
						else orientation = orientation_tmp;
					}
					// Si le pokemon courant est un predateur par rapport au voisin alors on va vers le voisin
					else if(isPredateur(voisin) == true){
						int orientation_tmp = poursuit(direction, orientationPossibles);
						if(orientation_tmp < 0) return;
						else orientation = orientation_tmp;
					}
				}
			}
		
			// Gestion de deplacement
			
			// Avant de changer la position du Pokemon, il faut supprimer le Pokemon de la matrice
			map.setPokemon(this.x, this.y, null);
			
			// met a jour: la position de predateur (depend de l'orientation)
			switch ( orientation ) 
			{
			case 0: // nord
				if(map.isPokemon(x,y-1) && isPredateur(map.getPokemon(x,y-1))){
					mangeProie(x,y-1);
				}
				y = ( y - 1 + map.getHeight() ) % map.getHeight();
				break;
			case 1:	// est
				if(map.isPokemon(x+1,y) && isPredateur(map.getPokemon(x+1,y))){
					mangeProie(x+1,y);
				}
				x = ( x + 1 + map.getWidth() ) % map.getWidth();
				break;
			case 2:	// sud
				if(map.isPokemon(x,y+1) && isPredateur(map.getPokemon(x,y+1))){
					mangeProie(x,y+1);
				}
				y = ( y + 1 + map.getHeight() ) % map.getHeight();
				break;
			case 3:	// ouest
				if(map.isPokemon(x-1,y) && isPredateur(map.getPokemon(x-1,y))){
					mangeProie(x-1,y);
				}
				x = ( x - 1 + map.getWidth() ) % map.getWidth();
				break;
			case 4:
				break;
			}
			// x et y sont les nouvelles positions du Pokemon
			// il faut donc modifier la position du Pokemon dans la matrice de Pokemon
			map.setPokemon(this.x, this.y, this);
		}
		// Aucune orientation possible
		else{
			//orientation = 4;
		}
			
	}
	
	public void deplacerEau() {
		
		// Definir les orientations possibles
		boolean nordLibre = isCaseValideEau(x,y-1);
		boolean estLibre = isCaseValideEau(x+1,y);
		boolean sudLibre = isCaseValideEau(x,y+1);
		boolean ouestLibre = isCaseValideEau(x-1,y);
		
		// On ajoute les orientations possibles dans une liste d'orientation de taille variable
		ArrayList<Integer> orientationPossibles = new ArrayList<Integer>(); 
		if(nordLibre){
			System.out.println("Case Nord libre");
			orientationPossibles.add(0);
		}
		if(estLibre){
			System.out.println("Case Est libre");
			orientationPossibles.add(1);
		}
		if(sudLibre){
			System.out.println("Case Sud libre");
			orientationPossibles.add(2);
		}
		if(ouestLibre){
			System.out.println("Case Ouest libre");
			orientationPossibles.add(3);
		}	
		
		System.out.println("les orientations possibles ont ete ajoutees dans la liste d'orientations possibles");
		
		// On stocke le Pokemon voisin dans une variable qui renvoie null s'il y en a pas
		Pokemon voisin = map.getNearestPokemon(x, y, vision);
		
		if(orientationPossibles.size() > 0){

			orientation = random(orientationPossibles);

		
			// Gestion de deplacement
			
			// Avant de changer la position du Pokemon, il faut supprimer le Pokemon de la matrice
			map.setPokemon(this.x, this.y, null);
			
			// met a jour: la position de predateur (depend de l'orientation)
			switch ( orientation ) 
			{
			case 0: // nord
				if(map.isPokemon(x,y-1) && isPredateur(map.getPokemon(x,y-1))){
					mangeProie(x,y-1);
				}
				y = ( y - 1 + map.getHeight() ) % map.getHeight();
				break;
			case 1:	// est
				if(map.isPokemon(x+1,y) && isPredateur(map.getPokemon(x+1,y))){
					mangeProie(x+1,y);
				}
				x = ( x + 1 + map.getWidth() ) % map.getWidth();
				break;
			case 2:	// sud
				if(map.isPokemon(x,y+1) && isPredateur(map.getPokemon(x,y+1))){
					mangeProie(x,y+1);
				}
				y = ( y + 1 + map.getHeight() ) % map.getHeight();
				break;
			case 3:	// ouest
				if(map.isPokemon(x-1,y) && isPredateur(map.getPokemon(x-1,y))){
					mangeProie(x-1,y);
				}
				x = ( x - 1 + map.getWidth() ) % map.getWidth();
				break;
			case 4:
				break;
			}
			// x et y sont les nouvelles positions du Pokemon
			// il faut donc modifier la position du Pokemon dans la matrice de Pokemon
			map.setPokemon(this.x, this.y, this);
		}
		// Aucune orientation possible
		else{
			//orientation = 4;
		}
			
	}
	
	public void fuiteTsunami() {
		final int nord = 0;
		final int est = 1;
		final int ouest = 3;
		
		// Definir les orientations possibles
		boolean nordLibre = isCaseValide(x, y - 1);
		boolean estLibre = isCaseValide(x + 1, y);
		boolean ouestLibre = isCaseValide(x - 1, y);

		

		// On ajoute les orientations possibles dans une liste d'orientation de
		// taille variable
		ArrayList<Integer> orientationPossibles = new ArrayList<Integer>();
		//Si le pokemon 
			if (nordLibre) {
				orientation = nord;
			} 
			//si nord est bloque, 
			else{
				// si case sud bloque
				if(!isCaseValide(x, y + 1)){
					//map.getPokeList()[x][y] = null;
				} else {	
					if (estLibre) {
						orientationPossibles.add(est);
					}
					if (ouestLibre) {
						orientationPossibles.add(ouest);
					} 
					if(orientationPossibles.size() > 0){
						orientation = random(orientationPossibles);
					}
				}
			}
			
			map.setPokemon(this.x, this.y, null);
			// met a jour: la position de predateur (depend de l'orientation)
			switch (orientation) {
			case 0: // nord
				y = (y - 1 + map.getHeight()) % map.getHeight();
	
				break;
			case 1: // est
				x = (x + 1 + map.getWidth()) % map.getWidth();
				break;
	
			case 3: // ouest
				x = (x - 1 + map.getWidth()) % map.getWidth();
				break;
			case 4:
				break;
			}
		
			map.setPokemon(this.x, this.y, this);

	}
	
	public void mangeProie(int x_proie, int y_proie) {
		map.setPokemon(x_proie, y_proie, null);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////

	public int random(int i, int j){
		if(Math.random() < 0.5)
			return i;
		else
			return j;
	}
	
	public int randomTriple(int i, int j, int k){
		if(Math.random() < 0.33)
			return i;
		else if(Math.random() < 0.66)
			return j;
		else
			return k;
	}
	
	public int random(List<Integer> list){
		if(list.size() == 1) {
			return list.get(0);
		} else if(list.size() == 2) {
			return random(list.get(0), list.get(1));
		} else if(list.size() == 3 ){
			return randomTriple(list.get(0), list.get(1), list.get(2));
		} else if( list.size() == 0) {
			return -1;
		}
		else
			return random(random(list.get(0), list.get(1)),random(list.get(2), list.get(3)));
	}
	
	public void afficherPokemon(Pokemon pokemon) {
		// modification de l'indice de la case de l'agent;
		int indice = this.orientation + this.getType()*10;
		pokemon.setIndice(indice);
		map.setPokemon(pokemon.x, pokemon.y, pokemon);
	}
	
	public void remettreSprite(int x, int y){
		map.myWorld[x][y] = map.myWorld[x][y]%100;
	}
	
	public String getElement(){
		return element;
	}
	
	public int getType(){
		return this.type;
	}
	
	public void setType(int n){
		this.type = n;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getOrientation(){
		return this.orientation;
	}
	
	public int getIndice(){
		return this.indice;
	}
	
	public void setIndice(int i){
		this.indice = i;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	public int choisirDirection(int x_courant, int y_courant, int x_voisin, int y_voisin){
		int pente;
		int direction = -1;
		if(x_courant == x_voisin){
			if(y_courant - y_voisin > 0){	// voisin est en haut de courant
				direction = 0;
			}
			else{	// voisin est en bas de courant
				direction = 4;
			}
		}
		else if(y_courant == y_voisin){
			if(x_courant - x_voisin > 0){	// voisin est a gauche de courant
				direction = 6;
			}
			else{	// voisin est a droite de courant
				direction = 2;
			}	
		}
		else{
			pente = coefficientDirecteur(x_courant,y_courant,x_voisin,y_voisin);
			// Si le coefficient directeur est positif, le voisin est situe en bas a droite ou en haut a gauche par rapport au courant
			if(pente > 0){
				// Si le voisin est en bas a droite
				if((y_voisin - y_courant > 0) && (x_voisin - x_courant > 0)){
					direction = 3;
				}
				// Si le voisin est en haut a gauche
				else if((y_voisin - y_courant < 0) && (x_voisin - x_courant < 0)){
					direction = 7;
				}
			} // Si le coefficient directeur est negatif, le voisin est situe en bas a gauche ou en haut a droite par rapport au courant
			else {
				// Si le voisin est en bas a gauche
				if((y_voisin - y_courant > 0) && (x_voisin - x_courant < 0)){
					direction = 5;
				}
				// Si le voisin est en haut a droite
				else if((y_voisin - y_courant < 0) && (x_voisin - x_courant > 0)){
					direction = 1;
				}
			}
		}
		return direction;
	}
	
	public int coefficientDirecteur(int x_courant, int y_courant, int x_voisin, int y_voisin){
		return (y_voisin - y_courant)/(x_voisin - x_courant);
	}
	
	public int fuit(int direction, ArrayList<Integer> orientationsPossibles){
		final int nord = 0, sud = 2, est = 1, ouest = 3;
		if(direction == 0){
			if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(est) )
				return est;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(nord))
				return nord;
		}else if(direction == 1){
			if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(nord))
				return nord;
		}else if(direction == 2){
			if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(est))
				return est;
		}else if(direction == 3){
			if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(sud))
				return sud;
		}else if(direction == 4){
			if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(sud))
				return sud;
		}else if(direction == 5){
			if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(sud))
				return sud;
		}else if(direction == 6){
			if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
		}else if(direction == 7){
			if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(nord))
				return nord;
		}
		return random(orientationsPossibles);
	}

	public int poursuit(int direction, ArrayList<Integer> orientationsPossibles){
		final int nord = 0, sud = 2, est = 1, ouest = 3;
		if(direction == 0){
			if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(sud))
				return sud;
		}else if(direction == 1){
			if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(sud))
				return sud;
		}else if(direction == 2){
			if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
		}else if(direction == 3){
			if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
		}else if(direction == 4){
			if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(nord))
				return nord;
		}else if(direction == 5){
			if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(nord))
				return nord;
		}else if(direction == 6){
			if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(sud))
				return sud;
			else if(orientationsPossibles.contains(est))
				return est;
		}else if(direction == 7){
			if(orientationsPossibles.contains(ouest))
				return ouest;
			else if(orientationsPossibles.contains(nord))
				return nord;
			else if(orientationsPossibles.contains(est))
				return est;
			else if(orientationsPossibles.contains(sud))
				return sud;
		}
		return random(orientationsPossibles);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	

	public boolean isStepDone() {
		// TODO Auto-generated method stub
		return this.stepDone;
	}
	
	public void setStepDone(boolean b){
		this.stepDone = b;
	}

	protected boolean isCaseValide(int next_x, int next_y) {
		// Si les coordonnees sont hors des limites de la carte, alors case invalide
		if(next_x < 0 || next_x > map.getWidth()-1 || next_y < 0 || next_y > map.getHeight()-1) return false;
		else{
			// S'il n'y a pas d'obstacle dans la case voisine
			if(map.isObstacle(next_x, next_y) == false) {
				// S'il y a un pokemon dans une des cases voisines
				if(map.getPokemon(next_x,next_y) != null){
					// Si ce pokemon est un predateur par rapport au pokemon courant, alors la case voisine n'est pas valide
					if(isProie(map.getPokemon(next_x,next_y)) == true) {
						return false;
					}
					// Si ce Pokemon est une proie par rapport au pokemon courant, alors la case voisine est valide
					else if(isPredateur(map.getPokemon(next_x,next_y)) == true){
						return true;
					}
				}
				// S'il n'y a pas de Pokemon dans la case voisine
				else{
					return true;
				}
			}
			// S'il y a un obstacle, alors la case voisine n'est pas valable
			else {
				return false;
			}
		}
		return true;
	}
	
	protected boolean isCaseValideEau(int next_x, int next_y){
		// Si les coordonnees sont hors des limites, alors case invalide
		if(next_x < 0 || next_x > map.getWidth()-1 || next_y < 0 || next_y > map.getHeight()-1)
			return false;
		else {
			// S'il n'y a pas d'obstacle dans la case voisine
			if(CaseType.getCaseTypeById(map.getTileMap(next_x, next_y), map.getMapType()).isObstacle() == false){
				return true;
			}
			// S'il y a un obstacle, alors la case voisine n'est pas valable
			else
				return false;
		}
	}
	

	public boolean isProie(Pokemon voisin){
		int indexVoisin;
		int currentIndexPokemon;
		
		indexVoisin = voisin.getType();
		currentIndexPokemon = getType();
		// Si le voisin est un Eau
		if(indexVoisin == 1 || indexVoisin == 2 || indexVoisin == 3){
			// Si le Pokemon courant est un feu alors le pokemon courant est une proie
			if(currentIndexPokemon == 4 || currentIndexPokemon == 5 || currentIndexPokemon == 6) return true;
			else return false;
		}
		// Si le voisin est un feu
		if(indexVoisin == 4 || indexVoisin == 5 || indexVoisin == 6){
			// Si le Pokemon courant est un feuille alors le pokemon courant est une proie
			if(currentIndexPokemon == 7 || currentIndexPokemon == 8 || currentIndexPokemon == 9) return true;
			else return false;
		}
		// Si le voisin est une feuille
		if(indexVoisin == 7 || indexVoisin == 8 || indexVoisin == 9){
			// Si le Pokemon courant est un eau alors le pokemon courant est une proie
			if(currentIndexPokemon == 1 || currentIndexPokemon == 2 || currentIndexPokemon == 3) return true;
			else return false;
		}
		return false;
	}
	
	public boolean isOeuf(Pokemon voisin){
		int indexPokemon = voisin.getIndice()%10;
		if(indexPokemon == 8 && this.element == voisin.getElement())
			return true;
		return false;
	}
	
	public boolean isPredateur(Pokemon voisin){
		int indexVoisin;
		int currentIndexPokemon;
		
		indexVoisin = voisin.getType();
		currentIndexPokemon = getType();
			
		// Si le voisin est un Eau
		if(indexVoisin == 1 || indexVoisin == 2 || indexVoisin == 3){
			// Si le Pokemon courant est une feuille alors le pokemon courant est un predateur
			if(currentIndexPokemon == 7 || currentIndexPokemon == 8 || currentIndexPokemon == 9) return true;
			else return false;
		}
		// Si le voisin est un feu
		if(indexVoisin == 4 || indexVoisin == 5 || indexVoisin == 6){
			// Si le Pokemon courant est un eau alors le pokemon courant est un predateur
			if(currentIndexPokemon == 1 || currentIndexPokemon == 2 || currentIndexPokemon == 3){
				return true;
			}
			else return false;
		}
		// Si le voisin est une feuille
		if(indexVoisin == 7 || indexVoisin == 8 || indexVoisin == 9){
			// Si le Pokemon courant est un feu alors le pokemon courant est une predateur
			if(currentIndexPokemon == 4 || currentIndexPokemon == 5 || currentIndexPokemon == 6) return true;
			else return false;
		}
	return false;
	}
	


	public int getVision() {
		// TODO Auto-generated method stub
		return this.vision;
	}

	
}