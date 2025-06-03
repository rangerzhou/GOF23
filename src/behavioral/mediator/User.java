package behavioral.mediator;

public abstract class User {
    protected ChatRoom chatRoom;
    protected String userName;

    public String getUserName() {
        return userName;
    }

    public User(ChatRoom chatRoom, String userName) {
        this.chatRoom = chatRoom;
        this.userName = userName;
    }

    public void sendMessage(User receiver, String message) {
        chatRoom.sendMessage(this, receiver, message);
    }

    public abstract void receiveMessage(String senderName, String message);
}
