
public class ChatFactory {
	public ChatFactory() {
		
	}

	public ChatEntity createEntity(String entity, String name, IChatRoom chatRoom) {
		ChatEntity chatEntity = null;
		Bot bot = null;

		if (entity.equals("BOT")) {
			chatEntity = bot.getInstance(chatRoom, name);
		}

		if (entity.equals("USER")) {
			chatEntity = new User(chatRoom, name);
		}
	
		chatEntity.logIsCreated();
		return chatEntity;
	}
}
