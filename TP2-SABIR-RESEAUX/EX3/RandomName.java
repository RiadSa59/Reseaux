package EX3 ;
import java.util.Random;

/**
 * Une classe qui permet de générer aléoratoirement un nom d'utilisateur
 * @author Riad SABIR 
 */

 public class RandomName {
	// Initialisation de Random
    private static Random generate = new Random();
	// Taille du nom
    private static final int Taille=10;
    // Lettre à utiliser pour générer nom 
	private static final char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    // Méthode static pour générer un nom 
    public static String generateName() {
		char[] name = new char[Taille];
		for(int i=0; i< Taille; i++) {
			name[i] = letters[generate.nextInt(Integer.MAX_VALUE) % Taille];
		}
		return new String(name);
	}

}