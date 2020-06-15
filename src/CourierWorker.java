import java.util.ArrayList;

public abstract class CourierWorker implements IObservable{
	
	// Observer variables
	private String name;
	private ArrayList<IObserver> observers = new ArrayList<IObserver>(); 	
	
	// Chain of Responsibility variables
	public static int CITY = 1;
	public static int COUNTRY = 2;
	public static int INTERNATIONAL = 3;
	protected int level;
	protected CourierWorker nextWorker;
	
	// State variables
	public CourierState courierState;
	public Context courierContext;
	
	public void setNextWorker(CourierWorker nextWorker) {
		this.nextWorker = nextWorker;
	}
	
	public void sendPackage(int level, String message) {
		if(this.level <= level) {
			this.writeMessage(message);
		}
		
		if(this.nextWorker != null) {
			this.nextWorker.sendPackage(level, message);
		}
	}
	
	public void receivePackage(int level, String message) {
		this.courierContext.setState(new WorkingState());
		
		if(this.level <= level) {
			this.writeMessage(message);
		}
		
		if(this.nextWorker != null) {
			this.nextWorker.sendPackage(level, message);
		}
	}
	
	public void setName(String name) {
		this.name = name;
		this.notifyObservers();
	}
	
	@Override
	public void subscribe(IObserver observer) {
		this.observers.add(observer);
		observer.setWatchedWorker(this);
	}

	@Override
	public void unsubscribe(IObserver observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(IObserver observer : this.observers) {
			observer.update();
		}
	}

	@Override
	public String getUpdate() {
		return this.name;
	}
	
	abstract protected void writeMessage(String message);
}
