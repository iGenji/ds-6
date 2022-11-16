import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DicoSD {
	private HashMap<String,ArrayList<String>> structureDonnees;

	public DicoSD() {
		structureDonnees = new HashMap<>();
	}

	/**
	 * ajout dans le dico une association sd-lien si celle-ci n'est pas encore presente 
	 * @param sd une structure de donnees
	 * @param lien un lien vers un site internet
	 * @return true si le lien n'etait pas encore present dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String lien) {
		if (!structureDonnees.containsKey(sd)) {
			structureDonnees.put(sd, new ArrayList<>());
			return structureDonnees.get(sd).add(lien);
		}
		if (structureDonnees.get(sd).contains(lien)) {
			return false;
		}
		return structureDonnees.get(sd).add(lien);
	}
	
	/**
	 * verifie si la structure de donnees se trouve dans le dico
	 * cette structure de donnees doit posseder au moins un lien!
	 * @param sd
	 * @return true si sd est present, false sinon
	 */
	public boolean contient(String sd){
		return structureDonnees.containsKey(sd) && structureDonnees.get(sd).size() >= 1;
	}
	
	/**
	 * renvoie tous les liens associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les liens selon le format : [lienPile1, lienPile2] ou [] si vide
	 */
	public String lesLiens(String sd){
		if (!structureDonnees.containsKey(sd) || structureDonnees.get(sd).isEmpty())
			return "[]";
		return structureDonnees.get(sd).toString();
	}
	
	/**
	 * supprime dans le dico l'association sd-lien si celle-ci est presente 
	 * @param sd une structure de donnees
	 * @param lien un lien vers un site internet
	 * @return true si le lien etait present dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String lien){
		if (structureDonnees.containsKey(sd) && structureDonnees.get(sd).contains(lien)) {
			return structureDonnees.get(sd).remove(lien);
		}
		return false;
	}

	public HashMap getStructureDonnees() {
		return structureDonnees;
	}

	public void setStructureDonnees(HashMap structureDonnees) {
		this.structureDonnees = structureDonnees;
	}
		
}
