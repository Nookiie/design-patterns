import java.util.ArrayList;

public class CourierTeamster implements ICourierTeamster {
	private ArrayList<ICourierWorker> observers = new ArrayList<ICourierWorker>();
	private String name;

	public CourierTeamster(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
		this.notifyObservers();
	}

	@Override
	public void subscribe(ICourierWorker observer) {
		this.observers.add(observer);
		observer.setTeamster(this);
	}

	@Override
	public void unsubscribe(ICourierWorker observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ICourierWorker observer : this.observers) {
			if (observer.getState().getClass() == WorkingCourierState.class) {
				observer.update();
			}
		}
	}

	@Override
	public String getUpdate() {
		return this.name;
	}
}
