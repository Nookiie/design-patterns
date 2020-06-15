
// State that workers are in when waiting for a package to be delivered
public class IdleState extends CourierState {
	public IdleState() {
		this.stateName = "IDLE_STATE";
	}
}
