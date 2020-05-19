import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements IChatRoom {
	private ArrayList<User> users;
	private ArrayList<User> banList;
	private Bot bot;
	private ChatFactory chatFactory;

	public ChatRoom(ChatFactory chatFactory) {
		this.users = new ArrayList<>();
		this.banList = new ArrayList<>();
	}

	@Override
	public void sendMessage(String message, User user) {
		
		// Make sure the user is not in the ban list, if he is permit him
		if (banList.contains(user)) {
			System.out.println("User " + user.getUsername() + " is banned so nobody received the message");
			return;
		}
		
		// The bot gets the message first (if there is one), then everyone else
		// This way we can moderate the message before it gets sent to everyone else		

		if (bot != null) {
			if (!bot.receiveMessage(message, user)) {
				return;
			}
		}

	
		if (message.equals("addBot")) {
			bot = bot.getInstance(this, "ChatBot");
			System.out.println("Bot created: " + bot.getUsername());
		}

		for (User u : this.users) {
			if (u != user) {
				u.receiveMessage(message);
			}
		}
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

	@Override
	public void addBot(String botName) {
		chatFactory.createEntity("bot", botName, this);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public Bot getBot() {
		return bot;
	}

	@Override
	public void putUserInBanList(User user) {
		banList.add(user);
	}
}
