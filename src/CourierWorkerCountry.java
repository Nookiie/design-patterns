
public class CourierWorkerCountry extends CourierWorker {
	public CourierWorkerCountry() {
		this.level = CourierWorker.COUNTRY;
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("Country Package Message: " + message);
	}
}
