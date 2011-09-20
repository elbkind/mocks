package eu.elbkind.mocks;

import java.util.HashMap;
import java.util.Map;

public class User
{
	private Map<Aktie, AktienBuendel> depot = new HashMap<Aktie, AktienBuendel>();

	public Map<Aktie, AktienBuendel> getDepot()
	{
		return depot;
	}

	
	public void addDepot(AktienBuendel toAdd)
	{
		if(!depot.containsKey(toAdd.getAktie()))
		{
			depot.put(toAdd.getAktie(), toAdd);
		}
	}
}
