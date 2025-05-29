package behavioral.command;

/**
 * 请求的发送者
 */
public class RemoteControl {
    Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}
