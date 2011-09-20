package eu.elbkind.mocks;

public class Aktie
{
	long id;

	String name;
	
	public Aktie(long anId, String aName)
	{
		id = anId;
		name = aName;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
