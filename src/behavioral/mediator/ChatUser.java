package behavioral.mediator;

public class ChatUser extends User {
    public ChatUser(ChatRoom chatRoom, String userName) {
        super(chatRoom, userName);
    }

    @Override
    public void receiveMessage(String senderName, String message) {
        System.out.println("用户 [" + userName + "] 收到 [" + senderName + "] 的消息: \"" + message + "\"");
    }
}
