package personnages;

public class Musee {
	Trophee[] trophees = new Trophee[200];
	int nbTrophees = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee nvTrophee = new Trophee(gaulois, equipement);
		trophees[nbTrophees] = nvTrophee;
	}
	
	public String extraireInstructionsOCaml() {
		String chaineRenvoyee = "let musee = [";
		for (int i = 0; i < nbTrophees; i++) {
			chaineRenvoyee += "   \"" + trophees[i].getGaulois() + "\", " + trophees[i].getEquipement() + "\";\n";
		}
		chaineRenvoyee += "]";
		return chaineRenvoyee;
	}
}
