
public abstract class ChatEntity {
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
	
	public abstract void logIsCreated();

	public abstract void sendMessage(String message);

	public abstract void receiveMessage(String message);
}
