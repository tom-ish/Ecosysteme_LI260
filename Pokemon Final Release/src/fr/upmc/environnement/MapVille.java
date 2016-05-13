package fr.upmc.environnement;

import java.nio.MappedByteBuffer;

import fr.upmc.Start;
import fr.upmc.agent.EauPredateur;
import fr.upmc.agent.EauProie;
import fr.upmc.agent.EauReproducteur;
import fr.upmc.agent.FeuPredateur;
import fr.upmc.agent.FeuProie;
import fr.upmc.agent.FeuReproducteur;
import fr.upmc.agent.FeuillePredateur;
import fr.upmc.agent.FeuilleProie;
import fr.upmc.agent.FeuilleReproducteur;
import fr.upmc.agent.OeufEau;
import fr.upmc.agent.OeufFeu;
import fr.upmc.agent.OeufFeuille;
import fr.upmc.agent.Pokemon;

public class MapVille extends Map {
	//boolean
	public static boolean pluieIsActive = true;
	public static boolean brouillardIsActive = false;
	public static boolean feuIsActive = true; 
	public static boolean nuitIsActive = false;
	public static boolean isEruptionActive = false;



	private FeuFactory feu;
	private EruptionFactory eruption;
	private InverseTsunamiFactory reset;
	private TsunamiFactory tsunami;
	
	public static int nbEruptionLimite = /* (int) (Math.random() * 50); */40;

	public static int cptLave = 0;
	private int cptLimiteTsunami = 30;


	public MapVille(int nbPokemon) {
		super(nbPokemon, MapType.VILLE);
	}

