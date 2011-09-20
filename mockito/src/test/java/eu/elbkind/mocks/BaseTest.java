package eu.elbkind.mocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
public class BaseTest
{
	@Mock Broker broker;
	UserAgent userAgent;
	BrokerLog log = new BrokerLog();
	User user;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		user = new User();
	
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
		// Erwartungen definieren
		when(broker.getValueFor(any(Aktie.class))).thenReturn(101d);
//		when(broker.getValueFor(any(Aktie.class))).thenReturn(45d);
//		when(broker.getValueFor(any(Aktie.class))).thenReturn(12d);
//		when(broker.getValueFor(new Aktie(1,null))).thenReturn(0.5);
		
		AktienBuendel b = user.getBuendelById(1);
		
		Trade trade = new Trade();
		trade.setSold(b.getAnzahl() -2);
		trade.setMoneyEarned(trade.getSold() * broker.getValueFor(b.getAktie()));
		trade.setUser(user);
		trade.setBuendel(b);
		when(broker.sell(any(User.class), any(AktienBuendel.class))).thenReturn(trade);
		
		
		// Logik anwenden
		userAgent.checkStock(user);
		for(Trade t : log.getTrades())
		{
			System.err.println(t);
		}
		
		
		//Ergebnisse testen
		verify(broker).sell(any(User.class), any(AktienBuendel.class));
//		verify(broker, times(3)).sell(any(User.class), any(AktienBuendel.class)); 
	}
	
}
