
public class User extends ChatEntity {

	public User(IChatRoom chatRoom, String name) {
		super(chatRoom, name);

		chatRoom.addUser(this);
	}

	@Override
	public void receiveMessage(String message) {
		System.out.println("User " + this.getUsername() + " received message: " + message);
	}
}
