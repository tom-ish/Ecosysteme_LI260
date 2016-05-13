package fr.upmc.agent;
import fr.upmc.environnement.Map;


public class EauProie extends PokeProie	{

	public EauProie(int x, int y, Map m, int type, int life) {
		super(x, y, m, type, life, "Eau", 25);
		
	}
	
	@Override
	public void doStep()
	{
		if(this.age == 50){
			evolution();
		}
		else{
			// met a jour le pokemon
			//deplacementProie();
			deplacerEau();

			stepDone = true;
		}
	}

	
}
