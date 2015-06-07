import java.lang.*;

class werknemer {

	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected double salaris;

public static void main(String args[]){
	werknemer jos=new werknemer("Jos","Joske",1,1000);
	werknemer jef=new werknemer("Jef","Jefke",2,1250);
	werknemer benno=new werknemer("Benno","Bennoke",3,1500);
	werknemer simon=new werknemer("Simon","Simonneke",4,1600);
}
	public werknemer(String voornaam, String achternaam, int wNummer, double salaris)
	{
		this.voornaam=voornaam;
		this.achternaam=achternaam;
		werknemerNummer=wNummer;
		this.salaris=salaris;
	}
}



