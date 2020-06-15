
public class Package {
	private String name;
	private ICourierWorker assignedWorker;
	
	public Package(String name, ICourierWorker assignedWorker) {
		this.name = name;
		this.assignedWorker = assignedWorker;
		
		this.assignedWorker.sendPackage(3, "Sending package: " + name);
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
