
public interface ICourierWorker {
	
	// State
	public IState getState();
	public void applyState(IState state);
	
	// Observer
	public void update();
	public void setTeamster(IObservable topic);
	public void preparePackage(Package package1);
	
	// Chain of Responsibility
	public void setNextWorker(ICourierWorker nextWorker);
	public void sendPackage(int level, String message);
}
