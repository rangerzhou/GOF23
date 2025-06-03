package behavioral.mediator;

public interface ChatRoom {
    void sendMessage(User sender, User receiver, String message);
    void addUser(User user);
}
