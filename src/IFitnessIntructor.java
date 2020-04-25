
public interface IFitnessIntructor {
	public void subscribe(ILeadTrainer lead);
	
	public void unsubscribe(IParticipant participant);
	
	public void notifyLead();
	
	public String getName();
	
	public IExercise getExercise() ;
	
	public void setExercise(IExercise exercise);

	void performExercise();
}
