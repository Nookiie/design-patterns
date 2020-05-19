import java.util.ArrayList;

public interface IChatRoom {
	public void sendMessage(String message, ChatEntity user);

	public void addUser(User user);

	public void addBot(String botName);

	public ArrayList<User> getUsers();

	public void putInBanListAndRemove(User user);
}
