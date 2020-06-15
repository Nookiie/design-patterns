
public class CourierServiceMain {
	private 	static ICourierWorker getChain(CourierTeamster teamster) {
		
		ICourierWorker cityWorker = new CourierWorkerCity("Ivan");
		ICourierWorker countryWorker = new CourierWorkerCountry("Peter");
		ICourierWorker internationalWorker = new CourierWorkerInternational("Vladimir");
		
		teamster.subscribe(cityWorker);
		teamster.subscribe(countryWorker);
		teamster.subscribe(internationalWorker);
		
		internationalWorker.setNextWorker(countryWorker);
		countryWorker.setNextWorker(cityWorker);
		
		return internationalWorker;
	}
	
	
	public static void main(String[] args) {
		CourierTeamster teamster = new CourierTeamster("Pesho");
		
		ICourierWorker worker = (CourierWorkerInternational) getChain(teamster);
	
		Package package1 = new Package("Server Stuff", worker);
	}
}
