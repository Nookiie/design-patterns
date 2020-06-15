public abstract class CourierState implements IState {
	protected String stateName = "DEFAULT_STATE";
	
	@Override
	public void applyState(Context context) {
		context.setState(this);
	}

	@Override
	public String getStateName() {
		return this.stateName;
	}
}