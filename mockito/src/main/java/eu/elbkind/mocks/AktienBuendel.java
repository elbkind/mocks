package eu.elbkind.mocks;

public class AktienBuendel
{
	private Aktie aktie;
	private int anzahl;

	private double untergrenze;

	public Aktie getAktie()
	{
		return aktie;
	}

	public void setAktie(Aktie aktie)
	{
		this.aktie = aktie;
	}

	public int getAnzahl()
	{
		return anzahl;
	}

	public void setAnzahl(int anzahl)
	{
		this.anzahl = anzahl;
	}

	public double getUntergrenze()
	{
		return untergrenze;
	}

	public void setUntergrenze(double untergrenze)
	{
		this.untergrenze = untergrenze;
	}
}
