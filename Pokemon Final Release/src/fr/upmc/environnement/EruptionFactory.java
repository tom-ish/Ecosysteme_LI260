package fr.upmc.environnement;

public class EruptionFactory {

	private Map map;
	private final int[][] myWorldInitial;

	private int height;
	private int width;
	private int cptRoche = 0;
	private int cptRoche2 = 0;


	//Case
	private int lave = CaseType.VILLE_LAVE.getIdentifiant();
	private int burningtree = CaseType.VILLE_BURNINGTREE.getIdentifiant();
	private int tree = CaseType.VILLE_BIGTREE3.getIdentifiant();
	private int croute = CaseType.VILLE_CROUTE.getIdentifiant();
	private	int eau = CaseType.VILLE_WATER.getIdentifiant();
	private int eauInondee = CaseType.VILLE_WATER_INONDEE.getIdentifiant();
	private int sol_montagne2 = CaseType.VILLE_SOL_MONTAGNE2.getIdentifiant();
	private int sol_montagne = CaseType.VILLE_SOL_MONTAGNE.getIdentifiant();
	



	public EruptionFactory(Map m) {
		this.map = m;

		update();
		myWorldInitial = new int[map.getWidth()][map.getHeight()];

		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				myWorldInitial[i][j] = map.getMyWorld()[i][j];
			}
		}
		
	}

	public TypeEvenement typeEvenement() {
		return TypeEvenement.ERUPTION;
	}

	public static void initEruption(int[][] myWorld) {
		
		myWorld[6][5] = 50000; // Debut Eruption
		
	}
	
	public void update() {
		if(MapVille.isEruptionActive){
			debutEruption();
			MapVille.cptLave++;
		}
		if(MapVille.cptLave > MapVille.nbEruptionLimite){
			MapVille.isEruptionActive = false;
			if (cptRoche == MapVille.nbEruptionLimite){
				resetMontagne();
			} else {
				cptRoche++;
			}
			if (cptRoche2 == (MapVille.nbEruptionLimite)*2){
				resetMontagne();
			} else {
				cptRoche2++;
			}
		}
		
	}

	private void debutEruption() {
		int height = map.myWorld[0].length;
		int width = map.myWorld.length;
		int _orient = 0;
		
		int[][] buffer = new int[width][height];
		// affichage etat actuel
		for (int i = 0; i < map.myWorld.length; i++)
			for (int j = 0; j < map.myWorld[0].length; j++) {
				buffer[i][j] = map.myWorld[i][j];
			}
		
		for (int x = 0; x != map.myWorld.length; x++) {
			for (int y = 0; y != map.myWorld[0].length; y++) {
				
				
				if (x > 0 && x < width - 1 && y > 0 && y < height - 1) {
					if (map.myWorld[x][y] == lave && (map.altitude[x][y] == 4 || map.altitude[x][y] == 3 || map.altitude[x][y] == 2 )) {
						if (Math.random() > 0.5) // au hasard
							_orient = (_orient + 1) % 4; 
						else
						if(map.altitude[x][y] != 0){
							_orient = (_orient - 1 + 4) % 4;

						switch (_orient) {
						case 0: // nord
							if (map.myWorld[x][y - 1] == tree) {
								buffer[x][y - 1] = burningtree;
							} else if ( map.myWorld[x][y - 1] == eau || map.myWorld[x][y - 1] == eauInondee){
								buffer[x][y - 1] = croute;
							} else if (map.myWorld[x][y - 1] != lave && map.myWorld[x][y - 1] != croute ) {
								buffer[x][y - 1] = lave;
								if (map.isPokemon(x, y - 1) == true && map.getPokemon(x, y - 1).getElement() != "Feu"){
									map.getPokeList()[x][y - 1] = null;
								}
							}
							break;
						case 1: // est
							if (map.myWorld[x + 1][y] == tree){
								buffer[x + 1][y]= burningtree;								
							} else if (map.myWorld[x + 1][y] == eau || map.myWorld[x + 1][y] == eauInondee ){
								buffer[x + 1][y] = croute;
							} else if ( map.myWorld[x + 1][y] != lave && map.myWorld[x + 1][y] != croute ){
								buffer[x + 1][y] = lave;
								if (map.isPokemon(x + 1, y) == true && map.getPokemon(x + 1, y).getElement() != "Feu"){
									map.getPokeList()[x + 1][y] = null;
								}
							}
							break;
						case 2: // sud
							if (map.myWorld[x][y + 1] == tree){
								buffer[x][y + 1]= burningtree;				
							} else if (map.myWorld[x][y + 1] ==  eau || map.myWorld[x][y + 1] == eauInondee ){
								buffer[x][y + 1] = croute;
							} else if ( map.myWorld[x][y + 1] != lave && map.myWorld[x][y + 1] != croute ){
								buffer[x][y + 1] = lave;
								if (map.isPokemon(x, y + 1) == true && map.getPokemon(x, y + 1).getElement() != "Feu"){
									map.getPokeList()[x][y + 1] = null;
								}
							}
							break;
						case 3: // ouest
							if (map.myWorld[x - 1][y] == tree){
								buffer[x - 1][y]= burningtree;								
							} else  if (map.myWorld[x - 1][y] == eau || map.myWorld[x - 1][y] == eauInondee ){
								buffer[x - 1][y] = croute;
							} else if ( map.myWorld[x - 1][y] != lave && map.myWorld[x - 1][y] != croute){
								buffer[x - 1][y] = lave;
								if (map.isPokemon(x - 1, y) == true && map.getPokemon(x - 1,y).getElement() != "Feu"){
									map.getPokeList()[x - 1][y] = null;
								}
							}
							break;
						}
							
						}

					}
				}
				
			}
		}

		// affichage du nouveau tableau
		for (int i = 0; i < map.myWorld.length; i++) {
			for (int j = 0; j < map.myWorld[0].length; j++) {
				if (MapVille.cptLave + 1 == MapVille.nbEruptionLimite ){
					if (map.myWorld[i][j] == lave ){
						buffer[i][j] = croute;
					}
				}
				map.myWorld[i][j] = buffer[i][j];
			}
		}
	}
	
	private void resetMontagne() {
		for (int x = 0; x != map.myWorld.length; x++) {
			for (int y = 0; y != map.myWorld[0].length; y++) {
				
				if(x < 25 && y < 16){
					if(map.myWorld[x][y] == croute){
						map.myWorld[x][y] = sol_montagne2;
					} 
					if(cptRoche2 == (MapVille.nbEruptionLimite)*2 && map.myWorld[x][y] == sol_montagne2 ){
						map.myWorld[x][y] = sol_montagne;
						map.myWorld[5][2] = 81;
						map.myWorld[5][3] = 82;
						map.myWorld[5][4] = 83;
						map.myWorld[6][2] = 84;
						map.myWorld[6][3] = 50000;
						map.myWorld[6][4] = 86;
						map.myWorld[7][2] = 87;
						map.myWorld[7][3] = 88;
						map.myWorld[7][4] = 89;
					}
				}
			}
		}
	}
}
	
	


