import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeImpl<E> implements Liste<E>, Iterable<Object>  {

	private Noeud tete, queue;
	private int taille;
	private int numVersion; //pour l'iterateur

	public ListeImpl(){
		tete = new Noeud();  // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		tete.suivant = queue;
		queue.precedent = tete;
		taille=0;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeImpl(Object[] table) {
		this.taille = table.length;
		tete = new Noeud();
		queue = new Noeud();  
		tete.suivant = queue;
		queue.precedent = tete;
		for (int i = table.length-1; i>=0; i--) {
			Noeud nouveauNoeud = new Noeud(this.tete,table[i],this.tete.suivant);
			
			this.tete.suivant.precedent=nouveauNoeud;
			this.tete.suivant=nouveauNoeud;
		}	
	}
	
	public int taille(){
		return taille;
	}

	public boolean estVide(){
		return taille==0;
	}

	// A ne pas modifier ! Methode utilisee pour les tests
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=tete.suivant;
		while(baladeur!=queue) {
			aRenvoyer+=" "+baladeur.element;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}
	
	
	// A ne pas modifier ! Methode utilisee pour les tests
	public boolean equals(ListeImpl l){
		if(taille!=l.taille)
			return false;
		if(!this.toString().equals(l.toString()))
			return false;
		Noeud baladeurThis = queue.precedent;
		Noeud baladeurL = l.queue.precedent;
		while(baladeurThis!=tete){
			if(!baladeurL.element.equals(baladeurThis.element))
					return false;
			baladeurL = baladeurL.precedent;
			baladeurThis = baladeurThis.precedent;
		}
		return true;
		
	}

	/**
	 * cette methode insere un nouveau noeud en tete de liste
	 * @param element l'element contenu dans le nouveau noeud insere
	 */
	public void insererEnTete(E element) {
		// A COMPLETER
	}

	
	/**
	 * cette methode insere un nouveau noeud en fin de liste
	 * @param element l'element contenu dans le nouveau noeud insere
	 */
	public void insererEnFin(E element) {
		// A COMPLETER
		
	}

	/**
	 * cette methode renvoie l'element contenu dans le premier noeud sans l'enlever
	 * @return l'element de tete
	 * @throws ListeVideException si la liste est vide
	 */
	public E premier()throws ListeVideException{
		return null;
		// A COMPLETER
		// Ne renvoyez pas le noeud, mais l'element!
	}

	/**
	 * cette methode renvoie l'element contenu dans le dernier noeud sans l'enlever
	 * @return l'element de queue
	 * @throws ListeVideException si la liste est vide
	 */
	public E dernier()throws ListeVideException{
		return null;
		// A COMPLETER
		// Ne renvoyez pas le noeud, mais l'element!
	}

	/**
	 * cette methode recherche le noeud qui contient la premiere occurrence de l'element passe en parametre
	 * @param element l'element recherche
	 * @return le noeud recherche ou null si l'element n'est pas present dans la liste
	 */
	private Noeud trouverNoeud(E element){
		// A COMPLETER
		return null;
	}

	/**
	 * cette methode verifie la presence de l'element passe en parametre dans la liste
	 * @param element l'element recherche
	 * @return true si l'element est present, false sinon
	 */
	public boolean contient(E element){
		// A COMPLETER
		// PENSEZ A UTILISER LA METHODE trouverNoeud(E element)!!!
		return false;
	}


	

	/**
	 * cette methode insere un nouveaud noeud apres le noeud contenant la premiere occurrence de l'element passe en parametre
	 * @param element l'element recherche
	 * @param elementAInserer l'element qui est place dans le nouveau noeud
	 * @return true si l'element recherche est present dans la liste, false sinon
	 */
	public boolean insererApres(E element, E elementAInserer){
		// A COMPLETER
		// PENSEZ A UTILISER LES METHODES trouverNoeud(E element) !!!
		return false;
	}

	

	/**
	 * cette methode insere un nouveaud noeud avant le noeud contenant la premiere occurrence de l'element passe en parametre
	 * @param element l'element recherche
	 * @param elementAInserer l'element qui est place dans le nouveau noeud
	 * @return true si l'element recherche est present dans la liste, false sinon
	 */
	public boolean insererAvant(E element, E elementAInserer){
		// A COMPLETER
		// PENSEZ A UTILISER LES METHODES trouverNoeud(E element) !!!
		return false;
	}


	/**
	 * cette methode supprime le noeud contenant la premiere occurrence de l'element passe en parametre
	 * @param element l'element a supprimer
	 * @return true si l'element a supprimer est present dans la liste, false sinon
	 */
	public boolean supprimer(E element){
		// A COMPLETER
		// PENSEZ A UTILISER LES METHODES trouverNoeud(E element) !!!
		return false;
	}

	@Override
	public Iterator<Object> iterator() {
		// A COMPLETER
		return new IterateurImpl();
	}


	private class Noeud<E> {
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud() {
			this(null, null, null);
		}

		private Noeud(E element) {
			this(null, element, null);
		}

		private Noeud(Noeud precedent, E element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
			this.precedent = precedent;
		}

		public E element() {
			return element;
		}
	}


	private class IterateurImpl implements Iterator<Object>{

		private Noeud noeudCourant;
		private int version;


		private IterateurImpl() {
			// A COMPLETER
		}

		@Override
		public boolean hasNext() {
			// A COMPLETER
			return false;
		}

		@Override
		public Object next() {
			if (!hasNext()) throw new NoSuchElementException();
			// A COMPLETER
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			// A NE PAS COMPLETER : Les suppressions sont interdites
		}

	}

}