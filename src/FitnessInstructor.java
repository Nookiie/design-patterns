import java.util.ArrayList;

public class FitnessInstructor implements IFitnessIntructor {
	private String name;
	private ILead leadTrainer;
	private IExercise currentExercise;
	private IFitnessIntructor instructor;
	private ArrayList<IExercise> exercises = new ArrayList<IExercise>();
	
	public FitnessInstructor(String name) {
		this.name = name;
	}
	
	@Override
	public void performExercise() {
		currentExercise.execute();
		notifyLead();
	}
	
	@Override
	public void subscribe(ILead lead) {
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
