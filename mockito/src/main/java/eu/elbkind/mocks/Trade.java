package eu.elbkind.mocks;

public class Trade
{
	private int sold;

	private double moneyEarned;

	private User user;

	private AktienBuendel buendel;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public AktienBuendel getBuendel()
	{
		return buendel;
	}

	public void setBuendel(AktienBuendel buendel)
	{
		this.buendel = buendel;
	}

	public int getSold()
	{
		return sold;
	}

	public void setSold(int sold)
	{
		this.sold = sold;
	}

	public double getMoneyEarned()
	{
		return moneyEarned;
	}

	public void setMoneyEarned(double moneyEarned)
	{
		this.moneyEarned = moneyEarned;
	}
}
