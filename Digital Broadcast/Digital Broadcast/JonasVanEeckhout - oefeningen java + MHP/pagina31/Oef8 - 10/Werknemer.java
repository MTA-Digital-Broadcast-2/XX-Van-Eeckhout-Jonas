public class Werknemer implements Betaalbaar
{
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float RSZpercentage;

	public Werknemer(String voornaam, String achternaam, int wNummer, float salaris)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.werknemerNummer = wNummer;
		this.salaris = salaris;
		this.RSZpercentage = 33;
	}

	public void salarisVerhogen(int percentage)
	{
		float verhogingsfactor = (float)percentage/100;
		salaris += salaris*verhogingsfactor;
	}

	public float getSalaris()
	{
		return salaris;
	}

	public float getRSZ()
	{
		return RSZpercentage;
	}

	public void setRSZ(int value)
	{
		RSZpercentage = value;	
	}

	public void betaal()
	{
		System.out.println("Betaal het salaris van " + this.salaris + " aan de werknemer " + this.voornaam + " " + this.achternaam);
	}

	
}