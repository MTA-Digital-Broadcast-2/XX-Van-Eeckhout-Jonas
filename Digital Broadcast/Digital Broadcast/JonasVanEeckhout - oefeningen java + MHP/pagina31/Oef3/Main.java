public class Main
{
	public static void main(String args[])
	{
		Werknemer w1 = new Werknemer("Brecht", "Gorissen", 1, 2000);
		Werknemer w2 = new Werknemer("Goele", "Weytens", 2, 1800);
		Werknemer w3 = new Werknemer("Silke", "Iets", 3, 2200);
		Werknemer w4 = new Werknemer("Harrison", "Steinnogiets", 4, 1900);
		
		PartTimeWerknemer pw1 = new PartTimeWerknemer("Jonas", "Tempels", 5,  10, 20);
		PartTimeWerknemer pw2 = new PartTimeWerknemer("Sami", "Froncek", 6, 11, 15);

		w2.salarisVerhogen(10);
		w4.salarisVerhogen(20);	

		System.out.println(w1.getSalaris());
		System.out.println(w2.getSalaris());
		System.out.println(w3.getSalaris());
		System.out.println(w4.getSalaris());

		pw1.salarisVerhogen(10);
		pw2.salarisVerhogen(10);

		System.out.println(pw1.getSalaris());
		System.out.println(pw2.getSalaris());
	}
}