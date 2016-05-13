package fr.upmc.environnement;

import fr.upmc.agent.EauPredateur;
import fr.upmc.agent.EauProie;
import fr.upmc.agent.FeuPredateur;
import fr.upmc.agent.FeuProie;
import fr.upmc.agent.Pokemon;

public class MapGrotte extends Map {
	
	public MapGrotte(int nbPokemon) {
		super(nbPokemon, MapType.GROTTE);
	}

	@Override
	protected void initMap() {
		width = 64;
		height = 32;
		myWorld = new int[width][height]; // grotte Map


		// Implementation de la grotte
		for (int i = 0; i != width; i++) {
			for (int j = 0; j != height; j++) {
				myWorld[i][j] = CaseType.GROTTE_CAVE.getIdentifiant();// sol grotte

				if ((i > 5 && i < 61) && (j > 2 && j < 28)) { // sand
					myWorld[i][j] = 5;
				}
				if ((i > 4 && i < 7) && (j > 2 && j < 5)) { // coin gauche sol
															// grotte
					myWorld[i][j] = CaseType.GROTTE_CAVE.getIdentifiant();
				} else if (i > 51 && (j < 5 && j < 8)) // coin droit sol grotte
					myWorld[i][j] = CaseType.GROTTE_CAVE.getIdentifiant();
				else if (i > 57 && (j < 8))
					myWorld[i][j] = CaseType.GROTTE_CAVE.getIdentifiant();
				else if (i > 59 && j > 22)
					myWorld[i][j] = CaseType.GROTTE_CAVE.getIdentifiant();
				else if ((i == 5) && (j > 5 && j < 28)) // paroi Gauche
					myWorld[i][j] = 6;
				else if ((i == 4) && (j > 1 && j < 28)) // paroi double Gauche
					myWorld[i][j] = 6;
				else if ((i == 7) && (j > 2 && j < 5))
					myWorld[i][j] = 6;
				else if ((i == 1) && (j > 12 && j < 28))
					myWorld[i][j] = 6;
				else if ((i == 1) && (j == 12))
					myWorld[i][j] = 30;
				else if (i == 51 && (j > 1 && j < 5)) // paroi Droite
																	// sol
																	// grotte
					myWorld[i][j] = 34;
				else if (i == 57 && (j > 5 && j < 8))
					myWorld[i][j] = 34;
				else if (i == 61 && (j > 10 && j < 23))
					myWorld[i][j] = 7;
				else if (i == 62 && (j > 8 && j < 23)) // paroi double haute
															// droite
					myWorld[i][j] = 34;
				else if (i == 59 && (j > 22 && j < 28))
					myWorld[i][j] = 7;
				else if ((i == 35) && (j > 2 && j < 10))
					myWorld[i][j] = 7;
				else if ((i > 7 && i < 35) && (j > 1 && j < 3)) // paroi Haute
					myWorld[i][j] = 8;
				else if ((i > 4 && i < 51) && (j > 0 && j < 2)) // paroi double
																// Haute
					myWorld[i][j] = 8;
				else if ((i > 5 && i < 7) && (j > 4 && j < 6)) // paroi Haute
					myWorld[i][j] = 8;
				else if ((i > 51 && i < 57) && (j > 4 && j < 6)) // paroi Haute
					myWorld[i][j] = 8;
				else if ((i > 57 && i < 62) && (j == 8)) // paroi Haute
					myWorld[i][j] = 8;
				else if ((i > 35 && i < 61) && (j == 10)) // paroi Haute
					myWorld[i][j] = 8;
				else if ((i > 35 && i < 62) && (j > 1 && j < 10)) // sol grotte
																	// ilot
					myWorld[i][j] = CaseType.GROTTE_CAVE.getIdentifiant();
				else if ((i > 23) && (j > 27 && j < 29)) // paroi Basse Droite
					myWorld[i][j] = 13;
				if ((i > 59) && (j == 23)) // paroi Basse Droite
					myWorld[i][j] = 13;
				else if ((i < 20) && (j > 27 && j < 29)) // paroi Basse Gauche
					myWorld[i][j] = 13;
				else if ((i < 1) && (j == 12)) // paroi Basse Gauche
					myWorld[i][j] = 13;
				else if ((i > 19 && i < 24) && (j > 27 && j < 32)) // sortie eau
																	// Basse
					myWorld[i][j] = 17;
				else if ((i > 12 && i < 29) && (j > 23 && j < 28)) // eauNiv4
					myWorld[i][j] = 17;
				else if ((i > 12 && i < 29) && (j > 21 && j < 24)) // eauNiv45
					myWorld[i][j] = 26;
				else if ((i > 10 && i < 13) && (j > 23 && j < 28)) // eauNiv45
					myWorld[i][j] = 26;
				else if ((i > 28 && i < 31) && (j > 23 && j < 28)) // eauNiv45
					myWorld[i][j] = 26;
				else if ((i > 5 && i < 36) && (j > 20 && j < 28)) // eauNiv3
					myWorld[i][j] = 18;
				else if ((i > 10 && i < 31) && (j > 16 && j < 21)) // eauNiv3
					myWorld[i][j] = 18;
				else if ((i > 15 && i < 26) && (j > 14 && j < 17)) // eauNiv3
					myWorld[i][j] = 18;
				else if ((i > 5 && i < 38) && (j > 17 && j < 28)) // eauNiv2
					myWorld[i][j] = 19;
				else if ((i > 7 && i < 33) && (j > 15 && j < 28)) // eauNiv2
					myWorld[i][j] = 19;
				else if ((i > 13 && i < 29) && (j > 13 && j < 28)) // eauNiv2
					myWorld[i][j] = 19;
				else if ((i > 16 && i < 26) && (j > 11 && j < 28)) // eauNiv2
					myWorld[i][j] = 19;
				if ((i == 19) && (j > 27 && j < 32)) // paroi eau gauche
					myWorld[i][j] = 6;
				if ((i == 23) && (j > 27 && j < 32)) // paroi eau droite
					myWorld[i][j] = 7;

			}
		}
		// creuxEauNiv3G
		myWorld[10][20] = 20;
		myWorld[15][16] = 20;
		// creuxEauNiv3D
		myWorld[31][20] = 21;
		myWorld[36][27] = 21;
		myWorld[26][16] = 21;
		myWorld[6][20] = 21;
		// creuxEauNiv2G
		myWorld[7][17] = 22;
		myWorld[13][15] = 22;
		myWorld[16][13] = 22;
		// creuxEauNiv2D
		myWorld[29][15] = 23;
		myWorld[33][17] = 23;
		myWorld[26][13] = 23;
		myWorld[38][27] = 23;
		// coinEau
		myWorld[19][28] = 27;
		// coinEauD
		myWorld[23][28] = 28;
		// coinSandDroit
		myWorld[59][23] = 29;
		// entree
		myWorld[51][28] = 31;

		// ilot

		// coin/creux
		myWorld[35][2] = 11;
		myWorld[35][10] = 12;
		myWorld[61][10] = 11;
		// climb
		myWorld[40][10] = 33;

		// paroi double haute
		myWorld[4][1] = 10;// creux double gauche
		myWorld[51][1] = 11;

		// coin Gauche
		myWorld[7][5] = 9;
		// creux Gauche
		myWorld[7][2] = 10;
		myWorld[5][5] = 10;
		// creux Droit
		myWorld[57][5] = 11;
		// creux Droit
		myWorld[62][8] = 11;
		// coin Droit
		myWorld[51][5] = 12;
		// coin Droit
		myWorld[57][8] = 12;
		
	}

	
	protected void initPokemon() {
		tab_pokemon = new Pokemon[width][height];
		for(int i = 0; i < nbMonstre; i++){
			positionnerCarapuce();
			positionnerTortank();
			positionnerSalameche();
		}
	}
	
