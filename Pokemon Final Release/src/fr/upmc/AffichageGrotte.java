package fr.upmc;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.upmc.environnement.Map;

public class AffichageGrotte extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public final static int WIDTH = 1650;
	public final static int HEIGTH = 850;

	private Image tsunamiSprite;
	private Image waterSprite;
	private Image grassSprite;
	private Image treeSprite;
	private Image bigtreeSprite;
	private Image caveSprite;
	private Image sandSprite;
	private Image paroiGaucheSprite;
	private Image paroiDroiteSprite;
	private Image paroiDroiteGrotteSprite;
	private Image paroiHauteSprite;
	private Image coinGaucheSprite;
	private Image creuxGaucheSprite;
	private Image creuxDroitSprite;
	private Image coinDroitSprite;
	private Image paroiBasseSprite;
	private Image coinBasDroitSprite;
	private Image rocherDSprite;
	private Image rocherGSprite;
	private Image eauNiv4Sprite;
	private Image eauNiv3Sprite;
	private Image eauNiv2Sprite;
	private Image eauNiv45Sprite;
	private Image creuxEauNiv3GSprite;
	private Image creuxEauNiv3DSprite;
	private Image creuxEauNiv2GSprite;
	private Image creuxEauNiv2DSprite;
	private Image paroiEauDSprite;
	private Image paroiEauGSprite;
	private Image coinEauSprite;
	private Image coinEauDSprite;
	private Image coinSandDroitSprite;
	private Image coinGrotteGSprite;
	private Image entreeGrotteSprite;
	private Image climbSprite;
	
	
	//////////////////////
	
	// SPRITES POKEMONS
	
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
	
	
	private int spriteLength;
	
	private Map map;
	
	public AffichageGrotte(Map m)
	{	
		readSprites();

		setMap(m);
		this.spriteLength = Map.SPRITE_SIZE;
		
	}
	
	public void readSprites(){
		try
		{
			tsunamiSprite = ImageIO.read(new File("tsunami.png"));		// case = 900
			waterSprite = ImageIO.read(new File("eauNiv4.png"));		// case = 0
			caveSprite = ImageIO.read(new File("grotte.png"));		// case = 4
			sandSprite = ImageIO.read(new File("sand.png"));		// case = 5
			paroiGaucheSprite = ImageIO.read(new File("paroiGauche.png"));	// case = 6
			paroiDroiteSprite = ImageIO.read(new File("paroiDroite.png"));	// case = 7
			paroiHauteSprite = ImageIO.read(new File("paroiHaute.png"));	// case = 8
			coinGaucheSprite = ImageIO.read(new File("coinGauche.png"));	// case = 9
			creuxGaucheSprite = ImageIO.read(new File("creuxGauche.png"));	// case = 10
			creuxDroitSprite = ImageIO.read(new File("creuxDroit.png"));	// case = 11
			coinDroitSprite = ImageIO.read(new File("coinDroit.png"));		// case = 12
			paroiBasseSprite = ImageIO.read(new File("paroiBasse.png"));	// case = 13
			coinBasDroitSprite = ImageIO.read(new File("coinBasDroit.png"));// case = 14
			eauNiv4Sprite = ImageIO.read(new File("eauNiv4.png"));			// case = 17
			eauNiv3Sprite = ImageIO.read(new File("eauNiv3.png"));			// case = 18
			eauNiv2Sprite = ImageIO.read(new File("eauNiv2.png"));			// case = 19
			creuxEauNiv3GSprite = ImageIO.read(new File("creuxEauNiv3G.png"));		// case = 20
			creuxEauNiv3DSprite = ImageIO.read(new File("creuxEauNiv3D.png"));		// case = 21
			creuxEauNiv2GSprite = ImageIO.read(new File("creuxEauNiv2G.png"));		// case = 22
			creuxEauNiv2DSprite = ImageIO.read(new File("creuxEauNiv2D.png"));		// case = 23
			paroiEauDSprite = ImageIO.read(new File("paroiEauD.png"));	// case = 24
			paroiEauGSprite = ImageIO.read(new File("paroiEauG.png"));	// case = 25
			eauNiv45Sprite = ImageIO.read(new File("eauNiv45.png"));	// case = 26
			coinEauSprite = ImageIO.read(new File("coinEau.png"));	// case = 27
			coinEauDSprite = ImageIO.read(new File("coinEauD.png"));	// case = 28
			coinSandDroitSprite = ImageIO.read(new File("coinSandDroit.png"));	// case = 29
			coinGrotteGSprite = ImageIO.read(new File("coinGrotteG.png"));	// case = 30
			entreeGrotteSprite = ImageIO.read(new File("entreeGrotte.png"));	// case = 31
			climbSprite = ImageIO.read(new File("climb.png"));	// case = 33
			paroiDroiteGrotteSprite = ImageIO.read(new File("paroiDroiteGrotte.png"));	// case = 34
			
			// read sprites pokemon
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
			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}


	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		for ( int i = 0 ; i < map.getWidth() ; i++ ){
			for ( int j = 0 ; j < map.getHeight() ; j++ )
			{

				switch ( map.getMyWorld()[i][j]%100	) {
				case 900:
					g2.drawImage(tsunamiSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 0: 
					g2.drawImage(waterSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 1:
					g2.drawImage(grassSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break; 
				case 2: 
					g2.drawImage(bigtreeSprite, spriteLength*i, spriteLength*j, spriteLength, spriteLength, this);
					break;
				case 3: 
					g2.drawImage(treeSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 4: 
					g2.drawImage(caveSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 5: 
					g2.drawImage(sandSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 6: 
					g2.drawImage(paroiGaucheSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 7: 
					g2.drawImage(paroiDroiteSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 8: 
					g2.drawImage(paroiHauteSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 9: 
					g2.drawImage(coinGaucheSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 10: 
					g2.drawImage(creuxGaucheSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 11: 
					g2.drawImage(creuxDroitSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 12: 
					g2.drawImage(coinDroitSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 13: 
					g2.drawImage(paroiBasseSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 14: 
					g2.drawImage(coinBasDroitSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 15: 
					g2.drawImage(rocherDSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 16: 
					g2.drawImage(rocherGSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 17: 
					g2.drawImage(eauNiv4Sprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 18: 
					g2.drawImage(eauNiv3Sprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 19: 
					g2.drawImage(eauNiv2Sprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 20: 
					g2.drawImage(creuxEauNiv3GSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 21: 
					g2.drawImage(creuxEauNiv3DSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 22: 
					g2.drawImage(creuxEauNiv2GSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 23: 
					g2.drawImage(creuxEauNiv2DSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 24: 
					g2.drawImage(paroiEauDSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 25: 
					g2.drawImage(paroiEauGSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 26: 
					g2.drawImage(eauNiv45Sprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 27: 
					g2.drawImage(coinEauSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 28: 
					g2.drawImage(coinEauDSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 29: 
					g2.drawImage(coinSandDroitSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 30: 
					g2.drawImage(coinGrotteGSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 31: 
					g2.drawImage(entreeGrotteSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 33: 
					g2.drawImage(climbSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				case 34: 
					g2.drawImage(paroiDroiteGrotteSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, this);
					break;
				}
			}
		}
		
		
		
		for(int i = 0; i < map.getWidth(); i++){
			for(int j = 0; j < map.getHeight(); j++){
				switch(map.getMyWorld()[i][j]/100){
				
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
				/*
			case 888: // indice de changement de map
				this.setVisible(!this.isVisible()); // on attribut l'inverse de l'indice de changement de map
				if(this.isVisible()){		// si la map est au premier plan
					this.toBack();			// on la met en arriere plan
					isAffichageVille = false;
				}
				else if(!this.isVisible()){	// sinon 
					this.toFront();		// on la remet au premier plan
					isAffichageVille = true;
				}
				*/
					
			}
		}
	}
	
	public void setMap(Map m){ this.map = m; }
	
}