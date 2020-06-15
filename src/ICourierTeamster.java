// Observable

public interface ICourierTeamster {
	public void subscribe(ICourierWorker observer);
	public void unsubscribe(ICourierWorker observer);
	public void notifyObservers();
	public String getUpdate();
}
