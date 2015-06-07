public class Faktuur
{
	public int faktuurNr;
	public int faktuurBedrag;

	public Faktuur(int nr, int bedrag)
	{
		this.faktuurNr = nr;
		this.faktuurBedrag = bedrag;	
	}

	public void betaal()
	{
		System.out.println("Betaal het faktuur " + this.faktuurNr + " voor een bedrag van " + this.faktuurBedrag);	
	}
}