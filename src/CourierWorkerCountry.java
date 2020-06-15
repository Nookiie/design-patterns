
public class CourierWorkerCountry extends CourierWorker {
	public CourierWorkerCountry(String name) {
		super(name);
		
		this.level = CourierWorker.COUNTRY;
	}

	@Override
	protected void writeMessage() {
		System.out.println("Package has gone through Country Courier [" + this.getName() + "]");
	}
}
