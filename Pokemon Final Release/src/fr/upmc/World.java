package fr.upmc;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.upmc.environnement.Map;
import fr.upmc.environnement.MapGrotte;
import fr.upmc.environnement.MapVille;

public class World extends JFrame {

	private AffichageVille panelVille;
	private AffichageGrotte panelGrotte;
	
	private MapVille ville;
	private MapGrotte grotte;

	public World(){   
		initMaps();
		System.out.println("initMaps terminee");
		initFrame();
	}       
	
	private void initMaps() {
		ville = new MapVille(10);
		System.out.println("mapVille instanciee");
		grotte = new MapGrotte(10);
		
		panelVille = new AffichageVille(ville);
		panelGrotte = new AffichageGrotte(grotte);
	}
	
	private void initFrame() {
		this.setTitle("Ecosysteme");
	    this.setSize(1650, 850);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    // Maps
	    final JPanel content = new JPanel();
	    final CardLayout cardLayout = new CardLayout();
	    //On definit le layout
	    content.setLayout(cardLayout);
	    //On ajoute les cartes a la pile avec un nom pour les retrouver
	    content.add(panelVille, "Ville");
	    content.add(panelGrotte, "Grotte");
	   
	    
	    // Boutons
	    JButton boutonVille = new JButton("Ville");
	    JButton boutonGrotte = new JButton("Grotte");
	    
	    JPanel boutonPane = new JPanel();
	    boutonPane.add(boutonGrotte);
	    boutonPane.add(boutonVille);

	    //Definition de l'action du bouton
	    boutonGrotte.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		//Via cette instruction, on passe au prochain conteneur de la pile
	    		cardLayout.show(content, "Grotte");
	    	}
	    });
	    
	    //Definition de l'action du bouton2
	    boutonVille.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){				
	    		cardLayout.show(content, "Ville");
	    	}
	    });


	    this.getContentPane().add(boutonPane, BorderLayout.NORTH);
	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.setVisible(true);
	}

	public void update() {
		ville.action();
		grotte.action();
		this.repaint();
	}
}
