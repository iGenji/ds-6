import java.util.Iterator;


public interface ListeSD<E> {
	
	/**
	 * renvoie le nombre d elements dans la liste
	 * @return
	 */
	public int taille();

	/**
	 * verifie si la liste est vide
	 * @return true si la liste est vide, false sinon
	 */
	public boolean estVide();

	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 */
	public boolean contient(E element);

	/**
	 * renvoie l element de tete sans l enlever
	 * @return l element de tete
	 * @throws ListeVideException si la liste est vide
	 */
	public E premier();
	
	/**
	 * renvoie l element de queue sans l enlever
	 * @return l element de tete
	 * @throws ListeVideException si la liste est vide
	 */
	public E dernier();

	/**
	 * insere un nouvel element en tete de liste
	 * @param element le nouvel element a inserer en tete
	 * @throws DejaPresentException si l element est deja present
	 */
	public void insererEnTete(E element);

	/**
	 * insere un nouvel element en queue de liste
	 * @param element le nouvel element a inserer en queue
	 * @throws DejaPresentException si l element est deja present
	 */
	public void insererEnQueue(E element);
	
	/**
	 * insere le 2eme element passe en parametre apres le 1er element passe en parametre
	 * @param element l element apres lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si le 1er element passe en parametre est present dans la liste, false sinon
	 * @throws DejaPresentException si l element a inserer est deja present
	 */
	public boolean insererApres(E element, E elementAInserer);
	
	/**
	 * insere le 2eme element passe en parametre avant le 1er element passe en parametre
	 * @param element l element avant lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si le 1er element passe en parametre est present dans la liste, false sinon
	 * @throws DejaPresentException si l element a inserer est deja present
	 */
	public boolean insererAvant(E element, E elementAInserer);
	
	/**
	 * supprime de la liste l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element est present, false sinon
	 */
	public boolean supprimer(E element);

	/**
	 * permute les 2 elements passes en parametre
	 * @param element1
	 * @param element2
	 * @return true si les 2 elements sont bien presents, false sinon
	 */
	public boolean permuter(E element1, E element2);
	public String toString();
	
	/**
	 * cree un iterateur
	 * @return un iterateur de la liste
	 */
	public Iterator<E> iterator();

}