	protected void initAltitude(){
		altitude = new int[this.getWidth()][this.getHeight()];
		for(int i = 0; i < this.getWidth(); i++)
			for(int j = 0; j < this.getHeight(); j++){
				altitude[i][j] = 0;// sol grotte

				if ((i > 5 && i < 61) && (j > 2 && j < 28)) { // sand
					altitude[i][j] = -4;
				}
				if ((i > 4 && i < 7) && (j > 2 && j < 5)) { // coin gauche sol
															// grotte
					altitude[i][j] = -2;
				} else if (i > 51 && j < 8) // coin droit sol grotte
					altitude[i][j] = -2;
				else if (i > 59 && j > 22)
					altitude[i][j] = 0;	// etage le plus haut de la map
				else if ((i == 5) && (j > 5 && j < 28)) // paroi Gauche
					altitude[i][j] = -3;
				else if ((i == 4) && (j > 1 && j < 28)) // paroi double Gauche
					altitude[i][j] = -1;
				else if ((i == 7) && (j > 2 && j < 5))
					altitude[i][j] = -3;
				else if ((i == 1) && (j > 12 && j < 28))
					altitude[i][j] = 0;	// paroi la plus a gauche
				else if ((i == 1) && (j == 12))
					altitude[i][j] = 0; // Coin de la paroi la plus a gauche
				else if ((i > 50 && i < 52) && (j > 1 && j < 5)) // paroi Droite
																	// sol
																	// grotte
					altitude[i][j] = -1;
				else if (i == 57 && (j > 5 && j < 8))
					altitude[i][j] = -1;
				else if (i == 61 && (j > 10 && j < 23))
					altitude[i][j] = -3;
				else if ((i == 62) && (j > 8 && j < 23)) // paroi double haute
															// droite
					altitude[i][j] = -1;
				else if (i == 59 && (j > 22 && j < 28))
					altitude[i][j] = -3;
				else if ((i == 35) && (j > 2 && j < 10))
					altitude[i][j] = -3;
				else if ((i > 7 && i < 35) && j == 2) // paroi Haute
					altitude[i][j] = -3;
				else if ((i > 4 && i < 51) && j == 1) // paroi double
																// Haute
					altitude[i][j] = -1;
				else if (i == 6 && j == 5) // paroi Haute
					altitude[i][j] = -3;
				else if ((i > 51 && i < 57) && j == 5) // paroi Haute
					altitude[i][j] = -1;
				else if ((i > 57 && i < 62) && (j == 8)) // paroi Haute
					altitude[i][j] = -1;
				else if ((i > 35 && i < 61) && (j == 10)) // paroi Haute
					altitude[i][j] = -3;
				else if ((i > 35 && i < 62) && (j > 1 && j < 10)) // sol grotte
																	// ilot
					altitude[i][j] = -2;
				else if (i > 23 && j == 28) // paroi Basse Droite
					altitude[i][j] = 0;
				if (i > 59 && j == 23) // paroi Basse Droite
					altitude[i][j] = 0;
				else if (i < 20 && j == 28) // paroi Basse Gauche
					altitude[i][j] = 0;
				else if (i == 0 && j == 12) // paroi Basse Gauche
					altitude[i][j] = 0;
				else if ((i > 19 && i < 24) && (j > 27 && j < 32)) // sortie eau
																	// Basse
					altitude[i][j] = -8;
				else if ((i > 12 && i < 29) && (j > 23 && j < 28)) // eauNiv4
					altitude[i][j] = -8;
				else if ((i > 12 && i < 29) && (j > 21 && j < 24)) // eauNiv45
					altitude[i][j] = -7;
				else if ((i > 10 && i < 13) && (j > 23 && j < 28)) // eauNiv45
					altitude[i][j] = -7;
				else if ((i > 28 && i < 31) && (j > 23 && j < 28)) // eauNiv45
					altitude[i][j] = -7;
				else if ((i > 5 && i < 36) && (j > 20 && j < 28)) // eauNiv3
					altitude[i][j] = -6;
				else if ((i > 10 && i < 31) && (j > 16 && j < 21)) // eauNiv3
					altitude[i][j] = -6;
				else if ((i > 15 && i < 26) && (j > 14 && j < 17)) // eauNiv3
					altitude[i][j] = -6;
				else if ((i > 5 && i < 38) && (j > 17 && j < 28)) // eauNiv2
					altitude[i][j] = -5;
				else if ((i > 7 && i < 33) && (j > 15 && j < 28)) // eauNiv2
					altitude[i][j] = -5;
				else if ((i > 13 && i < 29) && (j > 13 && j < 28)) // eauNiv2
					altitude[i][j] = -5;
				else if ((i > 16 && i < 26) && (j > 11 && j < 28)) // eauNiv2
					altitude[i][j] = -5;
				if ((i == 19) && (j > 27 && j < 32)) // paroi eau gauche
					altitude[i][j] = -1;
				if ((i == 23) && (j > 27 && j < 32)) // paroi eau droite
					altitude[i][j] = -1;

		}

		// creuxEauNiv3G
		altitude[10][20] = -5;
		altitude[15][16] = -5;
		// creuxEauNiv3D
		altitude[31][20] = -5;
		altitude[36][27] = -5;
		altitude[26][16] = -5;
		altitude[6][20] = -5;
		// creuxEauNiv2G
		altitude[7][17] = -4;
		altitude[13][15] = -4;
		altitude[16][13] = -4;
		// creuxEauNiv2D
		altitude[29][15] = -4;
		altitude[33][17] = -4;
		altitude[26][13] = -4;
		altitude[38][27] = -4;
		// coinEau
		altitude[19][28] = 0;
		// coinEauD
		altitude[23][28] = 0;
		// coinSandDroit
		altitude[59][23] = -3;
		// entree
		altitude[51][28] = 0;
		altitude[52][28] = 0;
	
		// ilot
	
		// coin/creux
		altitude[35][2] = -3;
		altitude[35][10] = -3;
		altitude[61][10] = -3;
		// climb
		altitude[40][10] = -3;
	
		// paroi double haute
		altitude[4][1] = -1;// creux double gauche
		altitude[51][1] = -1;
	
		// coin Gauche
		altitude[7][5] = -3;
		// creux Gauche
		altitude[7][2] = -3;
		altitude[5][5] = -3;
		// creux Droit
		altitude[57][5] = -1;
		// creux Droit
		altitude[62][8] = -1;
		// coin Droit
		altitude[51][5] = -1;
		// coin Droit
		altitude[57][8] = -1;
		
	}

	public void initEvents(){
//		tsunami = new TsunamiFactory();
	}
	
	public void action(){
		updatePokemon();
		updateEvents();	
	}

	public void updateEvents(){
		//tsunami.update(this.myWorld,this.mapType);
	}

}
