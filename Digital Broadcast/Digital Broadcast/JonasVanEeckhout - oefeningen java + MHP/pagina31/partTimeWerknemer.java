import java.lang.*;
//oef1+2+5
class partTimeWerknemer extends werknemerSalaris {

	public int urenGewerkt;

public static void main(String args[]){
	partTimeWerknemer jos2=new partTimeWerknemer("Jos2","Joske2",1,1000,3,0.33);
	partTimeWerknemer jef2=new partTimeWerknemer("Jef2","Jefke2",2,1250,4,0.55);

	jos2.salarisVerhogen(10);
	jef2.salarisVerhogen(10);
	
	
}
	public partTimeWerknemer(String voornaam, String achternaam, int nr, double sal, int urengw)
	{
		super(voornaam, achternaam, nr, sal);
		this.urenGewerkt=urengw;
	}
	
	public void salarisVerhogen(int percentage)
	{
		if(percentage>5)
		{
			percentage=0;
			System.out.println("Fout: slechts 5% opslag toegestaan");
		}
		else
		{
			super.salarisVerhogen(percentage);
		}
	}
	
	public double getWeekLoon()
	{
		return this.salaris*(double)this.urenGewerkt;
	}

}