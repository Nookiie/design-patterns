
public class MainFitness {
	public static void main (String[] args) {
		ExerciseOnce();
		// ExerciseEternally();
	}
	private static void ExerciseOnce() {
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
				
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
				
			System.out.println("\nThe exercise is now over");
	}	
	private static void ExerciseEternally() {
		FitnessInstructor instructor = new FitnessInstructor("Pesho");
		
		FitnessLeadTrainer leadTrainer = new FitnessLeadTrainer("Gosho");
		
		FitnessParticipant participant_1 = new FitnessParticipant("James");
		FitnessParticipant participant_2 = new FitnessParticipant("Kek");
		FitnessParticipant participant_3 = new FitnessParticipant("Dev");
		
		instructor.subscribe(leadTrainer);
		
		leadTrainer.subscribe(participant_1);
		leadTrainer.subscribe(participant_2);
		leadTrainer.subscribe(participant_3);
		
		while (true){
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
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("\nWe're taking a break");
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
	}
}

}
