package fr.upmc.environnement;

public class FeuFactory {
	private Map map;
	private int height;
	private int width;
	private	int burningtree = CaseType.VILLE_BURNINGTREE.getIdentifiant();
	private int cendre = CaseType.VILLE_CENDRE.getIdentifiant();
	
	

	public FeuFactory(Map m) {
		this.map = m;
		height = map.getHeight();
		width = map.getWidth();
		
	}
	
	

	public int[][]getMyWorld(){
		return map.myWorld;
	}

	public TypeEvenement typeEvenement() {
		return TypeEvenement.FEU_DE_FORET;
	}

//	public void initFeudeforet(int x, int y) {
//		map.myWorld[x][y] = burningtree; //Debut feudeforet
//		MapVille.feuIsActive = true;
//	}

	public void update() {
		if(!MapVille.pluieIsActive && !MapVille.feuIsActive){
		} else if (MapVille.pluieIsActive){
			finFeu();
			MapVille.feuIsActive = false;
		} else if (MapVille.feuIsActive) {
			debutFeu();
		}
	}
		
		private void debutFeu() {
			int height = map.myWorld[0].length;
			int width = map.myWorld.length;
			int [][]buffer = new int[map.myWorld.length][map.myWorld[0].length];

			//affichage etat actuel
					for(int i = 0; i < width; i++)
						for(int j = 0; j < height; j++){
							buffer[i][j] = map.myWorld[i][j];
						}
					
					for (int x = 0; x != width; x++) {
						for (int y = 0; y != height; y++) {
							int cpt = 0;
							
							// met a jour l'automate cellulaire (pour la prochaine etape)
							if (map.myWorld[x][y] == 2) {
									if (map.myWorld[x][(y - 1 + height)%height ] == burningtree){
										cpt++;
									}
									if (map.myWorld[(x - 1 + width)%width][y] == burningtree){
										cpt++;
									}
									if (map.myWorld[x][(y + 1 + height)%height] == burningtree){
										cpt++;
									}
									if (map.myWorld[(x + 1 + width)%width][y] == burningtree){
										cpt++;
									}
							}
							
	
							if (map.myWorld[x][y] == 2  && cpt > 0) {
								buffer[x][y] = burningtree;
							} else if (map.myWorld[x][y] == burningtree){
								buffer[x][y] = cendre; 
							}
						}
					}
					

				//affichage du nouveau tableau
				for (int i = 0; i < width; i++) {
					for (int j = 0; j < height; j++) {
						map.myWorld[i][j] = buffer[i][j];
					}
				}
		}

	


	private void finFeu() {
		int height = map.myWorld[0].length;
		int width = map.myWorld.length;
		int [][]buffer = new int[map.myWorld.length][map.myWorld[0].length];

		//affichage etat actuel
				for(int i = 0; i < width; i++)
					for(int j = 0; j < height; j++){
						buffer[i][j] = map.myWorld[i][j];
					}
				
				for (int x = 0; x != width; x++) {
					for (int y = 0; y != height; y++) {
						if (map.myWorld[x][y] == burningtree){
							buffer[x][y] = cendre;
						}
					}
				}
				

			//affichage du nouveau tableau
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					map.myWorld[i][j] = buffer[i][j];
				}
			}
	}
}




