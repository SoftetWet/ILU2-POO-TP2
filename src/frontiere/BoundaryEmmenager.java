package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois " + nomVisiteur);
					int force = Clavier.entrerEntier("Quelle est votre Force ? \n");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;
				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue villageois " + nomVisiteur);
		
		int force = Clavier.entrerEntier("Quelle est votre Force ? \n");
		int effetPotionMinimum = 1;
		int effetPotionMaximum = -1;
		while(effetPotionMaximum < effetPotionMinimum) {
			effetPotionMinimum = Clavier.entrerEntier("Quelle est la force de la potion la plus faible que vous produisez ? \n");
			effetPotionMaximum = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous produisez ? \n");
			if(effetPotionMaximum < effetPotionMinimum) {
				System.out.println("Attention Druide, vous vous �tre tromp� entre le minimum et le maximum");
			}
		}
		
		this.controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMinimum, effetPotionMaximum);
	}
}
