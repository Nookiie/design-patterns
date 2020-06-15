import java.util.ArrayList;

public class CourierServiceMain {
	private static ArrayList<ICourierWorker> couriers = new ArrayList<ICourierWorker>();
	
	private 	static ICourierWorker getChain(CourierTeamster teamster) {
		
		ICourierWorker cityWorker = new CourierWorkerCity("Ivan");
		ICourierWorker countryWorker = new CourierWorkerCountry("Peter");
		ICourierWorker internationalWorker = new CourierWorkerInternational("Vladimir");
		
		couriers.add(cityWorker);
		couriers.add(countryWorker);
		couriers.add(internationalWorker);
		
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
		Package package1 = new Package("Server Stuff", worker, 3);
		package1.process(couriers);
	}
}
