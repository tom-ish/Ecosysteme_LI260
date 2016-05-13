package fr.upmc.environnement;

import java.util.ArrayList;
import java.util.Arrays;

import fr.upmc.agent.EauPredateur;
import fr.upmc.agent.EauProie;
import fr.upmc.agent.EauReproducteur;
import fr.upmc.agent.FeuPredateur;
import fr.upmc.agent.FeuProie;
import fr.upmc.agent.FeuReproducteur;
import fr.upmc.agent.FeuillePredateur;
import fr.upmc.agent.FeuilleProie;
import fr.upmc.agent.FeuilleReproducteur;
import fr.upmc.agent.OeufEau;
import fr.upmc.agent.OeufFeu;
import fr.upmc.agent.OeufFeuille;
import fr.upmc.agent.Pokemon;

public abstract class Map {
	protected final MapType mapType;
	protected static boolean isTsunamiActive = false;
	protected boolean isTsunamiReset = true;
	
	private FeuFactory feudeforet;

	// attrbuts MAP

	public int[][] myWorld;
	public int[][] altitude;
	public int width;
	public int height;

	public final static int SPRITE_SIZE = 16;

	// attributs MONSTRES

	protected Pokemon[][] tab_pokemon;

	protected int nbMonstre;

	// attributs de la classe My_Ecosystem_Predprey
	int displaySpeed = 1;

	public Map(int nbPokemon, MapType mapType) {
		this.nbMonstre = nbPokemon;
		this.mapType = mapType;
		initMap();
		initAltitude();
		initPokemon();
		initEvents();
	}


	protected abstract void initAltitude();
	protected abstract void initMap();
	protected abstract void initPokemon();
	protected abstract void action();
	protected abstract void initEvents();
	
	/////////////////////////////////////////////////////////////
	
	

	public void positionnerOeufFeu(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new OeufFeu(x,y,this);
	}
	
	public void positionnerOeufEau(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new OeufEau(x,y,this);
	}
	
	public void positionnerOeufFeuille(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new OeufFeuille(x,y,this);
	}
	
	public void positionnerCarapuce(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new EauProie(x,y,this,1,100);
	}

	public void positionnerCarabaffe(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new EauReproducteur(x,y,this,2,100);
	}
	
	public void positionnerTortank(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new EauPredateur(x,y,this,3,100);
	}
	
	public void positionnerSalameche(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new FeuProie(x,y,this,4,100);
	}
	
	public void positionnerReptincel(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new FeuReproducteur(x,y,this,5,100);
	}
	
	public void positionnerDracaufeu(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new FeuPredateur(x,y,this,6,100);
	}
	
	public void positionnerBulbizarre(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new FeuilleProie(x,y,this,7,100);
	}
	
	public void positionnerHerbizarre(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new FeuilleReproducteur(x,y,this,8,100);
	}
	
