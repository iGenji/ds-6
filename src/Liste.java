import java.util.Iterator;


public interface Liste<E> {
	
	public int taille();

	public boolean estVide();

	public boolean contient(E element);

	public E premier()throws ListeVideException;
	
	public E dernier()throws ListeVideException;

	public void insererEnTete(E element);
	
	public void insererEnFin(E element);

	public boolean insererApres(E element, E elementAInserer);
	
	public boolean insererAvant(E element, E elementAInserer);
	
	public boolean supprimer(E element);

	public String toString();
	
	public Iterator<Object> iterator();
	

}
