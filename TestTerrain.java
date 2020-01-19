package pobj.simuagent;

public class TestTerrain {
	
	public static void main(String[] args) {
		
		Terrain t = Terrain.Mur;
		
		
		System.out.println(t);// Affiche : Mur 
		
		
		Terrain t1 = Terrain.BorneExit_4;
		//Terrain.level(t1);
		
		System.out.println(Terrain.level(t1)); //Affiche : 4
		
		Terrain t3 = Terrain.conv('9');  //convertit le caractère 9 en Terrain
		System.out.println(t3);          // affiche BorneExit-9
		
		
		System.out.println(Terrain.isTarget(t1));// affiche : true
		
		Terrain t4 = Terrain.conv(Terrain.conv(t3)); // a partir d'un terrain, retourne un terrain avec la meme valeur
		System.out.println(t4);                      //affcihe BorneExit_9
		
		System.out.println(t3 == t4); //test l'egalite des constantes des 2 terrains, affiche true
		Terrain t5 = Terrain.BorneExit_9;
		System.out.println(t5);  // affiche : BorneExit_9
		System.out.println(t3 == t5); // affcihe true 
		
	}
	

}
