
public class Context {
	private String name;
	private IState state;
	
	public Context(String name) {
		this.name = name;
	}

	public IState getState() {
		return state;
	}

	public void setState(IState state) {
		this.state = state;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
