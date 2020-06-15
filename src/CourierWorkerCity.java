
public class CourierWorkerCity extends CourierWorker{
	public CourierWorkerCity() {
		this.level = CourierWorker.CITY;
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("City Package Message: " + message);
	}
}
