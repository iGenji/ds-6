import java.util.HashMap;

public class EnsembleVoituresAutorisees {
	private HashMap<String, Proprietaire> ensembleVoitures;

	/**
	 * construit un ensemble vide
	 */
	public EnsembleVoituresAutorisees(){
		ensembleVoitures = new HashMap<String, Proprietaire>();
	}

	/**
	 * ajoute une voiture a condition que celle-ci ne soit pas deja presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @param proprietaire le proprietaire de la voiture a ajouter
	 * @return true si la voiture n'etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(String plaque, Proprietaire proprietaire) {
		if (proprietaire == null)
			throw new IllegalArgumentException();
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		if (!ensembleVoitures.containsKey(plaque)) {
			ensembleVoitures.put(plaque, proprietaire);
			return true;
		}
		return false;
	}


	/**
	 * retire une voiture a condition que celle-ci soit presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(String plaque) {
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		if (ensembleVoitures.containsKey(plaque)) {
			ensembleVoitures.remove(plaque);
			return true;
		}
		return false;
	}
	
	/**
	 * verifie si la voiture est autorisee car presente dans l'ensemble
	 * @param plaque la plaque de la voiture a verifier
	 * @return true si la voiture est presente dans l'ensemble, false sinon
	 */
	public boolean voitureAutorisee(String plaque){
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		return ensembleVoitures.containsKey(plaque);
	}
	
	/**
	 * renvoie le proprietaire de la voiture
	 * @param plaque la plaque de la voiture recherchee
	 * @return le proprietaire ou null si la plaque n'est pas dans l'ensemble
	 */
	public Proprietaire donnerProprietaire(String plaque){
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		if (ensembleVoitures.containsKey(plaque)) {
			return ensembleVoitures.get(plaque);
		}
		return null;
	}
	
	public String toString(){
		return ensembleVoitures.toString();
	}
}
