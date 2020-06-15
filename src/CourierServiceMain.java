public class CourierServiceMain {
	public static void main(String[] args) {
		// Finished the exercise in 2 different ways

		// StateFirstApproach() - States of the courier workers are set first,
		// teamster is manually notified and retrieves every package after that

		// OneByOneApproach() - States, package preparation and teamster retrieval is on
		// one-by-one per package fully

		// Allocates the packages to their concurrent workers and sets their states
		// After that the teamster is manually activated
		OneByOneApproach();

		// One-by-one package allocation and work, as well as automatic notifying
		// teamster retrieval
		// StateFirstApproach();
	}

	private static void OneByOneApproach() {
		CourierTeamster teamster = new CourierTeamster("Pesho");
		ICourierWorker worker = (CourierWorkerCity) getChain(teamster);

		// 3 - International, 2 - Country, 1 - City
		IPackage package1 = new Package("Nothing Suspicious Stuff", worker, 3);
		IPackage package2 = new Package("Server Stuff", worker, 2);

		package1.process();
		package2.process();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void StateFirstApproach() {
		CourierTeamster teamster = new CourierTeamster("Pesho");
		teamster.setAutomaticNotify(false);

		ICourierWorker worker = (CourierWorkerCity) getChain(teamster);

		// 3 - International, 2 - Country, 1 - City
		IPackage package1 = new Package("Nothing Suspicious Stuff", worker, 3);
		IPackage package2 = new Package("Server Stuff", worker, 2);

		package1.process();
		package2.process();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		teamster.notifyTeamster();
	}

	private static ICourierWorker getChain(CourierTeamster teamster) {

		ICourierWorker cityWorker = new CourierWorkerCity("Ivan");
		ICourierWorker countryWorker = new CourierWorkerCountry("Peter");
		ICourierWorker internationalWorker = new CourierWorkerInternational("Vladimir");

		teamster.subscribe(cityWorker);
		teamster.subscribe(countryWorker);
		teamster.subscribe(internationalWorker);

		cityWorker.setNextWorker(countryWorker);
		countryWorker.setNextWorker(internationalWorker);

		return cityWorker;
	}
}
