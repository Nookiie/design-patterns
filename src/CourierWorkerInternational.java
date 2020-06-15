
public class CourierWorkerInternational extends CourierWorker {
	public CourierWorkerInternational() {
		this.level = CourierWorker.INTERNATIONAL;
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("International Package Message: " + message);
	}
}
