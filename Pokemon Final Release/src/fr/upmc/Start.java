package fr.upmc;

import java.util.ArrayList;

import fr.upmc.environnement.Map;

public class Start {

	public static int date = 0;
	
	public static void main(String[] args) {
		System.out.println("Debut Start");
		World world = new World();
		System.out.println("New world initialise");
		int delay = 80;

		// Initialisation de la map courante

		// Mise a jour de l'etat du monde
		while (date < 10000) {
			world.update();
			date++;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
			}
		}
	}


}
