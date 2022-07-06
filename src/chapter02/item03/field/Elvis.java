package chapter02.item03.field;

/**
 * public static final 필드 방식의 싱글톤
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() { };

    public void leaveTheBuilding() {
        System.out.println("필드 방식의 싱글턴!!");
    }
}
