public class TestDicoSD {

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a reçu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+" Attendu="+attendu+" reçu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+" Attendu="+attendu+" reçu="+recu);
			System.exit(0);			
		}
	}
	public static void main(String[] args) {
		DicoSD dico = new DicoSD();
		
		// test1 : dico vide
		assertEquals("Test1 ko : le dico est vide : pile present?",false, dico.contient("pile"));
		assertEquals("Test1 ko : le dico est vide : aucun lien pour pile : ", "[]", dico.lesLiens("pile"));
		assertEquals("Test1 ko : le dico est vide : suppression pile - lienPile : ", false, dico.supprimer("pile","lienPile"));
		
		// test2 : ajout pile -lienPile1 dans un dico vide
		assertEquals("Test2 ko : le dico au depart est vide, on ajoute pile - lienPile1   ajout? ",true,dico.ajouter("pile", "lienPile1"));
		assertEquals("Test2 ko : le dico au depart est vide, on ajoute pile : lienPile1  contenu pile ? ", "[lienPile1]", dico.lesLiens("pile"));
		assertEquals("Test2 ko : le dico au depart est vide, on vient d'ajouter pile : pile present? ", true, dico.contient("pile"));
		assertEquals("Test2 ko : le dico au depart est vide, on vient d'ajouter pile : ensemble present? ", false, dico.contient("ensemble"));
		
		// test3 : ajout pile- lienPile2 dans le dico qui contient pile - lienPile1, 
		assertEquals("Test3 ko : le dico contient pile - lienPile1, on ajoute pile - lienPile2   ajout? ",true,dico.ajouter("pile", "lienPile2"));
		assertEquals("Test3 ko : le dico contient pile - lienPile1, on ajoute pile - lienPile2   contenu pile ? ", "[lienPile1, lienPile2]", dico.lesLiens("pile"));
		
		// test4 : ajout pile- lienPile2 dans le dico qui contient pile - lienPile1 et pile - lienPile2
		assertEquals("Test4 ko : le dico contient pile - lienPile1 et lienPile2, on ajoute pile - lienPile2  ajout?",false,dico.ajouter("pile", "lienPile2"));
		assertEquals("Test4 ko : le dico contient pile - lienPile1 et lienPile2, on ajoute pile - lienPile2  contenu pile ? ","[lienPile1, lienPile2]", dico.lesLiens("pile"));
		
		// test5 : ajout pile- lienPile1 dans le dico qui contient pile - lienPile1 et pile - lienPile2
		assertEquals("Test5 ko : le dico contient pile - lienPile1 et lienPile2, on ajoute pile - lienPile1  ajout? " ,false,dico.ajouter("pile", "lienPile1"));
		assertEquals("Test5 ko : le dico contient pile - lienPile1 et lienPile2, on ajoute pile - lienPile1  contenu pile? ","[lienPile1, lienPile2]", dico.lesLiens("pile"));
		
		// test6 : ajout ensemble - lienEnsemble1 dans le dico qui contient pile - lienPile1 et pile - lienPile2
		assertEquals("Test6 ko : le dico contient pile - lienPile1 et lienPile2, on ajoute ensemble - lienEnsemble1  ajout? ",true, dico.ajouter("ensemble","lienEnsemble1"));
		assertEquals("Test6 ko : le dico contient pile - lienPile1 et lienPile2, on ajoute ensemble - lienEnsemble1  contenu ensemble? ","[lienEnsemble1]", dico.lesLiens("ensemble"));
		
		// test7 : supprime pile- lienPile2 dans le dico qui contient pile - lienPile1, pile - lienPile2, ensemble - lienEnsemble1
		assertEquals("Test7 ko : le dico contient pile - lienPile1 et lienPile2, on supprime pile - lienPile1  suppression? ",true, dico.supprimer("pile", "lienPile1"));
		assertEquals("Test7 ko : le dico contient pile - lienPile1 et lienPile2, on supprime pile - lienPile1  contenu? ","[lienPile2]", dico.lesLiens("pile"));
		assertEquals("Test7 ko : le dico contient pile - lienPile1 et lienPile2, on supprime pile - lienPile1  pile present? ",true, dico.contient("pile"));
		
		// test8 : supprime pile- lienPile2 dans le dico qui contient pile - lienPile2, ensemble - lienEnsemble1
				assertEquals("Test7 ko : le dico contient pile - lienPile2, on supprime pile - lienPile2  suppression? ",true, dico.supprimer("pile", "lienPile2"));
				assertEquals("Test7 ko : le dico contient pile - lienPile2, on supprime pile - lienPile2  contenu? ","[]", dico.lesLiens("pile"));
				assertEquals("Test7 ko : le dico contient pile - lienPile2, on supprime pile - lienPile2  pile present? ",false, dico.contient("pile"));
		System.out.println("Tous les tests ont reussi!");
	}

}
