
public abstract class ChatEntity implements IChatEntity {
	protected String username;
	protected IChatRoom chatRoom;

	public ChatEntity(IChatRoom chatRoom, String name) {
		this.username = name;
		this.chatRoom = chatRoom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// In your github repo (AlexanderPPetrov - mediator), all these methods are
	// marked abstract
	// but I decided this was much better as there was less code to write

	public void logIsCreated() {
		System.out.println("(" + this.getClass().getName() + ") " + this.getUsername() + " has joined the chat room");
	}

	public void sendMessage(String message) {
		System.out.println(this.getClass().getName() + " " + this.getUsername() + " sent message: " + message);
		chatRoom.sendMessage(message, this);
	}

	public void receiveMessage(String message) {
		System.out.println(this.getClass().getName() + " " + this.getUsername() + " received message: " + message);
	}

	// public abstract void logIsCreated();

	// public abstract void sendMessage(String message);

	// public abstract void receiveMessage(String message);
}
