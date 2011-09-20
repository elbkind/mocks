package eu.elbkind.mocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class BTest
{
	@Mock Broker broker;
	UserAgent userAgent;
	BrokerLog log = new BrokerLog();
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		User user = new User();
	
		user.addDepot(createBuendel("S2", 1, 5, 1.0d));
		user.addDepot(createBuendel("Bahn", 2, 205, 13.0d));
		user.addDepot(createBuendel("Comm Direct", 5, 10, 100.0d));
		user.addDepot(createBuendel("simyo", 14, 200, 0.05d));
		user.addDepot(createBuendel("Base", 130, 4, 67.0d));

		userAgent = new UserAgent();
		userAgent.setBroker(broker);
		userAgent.setBrokerLog(log);
		log.getTrades().clear();
	}
	private AktienBuendel createBuendel(String name, long id, int anzahl, double sell)
	{
		AktienBuendel b1 = new AktienBuendel();
		Aktie a1 = new Aktie(id, name);
		b1.setAktie(a1);
		b1.setAnzahl(anzahl);
		b1.setUntergrenze(sell);
		return b1;
	}
	
	@Test
	public void testSimple()
	{
		
	}
	
}
