import java.util.ArrayList;

public class FitnessParticipant implements IParticipant {	
	private String name;
	private FitnessLeadTrainer trainer;
	private IExercise currentExercise;

	public FitnessParticipant(String name) {
		this.name = name;
	}
	
	@Override
	public void update() {
		currentExercise = trainer.getExercise();
		
		if(currentExercise == null) {
			System.out.println("No exercise to perform");
			return;
		}
		
		System.out.println("Participant (" + name + ") is now performing  " + currentExercise.getName());
	}
	
	public void setLead(FitnessLeadTrainer trainer) {
		this.trainer = trainer;
	}
}
