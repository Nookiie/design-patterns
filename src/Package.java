import java.util.ArrayList;

public class Package {
	private String name;
	private ICourierWorker assignedWorker;
	private int toCode;
	
	public Package(String name, ICourierWorker worker, int toCode) {
		this.name = name;
		this.assignedWorker = worker;
		this.toCode = toCode;
	}
	
	public void process(ArrayList<ICourierWorker> couriers) {
		this.assignedWorker.sendPackage(toCode);
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
