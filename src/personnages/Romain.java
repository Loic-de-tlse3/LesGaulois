package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		if (force <= 0) {
			throw new IllegalArgumentException("Invalid force: " + force);
		}
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
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("A�e");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
// 		post condition la force a diminu�e
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement;i++) {
					if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
					} else {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom.toString() + "s'envole sous la force du coup.");
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
		String sentenceBegining = "Le soldat " + nom;
		switch (nbEquipement) {
		case 2:
			System.out.println(sentenceBegining + " est d�j� bien prot�g�(e) !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println(sentenceBegining + " poss�de d�j� un " + equipement);
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
		System.out.println("Le soldat " + nom + " s'�quipe d'un " + equipement);
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