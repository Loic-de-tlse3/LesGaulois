package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole(getNom()) +  texte);
	}

	private String prendreParole(String nom) {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		Romain unRomain = new Romain("UnRomain", 5);
		System.out.println(unRomain.prendreParole(unRomain.getNom()));
		unRomain.parler("les gaulois !");
		unRomain.recevoirCoup(8);
	}
}
