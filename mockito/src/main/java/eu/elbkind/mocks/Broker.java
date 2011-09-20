package eu.elbkind.mocks;

public interface Broker
{
	double getValueFor(Aktie aktie);
	Trade sell(User user, AktienBuendel request);
}
