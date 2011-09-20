package eu.elbkind.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserAgent
{
	private Broker broker;
	private BrokerLog brokerLog;
	
	public void checkStock(User user)
	{
		List<Aktie> toRemove = new ArrayList<Aktie>();
		for(AktienBuendel buendel: user.getDepot().values())
		{
			double value = broker.getValueFor(buendel.getAktie());
			if(value < buendel.getUntergrenze())
			{
				Trade trade = broker.sell(user, buendel);
				int bestandNeu = buendel.getAnzahl() - trade.getSold();
				if(bestandNeu <1)
				{
					toRemove.add(buendel.getAktie());
				}
				else
				{
					buendel.setAnzahl(bestandNeu);
				}
				
				brokerLog.getTrades().add(trade);
			}
		}
		
		Set<Aktie> set = user.getDepot().keySet();
		set.removeAll(toRemove);
	}

	public Broker getBroker()
	{
		return broker;
	}

	public void setBroker(Broker broker)
	{
		this.broker = broker;
	}

	public BrokerLog getBrokerLog()
	{
		return brokerLog;
	}

	public void setBrokerLog(BrokerLog brokerLog)
	{
		this.brokerLog = brokerLog;
	}
}
