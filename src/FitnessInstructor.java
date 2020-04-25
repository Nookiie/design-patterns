public class FitnessInstructor implements IFitnessIntructor {
	private String name;
	private ILeadTrainer leadTrainer;
	private IExercise currentExercise;
	
	public FitnessInstructor(String name) {
		this.name = name;
	}
	
	@Override
	public void performExercise() {
		currentExercise.execute();
		notifyLead();
	}
	
	@Override
	public void subscribe(ILeadTrainer lead) {
		leadTrainer = lead;
		leadTrainer.setInstructor(this);
	}

	@Override
	public void unsubscribe(IParticipant participant) {
		this.leadTrainer = null;
	}
	
	@Override
	public void notifyLead() {
		leadTrainer.update();
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public IExercise getExercise() {
		return currentExercise;
	}
	
	@Override
	public void setExercise(IExercise exercise) {
		currentExercise = exercise;
	}
}
