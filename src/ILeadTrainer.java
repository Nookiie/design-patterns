
public interface ILeadTrainer {
	public void setExercise(IExercise exercise);
	
	public void subscribe(IParticipant participant);
	
	public void unsubscribe(IParticipant participant);
	
	public void update();
	
	public void notifyParticipants();

     public void executeCommand(IExercise exercise);
     
     public IExercise getExercise();
     
 	public void setName(String name);
	
	public String getName();

	public void setInstructor(IFitnessIntructor instructor);
}
