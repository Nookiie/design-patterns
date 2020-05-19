
public class User extends ChatEntity {

	public User(IChatRoom chatRoom, String name) {
		super(chatRoom, name);
		
		chatRoom.addUser(this);
	}

	@Override
	public void sendMessage(String message) {
		System.out.println("User " + this.getUsername() + " sends message " + message);
		chatRoom.sendMessage(message, this);
	}

	@Override
	public void receiveMessage(String message) {
		System.out.println("User " + this.getUsername() + " receives message " + message);
	}

	@Override
	public void logIsCreated() {
		System.out.println("User " + this.getUsername() + " joined chat room");
	}
}
