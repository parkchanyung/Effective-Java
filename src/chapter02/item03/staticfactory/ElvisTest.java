package chapter02.item03.staticfactory;

public class ElvisTest {
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}
