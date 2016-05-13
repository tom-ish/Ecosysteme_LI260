package fr.upmc;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.upmc.environnement.EruptionFactory;
import fr.upmc.environnement.Map;
import fr.upmc.environnement.MapVille;

public class AffichageVille extends JPanel {
	private static final long serialVersionUID = 1L;	
	private int densitePluie = 8;
	private int cptPluieActive = 0;

	public final static int WIDTH = 1650;
	public final static int HEIGTH = 850;
	

	// SPRITES MAP
	
	private Image waterSprite;
	private Image waterSprite2;
	private Image waterSprite3;
	private Image waterSprite4;
	private Image waterSprite5;

	
	private Image grassSprite;
	private Image grassSprite2;
	private Image grassSprite3;
	private Image grassSprite4;
	private Image grassSprite5;
	private Image grassSprite6;
	
	private Image bigtreeSprite3;
	
	private Image beachSprite;
	
	private Image groundSprite;
	private Image ground2Sprite;
	private Image groundSideSprite;
	private Image groundCornerSprite;
	
	private Image caveHoleSprite;
	private Image caveClimbSprite;
	private Image caveSprite10;
	private Image caveSprite11;
	private Image caveSprite12;
	private Image caveSprite13;
	private Image caveSprite15;
	private Image caveSprite16;
	private Image caveSprite17;
	private Image caveSprite18;
	
	private Image cratereSprite1;
	private Image cratereSprite2;
	private Image cratereSprite3;
	private Image cratereSprite4;
	
	
	//////////////////////
	
	// SPRITES POKEMONS
	
	private Image oeufFeuSprite;
	private Image oeufEauSprite;
	private Image oeufFeuilleSprite;
	
	private Image carapuceNordSprite;
	private Image carapuceSudSprite;
	private Image carapuceEstSprite;
	private Image carapuceOuestSprite;

	private Image carabaffeNordSprite;
	private Image carabaffeSudSprite;
	private Image carabaffeEstSprite;
	private Image carabaffeOuestSprite;
	
	private Image tortankNordSprite;
	private Image tortankSudSprite;
	private Image tortankEstSprite;
	private Image tortankOuestSprite;
	
	private Image salamecheNordSprite;
	private Image salamecheSudSprite;
	private Image salamecheEstSprite;
	private Image salamecheOuestSprite;
	
	private Image reptincelNordSprite;
	private Image reptincelSudSprite;
	private Image reptincelEstSprite;
	private Image reptincelOuestSprite;
	
	private Image dracaufeuNordSprite;
	private Image dracaufeuSudSprite;
	private Image dracaufeuEstSprite;
	private Image dracaufeuOuestSprite;
	
	private Image bulbizarreNordSprite;
	private Image bulbizarreSudSprite;
	private Image bulbizarreEstSprite;
	private Image bulbizarreOuestSprite;
	
	private Image herbizarreNordSprite;
	private Image herbizarreSudSprite;
	private Image herbizarreEstSprite;
	private Image herbizarreOuestSprite;
	
	private Image florizarreNordSprite;
	private Image florizarreSudSprite;
	private Image florizarreEstSprite;
	private Image florizarreOuestSprite;
	private Image florizarreBlockedSprite;
	
	//////////////////////
	
	// SPRITES EVENTS
	
	private Image croute_hSprite;
	private Image croute_vSprite;
	private Image croute_lave_hSprite;
	private Image croute_lave_vSprite;
	
	private Image tsunamiSprite;
	private Image crouteSprite;
	private Image brouillardSprite;
	private Image nuitSprite;
	private Image pluieSprite;
	private Image burningtreeSprite;
	private Image cendreSprite;
	private Image laveSprite;
	private Image sol_montagne2Sprite;

	private Image graineSprite;
	
	//////////////////////



	private int spriteLength;

	private Map map;

	public AffichageVille(Map m) {
		readSprites();

		setMap(m);
		this.spriteLength = Map.SPRITE_SIZE;
	}

	public void setMap(Map myWorld) {
		this.map = myWorld;
	}

