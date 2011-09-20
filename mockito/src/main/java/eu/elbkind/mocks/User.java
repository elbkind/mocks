package eu.elbkind.mocks;

import java.util.HashMap;
import java.util.Map;

public class User
{
	private Map<Long, AktienBuendel> depot = new HashMap<Long, AktienBuendel>();

	public Map<Long, AktienBuendel> getDepot()
	{
		return depot;
	}

	
	public void addDepot(AktienBuendel toAdd)
	{
		if(!depot.containsKey(toAdd.getAktie()))
		{
			depot.put(toAdd.getAktie().getId(), toAdd);
		}
	}
	
	public AktienBuendel getBuendelByName(String name)
	{
		for(AktienBuendel b : depot.values())
		{
			if(b.getAktie().getName().equals(name))
			{
				return b;
			}
		}
		
		return null;
	}
	
	public AktienBuendel getBuendelById(long id)
	{
		return depot.get(id);
	}
}
