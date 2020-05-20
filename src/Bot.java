import java.util.ArrayList;

public class Bot extends ChatEntity {
	private ArrayList<String> forbiddenWords = new ArrayList<>();
	private static Bot instance;

	public Bot(IChatRoom chatRoom, String name) {
		super(chatRoom, name);

		forbiddenWords.add("cat");
		forbiddenWords.add("fuck");
		forbiddenWords.add("mack");
	}

	public static Bot getInstance(IChatRoom chatRoom, String name) {
		if (instance == null) {
			instance = new Bot(chatRoom, name);
		}

		return instance;
	}

	public boolean checkMessage(String message, User user) {
		this.receiveMessage(message);

		if (!isMessageOk(message)) {
			String naughtyWord = getMessageForbiddenWord(message);
			System.out.println("\nMessage: " + message + " is illegal! \n");

			banUser(user);

			System.out.println(user.getUsername() + " has been banned from the chatroom.\n");
			this.sendMessage("We do not tolerate the word " + naughtyWord + " here in our Christian Server!");

			return false;
		}

		System.out.println("Message is ok!");
		return true;
	}

	private String getMessageForbiddenWord(String message) {
		for (String forbiddenWord : forbiddenWords) {
			if (message.contains(forbiddenWord)) {
				return forbiddenWord;
			}
		}
		return null;
	}

	private boolean isMessageOk(String message) {
		if (forbiddenWords.contains(message)) {
			return false;
		}

		return true;
	}

	private void banUser(User user) {
		this.chatRoom.putInBanListAndRemove(user);
	}
}
