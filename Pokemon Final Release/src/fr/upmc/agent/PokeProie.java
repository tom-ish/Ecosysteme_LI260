package fr.upmc.agent;
import fr.upmc.Start;
import fr.upmc.environnement.Map;


public abstract class PokeProie extends Pokemon{

	protected boolean isAlive;
	
	public PokeProie(int x, int y, Map m, int type, int life, String string, int age) {
		super(x, y, m, type, life, string, age);
		isAlive = true;
	}

	public void step() {
		if(Start.date%3==0){
			doStep();
			// Affichage du predateur
			afficherPokemon(this);
		}
		evolution();
		this.age++;
	}
	
	protected void evolution(){
		if(this.age == 50){
			map.setPokemon(this.x, this.y, null);
			if(this.getElement() == "Feu"){
				map.getPokeList()[this.x][this.y] = new FeuReproducteur(this.x,this.y,this.map,5,100);
				map.getPokeList()[this.x][this.y].setStepDone(true);
			}
			else if(this.getElement() == "Eau"){
				map.getPokeList()[this.x][this.y] = new EauReproducteur(this.x,this.y,this.map,2,100);
				map.getPokeList()[this.x][this.y].setStepDone(true);
			}
			else if(this.getElement() == "Feuille"){
				map.getPokeList()[this.x][this.y] = new FeuilleReproducteur(this.x,this.y,this.map,8,100);
				map.getPokeList()[this.x][this.y].setStepDone(true);
			}
		}
	}
}
	
