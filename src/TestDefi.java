import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class TestDefi {
	private final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {	
		
		System.out.println("****************************************");
		System.out.println("Programme Test pour la classe Liste2Impl");
		System.out.println("****************************************");
	
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode premier()");
			System.out.println("2 -> Tester la methode dernier()");
			System.out.println("3 -> Tester la methode insererEnTete()");
			System.out.println("4 -> Tester la methode insererEnFin()");
			System.out.println("5 -> Tester la methode contient()");			
			System.out.println("6 -> Tester la methode insererApres()'");
			System.out.println("7 -> Tester la methode insererAvant()'");
			System.out.println("8 -> Tester la methode supprimer()");
			System.out.println("9 -> Tester la methode iterator()");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testPremier();
				break;
			case 2:
				testDernier();
				break;
			case 3:
				testInsererEnTete();
				break;
			case 4:
				testInsererEnFin();
				break;
			case 5:				
				testContient();
				break;
			case 6:
				testInsererApres();
				break;
			case 7:
				testInsererAvant();
				break;
			case 8:
				testSupprimer();
				break;
			case 9:
				testIterator();
				break;
		
			default:
				break;
			}

		} while (choix >= 1 && choix <= 9);
	}


	
	// SUPPRIMER()
	private static void testSupprimer() {	
		System.out.println();
		System.out.println("Tests methode supprimer()");
		System.out.print("Test 1 : listeVide :");
		ListeImpl listeVide = new ListeImpl();
		try{
			if(listeVide.supprimer("a")){
				System.out.println(" KO : booleen renvoye : true!");
				return;
			}		
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : liste a b c : supprimer a : ");
		String[] tabc = {"a","b","c"};
		ListeImpl labc = new ListeImpl(tabc);
		String[] tbc = {"b","c"};
		ListeImpl lbc = new ListeImpl(tbc);
		String[] tab = {"a","b"};
		ListeImpl lab = new ListeImpl(tab);
		String[] tac = {"a","c"};
		ListeImpl lac = new ListeImpl(tac);
		try{
			if(!labc.supprimer(new String("a"))){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}	
			if(labc.taille()!=2){
				System.out.println(" KO : taille obtenue : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" b c")){
				System.out.println(" KO : contenu liste obtenu : "+ labc);
				return;
			}
			if(!labc.equals(lbc)){
				System.out.println(" KO : double chainage a revoir");
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 3 : liste a b c : supprimer b : ");
		labc = new ListeImpl(tabc);
		try{
			if(!labc.supprimer("b")){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}	
			if(labc.taille()!=2){
				System.out.println(" KO : taille obtenue : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a c")){
				System.out.println(" KO : contenu liste obtenu : "+ labc);
				return;
			}
			if(!labc.equals(lac)){
				System.out.println(" KO : double chainage a revoir");
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 4 : liste a b c : supprimer c : ");
		labc = new ListeImpl(tabc);
		try{
			if(!labc.supprimer("c")){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}	
			if(labc.taille()!=2){
				System.out.println(" KO : taille obtenue : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a b")){
				System.out.println(" KO : contenu liste obtenu : "+ labc);
				return;
			}
			if(!labc.equals(lab)){
				System.out.println(" KO : double chainage a revoir");
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 5 : liste a b c : supprimer d : ");
		labc = new ListeImpl(tabc);
		try{
			if(labc.supprimer("d")){
				System.out.println(" KO : booleen renvoye : true!");
				return;
			}	
			if(labc.taille()!=3){
				System.out.println(" KO : taille a change : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste a change : "+ labc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 6 : liste a : supprimer a : ");
		String[] ta = {"a"};
		ListeImpl la = new ListeImpl(ta);
		try{
			if(!la.supprimer("a")){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}	
			if(la.taille()!=0){
				System.out.println(" KO : taille obtenue : " + la.taille());
				return;
			}
			if(!la.toString().equals("")){
				System.out.println(" KO : contenu liste obtenu : "+ la);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	
	}

	
	// InSERERERAPRES()
	private static void testInsererApres() {
		System.out.println();
		System.out.println("Tests methode insererApres()");
		System.out.print("Test 1 : listeVide :");
		ListeImpl listeVide = new ListeImpl();
		try{
			if(listeVide.insererApres("a", "b")){
				System.out.println(" KO : booleen renvoye : true!");
				return;
			}		
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : liste a b c : inserer x apres a : ");
		String[] tabc = {"a","b","c"};
		ListeImpl labc = new ListeImpl(tabc);
		try{
			if(!labc.insererApres(new String("a"), "x")){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}	
			if(labc.taille()!=4){
				System.out.println(" KO : taille obtenue : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a x b c")){
				System.out.println(" KO : contenu liste obtenu : "+ labc);
				return;
			}
			String[] taxbc = {"a","x","b","c"};
			ListeImpl laxbc = new ListeImpl(taxbc);
			if(!labc.equals(laxbc)){
				System.out.println(" KO : double chainage a revoir");
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 3 : liste a b c : inserer x apres b : ");
		labc = new ListeImpl(tabc);
		try{
			if(!labc.insererApres("b", "x")){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}	
			if(labc.taille()!=4){
				System.out.println(" KO : taille obtenue : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a b x c")){
				System.out.println(" KO : contenu liste obtenu : "+ labc);
				return;
			}
			String[] tabxc = {"a","b","x","c"};
			ListeImpl labxc = new ListeImpl(tabxc);
			if(!labc.equals(labxc)){
				System.out.println(" KO : double chainage a revoir");
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 4 : liste a b c : inserer x apres c : ");
		labc = new ListeImpl(tabc);
		try{
			if(!labc.insererApres("c", "x")){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}	
			if(labc.taille()!=4){
				System.out.println(" KO : taille obtenue : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a b c x")){
				System.out.println(" KO : contenu liste obtenu : "+ labc);
				return;
			}
			String[] tabcx = {"a","b","c","x"};
			ListeImpl labcx = new ListeImpl(tabcx);
			if(!labc.equals(labcx)){
				System.out.println(" KO : double chainage a revoir");
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 5 : liste a b c : inserer x apres d : ");
		labc = new ListeImpl(tabc);
		try{
			if(labc.insererApres("d", "x")){
				System.out.println(" KO : booleen renvoye : true!");
				return;
			}	
			if(labc.taille()!=3){
				System.out.println(" KO : taille a change : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste a change : "+ labc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.println("Tous les tests ont reussi!");	
	}

	
	// InSERERERAVANT()
		private static void testInsererAvant() {
			System.out.println();
			System.out.println("Tests methode insererAvant()");
			System.out.print("Test 1 : listeVide :");
			ListeImpl listeVide = new ListeImpl();
			try{
				if(listeVide.insererAvant("a", "b")){
					System.out.println(" KO : booleen renvoye : true!");
					return;
				}		
			}catch (Exception ex){
				System.out.println(" KO, il y a eu Exception : ");
				ex.printStackTrace();
				return;
			}
			System.out.println(" ok");
			
			
			System.out.print("Test 2 : liste a b c : inserer x avant a : ");
			String[] tabc = {"a","b","c"};
			ListeImpl labc = new ListeImpl(tabc);
			try{
				if(!labc.insererAvant(new String("a"), "x")){
					System.out.println(" KO : booleen renvoye : false!");
					return;
				}	
				if(labc.taille()!=4){
					System.out.println(" KO : taille obtenue : " + labc.taille());
					return;
				}
				if(!labc.toString().equals(" x a b c")){
					System.out.println(" KO : contenu liste obtenu : "+ labc);
					return;
				}
				String[] txabc = {"x","a","b","c"};
				ListeImpl lxabc = new ListeImpl(txabc);
				if(!labc.equals(lxabc)){
					System.out.println(" KO : double chainage a revoir");
					return;
				}
			}catch (Exception ex){
				System.out.println(" ko, il y a eu Exception : ");
				ex.printStackTrace();
				return;
			}
			System.out.println(" ok");
			
			System.out.print("Test 3 : liste a b c : inserer x avant b : ");
			labc = new ListeImpl(tabc);
			try{
				if(!labc.insererAvant("b", "x")){
					System.out.println(" KO : booleen renvoye : false!");
					return;
				}	
				if(labc.taille()!=4){
					System.out.println(" KO : taille obtenue : " + labc.taille());
					return;
				}
				if(!labc.toString().equals(" a x b c")){
					System.out.println(" KO : contenu liste obtenu : "+ labc);
					return;
				}
				String[] taxbc = {"a","x","b","c"};
				ListeImpl laxbc = new ListeImpl(taxbc);
				if(!labc.equals(laxbc)){
					System.out.println(" KO : double chainage a revoir");
					return;
				}
			}catch (Exception ex){
				System.out.println(" ko, il y a eu Exception : ");
				ex.printStackTrace();
				return;
			}
			System.out.println(" ok");
			
			System.out.print("Test 4 : liste a b c : inserer x avant c : ");
			labc = new ListeImpl(tabc);
			try{
				if(!labc.insererAvant("c", "x")){
					System.out.println(" KO : booleen renvoye : false!");
					return;
				}	
				if(labc.taille()!=4){
					System.out.println(" KO : taille obtenue : " + labc.taille());
					return;
				}
				if(!labc.toString().equals(" a b x c")){
					System.out.println(" KO : contenu liste obtenu : "+ labc);
					return;
				}
				String[] tabxc = {"a","b","x","c"};
				ListeImpl labxc = new ListeImpl(tabxc);
				if(!labc.equals(labxc)){
					System.out.println(" KO : double chainage a revoir");
					return;
				}
			}catch (Exception ex){
				System.out.println(" ko, il y a eu Exception : ");
				ex.printStackTrace();
				return;
			}
			System.out.println(" ok");
			
			System.out.print("Test 5 : liste a b c : inserer x avant d : ");
			labc = new ListeImpl(tabc);
			try{
				if(labc.insererAvant("d", "x")){
					System.out.println(" KO : booleen renvoye : true!");
					return;
				}	
				if(labc.taille()!=3){
					System.out.println(" KO : taille a change : " + labc.taille());
					return;
				}
				if(!labc.toString().equals(" a b c")){
					System.out.println(" KO : contenu liste a change : "+ labc);
					return;
				}
			}catch (Exception ex){
				System.out.println(" ko, il y a eu Exception : ");
				ex.printStackTrace();
				return;
			}
			System.out.println(" ok");
			
			
			System.out.println("Tous les tests ont reussi!");	
		}
	
	
	
	// DERNIER()
	private static void testDernier() {
		System.out.println("Tests methode dernier()");
		System.out.println();
		System.out.print("Test 1 : listeVide :");
		ListeImpl listeVide = new ListeImpl();
		try{
			listeVide.dernier();
			System.out.println(" KO, il fallait une ListeVideException");
			return;
		}catch (ListeVideException e){
			
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : liste a b c :");
		String[] tabc = {"a","b","c"};
		ListeImpl labc = new ListeImpl(tabc);
		try{
			Object o = labc.dernier();
			if(!(o instanceof String)){
				System.out.println(" KO : la liste testee contient des objets de la classe String");
				System.out.println("         Verifiez si votre methode renvoie bien l'element contenu dans le noeud et non le noeud");
				return;
			}
			String s = (String) o;
			if(!s.equals("c")){
				System.out.println(" KO : premier renvoye : "+ s);
				return;
			}
			if(!labc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste  a change : "+ labc);
			}
		}catch (ListeVideException e){
			System.out.println(" ko, il y a eu ListeVideException : ");
			return;
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	
	}

	
	// PREMIER()
		private static void testPremier() {
			System.out.println("Tests methode premier()");
			System.out.println();
			System.out.print("Test 1 : listeVide :");
			ListeImpl listeVide = new ListeImpl();
			try{
				listeVide.premier();
				System.out.println(" KO, il fallait une ListeVideException");
				return;
			}catch (ListeVideException e){
				
			}catch (Exception ex){
				System.out.println(" KO, il y a eu Exception : ");
				ex.printStackTrace();
				return;
			}
			System.out.println(" ok");
			
			
			System.out.print("Test 2 : liste a b c :");
			String[] tabc = {"a","b","c"};
			ListeImpl labc = new ListeImpl(tabc);
			try{
				Object o = labc.premier();
				if(!(o instanceof String)){
					System.out.println(" KO : la liste testee contient des objets de la classe String");
					System.out.println("         Verifiez si votre methode renvoie bien l'element contenu dans le noeud et non le noeud");
					return;
				}
				String s = (String) o;
				if(!s.equals("a")){
					System.out.println(" KO : premier renvoye : "+ s);
					return;
				}
				if(!labc.toString().equals(" a b c")){
					System.out.println(" KO : contenu liste  a change : "+ labc);
				}
			}catch (ListeVideException e){
				System.out.println(" ko, il y a eu ListeVideException : ");
				return;
			}catch (Exception ex){
				System.out.println(" ko, il y a eu Exception : ");
				ex.printStackTrace();
				return;
			}
			System.out.println(" ok");
			System.out.println("Tous les tests ont reussi!");	
		}

	
	
	
	// CONTIENT()
	private static void testContient() {	
		System.out.println();
		System.out.println("Tests methode contient()");
		System.out.print("Test 1 : listeVide :");
		ListeImpl listeVide = new ListeImpl();
		try{
			if(listeVide.supprimer("a")){
				System.out.println(" KO : booleen renvoye : true!");
				return;
			}		
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : liste a b c : contient a : ");
		String[] tabc = {"a","b","c"};
		ListeImpl labc = new ListeImpl(tabc);
		try{
			if(!labc.contient(new String("a"))){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}
			if(labc.taille()!=3){
				System.out.println(" KO : taille a change : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste a change : "+ labc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 3 : liste a b c : contient b : ");
		labc = new ListeImpl(tabc);
		try{
			if(!labc.contient("b")){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}
			if(labc.taille()!=3){
				System.out.println(" KO : taille a change : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste a change : "+ labc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 4 : liste a b c : contient c : ");
		labc = new ListeImpl(tabc);
		try{
			if(!labc.contient("c")){
				System.out.println(" KO : booleen renvoye : false!");
				return;
			}	
			if(labc.taille()!=3){
				System.out.println(" KO : taille a change : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste a change : "+ labc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 5 : liste a b c : contient d : ");
		labc = new ListeImpl(tabc);
		try{
			if(labc.contient("d")){
				System.out.println(" KO : booleen renvoye : true!");
				return;
			}	
			if(labc.taille()!=3){
				System.out.println(" KO : taille a change : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste a change : "+ labc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.println("Tous les tests ont reussi!");	
	}

	
	// INSERERENTETE()
	private static void testInsererEnTete() {
		System.out.println();
		System.out.println("Tests methode insererEnTete()");
		System.out.print("Test 1 : listeVide :");
		ListeImpl listeVide = new ListeImpl();
		try{
			listeVide.insererEnTete("a");
			if(listeVide.taille()!=1){
				System.out.println(" KO : taille obtenue : " + listeVide.taille());
				return;
			}
			if(!listeVide.toString().equals(" a")){
				System.out.println(" KO : contenu liste obtenu : "+ listeVide);
				return;
			}
			String[] ta = {"a"};
			ListeImpl la = new ListeImpl(ta);
			if(!listeVide.equals(la)){
				System.out.println(" KO : double chainage a revoir");
				return;
			}
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : liste a b c : inserer en tete x : ");
		String[] tabc = {"a","b","c"};
		ListeImpl labc = new ListeImpl(tabc);
		try{
			labc.insererEnTete("x");
			if(labc.taille()!=4){
				System.out.println(" KO : taille obtenue : " + labc.taille());
				return;
			}
			if(!labc.toString().equals(" x a b c")){
				System.out.println(" KO : contenu liste obtenu : "+ labc);
				return;
			}
			String[] txabc = {"x","a","b","c"};
			ListeImpl lxabc = new ListeImpl(txabc);
			if(!labc.equals(lxabc)){
				System.out.println(" KO : double chainage a revoir");
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	
	}
	
	// INSERERENFIN()
		private static void testInsererEnFin() {
			System.out.println();
			System.out.println("Tests methode insererEnFin()");
			System.out.print("Test 1 : listeVide :");
			ListeImpl listeVide = new ListeImpl();
			try{
				listeVide.insererEnFin("a");
				if(listeVide.taille()!=1){
					System.out.println(" KO : taille obtenue : " + listeVide.taille());
					return;
				}
				if(!listeVide.toString().equals(" a")){
					System.out.println(" KO : contenu liste obtenu : "+ listeVide);
					return;
				}
				String[] ta = {"a"};
				ListeImpl la = new ListeImpl(ta);
				if(!listeVide.equals(la)){
					System.out.println(" KO : double chainage a revoir");
					return;
				}
			}catch (Exception ex){
				System.out.println(" KO, il y a eu Exception : ");
				ex.printStackTrace();
				return;
			}
			System.out.println(" ok");
			
			
			System.out.print("Test 2 : liste a b c : inserer en fin x : ");
			String[] tabc = {"a","b","c"};
			ListeImpl labc = new ListeImpl(tabc);
			try{
				labc.insererEnFin("x");
				if(labc.taille()!=4){
					System.out.println(" KO : taille obtenue : " + labc.taille());
					return;
				}
				if(!labc.toString().equals(" a b c x")){
					System.out.println(" KO : contenu liste obtenu : "+ labc);
					return;
				}
				String[] tabcx = {"a","b","c","x"};
				ListeImpl labcx = new ListeImpl(tabcx);
				if(!labc.equals(labcx)){
					System.out.println(" KO : double chainage a revoir");
					return;
				}
			}catch (Exception ex){
				System.out.println(" ko, il y a eu Exception : ");
				ex.printStackTrace();
				return;
			}
			System.out.println(" ok");
			System.out.println("Tous les tests ont reussi!");	
		}
	
	
	
	
	// ITERATOR()
	private static void testIterator() {
		System.out.println();
		System.out.println("Tests methode iterator()");	
		System.out.print("Test 1 : listeVide :");
		ListeImpl listeVide = new ListeImpl();
		try{
			Iterator<Object> it = listeVide.iterator();
			if(it.hasNext()){
				System.out.println(" KO : booleen renvoye par hasNext : true!");
				return;
			}
			it.next();
			System.out.println("");
		}catch (NoSuchElementException ex){
			System.out.println(" ok");
		}catch (Exception e){
			System.out.println(" KO, il y a eu Exception : ");
			System.out.println("                         Verifier si votre methode next() leve bien une NoSuchElementException quand il n'y a plus d'element");
			e.printStackTrace();
			return;
		}
		System.out.print("Test 2 : liste a b c :");
		String[] tabc = {"a","b","c"};
		ListeImpl labc = new ListeImpl(tabc);
		try{
			Iterator<Object> it = labc.iterator();
			if(!it.hasNext()){
				System.out.println(" KO : booleen renvoye par hasNext : false!");
				return;
			}
			Object o = it.next();
			if(!(o instanceof String)){
				System.out.println(" KO : la liste testee contient des objets de la classe String");
				System.out.println("         Verifiez si votre methode renvoie bien l'element contenu dans le noeud et non le noeud");
				return;
			}
			String s = (String) o;
			if(!s.equals("a")){
				System.out.println(" KO : premier renvoye : "+ s);
				return;
			}
			if(!labc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste  a change : "+ labc);
			}
		}catch (NoSuchElementException ex){
			System.out.println(" KO, il y a eu une NoSuchElementException");
			return;
		}catch (Exception e){
			System.out.println(" KO, il y a eu Exception : ");
			System.out.println("                         Verifier si votre methode next() leve bien une NoSuchElementException quand il n'y a plus d'element");
			e.printStackTrace();
			return;
		}
		String forE = "";
		for (Object object : labc) {
			forE+=object;
		}
		if(!forE.equals("abc")){
			System.out.println(" KO, foreach a echoue");
		}
		try{
			Iterator<Object > it = labc.iterator();
			it.next();
			labc.contient("a");
			it.next();	
		}catch (ConcurrentModificationException ex){
			System.out.println(" KO , il a eu une ConcurrentModificationException apres appel de la methode contient() ");
			System.out.println("Cette methode ne modifie pas la liste.");
			return;
		}
		try{
			Iterator<Object > it = labc.iterator();
			it.next();
			labc.premier();
			it.next();	
		}catch (ConcurrentModificationException ex){
			System.out.println(" KO , il a eu une ConcurrentModificationException apres appel de la methode premier() ");
			System.out.println("Cette methode ne modifie pas la liste.");
			return;
		}
		try{
			Iterator<Object > it = labc.iterator();
			it.next();
			labc.insererEnTete("a");		
			it.next();	
			System.out.println(" KO , il fallait une ConcurrentModificationException apres appel de la methode insererEnTete() ");
			System.out.println("Cette methode modifie la liste.");
			
		}catch (ConcurrentModificationException ex){
		}
		try{
			Iterator<Object > it = labc.iterator();
			it.next();
			labc.insererApres("a","a");		
			it.next();	
			System.out.println(" KO , il fallait une ConcurrentModificationException apres appel de la methode insererApres() ");
			System.out.println("Cette methode modifie la liste.");
			
		}catch (ConcurrentModificationException ex){
		}
		try{
			Iterator<Object > it = labc.iterator();
			it.next();
			labc.supprimer("a");		
			it.next();	
			System.out.println(" KO , il fallait une ConcurrentModificationException apres appel de la methode supprimer() ");
			System.out.println("Cette methode modifie la liste.");
			
		}catch (ConcurrentModificationException ex){
		}
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	
	}

}
