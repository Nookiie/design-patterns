
public class User extends ChatEntity {

	public User(IChatRoom chatRoom, String name) {
		super(chatRoom, name);

		chatRoom.addUser(this);
	}
}
