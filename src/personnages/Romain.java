package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;

	public Romain(String nom, int force) {
		assert (force > 0);
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
		System.out.println(prendreParole(getNom()) + texte);
	}

	private String prendreParole(String nom) {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert (this.force > 0);
//		int forceAvantCoup = this.force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert (forceAvantCoup > this.force);
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
// 		if (force > 0) {
// 			parler("Aïe");
// 		} else {
// 			equipementEjecte = ejecterEquipement();
// 			parler("J'abandonne...");
// 		}
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
// 		post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
					if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
						resistanceEquipement += 8;
					} else {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
					i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé(e) !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement);
			} else {
				this.equiper(equipement);
			}
			break;
		default:
			this.equiper(equipement);
		}
	}

	private void equiper(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		System.out.println("Le soldat " + nom + " s'équipe d'un " + equipement);
		nbEquipement++;
	}

	public static void main(String[] args) {
		Romain unRomain = new Romain("UnRomain", 6);
		System.out.println(unRomain.prendreParole(unRomain.getNom()));
		unRomain.parler("les gaulois !");
		unRomain.recevoirCoup(8);
		System.out.println("test enum Equipement");
		for (Equipement equipement : Equipement.values()) {
			System.out.println("- " + equipement);
		}
		unRomain.sEquiper(Equipement.CASQUE);
		unRomain.sEquiper(Equipement.CASQUE);
		unRomain.sEquiper(Equipement.BOUCLIER);
		unRomain.sEquiper(Equipement.CASQUE);
	}
}