
public class CourierWorkerInternational extends CourierWorker {
	public CourierWorkerInternational(String name) {
		super(name);
		
		this.level = CourierWorker.INTERNATIONAL;
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("International Package Message: " + message);
	}
}
