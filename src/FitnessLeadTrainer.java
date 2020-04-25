import java.util.ArrayList;

public class FitnessLeadTrainer implements ILeadTrainer {
	 private String name;
	 private IExercise currentExercise;
	 private IFitnessIntructor instructor;
	 private ArrayList<IParticipant> participants = new ArrayList<IParticipant>();
	
	public FitnessLeadTrainer(String name) {
		this.name = name;
	}
	
	@Override
	public void setExercise(IExercise exercise) {
		currentExercise = exercise;
		notifyParticipants();
	}
	
	@Override
	public void subscribe(IParticipant participant) {
		this.participants.add(participant);
		participant.setLead(this);
	}

	@Override
	public void unsubscribe(IParticipant participant) {
		this.participants.remove(participant);
	}

	@Override
	public void update() {
		this.currentExercise = instructor.getExercise();
		System.out.println("Lead (" + name + ") was notified of new exercise on camera: " + currentExercise.getName() + " "
				+ "by instructor (" + instructor.getName() + "), executing");
		notifyParticipants();
	}
	
	@Override
	public void notifyParticipants() {
		for(IParticipant participant : participants) {
			participant.update();
		}
	}

	@Override
     public void executeCommand(IExercise exercise){
         exercise.execute();
     }
     
	@Override
     public IExercise getExercise() {
    	 return currentExercise;
     }

    @Override 
 	public void setName(String name) {
		this.name = name;
	}
	
    @Override
	public String getName(){
		return this.name;
	}

	@Override
	public void setInstructor(IFitnessIntructor instructor) {
		this.instructor = instructor;
	}
}
