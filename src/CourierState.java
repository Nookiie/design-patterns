
// Made an additional layer here, to prevent code duplicates
// (applyState and getStateName have the same logic on every IState implementation)
public abstract class CourierState implements IState {
	protected String stateName;

	@Override
	public void applyState(Context context) {
		context.setState(this);
	}

	@Override
	public String getStateName() {
		return this.stateName;
	}
}
