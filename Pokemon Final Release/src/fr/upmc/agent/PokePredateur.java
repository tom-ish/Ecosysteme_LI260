package fr.upmc.agent;
import java.util.ArrayList;

import fr.upmc.environnement.CaseType;
import fr.upmc.environnement.Map;


public abstract class PokePredateur extends Pokemon{

	protected boolean isAlive;
	
	boolean estPredateur;
	public PokePredateur( int _x, int _y, Map __m, int type, int life, String string, int age)
	{
		super(_x,_y,__m, type, life, string, age);
		isAlive = true;
		estPredateur = true;
	}
	
	@Override
	public void step() {
		doStep();
		this.age++;
	}
	

	public boolean isNextOeuf(){
		if(map.isOeuf(this.x+1,this.y) || map.isOeuf(this.x-1,this.y) || map.isOeuf(this.x,this.y+1) || map.isOeuf(this.x,this.y-1))
			return true;
		else return false;
	}
	
	public int getX_oeuf(){
		if(map.isOeuf(this.x+1, this.y))
			return x+1;
		else if(map.isOeuf(this.x-1, this.y))
			return x-1;
		else
			return -1;
	}
	
	public int getY_oeuf(){
		if(map.isOeuf(this.x,this.y+1))
			return y+1;
		else if(map.isOeuf(this.x, this.y-1))
			return y-1;
		else
			return -1;
	}
	
	public void protegeOeuf(Pokemon oeuf){
		final int nord = 0, sud = 2, est = 1, ouest = 3;
		
		boolean nordLibre = isCaseValide(this.x,this.y-1);
		boolean sudLibre = isCaseValide(this.x,this.y+1);
		boolean estLibre = isCaseValide(this.x+1,this.y);
		boolean ouestLibre = isCaseValide(this.x-1,this.y);
		
		ArrayList<Integer> orientationsPossibles = new ArrayList<Integer>();
		
		if(nordLibre) orientationsPossibles.add(0);
		if(sudLibre) orientationsPossibles.add(2);
		if(estLibre) orientationsPossibles.add(1);
		if(ouestLibre) orientationsPossibles.add(3);
		
		if(orientationsPossibles.size() == 0){
			return;
		}
		else{
			direction = choisirDirection(this.x,this.y,oeuf.getX(),oeuf.getY());
			// l'oeuf est au nord ou au sud
			if(direction == 0 || direction == 4){
				if(orientationsPossibles.contains(est) && orientationsPossibles.contains(ouest))
					orientation = random(est,ouest);
				else if(orientationsPossibles.contains(est) && !orientationsPossibles.contains(ouest))
					orientation = est;
				else if(orientationsPossibles.contains(ouest) && !orientationsPossibles.contains(est))
					orientation = ouest;
				else
					orientation = random(orientationsPossibles);
			}
			// l'oeuf est au nord est
			else if(direction == 1){
				if(orientationsPossibles.contains(nord) && orientationsPossibles.contains(est))
					orientation = random(est,nord);
				else if(orientationsPossibles.contains(est) && !orientationsPossibles.contains(nord))
					orientation = est;
				else if(orientationsPossibles.contains(nord) && !orientationsPossibles.contains(est))
					orientation = nord;
				else
					orientation = random(orientationsPossibles);
			}
			// l'oeuf est a l'est ou a l'ouest
			else if(direction == 2 || direction == 6){
				if(orientationsPossibles.contains(nord) && orientationsPossibles.contains(sud))
					orientation = random(sud,nord);
				else if(orientationsPossibles.contains(sud) && !orientationsPossibles.contains(nord))
					orientation = sud;
				else if(orientationsPossibles.contains(nord) && !orientationsPossibles.contains(sud))
					orientation = nord;
				else
					orientation = random(orientationsPossibles);
			}
			// l'oeuf est au sud est
			else if(direction == 3){
				if(orientationsPossibles.contains(est) && orientationsPossibles.contains(sud))
					orientation = random(est,sud);
				else if(orientationsPossibles.contains(sud) && !orientationsPossibles.contains(est))
					orientation = sud;
				else if(orientationsPossibles.contains(est) && !orientationsPossibles.contains(sud))
					orientation = est;
				else
					orientation = random(orientationsPossibles);
			}
			// l'oeuf est au sud ouest
			else if(direction == 5){
				if(orientationsPossibles.contains(ouest) && orientationsPossibles.contains(sud))
					orientation = random(sud,ouest);
				else if(orientationsPossibles.contains(sud) && !orientationsPossibles.contains(ouest))
					orientation = sud;
				else if(orientationsPossibles.contains(ouest) && !orientationsPossibles.contains(sud))
					orientation = ouest;
				else
					orientation = random(orientationsPossibles);
			}
			// l'oeuf est au nord ouest
			else if(direction == 7){
				if(orientationsPossibles.contains(nord) && orientationsPossibles.contains(ouest))
					orientation = random(ouest,nord);
				else if(orientationsPossibles.contains(ouest) && !orientationsPossibles.contains(nord))
					orientation = ouest;
				else if(orientationsPossibles.contains(nord) && !orientationsPossibles.contains(ouest))
					orientation = nord;
				else
					orientation = random(orientationsPossibles);
			}
			
			map.setPokemon(this.x, this.y, null);
			// met a jour: la position de predateur (depend de l'orientation)
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
			map.setPokemon(this.x,this.y,this);
		}
	}
	
	protected void evolution(){
			map.setPokemon(this.x, this.y, null);
	}

}
