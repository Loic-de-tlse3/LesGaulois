package personnages;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion = 1;
    private int nblisteTrophees;
    private Equipement[] listeTrophees = new Equipement[100];

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
        System.out.println(prendreParole() + getNom() + " " + texte);
    }
    
    private String prendreParole() {
    	return "Le gaulois " + nom + " : ";
    }
    
    public void frapper(Romain romain) {
    	System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
    	Equipement[] listeTrophees = romain.recevoirCoup((force / 3) * effetPotion);
    	for (int i = 0; listeTrophees != null && i < listeTrophees.length; i++, nblisteTrophees++) {
    		this.listeTrophees[nblisteTrophees] = listeTrophees[i];
    	}
    }

    public String toString() {
        return "Gaulois [nom=" + getNom() + ", force=" + getForce() + ", effetPotion=" + getEffetPotion() + "]";
    }
    
    public void boirePotion(Druide druide) {
        effetPotion = druide.getForcePotion();
        parler("Merci druide, je sens que ma force est " + effetPotion + " fois decuplee.");
    }
    
    public void faireUneDonnation(Musee musee){
    	parler("Je donne au musee tous mes trophees :");
    	for (int i = 0; i < nblisteTrophees; i--) {
    		musee.donnerTrophees(this, listeTrophees[nblisteTrophees]);
    		System.out.println("- " + listeTrophees[nblisteTrophees].toString());
    	}
    }

    public static void main(String[] args) {
        Gaulois asterix = new Gaulois("Asterix", 8);
        System.out.println(asterix);
        System.out.println(asterix.prendreParole() + asterix.getNom() + " ");
        asterix.parler("Je suis ami avec Obelix");
        asterix.boirePotion(new Druide("Panoramix", 5, 10));
        asterix.frapper(new Romain("UnRomain", 5));
    }
}