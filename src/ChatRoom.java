import java.util.ArrayList;

// Role: Mediator
public class ChatRoom implements IChatRoom {
	private ArrayList<User> users;
	private ArrayList<User> banList;
	private Bot bot;
	private IChatFactory chatFactory;

	public ChatRoom(IChatFactory chatFactory) {
		this.users = new ArrayList<>();
		this.banList = new ArrayList<>();
		this.chatFactory = chatFactory;
	}

	@Override
	public void sendMessage(String message, ChatEntity user) {

		// Make sure the user is not in the ban list, if he is prevent him from sending
		// messages to others
		if (banList.contains(user)) {
			System.out.println("User " + user.getUsername() + " is banned so nobody received the message");
			return;
		}

		// The bot gets the message first (if there is one), then everyone else
		// This way we can moderate the message before it gets sent to everyone else

		if (bot != null && !(user.getClass().equals(Bot.class))) {
			if (!bot.receiveMessage(message, (User) user)) {
				return;
			}
		}

		if (message.equals("addBot")) {
			bot = (Bot) chatFactory.createEntity("BOT", "ChatBot", this);
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
	public void putInBanListAndRemove(User user) {
		banList.add(user);

		this.users.remove(user);
	}
}
