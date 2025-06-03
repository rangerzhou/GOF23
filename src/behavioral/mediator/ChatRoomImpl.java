package behavioral.mediator;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatRoomImpl implements ChatRoom {
    private final Set<User> users;

    public ChatRoomImpl() {
        users = new HashSet<>();
    }

    @Override
    public void sendMessage(User sender, User receiver, String message) {
        // 中介者负责协调消息的转发
        System.out.println(new Date() + "\n[" + sender.getUserName() + "] 向 ["
                + (receiver != null ? receiver.getUserName() : "所有人") + "] 发送消息: " + message);

        // 将消息广播给所有其他用户 (除了发送者自己)
        if (receiver == null) {
            for (User user : users) {
                if (!user.equals(sender)) {
                    user.receiveMessage(sender.getUserName(), message);
                }
            }
        } else {
            receiver.receiveMessage(sender.getUserName(), message);
        }

    }

    @Override
    public void addUser(User user) {
        users.add(user);
        System.out.println(user.getUserName() + " 进入聊天室.");
    }
}
