import java.util.ArrayList;

public class Package {
	private String name;
	private ICourierWorker assignedWorker;
	
	public Package(String name, ICourierWorker worker, ArrayList<ICourierWorker> couriers, int toCode) {
		this.name = name;
		
		worker.sendPackage(toCode, "Sending package: " + name);
		setCorrespondingPackageCourier(toCode, couriers);
		this.assignedWorker.preparePackage(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private void setCorrespondingPackageCourier(int toCode, ArrayList<ICourierWorker> couriers) {
		for(ICourierWorker courier : couriers) {
			if(courier.getLevel() == toCode) {
				this.setAssignedWorker(courier);
			}
		}
	}
	
	public ICourierWorker getAssignedWorker() {
		return assignedWorker;
	}

	public void setAssignedWorker(ICourierWorker assignedWorker) {
		this.assignedWorker = assignedWorker;
	}

}