	public void positionnerFlorizarre(){
		int x, y;
		do{
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);
		}while(isObstacle(x,y));
		tab_pokemon[x][y] = new FeuillePredateur(x,y,this,9,100);
	}

	/////////////////////////////////////////////////////////////

	public void updatePokemon() {
		if(Math.random() < 0.33){
			for(int i = 0; i < getPokeList().length; i++)
				for(int j = 0; j < getPokeList()[0].length; j++)
					if(tab_pokemon[i][j] != null)
						if(tab_pokemon[i][j].getElement() == "Feu"){
							if(tab_pokemon[i][j].isStepDone() == false)
								tab_pokemon[i][j].step();
						}else if(tab_pokemon[i][j].getElement() == "Eau"){
							if(tab_pokemon[i][j].isStepDone() == false)
								tab_pokemon[i][j].step();
						}else
							if(tab_pokemon[i][j].isStepDone() == false)
								tab_pokemon[i][j].step();
		}
		else if(Math.random() < 0.66){
			for(int i = 0; i < getPokeList().length; i++)
				for(int j = 0; j < getPokeList()[0].length; j++)
					if(tab_pokemon[i][j] != null)
						if(tab_pokemon[i][j].getElement() == "Eau"){
							if(tab_pokemon[i][j].isStepDone() == false)
								tab_pokemon[i][j].step();
						}else if(tab_pokemon[i][j].getElement() == "Feuille"){
							if(tab_pokemon[i][j].isStepDone() == false)
								tab_pokemon[i][j].step();
						}else
							if(tab_pokemon[i][j].isStepDone() == false)
								tab_pokemon[i][j].step();
		}
		else{
			for(int i = 0; i < getPokeList().length; i++)
				for(int j = 0; j < getPokeList()[0].length; j++)
					if(tab_pokemon[i][j] != null)
						if(tab_pokemon[i][j].getElement() == "Feuille"){
							if(tab_pokemon[i][j].isStepDone() == false)
								tab_pokemon[i][j].step();
						}else if(tab_pokemon[i][j].getElement() == "Eau"){
							if(tab_pokemon[i][j].isStepDone() == false)
								tab_pokemon[i][j].step();
						}else
							if(tab_pokemon[i][j].isStepDone() == false)
								tab_pokemon[i][j].step();
		}

		for(int i = 0; i < getPokeList().length; i++)
			for(int j = 0; j < getPokeList()[0].length; j++)
				if(tab_pokemon[i][j] != null)
					tab_pokemon[i][j].setStepDone(false);
		System.out.println("il y a " + getNbPokemon() + " Pokemons");
	}

	public Pokemon[][] getPokeList() {
		return this.tab_pokemon;
	}

	// //////////////////////////////////////////////////////////

	public int[][] getMyWorld() {
		return myWorld;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getTileMap(int x, int y) {
		if(x >= 0 && y >= 0 && x < this.width && y < this.height)
			return this.myWorld[x][y];
		else 
			return -1;
	}
	
	public MapType getMapType(){
		return this.mapType;
	}

	// //////////////////////////////////////////////////////////

		/**
		 * on considere obstacle et eau pour les pokemons
		 */
		public boolean isObstacle(int x, int y) {
			CaseType caseType = CaseType.getCaseTypeById(getTileMap(x, y), mapType);
			if(caseType!=null) {
				return caseType.isObstacle() || caseType.isEau();
			} else {
				return true;
			}
		}

		public boolean isPokemon(int x, int y){
			if(tab_pokemon[x][y] != null) return true;
			else return false;
		}
		
		public boolean isOeuf(int x, int y){
			if(x >= 0 && x < getWidth()-1 && y >= 0 && y < getHeight()-1){
				if(tab_pokemon[x][y] != null)
					if(tab_pokemon[x][y].getOrientation() == 8) return true;
			}
			return false;
		}

		public void setTileMap(int x, int y, int type) {
			this.myWorld[x][y] = type;

		}

		public Pokemon getNearestPokemon(int x, int y, int champ){
			double distance = Math.sqrt(2*getPokemon(x,y).getVision()) + 1;
			double distance_min = distance;
			int x_tmp = -1;
			int y_tmp = -1;
			for(int i = x - champ; i <= x + champ; i++)
				for(int j = y - champ; j <= y + champ; j++)
					if(i == x && j == y)
						continue;
					else if(i < 0 || i >= getPokeList().length || j < 0 || j >= getPokeList()[0].length)
						continue;
					else{
						//System.out.println("i vaut: " + i + ", j vaut " + j);
						if(tab_pokemon[i][j] != null){
							distance = Math.sqrt(((i-x)*(i-x))+((j-y)*(j-y)));
							if(distance < distance_min){
								distance_min = distance;
								x_tmp = i;
								y_tmp = j;
							}
						}
					}
			if(x_tmp == -1 || y_tmp == -1) return null;
			return getPokeList()[x_tmp][y_tmp];
		}

		public Pokemon getPokemon(int x, int y){
			return tab_pokemon[x][y];
		}
		
		public void setPokemon(int x, int y, Pokemon pokemon) {
			// TODO Auto-generated method stub
			tab_pokemon[x][y] = pokemon;
		}
		
		public int getNbPokemon(){
			int nbPokemon = 0;
			for(int i = 0; i < this.width; i++)
				for(int j = 0; j < this.height; j++)
					if(this.getPokeList()[i][j] != null)
						nbPokemon++;
			return nbPokemon;
		}
		
		/////////////////////////////////////////////////////////////
		
		public int getAltitude(int x, int y){
			return this.altitude[x][y];
		}
		
		/////////////////////////////////////////////////////////////
		
		public boolean isSable(int x, int y){
			if(x >= 0 && x < getWidth() && y >= 0 && y < getHeight())
				if(myWorld[x][y]%100 == 3 && myWorld[x][y]/100 == 0) return true;
			return false;
		}
		
		public boolean isHerbe(int x, int y){
			if(x >= 0 && x < getWidth() && y >= 0 && y < getHeight())
				if(myWorld[x][y]%100 == 1 && myWorld[x][y]/100 == 0) return true;
			return false;
		}
		
		public boolean isTsunamiActive(){
			return isTsunamiActive;
		}

}