	@Override
	protected void initMap() {
		width = 88;
		height = 40;
		myWorld = new int[width][height]; // ville Map

		// Implementation de la map fixe

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

				if (i < 70 && j < 35)
					myWorld[i][j] = 3;
				if (i < 61 && j < 20)
					myWorld[i][j] = 1;

				if (i < 28 && j < 20)
					myWorld[i][j] = 2;
				if (i < 30 && j < 3)
					myWorld[i][j] = 2;
				if (i > 34 && i < 41 && j > 5 && j < 20)
					myWorld[i][j] = 2;
				if (i > 57 && i < 61 && j > 5 && j < 20)
					myWorld[i][j] = 2;
				if (i > 29 && i < 61 && j < 2)
					myWorld[i][j] = 2;
				if (i > 55 && i < 61 && j < 6)
					myWorld[i][j] = 2;
				if (i > 30 && i < 41 && j > 8 && j < 12)
					myWorld[i][j] = 2;
				if (i > 41 && i < 55 && j > 8 && j < 12)
					myWorld[i][j] = 2;
				if (i > 27 && i < 33 && j > 14 && j < 17)
					myWorld[i][j] = 2;
				if (i > 39 && i < 61 && j > 17 && j < 20)
					myWorld[i][j] = 2;

				if ((i > 24) && (i < 41) && (j > 19) && (j < 26))
					myWorld[i][j] = 3;

				if (i < 25) { // implementation de la montagne
					if (j < 16) {
						if (i != 24 && j != 15) {
							if (i == 16 && j == 10)
								myWorld[i][j] = 7;
							else if (i < 16 && j == 10)
								myWorld[i][j] = 5;
							else if (i == 16 && j < 11)
								myWorld[i][j] = 6;
							else
								myWorld[i][j] = 4;
						} else {
							if (i == 24 && j == 15)
								myWorld[i][j] = 7;
							else if (i == 24)
								myWorld[i][j] = 6;
							else
								myWorld[i][j] = 5;
						}

					} else if (j > 25) {
						if (j == 35)
							myWorld[i][j] = 30;
						else if (j < 35)
							myWorld[i][j] = 3;
					} else if (j > 21 && j < 35)
						myWorld[i][j] = 3;
					else if (j == 21)
						myWorld[i][j] = 20;
					else
						myWorld[i][j] = 1;
				}

				else if (j == 20 && i > 25 && i < 60)
					myWorld[i][j] = 20;
				else if (j == 20 && i == 60)
					myWorld[i][j] = 21;
				else if (j == 20 && i == 41)
					myWorld[i][j] = 23;
				else if (j == 20 && i == 25)
					myWorld[i][j] = 22;
				else if (i == 60 && j < 21)
					myWorld[i][j] = 24;
				else if (i > 24 && i < 65 && j == 35)
					myWorld[i][j] = 30;
				else if (i == 70 && j < 30)
					myWorld[i][j] = 31;
				else if (i == 65 && j > 30 && j < 35)
					myWorld[i][j] = 31;
				else if (j == 30 && i > 65 && i < 70)
					myWorld[i][j] = 30;

				if (i < 25 && j > 15 && j < 20) {
					if (i == 10 || i == 11 || i == 12)
						myWorld[i][j] = 1;
					else
						myWorld[i][j] = 2;
				}

				if (i > 65 && j > 30)
					myWorld[i][j] = 0;

			}
		}

		myWorld[11][15] = 8;
		myWorld[65][30] = 32;
		myWorld[65][35] = 33;
		myWorld[70][30] = 33;

		myWorld[6][10] = 80;
		myWorld[18][15] = 80;

		myWorld[5][2] = 81;
		myWorld[5][3] = 82;
		myWorld[5][4] = 83;
		myWorld[6][2] = 84;
		myWorld[6][3] = 50000;
		myWorld[6][4] = 86;
		myWorld[7][2] = 87;
		myWorld[7][3] = 88;
		myWorld[7][4] = 89;

		myWorld[1][0] = 91;
		myWorld[1][1] = 92;
		myWorld[2][1] = 93;
		myWorld[2][0] = 94;

		myWorld[1][3] = 91;
		myWorld[1][4] = 92;
		myWorld[2][4] = 93;
		myWorld[2][3] = 94;

		myWorld[1][6] = 91;
		myWorld[1][7] = 92;
		myWorld[2][7] = 93;
		myWorld[2][6] = 94;

		myWorld[10][0] = 91;
		myWorld[10][1] = 92;
		myWorld[11][1] = 93;
		myWorld[11][0] = 94;

		myWorld[10][3] = 91;
		myWorld[10][4] = 92;
		myWorld[11][4] = 93;
		myWorld[11][3] = 94;

		myWorld[10][6] = 91;
		myWorld[10][7] = 92;
		myWorld[11][7] = 93;
		myWorld[11][6] = 94;
		
		reset = new InverseTsunamiFactory(this);


	}

	//Implementation de l'altitude de la carte
	protected void initAltitude() {
		altitude = new int[width][height];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
		
				if ( i < 24 && j < 15){	
					if (i < 23 && j < 14) {
						altitude[i][j] = 2;
					}
					if (i < 23 && j == 14) {
						altitude[i][j] = 1;
					}
					if( i == 23 && j < 15 ){
						 altitude[i][j] = 1;
					 }
					if (i == 23 && j == 14){
						altitude[i][j] = 1;
					}
					
					if (i < 15 && j < 9) {
						altitude[i][j] = 4;
					}
					if (i == 15 && j == 10) {
						altitude[i][j] = 3;
					}
					if (i == 15 && j < 10) {
						altitude[i][j] = 3;
					}
					if (i < 16 && j == 9) {
						altitude[i][j] = 3;
					}
				} else {
					altitude[i][j] = 0;
				}
				

			}
		}

	}

	@Override
	protected void initPokemon() {
		tab_pokemon = new Pokemon[width][height];
		for(int i = 0; i < nbMonstre; i++){
			positionnerOeufFeu();
			positionnerOeufEau();
			positionnerOeufFeuille();
		}
		tab_pokemon[6][6] = new OeufFeu(6,6,this);
		tab_pokemon[38][28] = new OeufEau(38,28,this);
		tab_pokemon[41][10] = new OeufFeuille(41,10,this);
		
		System.out.println("les Pokemons ont ete places sur la carte");
	}
	
	@Override
	public void initEvents() {
		feu = new FeuFactory(this);
		eruption = new EruptionFactory(this);
		tsunami = new TsunamiFactory(this);

	}
	
	@Override
	public void action() {
		updatePokemon();
		System.out.println("==================== tour "+Start.date+": les pokemons ont ete mis a jour ==================================");
		updateEvents();
		System.out.println("==================== tour "+Start.date+": les evenements ont ete mis a jour ==================================");
	}
	
	public void updateEvents(){
		if(pluieIsActive && Start.date%5 == 0)
			germer();
		updateEruption();
		updateTsunami();
		feu.update();
	}
	
	private void updateTsunami(){
		if (isEruptionActive == true) {
			tsunami.update();
		} else {
			isTsunamiActive = false;
			reset.updateTsunami(myWorld, MapType.VILLE);
		}
	}
	
	private void updateEruption(){
			eruption.update();
	}
	
	private void germer(){
		for(int i = 0; i < this.width; i++)
			for(int j = 0; j < this.height; j++)
				if(this.myWorld[i][j] == 29)
					this.myWorld[i][j] = 2;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////

}