	private void readSprites() {
		try {
			// read sprites pokemon
						oeufFeuSprite = ImageIO.read(new File("oeufFeu.png"));
						oeufEauSprite = ImageIO.read(new File("oeufEau.png"));
						oeufFeuilleSprite = ImageIO.read(new File("oeufFeuille.png"));
			
						carapuceNordSprite = ImageIO.read(new File("carapuce_nord.gif"));
						carapuceSudSprite = ImageIO.read(new File("carapuce_sud.gif"));
						carapuceEstSprite = ImageIO.read(new File("carapuce_est.gif"));
						carapuceOuestSprite = ImageIO.read(new File("carapuce_ouest.gif"));
						
						carabaffeNordSprite = ImageIO.read(new File("carabaffe_nord.gif"));
						carabaffeSudSprite = ImageIO.read(new File("carabaffe_sud.gif"));
						carabaffeEstSprite = ImageIO.read(new File("carabaffe_est.gif"));
						carabaffeOuestSprite = ImageIO.read(new File("carabaffe_ouest.gif"));
						
						tortankNordSprite = ImageIO.read(new File("tortank_nord.gif"));
						tortankSudSprite = ImageIO.read(new File("tortank_sud.gif"));
						tortankEstSprite = ImageIO.read(new File("tortank_est.gif"));
						tortankOuestSprite = ImageIO.read(new File("tortank_ouest.gif"));
						
						salamecheNordSprite = ImageIO.read(new File("salameche_nord.gif"));
						salamecheSudSprite = ImageIO.read(new File("salameche_sud.gif"));
						salamecheEstSprite = ImageIO.read(new File("salameche_est.gif"));
						salamecheOuestSprite = ImageIO.read(new File("salameche_ouest.gif"));
						
						reptincelNordSprite = ImageIO.read(new File("reptincel_nord.gif"));
						reptincelSudSprite = ImageIO.read(new File("reptincel_sud.gif"));
						reptincelEstSprite = ImageIO.read(new File("reptincel_est.gif"));
						reptincelOuestSprite = ImageIO.read(new File("reptincel_ouest.gif"));
						
						dracaufeuNordSprite = ImageIO.read(new File("dracaufeu_nord.gif"));
						dracaufeuSudSprite = ImageIO.read(new File("dracaufeu_sud.gif"));
						dracaufeuEstSprite = ImageIO.read(new File("dracaufeu_est.gif"));
						dracaufeuOuestSprite = ImageIO.read(new File("dracaufeu_ouest.gif"));

						bulbizarreNordSprite = ImageIO.read(new File("bulbizarre_nord.gif"));
						bulbizarreSudSprite = ImageIO.read(new File("bulbizarre_sud.gif"));
						bulbizarreEstSprite = ImageIO.read(new File("bulbizarre_est.gif"));
						bulbizarreOuestSprite = ImageIO.read(new File("bulbizarre_ouest.gif"));

						herbizarreNordSprite = ImageIO.read(new File("herbizarre_nord.gif"));
						herbizarreSudSprite = ImageIO.read(new File("herbizarre_sud.gif"));
						herbizarreEstSprite = ImageIO.read(new File("herbizarre_est.gif"));
						herbizarreOuestSprite = ImageIO.read(new File("herbizarre_ouest.gif"));
					
						florizarreNordSprite = ImageIO.read(new File("florizarre_nord.gif"));
						florizarreSudSprite = ImageIO.read(new File("florizarre_sud.gif"));
						florizarreEstSprite = ImageIO.read(new File("florizarre_est.gif"));
						florizarreOuestSprite = ImageIO.read(new File("florizarre_ouest.gif"));
						florizarreBlockedSprite = ImageIO.read(new File("florizarre_blocked.png"));
						
						// read sprites events
						crouteSprite = ImageIO.read(new File("croute.png")); //case 70
						croute_hSprite = ImageIO.read(new File("croute_h.png")); //case 10000
						croute_vSprite = ImageIO.read(new File("croute_v.png")); //case 20000
						croute_lave_hSprite = ImageIO.read(new File("croute_lave_h.png")); //case 80000
						croute_lave_vSprite = ImageIO.read(new File("croute_lave_v.png")); //case 90000
						sol_montagne2Sprite = ImageIO.read(new File("sol_montagne2.png")); // case = 100000


						brouillardSprite = ImageIO.read(new File("brouillard.png")); // case = 100000
						nuitSprite = ImageIO.read(new File("nuit.png")); // case = 200000
						pluieSprite = ImageIO.read(new File("pluie.png"));
						tsunamiSprite = ImageIO.read(new File("tsunami.png")); // case = 40000
						burningtreeSprite = ImageIO.read(new File("burningtree.png")); // case = 600000
						laveSprite = ImageIO.read(new File("lave.png")); 	  // case = 50000
						cendreSprite = ImageIO.read(new File("cendre.png")); // case = 70000
						
						graineSprite = ImageIO.read(new File("graine.png"));	// case = 29


			
						// read sprites map
						waterSprite = ImageIO.read(new File("water.png"));						// case = 0
						waterSprite2 = ImageIO.read(new File("water_plage.png"));				// case = 30
						waterSprite3 = ImageIO.read(new File("water_plage_cote.png"));			// case = 31
						waterSprite4 = ImageIO.read(new File("water_plage_coin.png"));			// case = 32
						waterSprite5 = ImageIO.read(new File("water_plage_coin2.png"));			// case = 33
						

						grassSprite = ImageIO.read(new File("herbe.png"));						// case = 1
						grassSprite2 = ImageIO.read(new File("herbe_plage.png"));				// case = 20
						grassSprite3 = ImageIO.read(new File("herbe_plage3.png"));				// case = 21
						grassSprite4 = ImageIO.read(new File("herbe_plage_coin.png"));			// case = 22
						grassSprite5 = ImageIO.read(new File("herbe_plage4.png"));				// case = 23
						grassSprite6 = ImageIO.read(new File("herbe_plage5.png"));				// case = 24

						bigtreeSprite3 = ImageIO.read(new File("bigtree3.png"));				// case = 2
						beachSprite = ImageIO.read(new File("plage.png"));						// case = 3
						groundSprite = ImageIO.read(new File("sol_montagne.png"));				// case = 4
						ground2Sprite = ImageIO.read(new File("cote_montagne.png"));			// case = 5
						groundSideSprite = ImageIO.read(new File("cote_droit_montagne.png"));	// case = 6
						groundCornerSprite = ImageIO.read(new File("coin_montagne.png"));		// case = 7
						
						caveHoleSprite = ImageIO.read(new File("caveHole.png"));				// case = 8
						caveClimbSprite = ImageIO.read(new File("cave_climb.png"));				// case = 80
						caveSprite10 = ImageIO.read(new File("grotte1.png"));					// case = 81
						caveSprite11 = ImageIO.read(new File("grotte2.png"));					// case = 82
						caveSprite12 = ImageIO.read(new File("grotte3.png"));					// case = 83
						caveSprite13 = ImageIO.read(new File("grotte4.png"));					// case = 84
						caveSprite15 = ImageIO.read(new File("grotte6.png"));					// case = 86
						caveSprite16 = ImageIO.read(new File("grotte7.png"));					// case = 87
						caveSprite17 = ImageIO.read(new File("grotte8.png"));					// case = 88
						caveSprite18 = ImageIO.read(new File("grotte9.png"));					// case = 89
						
						cratereSprite1 = ImageIO.read(new File("cratere1.png"));				// case = 91
						cratereSprite2 = ImageIO.read(new File("cratere2.png"));				// case = 92
						cratereSprite3 = ImageIO.read(new File("cratere3.png"));				// case = 93
						cratereSprite4 = ImageIO.read(new File("cratere4.png"));				// case = 94
						

		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		for ( int i = 0 ; i < map.getWidth() ; i++ ){
			for ( int j = 0 ; j < map.getHeight() ; j++ ){
			
					switch( map.getMyWorld()[i][j] % 100 ){
						
						case 0:
							g2.drawImage(waterSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
							break;
												
						case 1:
							g2.drawImage(grassSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
							break;
							
						case 2:
							g2.drawImage(bigtreeSprite3,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
							break;
													
						case 20:
							g2.drawImage(grassSprite2,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
							break;
			
						case 21:
							g2.drawImage(grassSprite3,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
							break;
			
						case 22:
							g2.drawImage(grassSprite4,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
							break;
			
						case 23:
							g2.drawImage(grassSprite5,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
							break;
			
						case 24:
							g2.drawImage(grassSprite6,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
							break;
							
						case 3:
							g2.drawImage(beachSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 30:
							g2.drawImage(waterSprite2, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 31:
							g2.drawImage(waterSprite3, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
			
						case 32:
							g2.drawImage(waterSprite4, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
			
						case 33:
							g2.drawImage(waterSprite5, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
						
						case 4:
							g2.drawImage(groundSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
			
						case 5:
							g2.drawImage(ground2Sprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
			
						case 6:
							g2.drawImage(groundSideSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
			
						case 7:
							g2.drawImage(groundCornerSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
			
						case 8:
							g2.drawImage(caveHoleSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 80:
							g2.drawImage(caveClimbSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 81:
							g2.drawImage(caveSprite10, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 82:
							g2.drawImage(caveSprite11, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 83:
							g2.drawImage(caveSprite12, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 84:
							g2.drawImage(caveSprite13, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
						case 86:
							g2.drawImage(caveSprite15, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 87:
							g2.drawImage(caveSprite16, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 88:
							g2.drawImage(caveSprite17, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 89:
							g2.drawImage(caveSprite18, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 91:
							g2.drawImage(cratereSprite1, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
						case 92:
							g2.drawImage(cratereSprite2, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;

						case 93:
							g2.drawImage(cratereSprite3, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;

						case 94:
							g2.drawImage(cratereSprite4, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
							break;
							
				}
	
				if(map.getMyWorld()[i][j]%100 == 29)
					g2.drawImage(graineSprite, spriteLength*i,spriteLength*j,spriteLength,spriteLength,this);
			}
		}
		
		for ( int i = 0 ; i < map.getWidth() ; i++ ){
			for ( int j = 0 ; j < map.getHeight() ; j++ )
			{
				switch( map.getMyWorld()[i][j] / 1000){
				case 10:
					g2.drawImage(croute_hSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 20:
					g2.drawImage(croute_vSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 30:
					g2.drawImage(crouteSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 40:
					g2.drawImage(tsunamiSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 50:
					g2.drawImage(laveSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
					break;
				case 60:
					g2.drawImage(burningtreeSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
					break;
					
				case 70:
					g2.drawImage(cendreSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
					break;
				case 80:
					g2.drawImage(croute_lave_hSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
					break;
				case 90:
					g2.drawImage(croute_lave_vSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
					break;
				case 100:
					g2.drawImage(sol_montagne2Sprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
					break;
				}
				
			}
		}
		
		
		
		
					
	
		for(int i = 0; i < map.getWidth(); i++){
			for(int j = 0; j < map.getHeight(); j++){
				if (map.getPokeList()[i][j] != null) {

					switch (map.getPokeList()[i][j].getIndice()) {

					// case > 1000 reserve pour les pokemons
					
					case 10:
						g2.drawImage(carapuceNordSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 11:
						g2.drawImage(carapuceEstSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 12:
						g2.drawImage(carapuceSudSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 13:
						g2.drawImage(carapuceOuestSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 18:
						g2.drawImage(oeufEauSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
						
					case 20:
						g2.drawImage(carabaffeNordSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 21:
						g2.drawImage(carabaffeEstSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 22:
						g2.drawImage(carabaffeSudSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 23:
						g2.drawImage(carabaffeOuestSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;

						
					case 30:
						g2.drawImage(tortankNordSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 31:
						g2.drawImage(tortankEstSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 32:
						g2.drawImage(tortankSudSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 33:
						g2.drawImage(tortankOuestSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;

					case 40:
						g2.drawImage(salamecheNordSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 41:
						g2.drawImage(salamecheEstSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 42:
						g2.drawImage(salamecheSudSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 43:
						g2.drawImage(salamecheOuestSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 48:
						g2.drawImage(oeufFeuSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
						
					case 50:
						g2.drawImage(reptincelNordSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 51:
						g2.drawImage(reptincelEstSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 52:
						g2.drawImage(reptincelSudSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 53:
						g2.drawImage(reptincelOuestSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
			
						
					case 60:
						g2.drawImage(dracaufeuNordSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 61:
						g2.drawImage(dracaufeuEstSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 62:
						g2.drawImage(dracaufeuSudSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 63:
						g2.drawImage(dracaufeuOuestSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;

						
					case 70:
						g2.drawImage(bulbizarreNordSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 71:
						g2.drawImage(bulbizarreEstSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 72:
						g2.drawImage(bulbizarreSudSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 73:
						g2.drawImage(bulbizarreOuestSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 78:
						g2.drawImage(oeufFeuilleSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
						
					case 80:
						g2.drawImage(herbizarreNordSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 81:
						g2.drawImage(herbizarreEstSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 82:
						g2.drawImage(herbizarreSudSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 83:
						g2.drawImage(herbizarreOuestSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
							
					case 90:
						g2.drawImage(florizarreNordSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 91:
						g2.drawImage(florizarreEstSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 92:
						g2.drawImage(florizarreSudSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 93:
						g2.drawImage(florizarreOuestSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
						break;
					case 94:
						g2.drawImage(florizarreBlockedSprite, spriteLength * i, spriteLength * j, spriteLength, spriteLength, this);
					}
				}
				////////////////PLUIE////////////////////
				if (Start.date%100 < 35 ){
				MapVille.pluieIsActive = true;
					if (Math.random()*10 > densitePluie)
					g2.drawImage(pluieSprite,spriteLength*i , spriteLength*j, spriteLength, spriteLength, this);
				} else {
					MapVille.pluieIsActive = false;
				}
				
			}
		}
		
		///////////////NUIT/////////////
		if (Start.date%100 > 65 ){
			MapVille.nuitIsActive = true;
			if (MapVille.nuitIsActive) {
				g2.drawImage(nuitSprite, 0, 0, spriteLength * map.width,spriteLength * map.height, this);
			}
		} 
		
		/////////////BROUILLARD/////////////
		if ( MapVille.cptLave == MapVille.nbEruptionLimite){
			g2.drawImage(brouillardSprite, 0, 0, spriteLength * map.width, spriteLength * map.height, this);
			System.out.println("CPTCROUTE"+MapVille.cptLave+"/////=////////"+MapVille.nbEruptionLimite);

		}
		if (MapVille.pluieIsActive && MapVille.cptLave == MapVille.nbEruptionLimite) {
			cptPluieActive++;
			g2.drawImage(brouillardSprite, 0, 0, spriteLength * map.width, spriteLength * map.height, this);

			if (cptPluieActive > 10){
				MapVille.brouillardIsActive = false;
				cptPluieActive = 0;
				MapVille.cptLave = 0;
			}
		}
		

		
	}

}