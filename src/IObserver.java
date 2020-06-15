
public interface IObserver {
	public void update();
	public void setWatchedWorker(IObservable topic);
}
