
public class CourierWorkerCountry extends CourierWorker {
	public CourierWorkerCountry(String name) {
		super(name);
		
		this.level = CourierWorker.COUNTRY;
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("Country Package Message: " + message);
	}
}
