package fr.upmc.agent;
import fr.upmc.Start;
import fr.upmc.environnement.Map;
import fr.upmc.environnement.MapType;


public class OeufFeu extends Pokemon {
	
	public OeufFeu(int x, int y, Map m) {
		super(x, y, m, 4, 100, "Feu", 0);
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
		map.setPokemon(this.x,this.y, new FeuProie(this.x, this.y, this.map, 4, 100));
		map.getPokeList()[this.x][this.y].setStepDone(true);
	}
	
}
