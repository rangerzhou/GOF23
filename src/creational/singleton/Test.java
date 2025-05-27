package creational.singleton;

public class Test {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        eagerSingleton.showMessage();

        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.showMessage();

        DCLSingleton dclSingleton = DCLSingleton.getInstance();
        dclSingleton.showMessage();

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.showMessage();

        StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
        staticInnerClassSingleton.showMessage();
    }

}
