package pobj.tutoMoteurGraphique;

import pobj.ihm.Fenetre;
import pobj.ihm.VueRond;

public class PriseEnMainMoteurGraphique {

    // Ajout d'Exception liées à la temporisation que l'on ne souhaite pas gérer
    public static void main(String[] args) throws InterruptedException {
        Fenetre mgraph = new Fenetre();
        VueRond r = new VueRond(100, 100, 20);
        // ajout d'un élément dans le moteur graphique
        mgraph.add(r);
        
        // boucle de mouvement + affichage
        for(int iter = 0; iter<200; iter++) {
        	if (iter<100) {
            // mouvement du cercle
            r.move();
            // rafraichissement de l'affichage
            mgraph.repaint();      
            // temporisation (sinon, on ne voit rien)
            Thread.sleep(50);
        	}
        	if (iter>100) {
                // mouvement du cercle
                r.move2();
                // rafraichissement de l'affichage
                mgraph.repaint();      
                // temporisation (sinon, on ne voit rien)
                Thread.sleep(50);
            }
        	if (iter==199) {
                iter = 0;
        	
        	}
        }
        // Attention, le programme ne s'arrête pas, il faut fermer la fenêtre
    }

}
