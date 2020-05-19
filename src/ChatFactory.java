
public class ChatFactory implements IChatFactory {
	public ChatFactory() {

	}

	public IChatEntity createEntity(String entity, String name, IChatRoom chatRoom) {
		ChatEntity chatEntity = null;

		if (entity.equals("BOT")) {
			chatEntity = Bot.getInstance(chatRoom, name);
		}

		if (entity.equals("USER")) {
			chatEntity = new User(chatRoom, name);
		}

		chatEntity.logIsCreated();
		return chatEntity;
	}
}
