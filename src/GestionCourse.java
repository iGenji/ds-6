public class GestionCourse {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	private static Course course;

	public static void main(String[] args) {
		
		course = new Course();
		System.out.println("Combien de coureurs ?");
		int nbCoureurs = scanner.nextInt();
		int i = 0;
		System.out.println("Entrez les coureurs :");
		while (i < nbCoureurs) {
			String coureur = scanner.next();
			try {
				course.ajouterCoureurFin(coureur);
				i++;
			} catch (Exception e) {
				System.out.println("Attention, ce coureur est deja present.");	
			}
		}
		commencerCourse();
	}
	
	public static void commencerCourse() {
		System.out.println("\n********************************************");
		System.out.println("Programme de gestion d'une course automobile");
		System.out.println("********************************************");
		
		int choix;
		do {
		System.out.println("1 -> Afficher toute la course");
		System.out.println("2 -> Afficher premier coureur");
		System.out.println("3 -> Avancer un coureur");
		System.out.println("4 -> Sortir un coureur");
		System.out.println("5 -> Donner position d'un coureur");
		System.out.println("6 -> Fin course");
		System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				afficherCourse();
				break;
			case 2:
				premierCoureur();
				break;
			case 3:
				avancerCoureur();
				break;
			case 4:
				sortirCoureur();
				break;
			case 5:
				donnerPosition();
			}
		} while (choix >= 1 && choix <= 5);
		System.out.println("Fin de la course...");
		System.out.println();
	}
	
	public static void afficherCourse() {
		String courseString = course.toString();
		if (courseString.equals("")) {
			System.out.println("Aucun coureur en course.");
		} else {
			System.out.println(courseString);
		}
		System.out.println();
	}
	
	public static void premierCoureur() {
		try {
			System.out.println("Le premier coureur est " + course.donnerPremierCoureur());
		} catch (Exception e) {
			System.out.println("Attention, il n'y a aucun coureur.");
		}
		System.out.println();
	}
	
	public static void avancerCoureur() {
		System.out.print("Entrez le coureur : ");
		String coureur = scanner.next();
		try {
			if (!course.avancerCoureur(coureur)) {
				System.out.println("Impossible de l'avancer !");
			}
		} catch (Exception e) {
			System.out.println("Coureur incorrect.");
		}
		System.out.println();
	}
	
	public static void sortirCoureur() {
		System.out.print("Entrez le coureur : ");
		String coureur = scanner.next();
		try {
			if (!course.supprimer(coureur)) {
				System.out.println("Attention, le coureur n'existe pas.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Le coureur est incorrect.");
		} catch (ListeVideException l) {
			System.out.println("Attention, il n'y a aucun coureur.");
		}
		System.out.println();
	}

	public static void donnerPosition() {
		System.out.print("Entrez le coureur : ");
		String coureur = scanner.next();
		int position = course.donnerPosition(coureur);
		if (position == -1) {
			System.out.println("Ce coureur n'est pas present.");
		}
		else  {
			System.out.println("Le coureur " + coureur + " est a la position " + position);
		}
		System.out.println();
	}
}
