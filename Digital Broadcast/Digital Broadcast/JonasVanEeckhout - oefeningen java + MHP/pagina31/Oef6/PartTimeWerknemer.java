public class PartTimeWerknemer extends Werknemer
{
	public int urenGewerkt;

	public PartTimeWerknemer(String voornaam, String achternaam, int nr, float sal, int urengw)
	{
		super(voornaam, achternaam, nr, sal);
		this.urenGewerkt = urengw;
	}

	public void salarisVerhogen(int percentage)
	{
		if(percentage > 5)
		{
			System.out.println("Fout: Slechts 5% opslag toegeslaan!");		
		}

		else
		{
			super.salarisVerhogen(percentage);
		}
	}

	public float getWeekLoon()
	{
		return this.salaris * (float)this.urenGewerkt;
	}
}