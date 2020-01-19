package pobj.tutoMoteurPhysique;

import pobj.ihm.Fenetre;
import pobj.ihm.VueMur;
import pobj.ihm.VueParticule;
import pobj.physics.CerclePhysique;
import pobj.physics.MoteurPhysique;
import pobj.physics.RectanglePhysique;


public class PriseEnMainMoteurPhysique {
    
    // Ajout d'Exception liées à la temporisation que l'on ne souhaite pas gérer
    public static void main(String[] args) throws InterruptedException {
        
        // Moteur Physique 2D (vue dessus)
        MoteurPhysique mphys = new MoteurPhysique();
        // Création d'une boite = murs
        
        RectanglePhysique mur = new RectanglePhysique(50, 50, 320, 300);
        // Création d'une particule
        
        CerclePhysique particule = new CerclePhysique(100, 100, 10, 1);
        
        
        
        particule.setRandomDirectionAndVitesse();
        mphys.add(mur);
        mphys.add(particule);
        
        
        Fenetre mgraph = new Fenetre();
 
        
        // ajout d'un élément dans le moteur graphique
       //VueParticule vuep = new VueParticule(particule);

        //mgraph.add(vuep);
        mgraph.add(new VueMur(mur));
        particule.getRayon();
        // boucle de mouvement + affichage
    
      
        // Création des vues associées aux objets physiques
        VueParticule vuep = new VueParticule(particule);

        // boucle de mouvement + affichage
        for(int iter = 0; iter<2000; iter++) {
            // mouvements

            mgraph.add(vuep);
            mphys.updateMovablePosition();


            
            // mouvement 
            // rafraichissement de l'affichage
            System.out.println(vuep.getx());


            mgraph.repaint();      
            // temporisation (sinon, on ne voit rien)
            Thread.sleep(50);
            vuep.move(particule,mur);
        
            if(!mphys.isMove()) {
                System.out.println("plus de mouvement => sortie");
                break;
            }
        }
     /*
        for(int iter = 0; iter<200; iter++) {
        	if (iter<100) {
            // mouvement du cercle
            particule.move();
            // rafraichissement de l'affichage
            mgraph.repaint();      
            // temporisation (sinon, on ne voit rien)
            Thread.sleep(50);
        	}
        	if (iter>100) {
                // mouvement du cercle
                particule.move2();
                // rafraichissement de l'affichage
                mgraph.repaint();      
                // temporisation (sinon, on ne voit rien)
                Thread.sleep(50);
            }
        	if (iter==199) {
                iter = 0;
        	
        	}
        }*/
        
        
        // Attention, le programme ne s'arrête pas, il faut fermer la fenêtre
    }
}
