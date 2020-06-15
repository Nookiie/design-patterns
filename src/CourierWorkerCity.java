
public class CourierWorkerCity extends CourierWorker{
	public CourierWorkerCity(String name) {
		super(name);
		
		this.level = CourierWorker.CITY;
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("City Package Message: " + message);
	}
}
