package chapter02.item03.enumtype;

/**
 * 열거타입 방식의 싱글턴 - 바람직한 방법!
 */
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("열거타입 방식의 싱글턴!!");
    }
}
