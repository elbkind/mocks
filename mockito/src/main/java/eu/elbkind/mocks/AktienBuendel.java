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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aktie == null) ? 0 : aktie.hashCode());
		return result;
	}

	@Override
	public String toString()
	{
		return "AktienBuendel [aktie=" + aktie + ", anzahl=" + anzahl + ", untergrenze=" + untergrenze + "]";
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
