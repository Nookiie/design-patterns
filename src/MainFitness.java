
public class MainFitness {
	public static void main (String[] args) {
			FitnessInstructor instructor = new FitnessInstructor("Pesho");
			
			FitnessLeadTrainer leadTrainer = new FitnessLeadTrainer("Gosho");
			
			FitnessParticipant participant_1 = new FitnessParticipant("James");
			FitnessParticipant participant_2 = new FitnessParticipant("Kek");
			FitnessParticipant participant_3 = new FitnessParticipant("Dev");
			
			instructor.subscribe(leadTrainer);
			
			leadTrainer.subscribe(participant_1);
			leadTrainer.subscribe(participant_2);
			leadTrainer.subscribe(participant_3);
			
			System.out.println();
			
			instructor.setExercise(new PushupsExercise());
			instructor.performExercise();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println();
			
			instructor.setExercise(new SitupsExercise());
			instructor.performExercise();
	}
}
