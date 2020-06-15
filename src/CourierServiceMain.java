public class CourierServiceMain {
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

	public static void main(String[] args) {
		CourierTeamster teamster = new CourierTeamster("Pesho");
		ICourierWorker worker = (CourierWorkerCity) getChain(teamster);

		// 3 - International, 2 - Country, 1 - City
		IPackage package1 = new Package("Nothing Suspicious Stuff", worker, 3);
		package1.process();
	}
}
