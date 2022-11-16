import java.util.HashMap;
import java.util.HashSet;

public class Parking {
	private HashMap<String, Proprietaire> plaquesAutorisees;
	private HashSet<String> voituresPresentes;

	public Parking() {
		plaquesAutorisees = new HashMap<>();
		voituresPresentes = new HashSet<>();
	}
	
	/**
	 * renvoie sous forme d'un String toutes les voitures autorisees et celles presentes dans le parking
	 */
	public String toString(){
		String txt = plaquesAutorisees.toString();
		txt += "\n" + voituresPresentes.toString();
		return txt;
	}
	
	/**
	 * ajoute une voiture a l'ensemble des voitures autorisees
	 * @param Plaque 
	 * @param proprietaire 
	 * @return true si la voiture n'etait pas encore presente, false sinon
	 */
	public boolean ajouterAutorisationVoiture(String plaque, Proprietaire proprietaire){
		if (proprietaire == null)
			throw new IllegalArgumentException();
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		if (!plaquesAutorisees.containsKey(plaque)) {
			plaquesAutorisees.put(plaque, proprietaire);
			return true;
		}
		return false;
	}
	
	/**
	 * supprime une voiture a l'ensemble des voitures autorisees
	 * @param plaque
	 * @return true si la voiture n'est pas presente, false sinon
	 */
	public boolean retirerAutorisationVoiture(String plaque){
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		if (plaquesAutorisees.containsKey(plaque)) {
			plaquesAutorisees.remove(plaque);
			return true;
		}		
		return false;
	}
	
	/**
	 * verifie si la voiture dont le numero de plaque est passe en parametre fait partie des voitures
	*  autorisees
	 * @param Plaque
	 * @return true si la voiture est autorisee, false sinon
	 */
	public boolean estAutorisee(String plaque){
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		return plaquesAutorisees.containsKey(plaque);
	}
	
	/**
	 * renvoie le proprietaire de la voiture dont le numero de plaque est passe en parametre
	 * @param Plaque
	 * @return le proprietaire ou null si la voiture n'est pas reconnue
	 */
	public Proprietaire getProprietaire(String plaque){
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		return plaquesAutorisees.get(plaque);
	}
	
	/**
	 * met la plaque dans l'ensemble des plaques des voitures presentes 
	 * @param Plaque
	 * @return true si la voiture est autorisee, false sinon
	 * @throws IllegalStateException si la voiture est deja presente dans le parking
	 */
	public boolean entrerVoiture(String plaque)throws IllegalStateException{
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		if (voituresPresentes.contains(plaque))
			throw new IllegalStateException();
		if (estAutorisee(plaque)) {
			voituresPresentes.add(plaque);
			return true;
		}
		return false;	
	}
	
	/**
	 * retire la plaque dans l'ensemble des plaques des voitures presentes 
	 * @param Plaque
	 * @return true si la voiture est autorisee, false sinon
	 * @throws IllegalStateException si la voiture n'etait pas presente dans le parking
	 */
	public boolean sortirVoiture(String plaque)throws IllegalStateException {
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		if (!voituresPresentes.contains(plaque)) 
			throw new IllegalStateException();
		if (estAutorisee(plaque)) {
			voituresPresentes.remove(plaque);
			return true;
		}
		return false;
	}
	
	/**
	 * verifie la presence d'une voiture dans le parking
	 * @param plaque
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean estPresente(String plaque){
		if (plaque == null || plaque.equals(""))
			throw new IllegalArgumentException();
		return voituresPresentes.contains(plaque);
	}	
}
