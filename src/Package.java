public class Package implements IPackage {
	private String name;
	private ICourierWorker assignedWorker;
	private int toCode;
	
	public Package(String name, ICourierWorker worker, int toCode) {
		this.name = name;
		this.assignedWorker = worker;
		this.toCode = toCode;
	}
	
	public void process() {
		this.assignedWorker.sendPackage(toCode, this);
		// setCorrespondingPackageCourier(toCode, courier);
		this.assignedWorker.preparePackage(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ICourierWorker getAssignedWorker() {
		return assignedWorker;
	}

	public void setAssignedWorker(ICourierWorker assignedWorker) {
		this.assignedWorker = assignedWorker;
	}

}
