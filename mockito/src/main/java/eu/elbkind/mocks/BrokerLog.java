package eu.elbkind.mocks;

import java.util.ArrayList;
import java.util.List;


public class BrokerLog
{
	private List<Trade> trades = new ArrayList<Trade>();

	public List<Trade> getTrades()
	{
		return trades;
	}

	public void setTrades(List<Trade> trades)
	{
		this.trades = trades;
	}
}
