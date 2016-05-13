package fr.upmc.environnement;

public class InverseTsunamiFactory {
	private final int[][] myWorldInitial;
	private int burningtree = CaseType.VILLE_BURNINGTREE.getIdentifiant();
	private int eauInondee = CaseType.VILLE_WATER_INONDEE.getIdentifiant();
	private int eau = CaseType.VILLE_WATER.getIdentifiant();
	private int sand = CaseType.VILLE_PLAGE.getIdentifiant();

	public InverseTsunamiFactory(Map map) {
		myWorldInitial = new int[map.getWidth()][map.getHeight()];

		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				myWorldInitial[i][j] = map.getMyWorld()[i][j];
			}
		}
	}
	
	public void updateTsunami(int[][] myWorld, MapType mapType) {
		int height = myWorld[0].length;
		int width = myWorld.length;

		int[][] buffer = new int[width][height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (y >= 0 && y < height - 1) {

					if (myWorld[x][y] == eauInondee) {
						buffer[x][y + 1] = eauInondee;
						if ( x < 65 && y < 35) {
							buffer[x][y] = sand;
						} else {
							buffer[x][y] = myWorldInitial[x][y];
						}
					} else if (myWorld[x][y] != eauInondee && myWorld[x][y] != eau) {
						buffer[x][y] = myWorld[x][y];
					}
				}

			}
		}
		// met a jour l'automate cellulaire (pour la prochaine etape)

		// affichage du nouveau tableau
		for (int i = 0; i < myWorld.length; i++) {
			for (int j = 0; j < myWorld[0].length; j++) {
				myWorld[i][j] = buffer[i][j];
			}
		}
	}
	
//	public void updateTsunami(int[][] myWorld, MapType mapType) {
//		int height = myWorld[0].length;
//		int width = myWorld.length;
//
//		int[][] buffer = new int[width][height];



}
