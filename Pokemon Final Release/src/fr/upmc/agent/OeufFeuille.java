package fr.upmc.agent;

import fr.upmc.Start;
import fr.upmc.environnement.Map;

public class OeufFeuille extends Pokemon {

	public OeufFeuille(int x, int y, Map m) {
		super(x, y, m, 7, 100, "Feuille", 0);
		// TODO Auto-generated constructor stub
		this.orientation = 8;
		afficherPokemon(this);
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		if(this.age == 25)
			evolution();
		stepDone = true;
		age++;
	}

	@Override
	public void doStep() {
		// TODO Auto-generated method stub
		step();
	}

	protected void evolution(){
		map.setPokemon(this.x, this.y, null);
		map.setPokemon(this.x,this.y, new FeuilleProie(this.x, this.y, this.map, 7, 100));
		map.getPokeList()[this.x][this.y].setStepDone(true);
	}
}
