package fr.upmc.agent;

import fr.upmc.Start;
import fr.upmc.environnement.Map;

public class OeufEau extends Pokemon {
	
	public OeufEau(int x, int y, Map m){
		super(x, y, m, 1, 100, "Eau", 0);
		// TODO Auto-generated constructor stub
		this.orientation = 8;
		afficherPokemon(this);
	}

	@Override
	public void step() {
		if(this.age == 25)
			evolution();
		stepDone = true;
		age++;
	}

	@Override
	public void doStep() {
		step();

	}
	
	protected void evolution(){
		map.setPokemon(this.x, this.y, null);
		map.setPokemon(this.x, this.y, new EauProie(this.x, this.y, this.map, 1, 100));
		map.getPokeList()[this.x][this.y].setStepDone(true);
	}
}