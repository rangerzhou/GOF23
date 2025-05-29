package structural.proxy;

public class Test {
    public static void main(String[] args) {
        Door door = new ProxyDoor("123456");
        door.open();
        door.close();

        door = new ProxyDoor("654321");
        door.open();
        door.close();
    }
}
