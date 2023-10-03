package personnages;

public class Village {
    private String nom;
    private Chef chef;
    private int nbVillageois = 0;
    private Gaulois[] villageois;
    
    public Village(String nom, int nbVillageoisMaximum) {
        this.nom = nom;
        villageois = new Gaulois[nbVillageoisMaximum];
    }
    
    public void ajouterHabitant(Gaulois gaulois) {
        villageois[nbVillageois] = gaulois;
        nbVillageois++;
    }
    
    public Gaulois trouverHabitant(int numeroVillageois) {
        return villageois[numeroVillageois];
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setChef(Chef chef) {
        this.chef = chef;
    }
    
    public String getChef() {
        return chef.getNom();
    }
    
    public void afficherVillage() {
        System.out.println("Dans le village du chef " + getChef() + " vivent les légendaires gaulois");
        for (int i = 0; i < nbVillageois; i++) {
            System.out.println("- " + villageois[i].getNom());
        }
    }
    
    public static void main(String[] args) {
        Village village = new Village("Village des irréductibles", 30);
//        Gaulois gaulois = village.trouverHabitant(30);
//        On a une erreur car il n'existe pas d'élément en case 30, le trentième se trouve en case 29.
        Chef abraracourix = new Chef("Abraracourcix", 6, village);
        village.setChef(abraracourix);
        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterHabitant(asterix);
//        Gaulois gaulois = village.trouverHabitant(1);
//        System.out.println(gaulois);
        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterHabitant(obelix);
        village.afficherVillage();
    }
}