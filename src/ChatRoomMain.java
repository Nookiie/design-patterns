
public class ChatRoomMain {

	public static void main(String[] args) {
		IChatFactory chatFactory = new ChatFactory();
		IChatRoom chatRoom = new ChatRoom(chatFactory);

		User user1 = (User) chatFactory.createEntity("USER", "Georgi", chatRoom);
		User user2 = (User) chatFactory.createEntity("USER", "Vasili", chatRoom);
		User user3 = (User) chatFactory.createEntity("USER", "Metodii", chatRoom);

		System.out.println();

		user1.sendMessage("addBot");

		System.out.println();

		user1.sendMessage("cat");

		System.out.println();

		user1.sendMessage("y tho ;(");
	}
}
