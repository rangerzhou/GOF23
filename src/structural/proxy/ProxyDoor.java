package structural.proxy;

public class ProxyDoor implements Door {
    private final RealDoor door;
    private final String password;

    public ProxyDoor(String password) {
        door = new RealDoor();
        this.password = password;
    }

    @Override
    public void open() {
        if ("123456".equals(password)) {
            System.out.println("密码正确，正在打开门...");
            door.open();
        } else {
            System.out.println("密码错误，无法打开门");
        }
    }

    @Override
    public void close() {
        door.close();
    }
}
