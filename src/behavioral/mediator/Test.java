package behavioral.mediator;

public class Test {
    public static void main(String[] args) {
        // 创建具体中介者 (聊天室)
        ChatRoom chatRoom = new ChatRoomImpl();

        // 创建具体用户，并将中介者注入
        User yefan = new ChatUser(chatRoom, "叶凡");
        User ziyue = new ChatUser(chatRoom, "姬紫月");
        User miaoyi = new ChatUser(chatRoom, "安妙依");
        User yaoxi = new ChatUser(chatRoom, "姚曦");

        // 将用户添加到聊天室 (中介者管理这些用户)
        chatRoom.addUser(yefan);
        chatRoom.addUser(ziyue);
        chatRoom.addUser(miaoyi);
        chatRoom.addUser(yaoxi);

        // 用户通过中介者发送消息，而不是直接与其他用户通信
        yefan.sendMessage(null, "小可爱们，我叶天帝回来了！！！");
        ziyue.sendMessage(yefan, "老公么么哒~~");
        miaoyi.sendMessage(yefan, "宝贝儿我爱你~~");
        yaoxi.sendMessage(yefan, "哼，什么天帝，当年不过是个偷内衣的无耻小贼！");
    }
}
