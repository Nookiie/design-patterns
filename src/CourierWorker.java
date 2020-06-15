public abstract class CourierWorker implements ICourierWorker{
	
	// Observer 
	private String name;
	private IObservable assignedTeamster;
	
	// Chain of Responsibility 
	public static int CITY = 1;
	public static int COUNTRY = 2;
	public static int INTERNATIONAL = 3;
	
	protected int level;
	protected CourierWorker nextWorker;
	
	// State 
	public Context courierStateContext = new Context();
	
	public Package currentPackage;
	
	public CourierWorker(String name) {
		this.name = name;
		
		// Every worker starts out in an idle state
		this.courierStateContext.setState(new IdleState());
	}
	
	private String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public IState getState() {
		return this.courierStateContext.getState();
	}
	
	public void applyState(IState state) {
		this.courierStateContext.setState(state);
		System.out.println(this.getName() + " is currently in a state of " + state.getStateName());
	}
	
	public void setNextWorker(ICourierWorker nextWorker) {
		this.nextWorker = (CourierWorker) nextWorker;
	}
	
	public void sendPackage(int level, String message) {
		if(this.level <= level) {
			this.writeMessage();
		}
		
		if(this.nextWorker != null) {
			this.nextWorker.sendPackage(level, message);
		}
	}
	
	public void receivePackage(int level, String message) {
		this.courierStateContext.setState(new WorkingState());
		
		if(this.level <= level) {
			this.writeMessage();
		}
		
		if(this.nextWorker != null) {
			this.nextWorker.sendPackage(level, message);
		}
	}

	@Override
	public void update() {
		if(assignedTeamster == null) {
			System.out.println("No teamster assigned, preparation cancelled");
			return;
		}
		
		if(currentPackage == null) {
			System.out.println("Teamster: " + getName() + " has no package, preparation cancelled");
			return;
		}
		
		System.out.println(this.getName() + " is currently preparing package: " + this.currentPackage.getName());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Assigned teamster " + "[" + this.assignedTeamster.getUpdate() + "]" 
		+ " has taken package " + "[" + currentPackage.getName() +"]"
		+" from worker " + "[" + this.getName() + "]");
		
		cleanUpPackageResponsibility();
	}	

	@Override
	public void setTeamster(IObservable teamster) {
		this.assignedTeamster = teamster;
	}
	
	@Override
	public void preparePackage(Package package1) {
		this.currentPackage = package1;
		this.applyState(new WorkingState());
		
		this.update();
	}
	
	private void cleanUpPackageResponsibility() {
		this.applyState(new IdleState());
		
		this.currentPackage = null;
	}
	
	
	abstract protected void writeMessage();
}
