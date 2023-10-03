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
        System.out.println(prendreParole(getNom()) + texte);
    }

    private String prendreParole(String nom) {
        return "Le gaulois " + nom + " : ";
    }

    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        romain.recevoirCoup(force / 3 * effetPotion);
    }

    public String toString() {
        return "Gaulois [nom=" + getNom() + ", force=" + getForce() + ", effetPotion=" + getEffetPotion() + "]";
    }
    
    public void boirePotion(Druide druide) {
        effetPotion = druide.getForcePotion();
        parler("« Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée. »");
    }

    public static void main(String[] args) {
        Gaulois asterix = new Gaulois("Astérix", 8);
        System.out.println(asterix);
        System.out.println(asterix.prendreParole(asterix.getNom()));
        asterix.parler("Je suis ami avec Obélix");
        asterix.boirePotion(new Druide("Panoramix", 5, 10));
        asterix.frapper(new Romain("UnRomain", 5));
    }
}