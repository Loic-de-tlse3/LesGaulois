package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public int getEffetPotion() {
		return effetPotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole(getNom()) +  texte);
	}

	private String prendreParole(String nom) {
		return "Le gaulois " + nom + " : ";
	}
	
	public String toString() {
		return "Gaulois [nom=" + getNom() + ", force=" + getForce() + ", effetPotion=" + getEffetPotion() + "]";
	}
}
