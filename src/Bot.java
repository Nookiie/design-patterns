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

	public boolean receiveMessage(String message, User user) {
		System.out.println(this.getUsername() + " receives a message: " + message);
		
		if (!isMessageOk(message)) {
			String naughtyWord = getMessageForbiddenWord(message);
			
			System.out.println("Message: " + message + " is illegal! \n" + "We do not tolerate the word " + naughtyWord
					+ " here in our Christian Server!");
			banUser(user);
			
			System.out.println(user.getUsername() + " has been banned from the chatroom.");
			return false;
		}

		System.out.println("Message is ok!");
		return true;
	}
	@Override
	public void receiveMessage(String message) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void sendMessage(String message) {
		System.out.println("You have been banned from the chatRoom");
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
		this.chatRoom.putUserInBanList(user);
	}

	@Override
	public void logIsCreated() {
		System.out.println("Bot: " + this.getUsername() + "  has joined the chat room");
	}

	
}
