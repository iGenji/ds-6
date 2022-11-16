
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListeSDImpl<E> implements ListeSD<E>, Iterable<E> {

	private HashMap<E, Noeud> mapElt;
	private Noeud tete, queue;
	private int taille;
	private int numVersion;

	public ListeSDImpl() {
		mapElt = new HashMap<>();
		tete = new Noeud();
		queue = new Noeud();
		tete.suivant = queue;
		queue.precedent = tete;
		taille = 0;
		numVersion = 0;
	}

	/**
	 * renvoie le nombre d elements dans la liste
	 * @return la taille de la liste
	 */
	public int taille() {
		return taille;
	}

	/**
	 * verifie si la liste est vide
	 * @return true si la liste est vide, false sinon
	 */
	public boolean estVide() {
		return taille == 0;
	}
	
	/**
	 * renvoie le noeud de l element
	 * @param element l element a rechercher
	 * @return le noeud de l element
	 */
	private Noeud donnerNoeud(E element){
		if (element == null) 
			throw new IllegalArgumentException();
		if (!mapElt.containsKey(element))
			return null;
		return mapElt.get(element);
	}

	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 */
	public boolean contient(E element) {
		return donnerNoeud(element) != null;
	}

	/**
	 * renvoie l element de tete sans l enlever
	 * @return l element de tete
	 * @throws ListeVideException si la liste est vide
	 */
	public E premier() {
		if (taille == 0)
			throw new ListeVideException();
		return tete.suivant.element;
	}

	/**
	 * renvoie l element de queue sans l enlever
	 * @return l element de tete
	 * @throws ListeVideException si la liste est vide
	 */
	public E dernier() {
		if (taille == 0)
			throw new ListeVideException();
		return queue.precedent.element;
	}

	/**
	 * insere un nouvel element en tete de liste
	 * @param element le nouvel element a inserer en tete
	 * @throws DejaPresentException si l element est deja present
	 */
	public void insererEnTete(E element) {
		if (element == null)
			throw new IllegalArgumentException();
		if (mapElt.containsKey(element))
			throw new DejaPresentException();
		Noeud suivant = tete.suivant;
		tete.suivant = new Noeud(element, tete, tete.suivant);
		suivant.precedent = tete.suivant;
		mapElt.put(element, tete.suivant);
		taille++;
		numVersion++;
	}

	/**
	 * insere un nouvel element en queue de liste
	 * @param element le nouvel element a inserer en queue
	 * @throws DejaPresentException si l element est deja present
	 */
	public void insererEnQueue(E element) {
		if (element == null) 
			throw new IllegalArgumentException();
		if (mapElt.containsKey(element))
			throw new DejaPresentException();
		Noeud precedent = queue.precedent;
		precedent.suivant = new Noeud(element, queue.precedent, queue);
		queue.precedent = precedent.suivant;
		mapElt.put(element, queue.precedent);
		taille++;
		numVersion++;
	}

	/**
	 * insere le 2eme element passe en parametre apres le 1er element passe en parametre
	 * @param element l element apres lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si le 1er element passe en parametre est present dans la liste, false sinon
	 * @throws DejaPresentException si l element a inserer est deja present
	 */
	public boolean insererApres(E element, E elementAInserer) {
		if (taille == 0)
			throw new ListeVideException();
		if (element == null || elementAInserer == null)
			throw new IllegalArgumentException();
		if (mapElt.containsKey(elementAInserer))
			throw new DejaPresentException();
		if (!mapElt.containsKey(element))
			return false;
		Noeud noeudElement = donnerNoeud(element);
		Noeud noeudSuivant = noeudElement.suivant;
		Noeud noeudAAjouter = new Noeud(elementAInserer, noeudElement, noeudElement.suivant);
		noeudElement.suivant = noeudAAjouter;
		noeudSuivant.precedent = noeudAAjouter;
		mapElt.put(elementAInserer, noeudAAjouter);
		taille++;
		numVersion++;
		return true;
	}
	
	/**
	 * insere le 2eme element passe en parametre avant le 1er element passe en parametre
	 * @param element l element avant lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si le 1er element passe en parametre est present dans la liste, false sinon
	 * @throws DejaPresentException si l element a inserer est deja present
	 */
	public boolean insererAvant(E element, E elementAInserer) {
		if (element == null || elementAInserer == null)
			throw new IllegalArgumentException();
		if (mapElt.containsKey(elementAInserer))
			throw new DejaPresentException();
		if (!mapElt.containsKey(element))
			return false;
		Noeud noeudElement = donnerNoeud(element);
		Noeud noeudPrec = noeudElement.precedent;
		Noeud noeudAAjouter = new Noeud(elementAInserer, noeudElement.precedent, noeudElement);
		noeudPrec.suivant = noeudAAjouter;
		noeudElement.precedent = noeudAAjouter;
		mapElt.put(elementAInserer, noeudAAjouter);
		taille++;
		numVersion++;
		return true;
	}

	/**
	 * supprime de la liste l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element est present, false sinon
	 */
	public boolean supprimer(E element) {
		if (element == null)
			throw new IllegalArgumentException();
		if(!mapElt.containsKey(element))
			return false;
		Noeud noeudASuppr = donnerNoeud(element);
		Noeud prec = noeudASuppr.precedent;
		Noeud suiv = noeudASuppr.suivant;
		prec.suivant = suiv;
		suiv.precedent = prec;
		mapElt.remove(element);
		taille--;
		numVersion++;
		return true;
	}

	/**
	 * permute les 2 elements passes en parametre
	 * @param element1
	 * @param element2
	 * @return true si les 2 elements sont bien presents, false sinon
	 */
	public boolean permuter(E element1, E element2) {
		if (taille == 0)
			throw new ListeVideException();
		if (element1 == null || element2 == null)
			throw new IllegalArgumentException();
		if (!mapElt.containsKey(element1) || !mapElt.containsKey(element2))
			return false;
		Noeud noeudE2 = donnerNoeud(element2);
		Noeud noeudE1 = donnerNoeud(element1);
		E elemE2 = noeudE2.element;
		E elemE1 = noeudE1.element;
		noeudE1.element = elemE2;
		noeudE2.element = elemE1;	
		mapElt.put(element1, noeudE2);
		mapElt.put(element2, noeudE1);
		numVersion++; 
		return true;
	}
	
	/**
	 * Renvoie le precedent de l'element
	 * @param element
	 * @return le precedent de l'element s'il existe, null sinon et null si premier
	 */
	public E donnerPrecedent(E element) {
		return donnerNoeud(element).precedent.element;
	}
	
	/**
	 * Renvoie le suivant de l'element
	 * @param element
	 * @return le suivant de l'element s'il existe, null sinon et null si dernier
	 */
	public E donnerSuivant(E element) {
		return donnerNoeud(element).suivant.element;
	}
	
	/**
	 * cree un iterateur
	 * @return un iterateur de la liste
	 */
	public Iterator<E> iterator() {
		return new IterateurImpl<>();
	}
	
	public String toString() {
		String texte = "";
		Noeud baladeur = tete.suivant;
		while (baladeur != queue) {
			texte += baladeur.element + " ";
			baladeur = baladeur.suivant;
		}
		return texte;
	}

	private class Noeud {
		private E element;
		private Noeud precedent;
		private Noeud suivant;

		private Noeud(E element, Noeud precedent, Noeud suivant) {
			this.element = element;
			this.precedent = precedent;
			this.suivant = suivant;
		}
		private Noeud(){
			this.element = null;
			this.precedent = null;
			this.suivant = null;
		}
	}


	private class IterateurImpl<E> implements Iterator<E>{
		
		private Noeud noeudCourant;
		private int version;
	
		private IterateurImpl() {
			noeudCourant = tete.suivant;
			version = numVersion;
		}
		
		public boolean hasNext() {
			return noeudCourant != queue;
		}

		public E next() {
			if (numVersion != version)
				throw new ConcurrentModificationException();
			if(!hasNext()) 
				throw new NoSuchElementException();
			Noeud aRenvoyer = noeudCourant;
			noeudCourant = noeudCourant.suivant;
		  return (E)aRenvoyer.element;
		}

		public void remove() {
			throw new UnsupportedOperationException();			
		}	
	}
}
