import java.lang.*;
//oef3+4+5
class werknemerSalaris {

	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	public double salaris;
	private float RSZpercentage=0.33;

public static void main(String args[]){
	werknemerSalaris jos=new werknemerSalaris("Jos","Joske",1,1000,0.33);
	werknemerSalaris jef=new werknemerSalaris("Jef","Jefke",2,1250,0.33);
	werknemerSalaris benno=new werknemerSalaris("Benno","Bennoke",3,1500,0.55);
	werknemerSalaris simon=new werknemerSalaris("Simon","Simonneke",4,1600,55);

	jos.salarisVerhogen(10);
	jef.salarisVerhogen(10);
	System.out.println(jef.salaris);
	System.out.println(jos.salaris);
	System.out.println(benno.salaris);
	System.out.println(simon.salaris);
	System.out.println(simon.getRSZ());
	System.out.println(jos.getRSZ());
}
	public werknemerSalaris(String voornaam, String achternaam, int wNummer, double salaris, float RSZ)
	{
		this.voornaam=voornaam;
		this.achternaam=achternaam;
		werknemerNummer=wNummer;
		this.salaris=salaris;
		this.RSZ=RSZpercentage;
	}

	public void salarisVerhogen(int percentage)
	{
		double verhogingsfactor=(double)percentage/100;
		salaris += salaris*verhogingsfactor;
	}

	public double getSalaris()
	{
		return salaris;
	}

	public float setRSZ(float RSZ)
	{
		this.RSZ=RSZ;
	}

	public float getRSZ()
	{
		return RSZpercentage;
	}

}

