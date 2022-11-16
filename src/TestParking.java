
public class TestParking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*******");
		System.out.println("Parking");
		System.out.println("");
		System.out.println("*******");
		Parking p = new Parking();

		System.out.println("Test1 : ajout de 3 voitures differentes");

		System.out.println("p.ajouterAutorisation(AAA000, proprioA) "+ p.ajouterAutorisationVoiture("1AAA000", new Proprietaire("proprioA")));
		System.out.println("p.toString "+p);
		System.out.println();

		System.out.println("p.ajouterVoiture(BBB000, proprioB) "+ p.ajouterAutorisationVoiture("1BBB000", new Proprietaire("proprioB")));
		System.out.println("p.toString "+p);
		System.out.println();

		System.out.println("p.ajouterVoiture(1CCC000, proprioC) "+ p.ajouterAutorisationVoiture("1CCC000", new Proprietaire("proprioC")));
		System.out.println("p.toString "+p);
		System.out.println();


		System.out.println("Test2 : ajout d'1 voiture existante");
		System.out.println("p.ajouterVoiture(1CCC000, proprioC) "+ p.ajouterAutorisationVoiture("1CCC000", new Proprietaire("proprioC")));
		System.out.println("p.toString "+p);
		System.out.println();

		System.out.println("Test3 : test voiture autorisee");
		System.out.println("p.estAutorisee(1BBB000) "+ p.estAutorisee("1BBB000"));
		System.out.println();

		System.out.println("Test4 : test voiture non autorisee");
		System.out.println("p.voitureAutorisee(1XXX000) "+ p.estAutorisee("1XXX000"));
		System.out.println();


		System.out.println("Test5 : suppression d'1 voiture existante");
		System.out.println("p.retirerAutorisationVoiture(1BBB000) "+ p.retirerAutorisationVoiture("1BBB000"));
		System.out.println("p.toString "+p);
		System.out.println();

		System.out.println("Test6 : suppression d'1 voiture non existante");
		System.out.println("p.retirerAutorisationVoiture(1BBB000) "+ p.retirerAutorisationVoiture("1BBB000"));
		System.out.println("p.toString "+p);
		System.out.println();

		System.out.println("Test7 : proprietaire d'1 voiture existante");
		System.out.println("p.getProprietaire(1AAA000) "+ p.getProprietaire("1AAA000"));
		System.out.println();

		System.out.println("Test8 : proprietaire d'1 voiture non existante");
		System.out.println("p.getProprietaire(1XXX000) "+ p.getProprietaire("1XXX000"));
		System.out.println();

		try{
			System.out.println("Test9 : entree d'1 voiture autorisee");
			System.out.println("p.entrerVoiture(1AA000) "+ p.entrerVoiture("1AAA000"));
			System.out.println("p.toString "+p);
			System.out.println();
		}catch (IllegalStateException e){
			System.out.println("Attention IllegalStateException");
		}

		try{
			System.out.println("Test10 : entree d'1 voiture autorisee qui est deja presente");
			System.out.println("p.entrerVoiture(1AA000) "+ p.entrerVoiture("1AAA000"));
			System.out.println("p.toString "+p);
			System.out.println("Attention IllegalStateException");
			System.out.println();
		}catch (IllegalStateException e){
			System.out.println("IllegalStateException");
		}

		try{
			System.out.println("Test11 : entree d'1 voiture non autorisee");
			System.out.println("p.entrerVoiture(1XXX000) "+ p.entrerVoiture("1XXX000"));
			System.out.println("p.toString "+p);
			System.out.println();
		}catch (IllegalStateException e){
			System.out.println("Attention IllegalStateException");
		}

		try{
			System.out.println("Test12 : sortie d'1 voiture presente");
			System.out.println("p.sortirVoiture(1AAA000) "+ p.sortirVoiture("1AAA000"));
			System.out.println("p.toString "+p);
			System.out.println();
		}catch (IllegalStateException e){
			System.out.println("Attention IllegalStateException");
		}

		try{
			System.out.println("Test10 : sortie d'1 voiture autorisee non presente");
			System.out.println("p.sortirVoiture(1AA000) "+ p.sortirVoiture("1CCC000"));
			System.out.println("p.toString "+p);
			System.out.println("Attention IllegalStateException");
			System.out.println();
		}catch (IllegalStateException e){
			System.out.println("IllegalStateException");
		}

	}

}
