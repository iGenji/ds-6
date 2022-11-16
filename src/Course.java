public class Course {
	private ListeSDImpl<String> coureurs;

	public Course() {
		coureurs = new ListeSDImpl<>();
	}
	
	/**
	 * Donne la liste de tous les coureurs
	 */
	public String toString() {
		return coureurs.toString();
	}

	/**
	 * Ajoute un coureur en fin de course
	 * @param coureur Le coureur a ajouter en fin
	 */
	public void ajouterCoureurFin(String coureur) {
		coureurs.insererEnQueue(coureur);
	}

	/**
	 * Retrouve le premier coureur
	 * @return le premier coureur
	 */
	public String donnerPremierCoureur() {
		return coureurs.premier();
	}

	/**
	 * Echange de place entre le coureur et le coureur devant lui
	 * Avancer le coureur en tete n'est pas possible
	 * @param coureur Le coureur a avancer
	 * @return true si l'echange de place est possible, false sinon
	 */
	public boolean avancerCoureur(String coureur) {
		String precedent = coureurs.donnerPrecedent(coureur);
		if (precedent == null)
			return false;
		return coureurs.permuter(coureur, precedent); 
	}

	/**
	 * Supprime un coureur existant
	 * @param coureur Le coureur a enlever
	 * @return true si la suppression est possible, false sinon
	 */
	public boolean supprimer(String coureur) {
		return coureurs.supprimer(coureur);
	}

	/**
	 * Donner la position d'un coureur
	 * @param coureur Le coureur dont on recupere la position
	 * @return La position du coureur ou -1 s'il n'est pas present
	 */
	public int donnerPosition(String coureur) {
		int position = 1;
		for (String s : coureurs) {
			if (s.equals(coureur)) {
				return position;
			}
			position++;
		}
		return -1;
	}
}
